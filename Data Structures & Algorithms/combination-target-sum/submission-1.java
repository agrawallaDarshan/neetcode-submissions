class Solution {
    public void uniqueSubsets(int index, int[] candidates, int sum, int target, List<Integer> subset, List<List<Integer>> subsets) {
        if (sum == target) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        if (index == candidates.length || sum > target) return;
        subset.add(candidates[index]);
        uniqueSubsets(index, candidates, sum + candidates[index], target, subset, subsets);
        subset.remove(subset.size() - 1);
        uniqueSubsets(index + 1, candidates, sum, target, subset, subsets);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        uniqueSubsets(0, candidates, 0, target, subset, subsets);
        return subsets;
    }
}
