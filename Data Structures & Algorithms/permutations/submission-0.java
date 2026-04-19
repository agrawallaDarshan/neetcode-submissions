class Solution {
    public void solution(int[] nums, boolean[] visited, List<Integer> permute, List<List<Integer>> permutations) {
        if (permute.size() == nums.length) {
            permutations.add(new ArrayList<>(permute));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            permute.add(nums[i]);
            visited[i] = true;
            solution(nums, visited, permute, permutations);
            permute.remove(permute.size() - 1);
            visited[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<Integer> permute = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        solution(nums, visited, permute, result);
        return result;
    }
}