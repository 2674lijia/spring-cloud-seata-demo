package com.example.consume.mapper;

import com.example.consume.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.checkerframework.checker.units.qual.A;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lijia
 * @since 2021-05-17
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
