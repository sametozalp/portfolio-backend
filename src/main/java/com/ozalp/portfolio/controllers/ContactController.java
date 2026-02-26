package com.ozalp.portfolio.controllers;

import com.ozalp.portfolio.business.dtos.requests.MailContactRequest;
import com.ozalp.portfolio.business.dtos.requests.create.CreateContactRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateContactRequest;
import com.ozalp.portfolio.business.services.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    ResponseEntity<?> add(@RequestBody @Valid CreateContactRequest request) {
        contactService.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/send")
    ResponseEntity<?> send(@RequestBody @Valid MailContactRequest request) {
        contactService.send(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid UpdateContactRequest request) {
        contactService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    ResponseEntity<?> get() {
        return ResponseEntity.ok(contactService.getContact());
    }
}
