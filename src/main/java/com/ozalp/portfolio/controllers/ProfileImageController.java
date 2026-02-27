package com.ozalp.portfolio.controllers;

import com.ozalp.portfolio.business.services.ProfileImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/profileImages")
@RequiredArgsConstructor
public class ProfileImageController {

    private final ProfileImageService profileImageService;

    @GetMapping("/getAll")
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(profileImageService.getAll());
    }

    @GetMapping("/profileImage")
    ResponseEntity<?> getProfileImage() {
        return ResponseEntity.ok(profileImageService.getProfileImage());
    }

    @PostMapping(value = "/change", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<?> change(@RequestPart("image") MultipartFile image) {
        profileImageService.change(image);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable(required = true) int id) {
        profileImageService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
