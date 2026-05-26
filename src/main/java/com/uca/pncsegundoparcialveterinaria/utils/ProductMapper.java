package com.uca.pncsegundoparcialveterinaria.utils;

import com.uca.pncsegundoparcialveterinaria.dto.request.ProductDTORequest;
import com.uca.pncsegundoparcialveterinaria.dto.response.ProductDTOResponse;
import com.uca.pncsegundoparcialveterinaria.entities.Product;

public class ProductMapper {
    public static Product toEntity(ProductDTORequest ProductDTORequest){
        return Product.builder()
                .name(ProductDTORequest.name())
                .description(ProductDTORequest.description())
                .category(ProductDTORequest.category())
                .price(ProductDTORequest.price())
                .stock(ProductDTORequest.stock())
                .expirationDate(ProductDTORequest.expirationDate())
                .supplier(ProductDTORequest.supplier())
                .build();
    }

    public static ProductDTOResponse toResponse(Product product){
        return new ProductDTOResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getCategory(),
                product.getPrice(),
                product.getStock(),
                product.getAvailable(),
                product.getRequiresPrescription(),
                product.getExpirationDate(),
                product.getSupplier()
        );
    }
}
