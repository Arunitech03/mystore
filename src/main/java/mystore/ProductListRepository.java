package mystore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import mystore.product.entity.ProductEntity;

public interface ProductListRepository extends JpaRepository<ProductEntity, Integer> {

	}

