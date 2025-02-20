package com.PF.PoultryFarm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(
        name = "production_and_death"
)
@IdClass(CompositeKey.class)
public class ProductionAndDeath {
    @Id
    @Column(
            name = "date"
    )
    private Date date;
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
            name = "death_cnt"
    )
    private int deathCnt;
    @Column(
            name = "production_ratio"
    )
    private double ProductionRatio;

    public ProductionAndDeath() {
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        return this.ProductionRatio;
    }

    public void setProductionRatio(double productionRatio) {
        this.ProductionRatio = productionRatio;
    }

    public String toString() {
        String var10000 = String.valueOf(this.date);
        return "ProductionAndDeath{date=" + var10000 + ", shedId=" + this.shedId + ", large=" + this.large + ", small=" + this.small + ", broken=" + this.broken + ", dirty=" + this.dirty + ", deathCnt=" + this.deathCnt + ", ProductionRatio=" + this.ProductionRatio + "}";
    }
}
