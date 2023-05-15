package com.springdocker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdocker.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{

}
