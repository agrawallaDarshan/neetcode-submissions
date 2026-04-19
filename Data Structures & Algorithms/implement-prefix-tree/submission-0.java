class Tree {
    Map<Character, Tree> map;
    boolean isEnd;
    Tree() {
        map = new HashMap<>();
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
            Map<Character, Tree> map = node.map;
            if (map.containsKey(ch)) {
                node = map.get(ch);
            } else {
                Tree newNode = new Tree();
                map.put(ch, newNode);
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
            Map<Character, Tree> map = node.map;
            if (map.containsKey(ch)) {
                node = map.get(ch);
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
            Map<Character, Tree> map = node.map;
            if (map.containsKey(ch)) {
                node = map.get(ch);
            } else {
                return false;
            }
            index++;
        }
        return true;
    }
}
