class Solution {
    public int solution(int[] prices, int index, int n, int buyPrice) {
        if (index >= n)
            return 0;
        if (prices[index] <= buyPrice)
            return solution(prices, index + 1, n, prices[index]);
        else {
            return Math.max(prices[index] - buyPrice + solution(prices, index + 2, n, 1001),
                    solution(prices, index + 1, n, buyPrice));
        }
    }

    public int maxProfit(int[] prices) {
        return solution(prices, 1, prices.length, prices[0]);
    }
}
