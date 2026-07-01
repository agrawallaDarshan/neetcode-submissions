class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    int BUCKET_LIMIT = 10000;
    Node[] arr;

    public MyHashMap() {
        arr = new Node[BUCKET_LIMIT];
    }

    public void put(int key, int value) {
        int hashedValue = key % BUCKET_LIMIT;
        if (arr[hashedValue] == null) {
            Node node = new Node(key, value);
            arr[hashedValue] = node;
        } else {
            Node start = arr[hashedValue], prev = null;
            while (start != null && start.key != key) {
                prev = start;
                start = start.next;
            }
            if (start == null) {
                // append the key to the end of the DLL
                Node node = new Node(key, value);
                node.prev = prev;
                prev.next = node;
            } else {
                start.value = value;
            }
        }
    }

    public int get(int key) {
        int hashedValue = key % BUCKET_LIMIT;
        Node start = arr[hashedValue];
        while (start != null && start.key != key) {
            start = start.next;
        }
        if (start == null)
            return -1;
        return start.value;
    }

    public void remove(int key) {
        int hashedValue = key % BUCKET_LIMIT;
        Node start = arr[hashedValue];
        // if it's the head
        if (start != null && start.key == key) {
            arr[hashedValue] = start.next;
            start.next = null;
            return;
        }
        while (start != null && start.key != key) {
            start = start.next;
        }
        if (start == null)
            return;
        start.prev.next = start.next;
        if (start.next != null)
            start.next.prev = start.prev;
        start.next = null;
        start.prev = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */