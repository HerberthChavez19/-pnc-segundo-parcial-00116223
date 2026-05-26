package com.uca.pncsegundoparcialveterinaria.dto.response;

import com.uca.pncsegundoparcialveterinaria.utils.ProductCategory;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;

@Builder
public record ProductDTOResponse(
        Long id,
        String name,
        String description,
        ProductCategory category,
        BigDecimal price,
        Integer stock,
        Boolean available,
        Boolean requiresPrescription,
        Date expirationDate,
        String supplier
) {
}
