package dev.fujioka.java.avancado.web.repository;

import dev.fujioka.java.avancado.web.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository
     extends JpaRepository<Product, Long> {


    public List<Product> findProductByName(String name);
    public List<Product> findProductByDescription(String description); 
    public List<Product> findAllByOrderByDtUpdateAsc();
    public List<Product> findProductByNameAndDescription(String name, String description);
    public List<Product> findAllByOrderByDtCreationDesc();
}

