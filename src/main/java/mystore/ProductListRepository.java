package mystore;

import org.springframework.data.repository.CrudRepository;
import mystore.product.entity.ProductEntity;

public interface ProductListRepository extends CrudRepository<ProductEntity, Integer> {

	}

