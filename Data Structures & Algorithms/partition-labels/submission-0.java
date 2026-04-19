class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        int start = 0, end = sb.lastIndexOf("" + s.charAt(start)), index = 0;
        while (true) {
            while (index <= end) {
                int lIdx = sb.lastIndexOf("" + s.charAt(index));
                end = Math.max(end, lIdx);
                index++;
            }
            result.add(index - start);
            if (index < s.length()) {
                start = index;
                end = sb.lastIndexOf("" + s.charAt(start));
            } else {
                break;
            }
        }
        return result;
    }
}