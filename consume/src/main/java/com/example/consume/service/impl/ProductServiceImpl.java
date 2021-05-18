package com.example.consume.service.impl;

import com.example.consume.entity.Product;
import com.example.consume.mapper.ProductMapper;
import com.example.consume.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lijia
 * @since 2021-05-17
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
