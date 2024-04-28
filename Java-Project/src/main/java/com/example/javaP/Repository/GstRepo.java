package com.example.javaP.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.javaP.Model.Gst;

public interface GstRepo extends MongoRepository<Gst,String>{

}
