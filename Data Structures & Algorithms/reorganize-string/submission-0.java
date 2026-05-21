class Pair {
    char ch;
    int count;

    Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public String reorganizeString(String s) {
        int n = s.length(), limit = (n / 2) + (n % 2);
        if (n == 1)
            return s;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            if (count[s.charAt(i) - 'a'] > limit)
                return "";
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        for (int i = 0; i < 26; i++)
            if (count[i] > 0)
                pq.add(new Pair((char) (i + 'a'), count[i]));
        int index = 0;
        char[] result = new char[n];
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            while (pair.count > 0) {
                result[index] = pair.ch;
                pair.count--;
                if (index + 2 >= n)
                    index = 1;
                else
                    index += 2;
            }
        }
        String ans = new String(result);
        return ans;
    }
}