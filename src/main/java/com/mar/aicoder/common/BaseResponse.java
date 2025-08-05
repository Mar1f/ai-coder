package com.mar.aicoder.common;
import com.mar.aicoder.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;
/**
 * @description；通过响应类
 * @author:mar1
 * @data:2025/08/05
 **/
@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data) {
        this(code, data, "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage());
    }
}
