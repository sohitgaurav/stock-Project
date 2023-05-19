package com.geekster.StockManagement.controller;


import com.geekster.StockManagement.model.Stock;
import com.geekster.StockManagement.serices.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value="/stock")
public class StockController {
    @Autowired
    StockService stockService;

    //get Stock by StockType
    @GetMapping(value="/type/{stockType}")
    public List<Stock> getStockBasedOnType(@PathVariable String stockType){
        return stockService.getStockByType(stockType);
    }
     // custom finder
    //get stock Above price lower date
    @GetMapping(value="/abovePrice/price/{price}/lowerDate/date/{date}")
    public List<Stock> getStockAbovePriceAndLowerDate(@PathVariable double price , @PathVariable  String date){
        return  stockService.getStockAbovePriceAndLowerDate(price, date);
    }

    //custom query

    @GetMapping(value="/cap/{marketCap}")
    public List<Stock> getStockAboveMarketCap(@PathVariable double marketCap ){
        return  stockService.getStockAboveMarketCap(marketCap);
    }
    //update marketCap By Id     custom Query
    @PutMapping(value="/update/marketCap/{marketCap}/Id/{id}")
    public void updateStockMarketCapById(@PathVariable double marketCap,@PathVariable Integer id){
         stockService.updateStockMarketCapById(marketCap,id);

    }

    @PostMapping(value="/")
    public String insertStock(@RequestBody List<Stock>  stockList){
        return stockService.addStocks(stockList);
    }
    @DeleteMapping(value="/ownerCount/{clientCount}")
    public Void removeOnOwnerCount(@PathVariable Integer clientCount){
        stockService.deleteStockBasedOnOwnerCount(clientCount);

        return null;
    }


}
