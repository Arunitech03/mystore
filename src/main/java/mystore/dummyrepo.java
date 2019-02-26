package mystore;

import org.springframework.data.repository.CrudRepository;
import mystore.product.entity.dummyentity;

public interface dummyrepo extends CrudRepository<dummyentity, Integer> {

	}

