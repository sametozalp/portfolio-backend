package com.ozalp.portfolio.controllers;

import com.ozalp.portfolio.business.services.ProjectImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projectImages")
@RequiredArgsConstructor
public class ProjectImageController {

    private final ProjectImageService projectImageService;

    @GetMapping("/{projectId}")
    ResponseEntity<?> get(@PathVariable(required = true) int projectId) {
        return ResponseEntity.ok(projectImageService.getProjectImages(projectId));
    }
}
