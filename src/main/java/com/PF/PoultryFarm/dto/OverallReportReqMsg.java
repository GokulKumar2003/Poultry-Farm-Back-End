package com.PF.PoultryFarm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.sql.Date;

public class OverallReportReqMsg {
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

    public OverallReportReqMsg() {
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
        String var10000 = String.valueOf(this.startDate);
        return "OverallReportReqMsg{startDate=" + var10000 + ", endDate=" + String.valueOf(this.endDate) + "}";
    }
}
