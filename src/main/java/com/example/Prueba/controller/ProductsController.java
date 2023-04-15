package com.example.Prueba.controller;

import com.example.Prueba.dto.ProductsDto;
import com.example.Prueba.entity.Products;
import com.example.Prueba.service.impl.ProductsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductsController {
    private final ProductsImpl productsImpl;

    @PostMapping(value = "/save")
    public ResponseEntity<ProductsDto> save(@RequestBody ProductsDto productsDto){
        return new ResponseEntity<ProductsDto>(productsImpl.save(productsDto), HttpStatus.CREATED);
    }
    @GetMapping(value = "/list")
    public ArrayList<Products> listAll(){
        return this.productsImpl.listAll();
    }
}
