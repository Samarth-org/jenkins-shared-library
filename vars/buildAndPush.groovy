def call(String imageName, String tag) {
    sh "docker build -t ${imageName}:${tag} ."
    docker.withRegistry('', 'docker-hub-credentials') {
        sh "docker push ${imageName}:${tag}"
    }
}
