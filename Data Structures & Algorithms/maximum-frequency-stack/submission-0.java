class Pair {
    int val;
    int size;
    int order;

    Pair(int val, int size, int order) {
        this.val = val;
        this.size = size;
        this.order = order;
    }
}

class FreqStack {
    PriorityQueue<Pair> pq;
    int counter;
    HashMap<Integer, Stack<Integer>> map;

    public FreqStack() {
        pq = new PriorityQueue<>((a, b) -> {
            if (b.size != a.size)
                return b.size - a.size;
            else
                return b.order - a.order;
        });
        counter = 0;
        map = new HashMap<>();
    }

    public void push(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new Stack<>());
        }
        Stack<Integer> vst = map.get(val);
        vst.push(counter);
        pq.add(new Pair(val, vst.size(), vst.peek()));
        counter++;
    }

    public int pop() {
        Pair pair = pq.poll();
        map.get(pair.val).pop();
        if (map.get(pair.val).size() == 0)
            map.remove(pair.val);
        return pair.val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */