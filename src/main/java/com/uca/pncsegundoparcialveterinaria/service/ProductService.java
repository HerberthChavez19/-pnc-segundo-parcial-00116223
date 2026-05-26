package com.uca.pncsegundoparcialveterinaria.service;

import com.uca.pncsegundoparcialveterinaria.dto.GeneralResponse;
import com.uca.pncsegundoparcialveterinaria.dto.request.ProductDTORequest;
import com.uca.pncsegundoparcialveterinaria.dto.response.ProductDTOResponse;
import com.uca.pncsegundoparcialveterinaria.entities.Product;
import com.uca.pncsegundoparcialveterinaria.exception.DuplicateProductException;
import com.uca.pncsegundoparcialveterinaria.exception.ProductNotFoundException;
import com.uca.pncsegundoparcialveterinaria.repository.ProductRepository;
import com.uca.pncsegundoparcialveterinaria.utils.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductDTORequest product){
        if (productRepository.existsByName(product.name()) || (product.price() == null || product.price().compareTo(BigDecimal.ZERO) <= 0)) {

            throw new DuplicateProductException("Ya existe un producto con el nombre '" + product.name() + "'");
        }

        productRepository.save(ProductMapper.toEntity(product));
    }

    public List<Product> findAllPokemon(){
        return productRepository.findAll();
    }

    public ProductDTOResponse findProductById(Long id){
        return ProductMapper.toResponse(productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Product not found with id " + id)
        ));
    }

    public void updatePokemon(Long id, ProductDTORequest product){
        Product productToUpdate = ProductMapper.toEntity(product);
        if (productRepository.existsById(id)){
            productToUpdate.setId(id);
        }else{
            throw new ProductNotFoundException("Pokemon not found with id " + id);
        }
        productRepository.save(productToUpdate);
    }




}
