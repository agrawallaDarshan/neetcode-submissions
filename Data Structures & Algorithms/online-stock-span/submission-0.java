class Stock {
    int value;
    int stockSpan;

    Stock(int value, int stockSpan) {
        this.value = value;
        this.stockSpan = stockSpan;
    }
}

class StockSpanner {

    Stack<Stock> st;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int result = 1;
        while (!st.isEmpty() && st.peek().value <= price) {
            Stock stock = st.pop();
            result += stock.stockSpan;
        }
        st.add(new Stock(price, result));
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */