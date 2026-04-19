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

        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int src = queue.remove();
                List<Edge> edges = adj.get(src);
                for (Edge edge: edges) {
                    if (time[src] + edge.weight < time[edge.to]) {
                        time[edge.to] = time[src] + edge.weight;
                        queue.add(edge.to);
                    }
                }
            }
        }

        // System.out.println(Arrays.toString(time));

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (i == k) continue;
            if (time[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, time[i]);
        }
        return result;
    }
}
