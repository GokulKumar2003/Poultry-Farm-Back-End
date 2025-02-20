package com.PF.PoultryFarm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.sql.Date;

public class ReportReqMsg {
    private int shedId;
    @JsonFormat(
            shape = Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    private Date startDate;
    @JsonFormat(
            shape = Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    private Date endDate;

    public ReportReqMsg() {
    }

    public int getShedId() {
        return this.shedId;
    }

    public void setShedId(int shedId) {
        this.shedId = shedId;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String toString() {
        int var10000 = this.shedId;
        return "ReportReqMsg{shedId=" + var10000 + ", startDate=" + String.valueOf(this.startDate) + ", endDate=" + String.valueOf(this.endDate) + "}";
    }
}
