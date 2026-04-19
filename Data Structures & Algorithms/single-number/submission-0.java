class Solution {
    public int singleNumber(int[] nums) {
        int xorp = 0, xorn = 0;
        for (int num : nums) {
            if (num >= 0)
                xorp ^= num;
            else
                xorn ^= (num * -1);
        }
        if (xorn > 0)
            return xorn * -1;
        else
            return xorp;
    }
}