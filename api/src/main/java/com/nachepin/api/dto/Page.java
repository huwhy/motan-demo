package com.nachepin.api.dto;

import java.io.Serializable;

public class Page implements Serializable{
    private long totalNum;
    private int perSize;
    private int curNo;

    public Page() {
    }

    public Page(long totalNum, int perSize, int curNo) {
        this.totalNum = totalNum;
        this.perSize = perSize;
        this.curNo = curNo;
    }

    public long getTotalNum() {
        return this.totalNum;
    }

    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }

    public int getPerSize() {
        return this.perSize;
    }

    public void setPerSize(int perSize) {
        this.perSize = perSize;
    }

    public int getCurNo() {
        return this.curNo;
    }

    public void setCurNo(int curNo) {
        this.curNo = curNo;
    }

    public int getTotalPage() {
        return (int)this.getTotalNum() / this.getPerSize() + (this.getTotalNum() % (long)this.getPerSize() > 0L?1:0);
    }
}
