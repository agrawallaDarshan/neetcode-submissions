class Node {
    int value;
    int key;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int size;
    HashMap<Integer, Node> map;
    Node head, tail; // head = LRU, tail = MRU

    public void printList() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.value);

            if (curr.next != null) {
                System.out.print(" <-> ");
            }

            curr = curr.next;
        }

        System.out.println();
    }

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
        head = null;
    }

    public int get(int key) {
        System.out.println("key = " + key);
        System.out.println("Before = ");
        printList();
        if (map.containsKey(key)) {
            System.out.println("After = ");
            Node ref = map.get(key);
            if (map.size() == 1 || tail.key == ref.key)
                return ref.value;
            if (ref == head) {
                tail.next = head;
                head.prev = tail;
                Node newHead = head.next;
                head.next = null;
                newHead.prev = null;
                tail = head;
                head = newHead;
                printList();
                return ref.value;
            } else {
                if (ref.prev != null)
                    ref.prev.next = ref.next;
                if (ref.next != null)
                    ref.next.prev = ref.prev;
                ref.prev = tail;
                tail.next = ref;
                ref.next = null;
                tail = ref;
                printList();
                return ref.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node ref = map.get(key);
            ref.value = value;
            if (ref == tail) return;
            if (ref == head) {
                tail.next = head;
                head.prev = tail;
                Node newHead = head.next;
                head.next = null;
                newHead.prev = null;
                tail = head;
                head = newHead;
            } else {
                if (ref.prev != null)
                    ref.prev.next = ref.next;
                if (ref.next != null)
                    ref.next.prev = ref.prev;
                ref.prev = tail;
                tail.next = ref;
                ref.next = null;
                tail = ref;
            }
        } else {
            Node node = new Node(key, value);
            if (map.size() == size) {
                tail.next = node;
                node.prev = tail;
                tail = node;
                map.remove(head.key);
                head = head.next;
                head.prev = null;
            } else {
                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
            }
            map.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
