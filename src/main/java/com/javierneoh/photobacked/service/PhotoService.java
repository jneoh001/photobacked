package com.javierneoh.photobacked.service;

import com.javierneoh.photobacked.model.Photo;
import com.javierneoh.photobacked.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Iterable<Photo> get() {
        return photoRepository.findAll();
    }

    public Photo get(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photoRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data){
        Photo photo = new Photo();
        photo.setFileName(fileName);

        photo.setData(data);
        photo.setContentType(contentType);

        photoRepository.save(photo);
        return photo;
    }
}
