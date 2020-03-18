package com.chenbro.deliverybarcode.model.base;

import java.util.List;

/**
 * @ClassName PageResult
 * @Description TODO 分页 构造放入json data部分
 * @Author c8777
 * @Date 2020/2/13 23:45
 * @Version 1.0
 **/
public class PageResult<T> {

    private Long total;
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

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
