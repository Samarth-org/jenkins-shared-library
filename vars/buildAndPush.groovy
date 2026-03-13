def call(String imageName, String tag) {
    sh "docker build -t ${imageName}:${tag} ."
    withDockerRegistry(credentialsId: 'docker-hub-credentials', url: '') {
        sh "docker push ${imageName}:${tag}"
    }
}