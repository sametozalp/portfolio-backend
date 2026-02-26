package com.ozalp.portfolio.controllers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateSkillRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateSkillRequest;
import com.ozalp.portfolio.business.services.SkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skill")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @PostMapping("/add")
    ResponseEntity<?> add(@RequestBody @Valid CreateSkillRequest request) {
        skillService.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid UpdateSkillRequest request) {
        skillService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    ResponseEntity<?> get() {
        return ResponseEntity.ok(skillService.getSkills());
    }
}
