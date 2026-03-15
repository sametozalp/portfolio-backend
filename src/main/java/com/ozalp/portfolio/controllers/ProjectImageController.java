package com.ozalp.portfolio.controllers;

import com.ozalp.portfolio.business.services.ProjectImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projectImages")
@RequiredArgsConstructor
public class ProjectImageController {

    private final ProjectImageService projectImageService;

    @GetMapping("/{projectId}")
    ResponseEntity<?> get(@PathVariable(required = true) int projectId) {
        return ResponseEntity.ok(projectImageService.getProjectImages(projectId));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable(required = true) int id) {
        projectImageService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/upOrderNumber")
    ResponseEntity<?> upOrderNumber(@PathVariable(required = true) int id) {
        projectImageService.upOrderNumber(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/downOrderNumber")
    ResponseEntity<?> downOrderNumber(@PathVariable(required = true) int id) {
        projectImageService.downOrderNumber(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/setCoverImage")
    ResponseEntity<?> setCoverImage(@PathVariable(required = true) int id) {
        projectImageService.setCoverImage(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
