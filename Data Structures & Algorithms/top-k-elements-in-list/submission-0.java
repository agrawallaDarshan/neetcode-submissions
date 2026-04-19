class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // All the possible counts
        // store the element for the count
        // Max count value = 10000
        List<List<Integer>> counts = new ArrayList<>();
        for (int i = 0; i < 10001; i++) counts.add(new ArrayList<>());
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num: nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            counts.get(frequency.get(num)).add(num);
        }   
        
        int[] result = new int[k];
        int index = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 10000; i >= 0 && index < k; i--) {
            List<Integer> elements = counts.get(i);
            for (int j = 0; j < elements.size() && index < k; j++) {
                int element = elements.get(j);
                if (!set.contains(element)) {
                    result[index] = element;
                    set.add(element);
                    index++;
                }
            }
        }
        return result;
    }
}
