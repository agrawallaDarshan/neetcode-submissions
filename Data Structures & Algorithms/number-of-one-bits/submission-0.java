class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        for (int j = 31; j >= 0; j--) {
            int mask = 1 << j;
            if ((n & mask) != 0)
                result++;
        }
        return result;
    }
}
