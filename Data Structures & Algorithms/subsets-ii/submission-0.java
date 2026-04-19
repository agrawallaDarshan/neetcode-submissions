class Solution {
    public void generateSubsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> subsets) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        generateSubsets(nums, index + 1, subset, subsets);
        subset.remove(subset.size() - 1);
        while (index + 1 < nums.length && nums[index + 1] == nums[index]) index++;
        generateSubsets(nums, index + 1, subset, subsets);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        generateSubsets(nums, 0, subset, subsets);
        return subsets;
    }
}
