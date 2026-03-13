def call(String status) {
    def branch = env.BRANCH_NAME ?: env.GIT_BRANCH ?: 'main'  // 👈 fallback
    echo "=========================================="
    echo "  Build ${status}"
    echo "  Job:    ${env.JOB_NAME}"
    echo "  Branch: ${branch}"
    echo "  Build:  #${env.BUILD_NUMBER}"
    echo "  URL:    ${env.BUILD_URL}"
    echo "=========================================="
}
