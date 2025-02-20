package com.PF.PoultryFarm.service;

import com.PF.PoultryFarm.dao.ProductionAndDeathRepository;
import com.PF.PoultryFarm.dao.SalesReportRepository;
import com.PF.PoultryFarm.dto.OverallProductionAndDeath;
import com.PF.PoultryFarm.dto.OverallSale;
import com.PF.PoultryFarm.dto.Report;
import com.PF.PoultryFarm.entity.ProductionAndDeath;
import com.PF.PoultryFarm.entity.Sales;
import jakarta.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReportService {
    SalesReportRepository salesReportRepository;
    ProductionAndDeathRepository productionAndDeathRepository;

    public ReportService(SalesReportRepository salesReportRepository, ProductionAndDeathRepository productionAndDeathRepository) {
        this.salesReportRepository = salesReportRepository;
        this.productionAndDeathRepository = productionAndDeathRepository;
    }

    public List<Sales> fetchSalesReport(Date startDate, Date endDate) {
        return this.salesReportRepository.findByDateBetweenOrderByDateAscShedIdAsc(startDate, endDate);
    }

    public List<Sales> fetchSalesReport(Date startDate, Date endDate, int shedId) {
        return this.salesReportRepository.findByDateBetweenAndShedIdOrderByDateAscShedIdAsc(startDate, endDate, shedId);
    }

    public List<ProductionAndDeath> fetchProductionAndDeathReport(Date startDate, Date endDate) {
        return this.productionAndDeathRepository.findByDateBetweenOrderByDateAscShedIdAsc(startDate, endDate);
    }

    public List<ProductionAndDeath> fetchProductionAndDeathReport(Date startDate, Date endDate, int shedId) {
        return this.productionAndDeathRepository.findByDateBetweenAndShedIdOrderByDateAscShedIdAsc(startDate, endDate, shedId);
    }

    public List<OverallSale> generateOverallSalesReport(Date startDate, Date endDate) {
        List<Sales> salesReport = this.fetchSalesReport(startDate, endDate);
        Map<Date, List<Integer>> saleEntryMap = new LinkedHashMap();
        List<OverallSale> overallSalesReport = new ArrayList();

        for(int i = 0; i < salesReport.size(); ++i) {
            List<Integer> sale = new ArrayList();
            sale.add(((Sales)salesReport.get(i)).getLarge());
            sale.add(((Sales)salesReport.get(i)).getSmall());
            sale.add(((Sales)salesReport.get(i)).getBroken());
            sale.add(((Sales)salesReport.get(i)).getDirty());
            Date date = ((Sales)salesReport.get(i)).getDate();
            if (!saleEntryMap.containsKey(date)) {
                saleEntryMap.put(date, sale);
            } else {
                List<Integer> otherSale = (List)saleEntryMap.get(date);

                for(int j = 0; j < sale.size(); ++j) {
                    sale.set(j, (Integer)sale.get(j) + (Integer)otherSale.get(j));
                }

                saleEntryMap.replace(date, sale);
            }
        }

        Iterator var11 = saleEntryMap.entrySet().iterator();

        while(var11.hasNext()) {
            Map.Entry<Date, List<Integer>> saleEntry = (Map.Entry)var11.next();
            OverallSale overallSale = new OverallSale();
            overallSale.setDate((Date)saleEntry.getKey());
            overallSale.setLarge((Integer)((List)saleEntry.getValue()).get(0));
            overallSale.setSmall((Integer)((List)saleEntry.getValue()).get(1));
            overallSale.setBroken((Integer)((List)saleEntry.getValue()).get(2));
            overallSale.setDirty((Integer)((List)saleEntry.getValue()).get(3));
            overallSalesReport.add(overallSale);
        }

        return overallSalesReport;
    }

    public List<OverallProductionAndDeath> generateOverallProductionAndDeathReport(Date startDate, Date endDate) {
        List<ProductionAndDeath> productionAndDeathReport = this.fetchProductionAndDeathReport(startDate, endDate);
        Map<Date, ProductionAndDeath> productionEntryMap = new LinkedHashMap();
        List<OverallProductionAndDeath> overallProductionAndDeathReport = new ArrayList();

        for(int i = 0; i < productionAndDeathReport.size(); ++i) {
            ProductionAndDeath productionAndDeath = new ProductionAndDeath();
            productionAndDeath.setLarge(((ProductionAndDeath)productionAndDeathReport.get(i)).getLarge());
            productionAndDeath.setSmall(((ProductionAndDeath)productionAndDeathReport.get(i)).getSmall());
            productionAndDeath.setBroken(((ProductionAndDeath)productionAndDeathReport.get(i)).getBroken());
            productionAndDeath.setDirty(((ProductionAndDeath)productionAndDeathReport.get(i)).getDirty());
            productionAndDeath.setDeathCnt(((ProductionAndDeath)productionAndDeathReport.get(i)).getDeathCnt());
            productionAndDeath.setProductionRatio(((ProductionAndDeath)productionAndDeathReport.get(i)).getProductionRatio());
            Date date = ((ProductionAndDeath)productionAndDeathReport.get(i)).getDate();
            if (!productionEntryMap.containsKey(date)) {
                productionEntryMap.put(date, productionAndDeath);
            } else {
                ProductionAndDeath otherProduction = (ProductionAndDeath)productionEntryMap.get(date);
                otherProduction.setLarge(productionAndDeath.getLarge() + otherProduction.getLarge());
                otherProduction.setSmall(productionAndDeath.getSmall() + otherProduction.getSmall());
                otherProduction.setBroken(productionAndDeath.getBroken() + otherProduction.getBroken());
                otherProduction.setDirty(productionAndDeath.getDirty() + otherProduction.getDirty());
                otherProduction.setDeathCnt(productionAndDeath.getDeathCnt() + otherProduction.getDeathCnt());
                otherProduction.setProductionRatio(productionAndDeath.getProductionRatio() / 5.0 + otherProduction.getProductionRatio());
                productionEntryMap.replace(date, otherProduction);
            }
        }

        Iterator var10 = productionEntryMap.entrySet().iterator();

        while(var10.hasNext()) {
            Map.Entry<Date, ProductionAndDeath> productionEntry = (Map.Entry)var10.next();
            OverallProductionAndDeath overallProductionAndDeath = new OverallProductionAndDeath();
            overallProductionAndDeath.setDate((Date)productionEntry.getKey());
            overallProductionAndDeath.setLarge(((ProductionAndDeath)productionEntry.getValue()).getLarge());
            overallProductionAndDeath.setSmall(((ProductionAndDeath)productionEntry.getValue()).getSmall());
            overallProductionAndDeath.setBroken(((ProductionAndDeath)productionEntry.getValue()).getBroken());
            overallProductionAndDeath.setDirty(((ProductionAndDeath)productionEntry.getValue()).getDirty());
            overallProductionAndDeath.setDeathCnt(((ProductionAndDeath)productionEntry.getValue()).getDeathCnt());
            overallProductionAndDeath.setProductionRatio(((ProductionAndDeath)productionEntry.getValue()).getProductionRatio());
            overallProductionAndDeathReport.add(overallProductionAndDeath);
        }

        return overallProductionAndDeathReport;
    }

    public List<Report> generateOverallConsolidatedReport(List<OverallSale> overallSales, List<OverallProductionAndDeath> overallProductionAndDeath) {
        List<Report> reportList = new ArrayList();
        List<Integer> added = new ArrayList();

        int i;
        for(i = 0; i < overallProductionAndDeath.size(); ++i) {
            added.add(0);
        }

        Report report;
        for(i = 0; i < overallSales.size(); ++i) {
            report = new Report();
            this.fillSalesDataInReport(report, (OverallSale)overallSales.get(i));

            for(int j = 0; j < overallProductionAndDeath.size(); ++j) {
                if (report.getDate().equals(((OverallProductionAndDeath)overallProductionAndDeath.get(j)).getDate())) {
                    this.fillProdDataInReport(report, (OverallProductionAndDeath)overallProductionAndDeath.get(j));
                    added.set(j, 1);
                    break;
                }
            }

            reportList.add(report);
        }

        for(i = 0; i < overallProductionAndDeath.size(); ++i) {
            report = new Report();
            if ((Integer)added.get(i) == 0) {
                this.fillProdDataInReport(report, (OverallProductionAndDeath)overallProductionAndDeath.get(i));
                reportList.add(report);
            }
        }

        if (reportList.size() != 0) {
            reportList.sort(Comparator.comparing((reportx) -> {
                return reportx.getDate();
            }));
        }

        return reportList;
    }

    public List<Report> generateConsolidatedReport(List<Sales> sales, List<ProductionAndDeath> productionAndDeaths) {
        List<Report> reportList = new ArrayList();
        List<Integer> added = new ArrayList();

        int i;
        for(i = 0; i < productionAndDeaths.size(); ++i) {
            added.add(0);
        }

        Report report;
        for(i = 0; i < sales.size(); ++i) {
            report = new Report();
            this.fillSalesDataInReport(report, (Sales)sales.get(i));

            for(int j = 0; j < productionAndDeaths.size(); ++j) {
                if (((Sales)sales.get(i)).getDate().equals(((ProductionAndDeath)productionAndDeaths.get(j)).getDate())) {
                    this.fillProdDataInReport(report, (ProductionAndDeath)productionAndDeaths.get(j));
                    added.set(j, 1);
                    break;
                }
            }

            reportList.add(report);
        }

        for(i = 0; i < productionAndDeaths.size(); ++i) {
            report = new Report();
            if ((Integer)added.get(i) == 0) {
                this.fillProdDataInReport(report, (ProductionAndDeath)productionAndDeaths.get(i));
                reportList.add(report);
            }
        }

        System.out.println(reportList.size());
        reportList.sort((r1, r2) -> {
            if (r1.getDate() == null && r2.getDate() == null) {
                return 0;
            } else if (r1.getDate() == null) {
                return 1;
            } else {
                return r2.getDate() == null ? -1 : r1.getDate().compareTo(r2.getDate());
            }
        });
        return reportList;
    }

    public void fillSalesDataInReport(Report report, OverallSale overallSale) {
        report.setDate(overallSale.getDate());
        report.setLargeSale(overallSale.getLarge());
        report.setSmallSale(overallSale.getSmall());
        report.setBrokenSale(overallSale.getBroken());
        report.setDirtySale(overallSale.getDirty());
    }

    public void fillSalesDataInReport(Report report, Sales sales) {
        report.setShedId(sales.getShedId());
        report.setDate(sales.getDate());
        report.setShedId(sales.getShedId());
        report.setLargeSale(sales.getLarge());
        report.setSmallSale(sales.getSmall());
        report.setBrokenSale(sales.getBroken());
        report.setDirtySale(sales.getDirty());
    }

    public void fillProdDataInReport(Report report, OverallProductionAndDeath overallProductionAndDeath) {
        report.setDate(overallProductionAndDeath.getDate());
        report.setLargeProd(overallProductionAndDeath.getLarge());
        report.setSmallProd(overallProductionAndDeath.getSmall());
        report.setBrokenProd(overallProductionAndDeath.getBroken());
        report.setDirtyProd(overallProductionAndDeath.getDirty());
        report.setDeath(overallProductionAndDeath.getDeathCnt());
        report.setProductionRatio(overallProductionAndDeath.getProductionRatio());
    }

    public void fillProdDataInReport(Report report, ProductionAndDeath productionAndDeath) {
        report.setShedId(productionAndDeath.getShedId());
        report.setDate(productionAndDeath.getDate());
        report.setLargeProd(productionAndDeath.getLarge());
        report.setSmallProd(productionAndDeath.getSmall());
        report.setBrokenProd(productionAndDeath.getBroken());
        report.setDirtyProd(productionAndDeath.getDirty());
        report.setDeath(productionAndDeath.getDeathCnt());
        report.setProductionRatio(productionAndDeath.getProductionRatio());
    }
}
