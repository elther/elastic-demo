package com.example.elasticdemo.user;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends ElasticsearchRepository<User, Long> {
    Iterable<User> findByName(String name);
}
