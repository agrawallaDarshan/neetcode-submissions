class Solution {
    int dir = 4;
    int[] dirX = { -1, 1, 0, 0 };
    int[] dirY = { 0, 0, -1, 1 };

    public boolean isValidIndex(int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i == m || j == n)
            return false;
        return true;
    }

    public int solution(int[][] matrix, int i, int j, int m, int n, int[][] dp) {
        if (dp[i][j] != 0)
            return dp[i][j];
        int ans = 0;
        for (int d = 0; d < dir; d++) {
            int x = i + dirX[d];
            int y = j + dirY[d];
            if (isValidIndex(x, y, m, n) && matrix[x][y] > matrix[i][j]) {
                ans = Math.max(ans, solution(matrix, x, y, m, n, dp));
            }
        }
        return dp[i][j] = ans + 1;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, solution(matrix, i, j, m, n, dp));
            }
        }
        return result;
    }
}