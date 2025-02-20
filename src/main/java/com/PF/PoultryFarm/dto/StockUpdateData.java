package com.PF.PoultryFarm.dto;

import java.sql.Date;

public class StockUpdateData {
    private int shedId;
    private Date date;
    private int largeProduction;
    private int smallProduction;
    private int brokenProduction;
    private int dirtyProduction;
    private int largeSale;
    private int smallSale;
    private int brokenSale;
    private int dirtySale;
    private int deathCnt;

    public StockUpdateData() {
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

    public int getLargeProduction() {
        return this.largeProduction;
    }

    public void setLargeProduction(int largeProduction) {
        this.largeProduction = largeProduction;
    }

    public int getSmallProduction() {
        return this.smallProduction;
    }

    public void setSmallProduction(int smallProduction) {
        this.smallProduction = smallProduction;
    }

    public int getBrokenProduction() {
        return this.brokenProduction;
    }

    public void setBrokenProduction(int brokenProduction) {
        this.brokenProduction = brokenProduction;
    }

    public int getDirtyProduction() {
        return this.dirtyProduction;
    }

    public void setDirtyProduction(int dirtyProduction) {
        this.dirtyProduction = dirtyProduction;
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

    public int getDeathCnt() {
        return this.deathCnt;
    }

    public void setDeathCnt(int deathCnt) {
        this.deathCnt = deathCnt;
    }

    public String toString() {
        int var10000 = this.shedId;
        return "StockUpdateData{shedId=" + var10000 + ", date=" + String.valueOf(this.date) + ", largeProduction=" + this.largeProduction + ", smallProduction=" + this.smallProduction + ", brokenProduction=" + this.brokenProduction + ", dirtyProduction=" + this.dirtyProduction + ", largeSale=" + this.largeSale + ", smallSale=" + this.smallSale + ", brokenSale=" + this.brokenSale + ", dirtySale=" + this.dirtySale + ", deathCnt=" + this.deathCnt + "}";
    }
}
