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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<?> add(@RequestPart("request") @Valid CreateProjectRequest request, @RequestPart("images") List<MultipartFile> images) {
        projectService.add(request, images);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid UpdateProjectRequest request) {
        projectService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(projectService.getProjects());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(projectService.findById(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable(required = true) int id) {
        projectService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
