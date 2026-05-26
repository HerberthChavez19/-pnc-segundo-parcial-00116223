package com.uca.pncsegundoparcialveterinaria.controller;


import com.uca.pncsegundoparcialveterinaria.dto.GeneralResponse;
import com.uca.pncsegundoparcialveterinaria.dto.request.ProductDTORequest;
import com.uca.pncsegundoparcialveterinaria.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<GeneralResponse> createPokemon(@Valid @RequestBody ProductDTORequest product) {
        productService.createProduct(product);
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(product)
                .message("Pokemon has been created")
                .build());
    }

    @GetMapping
    public ResponseEntity<GeneralResponse> findAll(){
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(productService.findAllPokemon())
                .message("All pokemons found")
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> getPokemonById(@PathVariable Long id) {
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(productService.findProductById(id))
                .message("Pokemon found with id: " + id)
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse> updatePokemon(@PathVariable Long id,@Valid @RequestBody ProductDTORequest product) {
        productService.updatePokemon(id,product);
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(product)
                .message("Pokemon has been updated")
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse> deletePokemon(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(productService.findProductById(id))
                .message("Pokemon has been deleted")
                .build());
    }

}
