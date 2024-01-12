package com.yg.learning.base.exception;

import lombok.Data;

@Data
public class RestErrorResponse {
    private String errMessage;

    public RestErrorResponse(String errMessage) {
        this.errMessage = errMessage;
    }
}
