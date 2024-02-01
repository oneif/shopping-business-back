package com.business.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.business.pojo.PageResult;
import com.business.pojo.Products;
import com.business.pojo.Result;
import com.business.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductsService productService;

    @PostMapping("/product")
    public Result product(@RequestParam("action") String action, Products product) throws JSONException {
        switch (action) {
            case "add" -> {
                productService.addProduct(product);
                return Result.success("添加成功");
            }
            case "delete" -> {
                productService.deleteById(product.getId());
                return Result.success("删除成功");
            }
            case "update" -> {
                productService.updateById(product);
                JSONObject o = new JSONObject();
                o.put("a", "a");
                return Result.success("更新成功");
            }
        }
        return null;
    }

    @PostMapping("/product/list")
    public PageResult<List<Products>> productList(Long id, Long page, Long limit) {
        Page<Products> productsList = productService.selectAll(id, page, limit);
        return PageResult.success("成功", productsList.getRecords(), page, limit, productsList.getTotal(), productsList.getPages());
    }
}
