class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int start = 0, end = map.get(s.charAt(start)), index = 0;
        while (true) {
            while (index <= end) {
                int lIdx = map.get(s.charAt(index));
                end = Math.max(end, lIdx);
                index++;
            }
            result.add(index - start);
            if (index < s.length()) {
                start = index;
                end = map.get(s.charAt(start));
            } else {
                break;
            }
        }
        return result;
    }
}