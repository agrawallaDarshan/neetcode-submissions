class Tuple {
    int dest;
    int dist;

    Tuple(int dest, int dist) {
        this.dest = dest;
        this.dist = dist;
    }
}

class Pair {
    int vertex;
    int weight;

    Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Pair> pairs = new ArrayList<>();
            graph.add(pairs);
        }

        for (int i = 0; i < flights.length; i++) {
            int source = flights[i][0];
            int destination = flights[i][1];
            int weight = flights[i][2];
            graph.get(source).add(new Pair(destination, weight));
        }

        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        cost[src] = 0;

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(src, 0));
        int stops = 0;
        while(!queue.isEmpty() && stops <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Tuple node = queue.poll();
                List<Pair> pairs = graph.get(node.dest);
                for (Pair pair: pairs) {
                    int costp = node.dist + pair.weight;
                    if (costp < cost[pair.vertex]) {
                        cost[pair.vertex] = costp;
                        queue.add(new Tuple(pair.vertex, costp));
                    }   
                }
            }
            stops++;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
