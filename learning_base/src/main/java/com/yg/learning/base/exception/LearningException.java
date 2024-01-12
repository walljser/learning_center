package com.yg.learning.base.exception;

import lombok.Data;

@Data
public class LearningException extends RuntimeException {
    private String errMessage;

    public LearningException() {}

    public LearningException(String errMessage) {
        this.errMessage = errMessage;
    }

    public static void cast(String msg) {
        throw new LearningException(msg);
    }

    public static void cast(CommonExceptionEnum commonExceptionEnum) {
        throw new LearningException(commonExceptionEnum.getErrMessage());
    }
}
