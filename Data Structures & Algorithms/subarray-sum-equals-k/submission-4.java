class Solution {
    public void removeElementFromMap(HashMap<Integer, Integer> map, int element) {
        if (map.containsKey(element)) {
            if (map.get(element) == 1)
                map.remove(element);
            else
                map.put(element, map.get(element) - 1);
        }
    }

    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        prefixSum[0] = nums[0];
        map.put(prefixSum[0], 1);
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }

        int result = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (prefixSum[i] == k)
                result++;
            removeElementFromMap(map, prefixSum[i]);
            int requiredValue = prefixSum[i] - k;
            result += map.getOrDefault(requiredValue, 0);
        }
        return result;
    }
}
