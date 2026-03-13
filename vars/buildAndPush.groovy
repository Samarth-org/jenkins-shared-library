stage('Build & Push Docker') {
    when {
        anyOf {
            branch 'main'
            // ↓ fallback for regular pipeline job
            expression { env.GIT_BRANCH == 'origin/main' }
            expression { env.BRANCH_NAME == null }
        }
    }
    steps {
        buildAndPush("${IMAGE_NAME}", "${IMAGE_TAG}")
    }
}

stage('Smoke Test') {
    when {
        anyOf {
            branch 'main'
            expression { env.GIT_BRANCH == 'origin/main' }
            expression { env.BRANCH_NAME == null }
        }
    }
    steps {
        sh '''
            docker run -d --name smoke-test -p 3000:3000 ${IMAGE_NAME}:${IMAGE_TAG}
            sleep 5
            curl -f http://localhost:3000/health || exit 1
            docker stop smoke-test
            docker rm smoke-test
        '''
    }
}
