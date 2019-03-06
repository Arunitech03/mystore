package mystore.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mystore.product.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
