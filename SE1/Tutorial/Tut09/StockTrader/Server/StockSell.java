package SE1Tutorial.Tut09.StockTrader.Server;

class StockSell {
    private final int stockNo;
    private final long timestamp;
    private final double priceAtSell;
    private final int quantity;

    public StockSell(int stockNo, long timestamp, double priceAtSell, int quantity) {
        this.stockNo = stockNo;
        this.timestamp = timestamp;
        this.priceAtSell = priceAtSell;
        this.quantity = quantity;
    }

    public int getStockNo() {
        return stockNo;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getPriceAtPurchase() {
        return priceAtSell;
    }

    public int getQuantity() {
        return quantity;
    }
}
