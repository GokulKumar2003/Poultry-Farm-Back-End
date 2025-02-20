package com.PF.PoultryFarm.dto;

import java.sql.Date;

public class OverallProductionAndDeath {
    private Date date;
    private int large;
    private int small;
    private int broken;
    private int dirty;
    private int deathCnt;
    private double productionRatio;

    public OverallProductionAndDeath() {
    }

    public void OverallProduction() {
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLarge() {
        return this.large;
    }

    public void setLarge(int large) {
        this.large = large;
    }

    public int getSmall() {
        return this.small;
    }

    public void setSmall(int small) {
        this.small = small;
    }

    public int getBroken() {
        return this.broken;
    }

    public void setBroken(int broken) {
        this.broken = broken;
    }

    public int getDirty() {
        return this.dirty;
    }

    public void setDirty(int dirty) {
        this.dirty = dirty;
    }

    public int getDeathCnt() {
        return this.deathCnt;
    }

    public void setDeathCnt(int deathCnt) {
        this.deathCnt = deathCnt;
    }

    public double getProductionRatio() {
        return this.productionRatio;
    }

    public void setProductionRatio(double productionRatio) {
    }

    public String toString() {
        String var10000 = String.valueOf(this.date);
        return "OverallProductionAndDeath{date=" + var10000 + ", large=" + this.large + ", small=" + this.small + ", broken=" + this.broken + ", dirty=" + this.dirty + ", deathCnt=" + this.deathCnt + ", ProductionRatio=" + this.productionRatio + "}";
    }
}
