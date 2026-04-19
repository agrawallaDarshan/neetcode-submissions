class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 31; j >= 0; j--) {
                int mask = 1 << j;
                if ((i & mask) != 0)
                    result[i]++;
            }
        }
        return result;
    }
}