package com.PF.PoultryFarm.dto;

import java.sql.Date;

public class DetailedStock {
    private int shedId;
    private int large;
    private int small;
    private int broken;
    private int dirty;
    private int birdsCnt;
    private int deathCnt;
    private int duration;
    private double productionRatio;
    private Date batchStartDate;

    public DetailedStock() {
    }

    public int getShedId() {
        return this.shedId;
    }

    public void setShedId(int shedId) {
        this.shedId = shedId;
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
        this.productionRatio = productionRatio;
    }

    public int getBirdsCnt() {
        return this.birdsCnt;
    }

    public void setBirdsCnt(int birdsCnt) {
        this.birdsCnt = birdsCnt;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getBatchStartDate() {
        return this.batchStartDate;
    }

    public void setBatchStartDate(Date batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    public String toString() {
        return "DetailedStock{shedId=" + this.shedId + ", large=" + this.large + ", small=" + this.small + ", broken=" + this.broken + ", dirty=" + this.dirty + ", birdsCnt=" + this.birdsCnt + ", deathCnt=" + this.deathCnt + ", duration=" + this.duration + ", productionRatio=" + this.productionRatio + "}";
    }
}
