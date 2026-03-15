package com.ozalp.portfolio.controllers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateExperienceRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateExperienceRequest;
import com.ozalp.portfolio.business.services.ExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/experience")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;

    @PostMapping
    ResponseEntity<?> add(@RequestBody @Valid CreateExperienceRequest request) {
        experienceService.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid UpdateExperienceRequest request) {
        experienceService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(experienceService.getExperience());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(experienceService.findById(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable(required = true) int id) {
        experienceService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/setShowableImage")
    ResponseEntity<?> setShowableImage(@PathVariable(required = true) int id, @RequestBody Boolean value) {
        experienceService.setShowable(id, value);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
