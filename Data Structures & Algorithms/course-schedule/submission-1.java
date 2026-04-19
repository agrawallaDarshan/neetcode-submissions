class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < numCourses; i++)
			graph.add(new ArrayList<Integer>());

		for (int i = 0; i < prerequisites.length; i++) {
			int ai = prerequisites[i][0];
			int bi = prerequisites[i][1];
			graph.get(ai).add(bi);
		}

		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			Set<Integer> set = new HashSet<>();
			if (!visited[i] && dfs(graph, i, visited, set))
				return false;
		}

		return true;
    }

    public boolean dfs(List<List<Integer>> graph, int src, boolean[] visited, Set<Integer> set) {
        set.add(src);
		List<Integer> connectedVertices = graph.get(src);
		for (int i = 0; i < connectedVertices.size(); i++) {
			int vertex = connectedVertices.get(i);
			if (set.contains(vertex) || (!visited[vertex] && dfs(graph, vertex, visited, set))) {
				return true;
			}
		}
		visited[src] = true;
		set.remove(src);
		return false;
    }
}
