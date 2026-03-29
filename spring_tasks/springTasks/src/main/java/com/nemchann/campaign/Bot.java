package com.nemchann.campaign;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Bot {
    private final String trackedStock;

    public Bot(@Qualifier("botStock") String stockName) {
        this.trackedStock = stockName;
        System.out.println("Бот следит за акцией: " + trackedStock);
    }

    @EventListener
    public void onPriceChange(StockPriceChangeEvent event) {
        String stockName = event.getStock().getName();

        if (trackedStock.equals(stockName)) {
            System.out.println("[БОТ] Внимание! " + event.getMessage());
        }
    }
}
