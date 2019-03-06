package mystore.product.service;

import mystore.product.model.*;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll();

    void delete(long id);
}