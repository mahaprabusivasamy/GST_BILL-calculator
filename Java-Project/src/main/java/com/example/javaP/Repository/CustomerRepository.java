package com.example.javaP.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.javaP.Model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}