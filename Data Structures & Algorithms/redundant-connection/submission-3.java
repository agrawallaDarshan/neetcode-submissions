class Solution {
    public int findRoot(int[] parent, int v) {
        if (parent[v] == v)
            return v;
        return findRoot(parent, parent[v]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i < parent.length; i++)
            parent[i] = i;
        for (int[] edge : edges) {
            int rootU = findRoot(parent, edge[0]);
            int rootV = findRoot(parent, edge[1]);
            if (rootU == rootV)
                return edge;
            parent[rootV] = rootU;
        }
        return new int[0];
    }
}