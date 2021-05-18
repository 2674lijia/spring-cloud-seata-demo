package com.example.feignclient.provide;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: lijia
 * @Description:
 * @CreateDate: 2021/5/12 18:09
 */
@FeignClient(value = "provide")
public interface ProvideFeignClient {

    @GetMapping("/provide/test")
    String test();
}
