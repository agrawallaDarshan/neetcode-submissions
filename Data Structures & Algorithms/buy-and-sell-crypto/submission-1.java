class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], index = 1, result = 0;
        while (index < prices.length) {
            buy = Math.min(buy, prices[index]);
            result = Math.max(result, prices[index] - buy);
            index++;
        }   
        return result;
    }
}
