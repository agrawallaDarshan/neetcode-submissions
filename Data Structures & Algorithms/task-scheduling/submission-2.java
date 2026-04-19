class Task {
    char name;
    int count;
    int nextCycle;

    Task(char name, int count, int nextCycle) {
        this.name = name;
        this.count = count;
        this.nextCycle = nextCycle;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.count, a.count);
        });
        Queue<Task> q = new LinkedList<>();
        for (char task: map.keySet()) {
            Task _task = new Task(task, map.get(task), 0);
            pq.add(_task);
        }

        int cycle = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            if (!pq.isEmpty()) {
                Task task = pq.poll();
                // Execute task
                task.count = task.count - 1;
                task.nextCycle = cycle + n;
                if (task.count > 0) {
                    q.add(task);
                }
            }
            while (!q.isEmpty() && q.peek().nextCycle == cycle) {
                pq.add(q.poll());
            } 
            cycle++;
        }

        return cycle;
    }
}