package com.PF.PoultryFarm.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class CompositeKey implements Serializable {
    private Date date;
    private int shedId;

    public CompositeKey() {
    }

    public Date getDate() {
        return this.date;
    }

    public int getShedId() {
        return this.shedId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setShedId(int shedId) {
        this.shedId = shedId;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            CompositeKey that = (CompositeKey)o;
            return Objects.equals(this.date, that.date) && Objects.equals(this.shedId, that.shedId);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.date, this.shedId});
    }
}
