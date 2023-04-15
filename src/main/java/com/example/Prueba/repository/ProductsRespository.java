package com.example.Prueba.repository;

import com.example.Prueba.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRespository extends JpaRepository<Products, Long> {
}
