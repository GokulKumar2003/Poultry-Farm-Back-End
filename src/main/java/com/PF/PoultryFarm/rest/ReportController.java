package com.PF.PoultryFarm.rest;

import com.PF.PoultryFarm.dto.OverallProductionAndDeath;
import com.PF.PoultryFarm.dto.OverallSale;
import com.PF.PoultryFarm.dto.Report;
import com.PF.PoultryFarm.dto.ReportReqMsg;
import com.PF.PoultryFarm.entity.ProductionAndDeath;
import com.PF.PoultryFarm.entity.Sales;
import com.PF.PoultryFarm.service.ReportService;
import jakarta.annotation.security.PermitAll;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
        origins = {"http://localhost:5173"}
)
@RequestMapping({"/api/1.0/reports"})
public class ReportController {
    ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PermitAll
    @PostMapping({"/shed_report"})
    public List<Report> getSalesAndProdcutionReport(@RequestBody ReportReqMsg reqMsg) {
        List<Sales> sales = this.reportService.fetchSalesReport(reqMsg.getStartDate(), reqMsg.getEndDate(), reqMsg.getShedId());
        System.out.println(sales);
        List<ProductionAndDeath> productionAndDeath = this.reportService.fetchProductionAndDeathReport(reqMsg.getStartDate(), reqMsg.getEndDate(), reqMsg.getShedId());
        System.out.println(productionAndDeath);
        List<Report> report = this.reportService.generateConsolidatedReport(sales, productionAndDeath);
        System.out.println("Controllor: " + report.size());
        System.out.println(report);
        return report;
    }

    @PermitAll
    @PostMapping({"/overall_report"})
    public List<Report> getOverallSalesAndProductionReport(@RequestBody ReportReqMsg reqMsg) {
        List<OverallSale> overallSales = this.reportService.generateOverallSalesReport(reqMsg.getStartDate(), reqMsg.getEndDate());
        System.out.println(overallSales.toString());
        List<OverallProductionAndDeath> overallProductionAndDeath = this.reportService.generateOverallProductionAndDeathReport(reqMsg.getStartDate(), reqMsg.getEndDate());
        List<Report> report = this.reportService.generateOverallConsolidatedReport(overallSales, overallProductionAndDeath);
        return report;
    }
}
