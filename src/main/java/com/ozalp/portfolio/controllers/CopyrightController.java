package com.ozalp.portfolio.controllers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateCopyrightRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateCopyrightRequest;
import com.ozalp.portfolio.business.services.CopyrightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/copyright")
@RequiredArgsConstructor
public class CopyrightController {

    private final CopyrightService copyrightService;

    @PostMapping
    ResponseEntity<?> add(@RequestBody @Valid CreateCopyrightRequest request) {
        copyrightService.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid UpdateCopyrightRequest request) {
        copyrightService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    ResponseEntity<?> get() {
        return ResponseEntity.ok(copyrightService.getCopyright());
    }
}
