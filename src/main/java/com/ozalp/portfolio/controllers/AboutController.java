package com.ozalp.portfolio.controllers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateAboutRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateAboutRequest;
import com.ozalp.portfolio.business.services.AboutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/about")
@RequiredArgsConstructor
public class AboutController {

    private final AboutService aboutService;

    @PostMapping("/add")
    ResponseEntity<?> add(@RequestBody @Valid CreateAboutRequest request) {
        aboutService.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid UpdateAboutRequest request) {
        aboutService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    ResponseEntity<?> get() {
        return ResponseEntity.ok(aboutService.getAbout());
    }
}
