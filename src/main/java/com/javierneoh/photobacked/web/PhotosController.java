package com.javierneoh.photobacked.web;

import com.javierneoh.photobacked.model.Photo;
import com.javierneoh.photobacked.service.PhotoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;

@RestController
public class PhotosController {

    private final PhotoService photoService;

    public PhotosController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/photos")
    public Iterable<Photo> getPhotos(){
        return photoService.get();
    }

    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable Integer id){
        Photo photo =  photoService.get(id);

        if (photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable Integer id){
        photoService.remove(id);
    }

    @PostMapping("/photos/add")
    public Photo addPhoto(@RequestPart("data") @Valid MultipartFile file) throws IOException {
        return photoService.save(file.getOriginalFilename(), file.getContentType() ,file.getBytes());
    }
}
