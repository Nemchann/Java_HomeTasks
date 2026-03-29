package com.nemchann.campaign;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class StockService {
    private final Map<String, Stock> stocks = new HashMap<>();

    public StockService(@Qualifier("orclStock") Stock orclStock, @Qualifier("tslaStock") Stock tslaStock){
        stocks.put(orclStock.getName(), orclStock);
        stocks.put(tslaStock.getName(), tslaStock);
    }

    public Stock getStock(String name){
        return stocks.get(name);
    }

    public void updatePrice(String stockName, double newPrice) {
        Stock stock = stocks.get(stockName);
        if (stock != null) {
            stock.setPrice(newPrice);
        } else {
            throw new IllegalArgumentException("Акция не найдена: " + stockName);
        }
    }

}
