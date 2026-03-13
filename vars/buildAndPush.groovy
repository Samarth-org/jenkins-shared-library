def call(String imageName, String tag) {
    Run directly on Jenkins agent where Docker IS installed
    sh "docker build -t ${imageName}:${tag} ."
    withDockerRegistry(credentialsId: 'docker-hub-credentials', url: '') {
        sh "docker push ${imageName}:${tag}"
    }
}