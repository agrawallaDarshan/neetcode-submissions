class Solution {
    public int maxProfit(int[] prices) {
        int sell = prices[0], buy = prices[0], index = 1, result = 0;
        while (index < prices.length) {
            sell = Math.max(sell, prices[index]);
            if (prices[index] < buy) {
                buy = prices[index];
                sell = prices[index];
            }
            result = Math.max(result, sell - buy);
            index++;
        }   
        return result;
    }
}
