package com.PF.PoultryFarm.service;

import com.PF.PoultryFarm.dao.ProductionAndDeathRepository;
import com.PF.PoultryFarm.dao.SalesReportRepository;
import com.PF.PoultryFarm.dao.ShedProductionRepository;
import com.PF.PoultryFarm.dao.ShedStockRepository;
import com.PF.PoultryFarm.dto.DetailedStock;
import com.PF.PoultryFarm.dto.StockUpdateData;
import com.PF.PoultryFarm.entity.CompositeKey;
import com.PF.PoultryFarm.entity.ProductionAndDeath;
import com.PF.PoultryFarm.entity.Sales;
import com.PF.PoultryFarm.entity.ShedProduction;
import com.PF.PoultryFarm.entity.ShedStock;
import jakarta.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StockService {
    ShedStockRepository shedStockRepository;
    ShedProductionRepository shedProductionRepository;
    SalesReportRepository salesReportRepository;
    ProductionAndDeathRepository productionAndDeathRepository;

    @Autowired
    public StockService(ShedStockRepository shedStockRepository, ShedProductionRepository shedProductionRepository, SalesReportRepository salesReportRepository, ProductionAndDeathRepository productionAndDeathRepository) {
        this.shedStockRepository = shedStockRepository;
        this.shedProductionRepository = shedProductionRepository;
        this.salesReportRepository = salesReportRepository;
        this.productionAndDeathRepository = productionAndDeathRepository;
    }

    public void updateShedStockSales(Sales newEntry, Sales oldEntry, boolean is_new, ShedStock shedStock) {
        if (!is_new) {
            shedStock.setLargeEggs(shedStock.getLargeEggs() + oldEntry.getLarge());
            shedStock.setSmallEggs(shedStock.getSmallEggs() + oldEntry.getSmall());
            shedStock.setBrokenEggs(shedStock.getBrokenEggs() + oldEntry.getBroken());
            shedStock.setDirtyEggs(shedStock.getDirtyEggs() + oldEntry.getDirty());
        }

        shedStock.setLargeEggs(shedStock.getLargeEggs() - newEntry.getLarge());
        shedStock.setSmallEggs(shedStock.getSmallEggs() - newEntry.getSmall());
        shedStock.setBrokenEggs(shedStock.getBrokenEggs() - newEntry.getBroken());
        shedStock.setDirtyEggs(shedStock.getDirtyEggs() - newEntry.getDirty());
    }

    public void updateShedStockProduction(ProductionAndDeath newEntry, ProductionAndDeath oldEntry, boolean is_new, ShedStock shedStock) {
        if (!is_new) {
            shedStock.setLargeEggs(shedStock.getLargeEggs() - oldEntry.getLarge());
            shedStock.setSmallEggs(shedStock.getSmallEggs() - oldEntry.getSmall());
            shedStock.setBrokenEggs(shedStock.getBrokenEggs() - oldEntry.getBroken());
            shedStock.setDirtyEggs(shedStock.getDirtyEggs() - oldEntry.getDirty());
        }

        shedStock.setLargeEggs(shedStock.getLargeEggs() + newEntry.getLarge());
        shedStock.setSmallEggs(shedStock.getSmallEggs() + newEntry.getSmall());
        shedStock.setBrokenEggs(shedStock.getBrokenEggs() + newEntry.getBroken());
        shedStock.setDirtyEggs(shedStock.getDirtyEggs() + newEntry.getDirty());
    }

    public void updateSaleEntry(Sales sales, ShedStock shedStock) {
        CompositeKey key = new CompositeKey();
        key.setShedId(sales.getShedId());
        key.setDate(sales.getDate());
        Optional<Sales> salesEntryInDB = this.salesReportRepository.findById(key);
        if (salesEntryInDB.isPresent()) {
            this.updateShedStockSales(sales, (Sales)salesEntryInDB.get(), false, shedStock);
        } else {
            this.updateShedStockSales(sales, (Sales)null, true, shedStock);
        }

        System.out.println(sales.toString());
        this.salesReportRepository.save(sales);
    }

    public void updateProductionAndDeathEntry(ProductionAndDeath productionAndDeath, ShedStock shedStock) {
        CompositeKey key = new CompositeKey();
        key.setDate(productionAndDeath.getDate());
        key.setShedId(productionAndDeath.getShedId());
        Optional<ProductionAndDeath> productionAndDeathEntryInDB = this.productionAndDeathRepository.findById(key);
        if (productionAndDeathEntryInDB.isPresent()) {
            this.updateShedStockProduction(productionAndDeath, (ProductionAndDeath)productionAndDeathEntryInDB.get(), false, shedStock);
            this.updateShedProduction(productionAndDeath, (ProductionAndDeath)productionAndDeathEntryInDB.get(), false);
        } else {
            this.updateShedStockProduction(productionAndDeath, (ProductionAndDeath)null, true, shedStock);
            this.updateShedProduction(productionAndDeath, (ProductionAndDeath)null, true);
        }

        System.out.println(productionAndDeath.toString());
        this.productionAndDeathRepository.save(productionAndDeath);
    }

    public void updateShedProduction(ProductionAndDeath newEntry, ProductionAndDeath oldEntry, boolean is_new) {
        Optional<ShedProduction> shedProductionEntryInDB = this.shedProductionRepository.findById(newEntry.getShedId());
        ShedProduction shedProduction = null;
        if (shedProductionEntryInDB.isPresent()) {
            shedProduction = (ShedProduction)shedProductionEntryInDB.get();
        }

        if (!is_new) {
            shedProduction.setLarge(shedProduction.getLarge() - oldEntry.getLarge());
            shedProduction.setSmall(shedProduction.getSmall() - oldEntry.getSmall());
            shedProduction.setBroken(shedProduction.getBroken() - oldEntry.getBroken());
            shedProduction.setDirty(shedProduction.getDirty() - oldEntry.getDirty());
            shedProduction.setTotalBirds(shedProduction.getTotalBirds() + oldEntry.getDeathCnt());
            shedProduction.setDeathCnt(shedProduction.getDeathCnt() - oldEntry.getDeathCnt());
            shedProduction.setBatchDuration(shedProduction.getBatchDuration() - 1);
        }

        shedProduction.setLarge(shedProduction.getLarge() + newEntry.getLarge());
        shedProduction.setSmall(shedProduction.getSmall() + newEntry.getSmall());
        shedProduction.setBroken(shedProduction.getBroken() + newEntry.getBroken());
        shedProduction.setDirty(shedProduction.getDirty() + newEntry.getDirty());
        shedProduction.setDeathCnt(shedProduction.getDeathCnt() + newEntry.getDeathCnt());
        shedProduction.setTotal(shedProduction.getLarge() + shedProduction.getSmall() + shedProduction.getBroken() + shedProduction.getDirty());
        shedProduction.setTotalBirds(shedProduction.getTotalBirds() - newEntry.getDeathCnt());
        int todaysProduction = newEntry.getLarge() + newEntry.getSmall() + newEntry.getBroken() + newEntry.getDirty();
        double todaysProductionRatio = (double)(todaysProduction * 30) / (double)shedProduction.getTotalBirds();
        int days = shedProduction.getBatchDuration();
        double avgProductionRatio = (todaysProductionRatio + shedProduction.getProductionRatio() * (double)days) / (double)(days + 1);
        shedProduction.setProductionRatio(avgProductionRatio);
        shedProduction.setBatchDuration(shedProduction.getBatchDuration() + 1);
        newEntry.setProductionRatio(todaysProductionRatio);
        System.out.println(shedProduction.toString());
        this.shedProductionRepository.save(shedProduction);
    }

    public void updateStock(StockUpdateData stockUpdateData) {
        Optional<ShedStock> shedStockEntryInDB = this.shedStockRepository.findById(stockUpdateData.getShedId());
        ShedStock shedStock = null;
        if (shedStockEntryInDB.isPresent()) {
            shedStock = (ShedStock)shedStockEntryInDB.get();
        }

        Sales sales = new Sales();
        sales.setShedId(stockUpdateData.getShedId());
        sales.setDate(stockUpdateData.getDate());
        sales.setLarge(stockUpdateData.getLargeSale());
        sales.setSmall(stockUpdateData.getSmallSale());
        sales.setBroken(stockUpdateData.getBrokenSale());
        sales.setDirty(stockUpdateData.getDirtySale());
        ProductionAndDeath productionAndDeath = new ProductionAndDeath();
        productionAndDeath.setShedId(stockUpdateData.getShedId());
        productionAndDeath.setDate(stockUpdateData.getDate());
        productionAndDeath.setLarge(stockUpdateData.getLargeProduction());
        productionAndDeath.setSmall(stockUpdateData.getSmallProduction());
        productionAndDeath.setBroken(stockUpdateData.getBrokenProduction());
        productionAndDeath.setDirty(stockUpdateData.getDirtyProduction());
        productionAndDeath.setDeathCnt(stockUpdateData.getDeathCnt());
        this.updateSaleEntry(sales, shedStock);
        this.updateProductionAndDeathEntry(productionAndDeath, shedStock);
        System.out.println(shedStock.toString());
        this.shedStockRepository.save(shedStock);
    }

    public List<DetailedStock> getDetailedStock() {
        List<ShedStock> shedStockList = this.fetchStock();
        List<ShedProduction> shedProductionList = this.fetchShedProduction();
        List<DetailedStock> detailedStockList = new ArrayList();

        for(int i = 0; i < shedStockList.size(); ++i) {
            DetailedStock detailedStock = new DetailedStock();
            detailedStock.setShedId(((ShedStock)shedStockList.get(i)).getShedId());
            detailedStock.setLarge(((ShedStock)shedStockList.get(i)).getLargeEggs());
            detailedStock.setSmall(((ShedStock)shedStockList.get(i)).getSmallEggs());
            detailedStock.setBroken(((ShedStock)shedStockList.get(i)).getBrokenEggs());
            detailedStock.setDirty(((ShedStock)shedStockList.get(i)).getDirtyEggs());
            detailedStock.setProductionRatio(((ShedProduction)shedProductionList.get(i)).getProductionRatio());
            detailedStock.setDeathCnt(((ShedProduction)shedProductionList.get(i)).getDeathCnt());
            detailedStock.setBirdsCnt(((ShedProduction)shedProductionList.get(i)).getTotalBirds());
            detailedStock.setDuration(((ShedProduction)shedProductionList.get(i)).getBatchDuration());
            detailedStock.setBatchStartDate(((ShedProduction)shedProductionList.get(i)).getBatchStartDate());
            detailedStockList.add(detailedStock);
        }

        return detailedStockList;
    }

    public List<ShedStock> fetchStock() {
        return this.shedStockRepository.findAll();
    }

    public List<ShedProduction> fetchShedProduction() {
        return this.shedProductionRepository.findAll();
    }

    public void resetStock(int shedId, int birdsCnt, Date startDate) {
        ShedStock shedStock = new ShedStock();
        shedStock.setShedId(shedId);
        this.shedStockRepository.save(shedStock);
        ShedProduction shedProduction = new ShedProduction();
        shedProduction.setShedId(shedId);
        shedProduction.setTotalBirds(birdsCnt);
        shedProduction.setBatchStartDate(startDate);
        System.out.println(startDate);
        this.shedProductionRepository.save(shedProduction);
    }
}
