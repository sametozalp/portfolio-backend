package com.ozalp.portfolio.controllers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateEntranceRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateEntranceRequest;
import com.ozalp.portfolio.business.services.EntranceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entrance")
@RequiredArgsConstructor
public class EntranceController {

    private final EntranceService entranceService;

    @PostMapping
    ResponseEntity<?> add(@RequestBody @Valid CreateEntranceRequest request) {
        entranceService.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid UpdateEntranceRequest request) {
        entranceService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    ResponseEntity<?> get() {
        return ResponseEntity.ok(entranceService.getEntrance());
    }
}
