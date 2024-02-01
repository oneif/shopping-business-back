package com.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.mapper.ProductMapper;
import com.business.pojo.Products;
import com.business.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductsService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void addProduct(Products product) {
        productMapper.insert(product);
    }

    @Override
    public void deleteById(Long id) {
        productMapper.deleteById(id);
    }

    @Override
    public void updateById(Products product) {
        productMapper.updateById(product);
    }

    @Override
    public Page<Products> selectAll(Long id, Long page, Long size) {
        Page<Products> productPage = new Page<>(page, size);
        QueryWrapper<Products> qw = new QueryWrapper<>();
        qw.eq("business_id", id);
        return productMapper.selectPage(productPage, qw);
    }
}
