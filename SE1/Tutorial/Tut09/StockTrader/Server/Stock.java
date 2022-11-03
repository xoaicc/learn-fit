package SE1Tutorial.Tut09.StockTrader.Server;

class Stock {
    private final int stockNo;
    private int quantity;
    private double price;

    public Stock(int stockNo, int quantity, double price) {
        this.stockNo = stockNo;
        this.quantity = quantity;
        this.price = price;
    }

    public int getStockNo() {
        return stockNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
