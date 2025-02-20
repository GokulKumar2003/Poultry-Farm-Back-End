package com.PF.PoultryFarm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.sql.Date;

public class ResetData {
    private int shedId;
    private int birdsCnt;
    @JsonFormat(
            shape = Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    private Date batchStartDate;

    public ResetData() {
    }

    public int getShedId() {
        return this.shedId;
    }

    public void setShedId(int shedId) {
        this.shedId = shedId;
    }

    public int getBirdsCnt() {
        return this.birdsCnt;
    }

    public void setBirdsCnt(int birdsCnt) {
        this.birdsCnt = birdsCnt;
    }

    public Date getBatchStartDate() {
        return this.batchStartDate;
    }

    public void setBatchStartDate(Date batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    public String toString() {
        return "ResetData{shedId=" + this.shedId + ", birdsCnt=" + this.birdsCnt + "}";
    }
}
