package com.PF.PoultryFarm.dto;

import java.sql.Date;

public class Report {
    private int shedId;
    private Date date;
    private int largeProd;
    private int smallProd;
    private int brokenProd;
    private int dirtyProd;
    private int largeSale;
    private int smallSale;
    private int brokenSale;
    private int dirtySale;
    private int death;
    private double productionRatio;

    public Report() {
    }

    public Report(int shedId, Date date, int largeProd, int smallProd, int brokenProd, int dirtyProd, int largeSale, int smallSale, int brokenSale, int dirtySale, int death, double productionRatio) {
        this.shedId = shedId;
        this.date = date;
        this.largeProd = largeProd;
        this.smallProd = smallProd;
        this.brokenProd = brokenProd;
        this.dirtyProd = dirtyProd;
        this.largeSale = largeSale;
        this.smallSale = smallSale;
        this.brokenSale = brokenSale;
        this.dirtySale = dirtySale;
        this.death = death;
        this.productionRatio = productionRatio;
    }

    public int getShedId() {
        return this.shedId;
    }

    public void setShedId(int shedId) {
        this.shedId = shedId;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLargeProd() {
        return this.largeProd;
    }

    public void setLargeProd(int largeProd) {
        this.largeProd = largeProd;
    }

    public int getSmallProd() {
        return this.smallProd;
    }

    public void setSmallProd(int smallProd) {
        this.smallProd = smallProd;
    }

    public int getBrokenProd() {
        return this.brokenProd;
    }

    public void setBrokenProd(int brokenProd) {
        this.brokenProd = brokenProd;
    }

    public int getDirtyProd() {
        return this.dirtyProd;
    }

    public void setDirtyProd(int dirtyProd) {
        this.dirtyProd = dirtyProd;
    }

    public int getLargeSale() {
        return this.largeSale;
    }

    public void setLargeSale(int largeSale) {
        this.largeSale = largeSale;
    }

    public int getSmallSale() {
        return this.smallSale;
    }

    public void setSmallSale(int smallSale) {
        this.smallSale = smallSale;
    }

    public int getBrokenSale() {
        return this.brokenSale;
    }

    public void setBrokenSale(int brokenSale) {
        this.brokenSale = brokenSale;
    }

    public int getDirtySale() {
        return this.dirtySale;
    }

    public void setDirtySale(int dirtySale) {
        this.dirtySale = dirtySale;
    }

    public int getDeath() {
        return this.death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public double getProductionRatio() {
        return this.productionRatio;
    }

    public void setProductionRatio(double productionRatio) {
        this.productionRatio = productionRatio;
    }
}
