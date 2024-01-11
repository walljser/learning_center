package com.yg.learning.base.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class PageResult<T> implements Serializable {
    private List<T> items;
    private long total;
    private long pageNo;
    private long pageSize;

    public PageResult() {}

    public PageResult(List<T> items, Long total, Long pageNo, Long pageSize) {
        this.items = items;
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
