package com.uca.pncsegundoparcialveterinaria.dto.request;

import com.uca.pncsegundoparcialveterinaria.utils.ProductCategory;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;

@Builder
public record productDTORequest(
        @NotNull(message = "El nombre del producto no puede ser nulo")
        @NotBlank(message = "El nombre del producto no puede estar vacio")
        String name,

        String description,

        @NotNull(message = "La categoría del producto es obligatoria")
        ProductCategory category,

        @NotNull(message = "El precio del producto es obligatorio")
        @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
        BigDecimal price,

        @NotNull(message = "El stock del producto es obligatorio")
        @Min(value = 0, message = "El stock no puede ser negativo")
        Integer stock,

        @NotNull(message = "La fecha de vencimiento es obligatoria")
        @Future(message = "La fecha de vencimiento debe ser futura")
        Date expirationDate,

        @NotNull(message = "El proveedor del producto no puede ser nulo")
        @NotBlank(message = "El proveedor del producto no puede estar vacio")
        String supplier
) {
}
