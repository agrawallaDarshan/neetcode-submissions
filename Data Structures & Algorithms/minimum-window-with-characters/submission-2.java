class Solution {
    public boolean compareMap(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        // All characters of map2 should present on map1
        // worst case: O(52) -> constant time
        if (map1.size() < map2.size())
            return false;
        for (Character ch : map2.keySet())
            if (map1.getOrDefault(ch, 0) < map2.get(ch))
                return false;
        return true;
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>(); // s
        HashMap<Character, Integer> map2 = new HashMap<>(); // t
        // tc -> O(n)
        for (int i = 0; i < t.length(); i++)
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        // tc -> O(m + n)
        int start = -1, end = -1;
        int left = 0, current = 0;
        while (current < s.length()) {
            map1.put(s.charAt(current), map1.getOrDefault(s.charAt(current), 0) + 1);
            while (compareMap(map1, map2)) {
                if ((start == -1 && end == -1) || (current - left < end - start)) {
                    start = left;
                    end = current;
                }
                map1.put(s.charAt(left), map1.get(s.charAt(left)) - 1);
                if (map1.get(s.charAt(left)) == 0)
                    map1.remove(s.charAt(left));
                left++;
            }
            current++;
        }
        return start == -1 ? "" : s.substring(start, end + 1);
    }
}