class Solution {
    public boolean isValidString(String str) {
        if (str.length() > 3)
            return false;
        if (str.length() > 1 && str.charAt(0) == '0')
            return false;
        int num = Integer.parseInt(str);
        return num <= 255;
    }

    public void solution(String s, int index, int parts, String[] ip, List<String> result) {
        if (parts == ip.length - 1) {
            String currentString = s.substring(index);
            if (isValidString(currentString)) {
                ip[parts] = currentString;
                result.add(String.join(".", ip));
            }
            return;
        }

        for (int i = index + 1; i < s.length() && i - index < 4; i++) {
            String currentString = s.substring(index, i);
            if (isValidString(currentString)) {
                ip[parts] = currentString;
                solution(s, i, parts + 1, ip, result);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        String[] ip = new String[4];
        solution(s, 0, 0, ip, result);
        return result;
    }
}