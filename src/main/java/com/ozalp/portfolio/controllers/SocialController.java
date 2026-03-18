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

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid UpdateSocialRequest request) {
        socialService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/all")
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(socialService.getSocials());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getSocial(@PathVariable int id) {
        return ResponseEntity.ok(socialService.getSocial(id));
    }

    @PostMapping("/{id}/setShowable")
    ResponseEntity<?> setShowable(@PathVariable(required = true) int id, @RequestBody Boolean value) {
        socialService.setShowable(id, value);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/upOrderNumber")
    ResponseEntity<?> upOrderNumber(@PathVariable(required = true) int id) {
        socialService.upOrderNumber(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/downOrderNumber")
    ResponseEntity<?> downOrderNumber(@PathVariable(required = true) int id) {
        socialService.downOrderNumber(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
