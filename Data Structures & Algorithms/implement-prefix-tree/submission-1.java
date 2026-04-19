class Tree {
    Tree[] map;
    boolean isEnd;
    Tree() {
        map = new Tree[26];
        isEnd = false;
    }
}

class PrefixTree {

    Tree root;

    public PrefixTree() {
        root = new Tree();
    }

    public void insert(String word) {
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
        int index = 0;
        Tree node = root;
        while (index < word.length()) {
            char ch = word.charAt(index);
            Tree[] map = node.map;
            if (map[ch - 97] != null) {
                node = map[ch - 97];
            } else {
                return false;
            }
            index++;
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        int index = 0;
        Tree node = root;
        while (index < prefix.length()) {
            char ch = prefix.charAt(index);
            Tree[] map = node.map;
            if (map[ch - 97] != null) {
                node = map[ch - 97];
            } else {
                return false;
            }
            index++;
        }
        return true;
    }
}
