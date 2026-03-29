package com.nemchann.campaign;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Printer{
    private final Set<String> trackedStocks = new HashSet<>();

    public Printer(@Qualifier("printerStocks") Set<String> stockNames) {
        this.trackedStocks.addAll(stockNames);
        System.out.println("Принтер следит за акциями: " + trackedStocks);
    }

    @EventListener
    public void onPriceChange(StockPriceChangeEvent event) {
        String stockName = event.getStock().getName();

        if (trackedStocks.contains(stockName)) {
            System.out.println("[ПРИНТЕР] " + event.getMessage());
        }
    }
}
