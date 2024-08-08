package com.lilonghe.demo.controller;

import com.lilonghe.demo.model.Product;
import com.lilonghe.demo.repository.ProductRepository;
import com.lilonghe.demo.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public APIResponse<List<Product>> list() {
        return APIResponse.Success(productRepository.findAll());
    }
}
