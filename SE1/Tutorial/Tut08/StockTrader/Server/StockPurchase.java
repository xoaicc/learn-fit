package SE1Tutorial.Tut08.StockTrader.Server;

class StockPurchase {
    private final int stockNo;
    private final long timestamp;
    private final double priceAtPurchase;
    private final int quantity;

    public StockPurchase(int stockNo, long timestamp, double priceAtPurchase, int quantity) {
        this.stockNo = stockNo;
        this.timestamp = timestamp;
        this.priceAtPurchase = priceAtPurchase;
        this.quantity = quantity;
    }

    public int getStockNo() {
        return stockNo;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getPriceAtPurchase() {
        return priceAtPurchase;
    }

    public int getQuantity() {
        return quantity;
    }
}
