class Edge {
    int to;
    int weight;

    Edge (int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int src = times[i][0];
            int des = times[i][1];
            int dis = times[i][2];
            Edge edge = new Edge(des, dis);
            adj.get(src).add(edge);
        }

        int[] time = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            time[i] = Integer.MAX_VALUE;
        }
        time[k] = 0;

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.add(new Edge(k, 0));
        visited[k] = true;

        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.remove();
            List<Edge> edges = adj.get(edge.to);
            for (Edge edg: edges) {
                time[edg.to] = Math.min(time[edg.to], time[edge.to] + edg.weight);
                if (!visited[edg.to]) {
                    minHeap.add(edg);
                    visited[edg.to] = true;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (i == k) continue;
            if (time[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, time[i]);
        }
        return result;
    }
}
