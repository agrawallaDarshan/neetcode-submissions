class Tree {
    Tree[] map;
    boolean isEnd;

    Tree() {
        map = new Tree[26];
        isEnd = false;
    }
}

class Solution {
    Tree root;
    int dirCount = 4;
    int[] dirX = {0, 0, 1, -1};
    int[] dirY = {1, -1, 0, 0};

    public boolean isValidIndex(int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i == m || j == n) return false;
        return true;
    }

    public void buildTrie(String word) {
        int index = 0;
        Tree node = root;
        while (index < word.length()) {
            char ch = word.charAt(index);
            Tree[] map = node.map;
            if (map[ch - 97] != null) {
                node = map[ch - 97];
            } else {
                Tree newNode = new Tree();
                map[ch - 97] = newNode;
                node = newNode;
            }
            index++;
        }
        node.isEnd = true;
    }

    public void dfs(char[][] board, boolean[][] visited, int i, int j, Tree node, StringBuilder sb, List<String> result) {
        Tree childNode = node.map[board[i][j] - 97];
        if (childNode == null) return;
        sb.append(board[i][j]);
        if (childNode.isEnd) {
            result.add(sb.toString());
            childNode.isEnd = false; // avoid duplicates
        }
        visited[i][j] = true;
        for (int dir = 0; dir < dirCount; dir++) {
            int dirx = i + dirX[dir];
            int diry = j + dirY[dir];
            if (isValidIndex(dirx, diry, board.length, board[0].length) && !visited[dirx][diry]) {
                dfs(board, visited, dirx, diry, childNode, sb, result);
            }
        }
        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        root = new Tree();
        for (String word: words) {
            buildTrie(word);
        }
        boolean[][] visited = new boolean[m][n];
        List<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board[i][j];
                StringBuilder sb = new StringBuilder();
                dfs(board, visited, i, j, root, sb, result);
            }
        }
        return result;
    }
}
