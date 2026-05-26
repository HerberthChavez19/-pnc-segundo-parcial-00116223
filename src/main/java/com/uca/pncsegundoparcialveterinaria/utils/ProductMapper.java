package com.uca.pncsegundoparcialveterinaria.utils;

import com.uca.pncsegundoparcialveterinaria.dto.request.productDTORequest;
import com.uca.pncsegundoparcialveterinaria.dto.response.productDTOResponse;
import com.uca.pncsegundoparcialveterinaria.entities.Product;

public class ProductMapper {
    public static Product toEntity(productDTORequest ProductDTORequest){
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

    public static productDTOResponse toResponse(Product product){
        return new productDTOResponse(
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
