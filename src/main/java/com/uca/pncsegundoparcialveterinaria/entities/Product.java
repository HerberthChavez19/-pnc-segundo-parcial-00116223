package com.uca.pncsegundoparcialveterinaria.entities;

import com.uca.pncsegundoparcialveterinaria.utils.ProductCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    @Column(name = "productName")
        private String name;
    @Column(name = "productDescription")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "productCategory")
    private ProductCategory category;
    @Column(name = "productPrice")
    private BigDecimal price;
    @Column(name = "productStock")
    private int stock;
    @Column(name = "productAvailable")
    private Boolean available;
    @Column(name = "productPresciption")
    private Boolean requiresPrescription;
    @Column(name = "productExpirationDate")
    private Date expirationDate;
    @Column(name = "productSupplier")
    private String supplier;
}
