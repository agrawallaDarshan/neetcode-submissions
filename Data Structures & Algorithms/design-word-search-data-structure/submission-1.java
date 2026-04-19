class Tree {
    Tree[] map;
    boolean isEnd;
    Tree() {
        map = new Tree[26];
        isEnd = false;
    }
}

class WordDictionary {

    Tree root;

    public WordDictionary() {
        root = new Tree();
    }

    public void addWord(String word) {
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

    public boolean search(String word) {
        // Level Order Traversal
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int size = queue.size();
            if (size == 0) return false;
            if (ch == '.') {
                while (size > 0) {
                    Tree tree = queue.remove();
                    Tree[] map = tree.map;
                    for (Tree node: map) {
                        if (node != null) queue.add(node);
                    }
                    size--;
                }
            } else {
                while (size > 0) {
                    Tree tree = queue.remove();
                    Tree[] map = tree.map;
                    if (map[ch - 97] != null) queue.add(map[ch - 97]);
                    size--;
                }
            }
        }
        while (!queue.isEmpty()) {
            Tree tree = queue.remove();
            if (tree.isEnd) return true;
        }
        return false;
    }
}
