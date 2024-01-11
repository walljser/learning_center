package com.yg.learning.base.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageParams {
    private long pageNo = 1L;

    private long pageSize = 10L;

    public PageParams() {}

    public PageParams(long pageNo, long pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
