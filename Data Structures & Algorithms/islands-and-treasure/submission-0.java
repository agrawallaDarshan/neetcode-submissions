class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public boolean isValidPath(int i, int j, int m, int n) {
		if (i < 0 || j < 0 || i >= m || j >= n)
			return false;
		return true;
	}

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dirX = {-1, 1, 0, 0 };
        int[] dirY = { 0, 0, -1, 1 };

        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				Pair pair = queue.poll();
				for (int i = 0; i < 4; i++) {
					int x = pair.x + dirX[i];
					int y = pair.y + dirY[i];
					if (isValidPath(x, y, m, n) && grid[x][y] == Integer.MAX_VALUE) {
						grid[x][y] = grid[pair.x][pair.y] + 1;
						queue.add(new Pair(x, y));
					}
				}
			}
		}
    }
}
