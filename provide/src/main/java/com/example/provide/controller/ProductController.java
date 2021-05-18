package com.example.provide.controller;


import com.example.core.base.BaseResponse;
import com.example.provide.config.PublicException;
import com.example.provide.entity.Product;
import com.example.provide.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lijia
 * @since 2021-05-14
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/insert")
    BaseResponse insert() {
        Product product = new Product();
        product.setCounts(100);
        boolean save = productService.save(product);
//        if (true) {
//            throw new PublicException("模拟错误，回滚！");
//        }
        return new BaseResponse().setMessage("插入成功");
    }

    @PostMapping("/update")
    boolean update(@RequestBody Product product) {
        boolean b = productService.updateById(product);
        return b;
    }
}
