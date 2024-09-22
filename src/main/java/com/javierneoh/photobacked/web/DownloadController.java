package com.javierneoh.photobacked.web;

import com.javierneoh.photobacked.model.Photo;
import com.javierneoh.photobacked.service.PhotoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
    public class DownloadController {

        private final PhotoService photoService;

        public DownloadController(PhotoService photoService) {
            this.photoService = photoService;
        }

        @GetMapping("/download/{id}")
        // we use ResponseEntity over just sending byte[] so that we can include metadata like headers.
        // Also note Content-disposition is a header indicating how browser should behave/handle  the
        // content from response. ( Display in browser/ download )
        public ResponseEntity<byte[]> download(@PathVariable("id") Integer id) {

            Photo photo = photoService.get(id);
            if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            byte[] data = photo.getData();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf(photo.getContentType()));
            ContentDisposition build = ContentDisposition
                    .builder("attachment")
                    .filename(photo.getFileName())
                    .build();
            headers.setContentDisposition(build);

            return new ResponseEntity<>(data, headers, HttpStatus.OK);
        }

    }
