class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();
        for (int left = 0; left < nums.length - 2; left++) {
            // Avoid duplicate
            if (left != 0 && nums[left] == nums[left - 1]) continue;
            for (int right = left + 1; right < nums.length - 1; right++) {
                // Avoid duplicate
                if (right > left + 1 && nums[right] == nums[right - 1]) continue;
                int sum = nums[left] + nums[right];
                if (sum <= 0) {
                    int target = 0 - sum;
                    int low = right + 1, high = nums.length - 1;
                    int index = -1;
                    while (low <= high) {
                        // System.out.println("low = " + low + " high = " + high);
                        int mid = low + (high - low) / 2;
                        if (nums[mid] == target) {
                            index = mid;
                            break;
                        } else if (nums[mid] > target) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    }
                    if (index != -1) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(nums[left]);
                        pair.add(nums[right]);
                        pair.add(nums[index]);
                        result.add(pair);
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
