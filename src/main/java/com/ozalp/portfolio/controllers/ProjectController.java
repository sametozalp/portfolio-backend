package com.ozalp.portfolio.controllers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateProjectRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateProjectRequest;
import com.ozalp.portfolio.business.services.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<?> add(@RequestBody @Valid CreateProjectRequest request) {
        projectService.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid UpdateProjectRequest request) {
        projectService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping
    ResponseEntity<?> get() {
        return ResponseEntity.ok(projectService.getProjects());
    }
}
