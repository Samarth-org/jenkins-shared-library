def call(String status) {
    echo "=========================================="
    echo "  Build ${status}"
    echo "  Job:    ${env.JOB_NAME}"
    echo "  Branch: ${env.BRANCH_NAME}"
    echo "  Build:  #${env.BUILD_NUMBER}"
    echo "  URL:    ${env.BUILD_URL}"
    echo "=========================================="
}
