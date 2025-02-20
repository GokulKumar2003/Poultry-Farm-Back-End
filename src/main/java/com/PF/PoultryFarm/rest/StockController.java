package com.PF.PoultryFarm.rest;

import com.PF.PoultryFarm.dto.DetailedStock;
import com.PF.PoultryFarm.dto.ResetData;
import com.PF.PoultryFarm.dto.StockUpdateData;
import com.PF.PoultryFarm.service.StockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://www.anbupf.com")
@RequestMapping({"/api/1.0/stocks"})
public class StockController {
    StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping({""})
    public List<DetailedStock> getStock() {
        return this.stockService.getDetailedStock();
    }

    @PostMapping({""})
    public void updateStock(@RequestBody StockUpdateData stockUpdateData) {
        System.out.println(stockUpdateData.toString());
        this.stockService.updateStock(stockUpdateData);
    }

    @PostMapping({"/reset"})
    public void resetStock(@RequestBody ResetData resetData) {
        System.out.println(resetData);
        this.stockService.resetStock(resetData.getShedId(), resetData.getBirdsCnt(), resetData.getBatchStartDate());
    }
}
