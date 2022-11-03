package SE1Tutorial.Tut09.StockTrader.Server;

import java.time.Instant;
import java.util.*;

// Should be StockController -- storing business logic
public class StockServer {
    private static final Map<String, String> ALLOWED_USERS = new HashMap<>();

    static {
        // map.put(key, value) -> { key => value }
        // map.put(k1, v1) -> { key : value, k1 : v1 }
        ALLOWED_USERS.put("vuong", "1234");
    }

    private boolean hasLogin = false;
    private final Map<Integer, Stock> allStocks = new HashMap<>();
    private final Map<Integer, Stock> yourStocks = new HashMap<>();
    private final Map<Integer, StockPurchase> yourPurchases = new HashMap<>();
    private final Map<Integer, StockSell> yourSell = new HashMap<>();

    public StockServer() {
        // initialize some stock no
        allStocks.put(1, new Stock(1, 100, 20.0));
        allStocks.put(2, new Stock(2, 200, 12.0));
        allStocks.put(3, new Stock(3, 150, 16.0));
        allStocks.put(4, new Stock(4, 500, 14.0));
    }

    /**
     * @effects <pre>
     *     if username in ALLOWED_USERS and password = ALLOWED_USERS[username]
     *       set this.hasLogin = true
     *       return "OK"
     *     else
     *       return "aopsdjasdasd" (not logged in)
     * </pre>
     */
    public String login(String username, String password) {
        if (ALLOWED_USERS.containsKey(username)
                && password.equals(ALLOWED_USERS.get(username))) {
            this.hasLogin = true;
            return "OK";
        } else {
            return "aopsdjasdasd";
        }
    }

    public String listAllStocks() {
        nextDay();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Updated ").append(new Date()).append("\n");
        String heading = "   # | Stock No | Quantity | Price ";
        String format = "     | %8s | %8s | %5s";
        if (allStocks.isEmpty()) {
            stringBuilder.append("No stock available!");
        } else {
            stringBuilder.append(heading);
            for (Stock stock : allStocks.values()) {
                stringBuilder.append("\n").append(String.format(
                    format, stock.getStockNo(), stock.getQuantity(), stock.getPrice()
                ));
            }
        }
        return stringBuilder.toString();
    }

    public boolean purchase(int stockNo, int quantity) {
        double nowPrive = allStocks.get(stockNo).getPrice();
        int beforeQuantity = allStocks.get(stockNo).getQuantity();
        if (!allStocks.containsKey(stockNo)) {
            return false;
        }
        if (beforeQuantity < quantity) {
            return false;
        } else if (beforeQuantity == quantity) {
            allStocks.remove(stockNo);
        } else {
            allStocks.get(stockNo).setQuantity(beforeQuantity - quantity);
        }
        StockPurchase purchase = new StockPurchase(
                stockNo,
                System.currentTimeMillis(),
                nowPrive,
                quantity
        );
        yourStocks.put(stockNo, new Stock(stockNo, quantity, nowPrive));
        return yourPurchases.put(stockNo, purchase) != null;
    }

    public String listOwnStocks() {
        StringBuilder stringBuilder = new StringBuilder();
        String heading = "   # | Stock No | Quantity | Price ";
        String format = "     | %8s | %8s | %5s";
        if (yourStocks.isEmpty()) {
            stringBuilder.append("No stock available!");
        } else {
            stringBuilder.append(heading);
            for (Stock stock : yourStocks.values()) {
                stringBuilder.append("\n").append(String.format(
                    format, stock.getStockNo(), stock.getQuantity(), stock.getPrice()
                ));
            }
        }
        return stringBuilder.toString();
    }

    public boolean sellStock(int stockNo, int quantity) {
        double nowPrive = yourStocks.get(stockNo).getPrice();
        int yourQuantity = yourStocks.get(stockNo).getQuantity();
        int currentQuantity = allStocks.get(stockNo).getQuantity();
        if (!yourStocks.containsKey(stockNo)) {
            return false;
        }
        if (yourQuantity < quantity) {
            return false;
        } else if (yourQuantity == quantity) {
            yourStocks.remove(stockNo);
        } else {
            yourStocks.get(stockNo).setQuantity(yourQuantity - quantity);
        }
        StockSell sell = new StockSell(
                stockNo,
                System.currentTimeMillis(),
                nowPrive,
                quantity
        );
        allStocks.put(stockNo, new Stock(stockNo, currentQuantity + quantity, nowPrive));
        return yourSell.put(stockNo, sell) != null;
    }

    public void nextDay() {
        Random random = new Random();
        double floor = 10;
        double ceiling = 100;
        for (Stock stock : allStocks.values()) {
            double newPrice = floor + random.nextDouble() * (ceiling - floor);
            stock.setPrice(newPrice);
        }
        for (Stock stock : yourStocks.values()) {
            stock.setPrice(allStocks.get(stock.getStockNo()).getPrice());
        }
    }

    public String trackStocks() {
        StringBuilder stringBuilder = new StringBuilder();
        String heading = "   # | Stock no | Purchase time | Price at purchase |   Current price   | Benefit ";
        String format = "     | %8s | %13s | %17s | %17s | %7s ";
        if (yourStocks.isEmpty()) {
            stringBuilder.append("No stock available!");
        } else {
            stringBuilder.append(heading);
            for (Stock stock : yourStocks.values()) {
                long timestamp = yourPurchases.get(stock.getStockNo()).getTimestamp();
                double priceAtPurchase = yourPurchases.get(stock.getStockNo()).getPriceAtPurchase();
                stringBuilder.append("\n").append(String.format(
                    format, stock.getStockNo(), timestamp, priceAtPurchase, stock.getPrice(), stock.getPrice() - priceAtPurchase
                ));
            }
        }
        return stringBuilder.toString();
    }
}
