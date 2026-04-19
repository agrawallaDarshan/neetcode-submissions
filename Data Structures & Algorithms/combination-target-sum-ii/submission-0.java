class Solution {
    public void uniqueSubsets(int index, int[] candidates, int sum, int target, List<Integer> subset, List<List<Integer>> subsets) {
        // System.out.println("sum = " + sum);
        if (sum == target) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        if (index == candidates.length || sum > target) return;
        subset.add(candidates[index]);
        uniqueSubsets(index + 1, candidates, sum + candidates[index], target, subset, subsets);
        subset.remove(subset.size() - 1);
        while (index + 1 < candidates.length && candidates[index + 1] == candidates[index]) index++;
        uniqueSubsets(index + 1, candidates, sum, target, subset, subsets);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        uniqueSubsets(0, candidates, 0, target, subset, subsets);
        return subsets;
    }
}
