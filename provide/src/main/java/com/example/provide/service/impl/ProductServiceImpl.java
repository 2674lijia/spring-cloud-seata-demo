package com.example.provide.service.impl;

import com.example.provide.entity.Product;
import com.example.provide.mapper.ProductMapper;
import com.example.provide.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lijia
 * @since 2021-05-14
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
