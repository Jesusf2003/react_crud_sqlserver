package com.crud.crud.controller;

import com.crud.crud.entity.Books;
import com.crud.crud.repository.BooksRepository;
import com.crud.crud.service.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class BooksController {

    @Autowired
    private BooksService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Books>> findAll(@RequestParam(required = false) String title) {
        if (title == null) {
            return service.findAll();
        } else {
            return service.searchByTitle(title);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping("/published")
    public ResponseEntity<List<Books>> findAllByPublished() {
        return service.findByPublished(true);
    }

    @PostMapping
    public ResponseEntity<Books> save(@RequestBody Books data) {
        return service.insert(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Books> update(@PathVariable("id") Long id, @RequestBody Books data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Books> deleteById(@PathVariable("id") Long id) {
        return service.setInactive(id);
    }
}