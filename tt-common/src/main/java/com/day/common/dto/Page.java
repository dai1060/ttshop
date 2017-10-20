package com.day.common.dto;
//专门用于eazyui的datagrid通用分页类(请求参数)
public class Page {

    private int page;
    private int rows;
//    private int offset;偏移量

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    //偏移量是通过另外两个参数算出来的
    public int getOffset() {
        return (page-1)*rows;
    }

}
