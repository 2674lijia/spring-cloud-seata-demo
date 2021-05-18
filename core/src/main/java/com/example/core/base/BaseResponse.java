package com.example.core.base;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: lijia
 * @Description:
 * @CreateDate: 2021/5/17 14:47
 */
@Data
@Accessors(chain = true)
public class BaseResponse<T> {

    private String message;

    private Integer code;

    private T data;

    public BaseResponse() {
        this(null, SystemResponseCode.SUCCESS);
    }

    public BaseResponse(String message) {
        this(message, SystemResponseCode.SUCCESS);
    }

    public BaseResponse(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

}
