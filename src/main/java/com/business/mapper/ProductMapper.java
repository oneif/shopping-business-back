package com.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.business.pojo.Products;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Products> {
}
