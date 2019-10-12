package dev.fujioka.java.avancado.web.web.rest;

import dev.fujioka.java.avancado.web.domain.Product;
import dev.fujioka.java.avancado.web.repository.ProductRepository;
import dev.fujioka.java.avancado.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductResource {

    @Autowired
    private ProductService productService;


    @GetMapping("/product")
    public List<Product> getProductList() {

        return productService.findAll();
    }
    
    @GetMapping("/product/name/{name}")
    public List<Product> getProductByName(@PathVariable String name){
    	return productService.findByName(name);
    }
    
    @GetMapping("/product/description/{description}")
    public List<Product> getProductByDescription(@PathVariable String description){
    	return productService.findByDescription(description);
    }
    
    @GetMapping("/product/namedescription/{name}/{description}")
    public List<Product> getProductByNameAndDescription(@PathVariable  String name, @PathVariable String description){
    	return productService.findByNomeAndDescription(name, description);
    }
    
    @GetMapping("/product/{id}")
    public Optional<Product> getProductByid(@PathVariable long id){
    	return productService.findById(id);
    }
    
    @GetMapping("/product/desc")
    public List<Product> getAllByOrderDtCreationDesc(){
    	return productService.findAllByDtCreationDesc();
    }
    
    @GetMapping("/product/asc")
    public List<Product> getAllByOrderDtUpdateAsc(){
    	return productService.findAllByDtUpdateAsc();
    }

    @PostMapping("/product")
    public ResponseEntity<Product> save(
            @RequestBody Product product) {

        product = productService.save(product).get() ;

        return ResponseEntity.ok().body(product);
    }
    
    
    @PutMapping("/product")
    public ResponseEntity<Product> update(
            @RequestBody Product product) {

        product = productService.save(product).get();

        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> delete(
            @RequestBody Product product) {

        productService.delete(product);
        return ResponseEntity.ok().body("Product excluded " + product.getId());
    }


}
