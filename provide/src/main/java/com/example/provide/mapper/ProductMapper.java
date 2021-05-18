package com.example.provide.mapper;

import com.example.provide.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lijia
 * @since 2021-05-14
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
