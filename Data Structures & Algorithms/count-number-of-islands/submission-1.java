class Node {
    int i;
    int j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class DisjointSet {
    private final int[] ranks;
    private final int[] parents;
    private int components;

    public DisjointSet(int n) {
        ranks = new int[n];
        parents = new int[n];
        for (int i = 0; i < n; i++)
            parents[i] = i;
        components = n;
    }

    private int findUltimateParent(int node) {
        if (parents[node] == node)
            return node;
        return parents[node] = findUltimateParent(parents[node]);
    }

    public void unionByRank(int node1, int node2) {
        int ultimateParent1 = findUltimateParent(node1);
        int ultimateParent2 = findUltimateParent(node2);
        if (ultimateParent2 == ultimateParent1)
            return;
        if (ranks[ultimateParent1] < ranks[ultimateParent2]) {
            // connect node1 to node2
            parents[ultimateParent1] = ultimateParent2;
        } else if (ranks[ultimateParent2] < ranks[ultimateParent1]) {
            // connect node2 to node1
            parents[ultimateParent2] = ultimateParent1;
        } else {
            // connect node2 to node1
            parents[ultimateParent2] = ultimateParent1;
            ranks[ultimateParent1]++;
        }
        components--;
    }

    public int calculateNumberOfIslands(boolean[] visited) {
        Set<Integer> islands = new HashSet<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                islands.add(findUltimateParent(i));
            }
        }
        return islands.size();
    }
}

class Solution {
    int[] dirX = { -1, 1, 0, 0 };
    int[] dirY = { 0, 0, -1, 1 };
    DisjointSet ds;

    public static boolean isValidPath(int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return false;
        return true;
    }

    public void bfs(char[][] grid, int i, int j, boolean[] visited) {
        Node node = new Node(i, j);
        int m = grid.length, n = grid[0].length;
        int nodeID = i * n + j;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited[nodeID] = true;
        while (!q.isEmpty()) {
            Node current = q.poll();
            int currentNodeID = current.i * n + current.j;
            for (int dir = 0; dir < 4; dir++) {
                int x = current.i + dirX[dir];
                int y = current.j + dirY[dir];
                if (isValidPath(x, y, m, n) && grid[x][y] == '1') {
                    int nextNodeID = x * n + y;
                    ds.unionByRank(currentNodeID, nextNodeID);
                    if (!visited[nextNodeID]) {
                        q.add(new Node(x, y));
                        visited[nextNodeID] = true;
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        ds = new DisjointSet(m * n);
        boolean[] visited = new boolean[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int nodeID = i * n + j;
                if (grid[i][j] == '1' && !visited[nodeID]) {
                    bfs(grid, i, j, visited);
                }
            }
        }
        return ds.calculateNumberOfIslands(visited);
    }
}