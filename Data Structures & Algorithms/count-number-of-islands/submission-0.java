class Solution {
    int[] dirX = { -1, 1, 0, 0 };
	int[] dirY = { 0, 0, -1, 1 };

    public static boolean isValidPath(int i, int j, int m, int n) {
		if (i < 0 || j < 0 || i >= m || j >= n)
			return false;
		return true;
	}

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    markConnectIslands(grid, i, j);
                }
            }
        }
        return result;
    }

    public void markConnectIslands(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int dir = 0; dir < 4; dir++) {
            int x = i + dirX[dir];
            int y = j + dirY[dir];
			if (isValidPath(x, y, grid.length, grid[0].length) && grid[x][y] == '1') {
				markConnectIslands(grid, x, y);
			}
		}
    }
}
