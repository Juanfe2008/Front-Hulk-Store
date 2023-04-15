package com.example.Prueba.service.impl;

import com.example.Prueba.dto.ProductsDto;
import com.example.Prueba.entity.Products;
import com.example.Prueba.repository.ProductsRespository;
import com.example.Prueba.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductsImpl implements ProductsService {
    private final ProductsRespository productsRespository;
    private final ModelMapper modelMapper;


    @Override
    public ProductsDto save(ProductsDto productsDto) {
        try {
            Products products = modelMapper.map(productsDto, Products.class);
            productsRespository.save(products);
            return modelMapper.map(products, ProductsDto.class);
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public ArrayList<Products> listAll() {
        return (ArrayList<Products>) productsRespository.findAll();
    }

    @Override
    public ProductsDto listById(Long id) {
        return null;
    }

    @Override
    public ProductsDto update(Long id, ProductsDto productsDto) {
        return null;
    }

    @Override
    public ProductsDto deleteById(Long id) {
        return null;
    }
}
