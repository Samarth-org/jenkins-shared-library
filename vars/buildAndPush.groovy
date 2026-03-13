def call(String imageName, String tag) {
    docker.image('node:20').inside('-u root:root') {  // 👈 add this
        sh "docker build -t ${imageName}:${tag} ."
        withDockerRegistry(credentialsId: 'docker-hub-credentials', url: '') {
            sh "docker push ${imageName}:${tag}"
        }
    }
}