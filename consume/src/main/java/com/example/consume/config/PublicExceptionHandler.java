package com.example.consume.config;

import com.example.core.base.BaseResponse;
import com.example.core.base.SystemResponseCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: lijia
 * @Description:
 * @CreateDate: 2021/5/17 11:35
 */
@ControllerAdvice
public class PublicExceptionHandler {


    @ExceptionHandler(PublicException.class)
    @ResponseBody
    public BaseResponse publicException(PublicException publicException) {

        return new BaseResponse().setCode(SystemResponseCode.ERROR).setMessage(publicException.getMessage());
    }
}
