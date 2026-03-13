def call() {
    docker.image('node:20').inside {
        sh 'npm install --no-audit'
    }
}
