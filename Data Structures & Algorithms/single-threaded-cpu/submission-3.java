class Task {
    int index, enqueueTime, processingTime;

    Task(int index, int enqueueTime, int processingTime) {
        this.index = index;
        this.enqueueTime = enqueueTime;
        this.processingTime = processingTime;
    }
}

class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] result = new int[tasks.length];
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> a.enqueueTime - b.enqueueTime);
        int index = 0;
        for (int[] task : tasks) {
            pq.add(new Task(index++, task[0], task[1]));
        }
        PriorityQueue<Task> availableTasks = new PriorityQueue<>((a, b) -> {
            if (a.processingTime != b.processingTime)
                return a.processingTime - b.processingTime;
            else if (a.enqueueTime != b.enqueueTime)
                return a.enqueueTime - b.enqueueTime;
            return a.index - b.index;
        });
        int timeLimit = pq.peek().enqueueTime;
        index = 0;
        while (!pq.isEmpty() || !availableTasks.isEmpty()) {
            while (!pq.isEmpty() && pq.peek().enqueueTime <= timeLimit) {
                availableTasks.add(pq.poll());
            }
            if (!availableTasks.isEmpty()) {
                Task taskToRun = availableTasks.poll();
                timeLimit += taskToRun.processingTime;
                result[index++] = taskToRun.index;
            } else {
                timeLimit = pq.peek().enqueueTime;
            }
        }
        return result;
    }
}