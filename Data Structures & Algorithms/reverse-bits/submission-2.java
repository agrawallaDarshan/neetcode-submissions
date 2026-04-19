class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            if ((n & mask) != 0) {
                res |= (1 << (31 - i));
            }
        }
        return res;
    }
}
