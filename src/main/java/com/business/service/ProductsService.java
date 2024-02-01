package com.business.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.pojo.Products;

public interface ProductsService {
    void addProduct(Products product);

    void deleteById(Long id);

    void updateById(Products product);

    Page<Products> selectAll(Long id, Long page, Long size);
}
