def call() {
    docker.image('node:20').inside('-u root:root') {
        sh 'npm test'
        // copy xml out of container to workspace
        sh 'cp test-results.xml $WORKSPACE/test-results.xml || true'
    }
}
