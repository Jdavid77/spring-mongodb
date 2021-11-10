package com.joaodavid.springmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joaodavid.springmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}