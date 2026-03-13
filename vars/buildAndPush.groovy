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
