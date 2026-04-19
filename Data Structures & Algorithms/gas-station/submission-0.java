class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, sum = 0;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }
        if (sum < 0)
            return -1;
        int res = 0, max = sum;
        for (int i = 1; i < n; i++) {
            sum -= diff[i - 1];
            if (max < sum) {
                res = i;
                max = sum;
            }
        }
        return res;
    }
}