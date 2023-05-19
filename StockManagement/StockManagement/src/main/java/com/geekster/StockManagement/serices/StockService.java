package com.geekster.StockManagement.serices;

import com.geekster.StockManagement.model.Stock;
import com.geekster.StockManagement.repository.IStockRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockService {
    @Autowired
    IStockRepository stockRepository;

   // custom finder
    public List<Stock> getStockByType(String stockType) {
        return stockRepository.findByStockType(stockType);
    }
   // eg of implicit crud Repo
    public String addStocks(List<Stock> stockList) {
        Iterable<Stock> list =stockRepository.saveAll(stockList);
        if(list!=null){
            return "added list ......!!!!";
        }
        else{
            return " not added.....!!!";
        }
    }

    public List<Stock> getStockAbovePriceAndLowerDate(double price, String date) {
        LocalDateTime myDate= LocalDateTime.parse(date);
        return stockRepository.findByStockPriceGreaterThanAndStockBirthTimestampLessThan(price,myDate);
    }

    public List<Stock> getStockAboveMarketCap(double marketCap) {
        return stockRepository.getStockAboveMarketCap(marketCap);
    }
    @Transactional
    public void updateStockMarketCapById(double marketCap, Integer id){
        stockRepository.updateStockMarketCapById(marketCap,id);
    }

    @Transactional
    public void deleteStockBasedOnOwnerCount(Integer clientCount){
        stockRepository.deleteStockBasedOnOwnerCount(clientCount);
    }



}
