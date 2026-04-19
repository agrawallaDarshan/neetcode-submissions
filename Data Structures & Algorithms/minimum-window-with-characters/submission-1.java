class Solution {
    public boolean areTwoMapsEqual(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for (Character ch: map2.keySet()) {
            if (map2.get(ch) > map1.getOrDefault(ch, 0)) return false;
        }
        return true;
    }

    public void updateMap(HashMap<Character, Integer> map, char ch) {
        if (map.get(ch) == 1) map.remove(ch);
        else map.put(ch, map.get(ch) - 1);
    }

    public String minWindow(String s, String t) {
        // s="ADOBECODEBANC"
        // t="ABC"
        HashMap<Character, Integer> mapt = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            mapt.put(ch, mapt.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> maps = new HashMap<>();
        String result = "";
        int right = 0, left = 0, n = s.length();
        while (right < n) {
            char ch = s.charAt(right);
            maps.put(ch, maps.getOrDefault(ch, 0) + 1);
            if (areTwoMapsEqual(maps, mapt)) {
                while (areTwoMapsEqual(maps, mapt)) {
                    char chl = s.charAt(left);
                    updateMap(maps, chl);
                    left++;
                }
                String sub = s.substring(left - 1, right + 1);
                if (result.equals("") || sub.length() < result.length()) {
                    result = sub;
                }
            }
            right++;
        }
        return result;
    }
}
