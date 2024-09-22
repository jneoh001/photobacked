package com.javierneoh.photobacked.repository;

import com.javierneoh.photobacked.model.Photo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {

}