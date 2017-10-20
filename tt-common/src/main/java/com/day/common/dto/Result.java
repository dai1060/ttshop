package com.day.common.dto;


import java.util.List;

//专门用于eazyui的datagrid通用分页类(响应参数)
public class Result<T> {
    //符合条件的查询总条数
    private Long total;
    //分页出来的某页查询出来的数据集合
    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
