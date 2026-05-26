package com.uca.pncsegundoparcialveterinaria.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private Boolean available;
    private Boolean requiresPrescription;
    private Date expirationDate;
    private String supplier;
}
