package com.nemchann.campaign;

public class StockPriceChangeEvent {
    private final Stock stock;
    private final double newPrice;

    public StockPriceChangeEvent(Stock stock, double newPrice) {
        this.stock = stock;
        this.newPrice = newPrice;
    }

    public Stock getStock() {
        return stock;
    }


    public double getNewPrice() {
        return newPrice;
    }


    public String getMessage() {
        return String.format("Акция %s: цена изменилась и стала %.2f",
                stock.getName(), newPrice);
    }
}
