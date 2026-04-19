class Solution {
    public int solution(List<List<Integer>> triangles, int triangle, int index, Integer[][] dp) {
        if (triangle == triangles.size())
            return 0;
        if (index >= triangles.get(triangle).size())
            return Integer.MAX_VALUE;
        if (dp[triangle][index] != null)
            return dp[triangle][index];
        dp[triangle][index] = triangles.get(triangle).get(index)
                + Math.min(solution(triangles, triangle + 1, index, dp),
                        solution(triangles, triangle + 1, index + 1, dp));
        return dp[triangle][index];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[triangle.size()][triangle.get(triangle.size() - 1).size()];
        return solution(triangle, 0, 0, dp);
    }
}