package com.geekster.StockManagement.repository;

import com.geekster.StockManagement.model.Stock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IStockRepository extends CrudRepository<Stock,Integer> {
    // custom finder
  public List<Stock> findByStockType(String stockType);


  public List<Stock> findByStockPriceGreaterThanAndStockBirthTimestampLessThan(double price, LocalDateTime myDate);
// custom query
  //native query

  @Query(value="select * from Stock  where STOCK_MARKET_CAP  > :marketCap",nativeQuery = true)
  public List<Stock> getStockAboveMarketCap(double marketCap);

@Modifying     //to update
  @Query(value=" update STOCk set STOCK_MARKET_CAP = :marketCap where STOCK_ID =:id ",nativeQuery = true)
    public void updateStockMarketCapById(double marketCap, Integer id);

@Modifying
  @Query(value="delete from STOCK where STOCK_OWNER_COUNT <= :clientCount",nativeQuery = true)
  public void deleteStockBasedOnOwnerCount(Integer clientCount);
}
