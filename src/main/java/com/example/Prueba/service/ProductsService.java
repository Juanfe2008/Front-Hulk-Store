package com.example.Prueba.service;

import com.example.Prueba.dto.ProductsDto;
import com.example.Prueba.entity.Products;

import java.util.ArrayList;

public interface ProductsService {
    ProductsDto save(ProductsDto productsDto);

    ArrayList<Products> listAll();

    ProductsDto listById(Long id);

    ProductsDto update(Long id, ProductsDto productsDto);

    ProductsDto deleteById(Long id);
}
