# stock-Project
java project using annotation validation enum 

java project using annotation validation Enum crudRpository 

## Framework and language used
* Springboot
* java

## dependency used
 * dev
 * web
 * lombok
 * h2-database
 * jpa
 * spring boot starter data jpa 

## Data Flow

### Stock
* 
* Integer StockId;
* String stockName;
*  Double stockPrice;
* Integer stockOwnerCount;
* String stockType
* Double stockMarketCapl 
* LocalDateTime stockBirthTimestamp;

### stockController
* @GetMapping  
    * getStockBasedOnType
    * getStockAbovePriceAndLowerDate
    * getStockAboveMarketCap
    * 
    
* @PostMapping
    * insertStock

 


*  @Putmapping 
    * updateStockMarketCapById

### StockService
 *  getStockByType
 *  addStocks
 *  getStockAbovePriceAndLowerDate
 *  getStockAboveMarketCap
 *  updateStockMarketCapById

### StockRepository
* findByStockType
* findByStockPriceGreaterThanAndStockBirthTimestampLessThan
* getStockAboveMarketCap
* updateStockMarketCapById
* deleteStockBasedOnOwnerCount

### Database used
* h2 datbase as dependency

##  About Project
* this Project is the about information about Stockmanagement System
