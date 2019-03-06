package mystore.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mystore.product.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	}

