package com.uca.pncsegundoparcialveterinaria.repository;

import com.uca.pncsegundoparcialveterinaria.entities.Product;
import com.uca.pncsegundoparcialveterinaria.utils.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(ProductCategory category);

    boolean existsByName(String name);

    List<Product> findByAvailable(Boolean available);

    List<Product> findByCategoryAndAvailable(ProductCategory category, Boolean available);
}
