def call() {
    docker.image('node:20').inside('-u root:root') {  // 👈 add this
        sh 'npm install --no-audit'
        sh 'npm install jest-junit --save-dev'
    }

}
