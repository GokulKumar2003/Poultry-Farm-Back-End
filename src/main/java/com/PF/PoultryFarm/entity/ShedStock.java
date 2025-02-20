package com.PF.PoultryFarm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "shed_stock"
)
public class ShedStock {
    @Id
    @Column(
            name = "shed_id"
    )
    private int shedId;
    @Column(
            name = "large_eggs"
    )
    private int largeEggs;
    @Column(
            name = "small_eggs"
    )
    private int smallEggs;
    @Column(
            name = "broken_eggs"
    )
    private int brokenEggs;
    @Column(
            name = "dirty_eggs"
    )
    private int dirtyEggs;

    public ShedStock() {
    }

    public int getShedId() {
        return this.shedId;
    }

    public void setShedId(int shedId) {
        this.shedId = shedId;
    }

    public int getLargeEggs() {
        return this.largeEggs;
    }

    public void setLargeEggs(int largeEggs) {
        this.largeEggs = largeEggs;
    }

    public int getSmallEggs() {
        return this.smallEggs;
    }

    public void setSmallEggs(int smallEggs) {
        this.smallEggs = smallEggs;
    }

    public int getBrokenEggs() {
        return this.brokenEggs;
    }

    public void setBrokenEggs(int brokenEggs) {
        this.brokenEggs = brokenEggs;
    }

    public int getDirtyEggs() {
        return this.dirtyEggs;
    }

    public void setDirtyEggs(int dirtyEggs) {
        this.dirtyEggs = dirtyEggs;
    }

    public String toString() {
        return "ShedStock{shedId=" + this.shedId + ", largeEggs=" + this.largeEggs + ", smallEggs=" + this.smallEggs + ", brokenEggs=" + this.brokenEggs + ", dirtyEggs=" + this.dirtyEggs + "}";
    }
}
