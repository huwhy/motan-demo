package com.nachepin.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageList<T> implements Serializable {
    private static final long serialVersionUID = -5395997221963176643L;

    public static PageList EMPTY = new PageList<>(new ArrayList(0), 1, 10, 1);

    private List<T> data;
    private Page page;

    public PageList(List<T> data, Page page) {
        this.data = data;
        this.page = page;
    }

    public PageList(List<T> data, long totalRow, int pageSize, int curNo) {
        this.data = data;
        this.page = new Page(totalRow, pageSize, curNo);
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Page getPage() {
        return this.page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}