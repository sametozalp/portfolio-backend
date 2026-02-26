package com.ozalp.portfolio.controllers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateSocialRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateSocialRequest;
import com.ozalp.portfolio.business.services.SocialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/social")
@RequiredArgsConstructor
public class SocialController {

    private final SocialService socialService;

    @PostMapping
    ResponseEntity<?> add(@RequestBody @Valid CreateSocialRequest request) {
        socialService.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid UpdateSocialRequest request) {
        socialService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping
    ResponseEntity<?> get() {
        return ResponseEntity.ok(socialService.getSocials());
    }
}
