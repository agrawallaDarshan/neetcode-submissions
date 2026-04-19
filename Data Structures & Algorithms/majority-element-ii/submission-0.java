class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length < 3) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            if (nums.length > 1 && nums[0] != nums[1])
                list.add(nums[1]);
            return list;
        }
        int candidate1 = 0, count1 = 0;
        int candidate2 = 0, count2 = 0;
        for (int num : nums) {
            if (candidate1 == num)
                count1++;
            else if (candidate2 == num)
                count2++;
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3)
            result.add(candidate1);
        if (count2 > nums.length / 3)
            result.add(candidate2);
        return result;
    }
}
