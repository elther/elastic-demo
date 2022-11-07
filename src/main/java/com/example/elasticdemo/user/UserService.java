package com.example.elasticdemo.user;

public interface UserService {
    User save(User user);
    User update(Long id, User user);
    void delete(Long id);
    User findOne(Long id);
    Iterable<User> findAll();
    Iterable<User> findByName(String name);
}
