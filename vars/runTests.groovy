def call() {
    docker.image('node:20').inside('-u root:root') {  // 👈 add this
        sh 'npm test'
    }
}