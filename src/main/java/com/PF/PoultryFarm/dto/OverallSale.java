package com.PF.PoultryFarm.dto;

import java.sql.Date;

public class OverallSale {
    private Date date;
    private int large;
    private int small;
    private int broken;
    private int dirty;

    public OverallSale() {
    }

    public void OverallSale() {
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

    public String toString() {
        String var10000 = String.valueOf(this.date);
        return "OverallSale{date=" + var10000 + ", large=" + this.large + ", small=" + this.small + ", broken=" + this.broken + ", dirty=" + this.dirty + "}";
    }
}
