package com.example.feignclient.provide;

import com.example.core.base.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: lijia
 * @Description:
 * @CreateDate: 2021/5/12 18:09
 */
@FeignClient(value = "provide")
public interface ProductFeignClient {

    @PostMapping("/product/insert")
    BaseResponse insert();

//    @PostMapping("/update")
//    boolean update();
}
