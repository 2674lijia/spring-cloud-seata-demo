package com.example.consume.service.impl;

import com.example.consume.config.PublicException;
import com.example.consume.entity.Product;
import com.example.consume.mapper.ProductMapper;
import com.example.consume.service.IConsumeService;
import com.example.core.base.BaseResponse;
import com.example.core.base.SystemResponseCode;
import com.example.feignclient.provide.ProductFeignClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: lijia
 * @Description:
 * @CreateDate: 2021/5/17 11:29
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ConsumeServiceImpl implements IConsumeService {

    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private ProductMapper productMapper;

    @Override
    @GlobalTransactional
    public String test() {
        Product product = new Product();
        product.setCounts(10000);
        productMapper.insert(product);
        BaseResponse baseResponse = productFeignClient.insert();
//        if (baseResponse.getCode() != SystemResponseCode.SUCCESS)
//            throw new PublicException(baseResponse.getMessage());
        if (true) {
            throw new PublicException("模拟错误，回滚！");
        }
        return "true";
    }
}
