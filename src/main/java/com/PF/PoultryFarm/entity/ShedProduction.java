package com.PF.PoultryFarm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(
        name = "shed_production"
)
public class ShedProduction {
    @Id
    @Column(
            name = "shed_id"
    )
    private int shedId;
    @Column(
            name = "large"
    )
    private int large;
    @Column(
            name = "small"
    )
    private int small;
    @Column(
            name = "broken"
    )
    private int broken;
    @Column(
            name = "dirty"
    )
    private int dirty;
    @Column(
            name = "total"
    )
    private int total;
    @Column(
            name = "large_percentage"
    )
    private double largePercentage;
    @Column(
            name = "small_percentage"
    )
    private double smallPercentage;
    @Column(
            name = "broken_percentage"
    )
    private double brokenPercentage;
    @Column(
            name = "dirty_percentage"
    )
    private double dirtyPercentage;
    @Column(
            name = "production_ratio"
    )
    private double productionRatio;
    @Column(
            name = "death_cnt"
    )
    private int deathCnt;
    @Column(
            name = "total_birds"
    )
    private int totalBirds;
    @Column(
            name = "batch_duration"
    )
    private int batchDuration;
    @Column(
            name = "batch_start_date"
    )
    private Date batchStartDate;

    public ShedProduction() {
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

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDeathCnt() {
        return this.deathCnt;
    }

    public void setDeathCnt(int deathCnt) {
        this.deathCnt = deathCnt;
    }

    public double getLargePercentage() {
        return this.largePercentage;
    }

    public void setLargePercentage(double largePercentage) {
        this.largePercentage = largePercentage;
    }

    public double getSmallPercentage() {
        return this.smallPercentage;
    }

    public void setSmallPercentage(double smallPercentage) {
        this.smallPercentage = smallPercentage;
    }

    public double getBrokenPercentage() {
        return this.brokenPercentage;
    }

    public void setBrokenPercentage(double brokenPercentage) {
        this.brokenPercentage = brokenPercentage;
    }

    public double getDirtyPercentage() {
        return this.dirtyPercentage;
    }

    public void setDirtyPercentage(double dirtyPercentage) {
        this.dirtyPercentage = dirtyPercentage;
    }

    public double getProductionRatio() {
        return this.productionRatio;
    }

    public void setProductionRatio(double productionRatio) {
        this.productionRatio = productionRatio;
    }

    public int getTotalBirds() {
        return this.totalBirds;
    }

    public void setTotalBirds(int totalBirds) {
        this.totalBirds = totalBirds;
    }

    public int getBatchDuration() {
        return this.batchDuration;
    }

    public void setBatchDuration(int batchDuration) {
        this.batchDuration = batchDuration;
    }

    public Date getBatchStartDate() {
        return this.batchStartDate;
    }

    public void setBatchStartDate(Date batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    public String toString() {
        int var10000 = this.shedId;
        return "ShedProduction{shedId=" + var10000 + ", large=" + this.large + ", small=" + this.small + ", broken=" + this.broken + ", dirty=" + this.dirty + ", total=" + this.total + ", largePercentage=" + this.largePercentage + ", smallPercentage=" + this.smallPercentage + ", brokenPercentage=" + this.brokenPercentage + ", dirtyPercentage=" + this.dirtyPercentage + ", productionRatio=" + this.productionRatio + ", deathCnt=" + this.deathCnt + ", totalBirds=" + this.totalBirds + ", batchDuration=" + this.batchDuration + ", batchStartDate=" + String.valueOf(this.batchStartDate) + "}";
    }
}
