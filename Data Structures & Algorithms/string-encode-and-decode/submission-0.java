class Solution {

    public String convertNumberToString(int size) {
        if (size < 10) return "00" + size;
        if (size < 100) return "0" + size;
        return "" + size;
    }

    public String encode(List<String> strs) {
        String encoded = "";
        encoded += convertNumberToString(strs.size());
        String lengths = "";
        String data = "";
        for (String str: strs) {
            lengths += convertNumberToString(str.length());
            data += str;
        }
        encoded += lengths + data;
        return encoded;
    }

    public List<String> decode(String str) {
        // 004004004004003neetcodeloveyou
        List<String> result = new ArrayList<>();
        int size = Integer.parseInt(str.substring(0, 3));
        if (size == 0) return result;
        int endIndexOfLengths = 3 + (3 * size);
        String lengths = str.substring(3, endIndexOfLengths);
        String data = str.substring(endIndexOfLengths);
        int i = 0, j = 0;
        while (size > 0) {
            int currentSize = Integer.parseInt(lengths.substring(i, i + 3));
            result.add(data.substring(j, j + currentSize));
            j += currentSize;
            i += 3;
            size--;
        }
        return result;
    }
}
