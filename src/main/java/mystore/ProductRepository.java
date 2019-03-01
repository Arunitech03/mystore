package mystore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import mystore.product.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	}

