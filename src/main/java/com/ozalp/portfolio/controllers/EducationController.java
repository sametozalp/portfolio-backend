package com.ozalp.portfolio.controllers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateEducationRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateEducationRequest;
import com.ozalp.portfolio.business.services.EducationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/education")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @PostMapping("/add")
    ResponseEntity<?> add(@RequestBody @Valid CreateEducationRequest request) {
        educationService.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid UpdateEducationRequest request) {
        educationService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    ResponseEntity<?> get() {
        return ResponseEntity.ok(educationService.getEducations());
    }
}
