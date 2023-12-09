package com.crud.crud.service;

import com.crud.crud.entity.Books;
import com.crud.crud.repository.BooksRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BooksService {

    private BooksRepository repo;

    public ResponseEntity<List<Books>> findAll() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Books> findById(Long id) {
        Optional<Books> opt = repo.findById(id);
        if (opt.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(opt.get(), HttpStatus.OK);
    }

    public ResponseEntity<List<Books>> searchByTitle(String title) {
        return new ResponseEntity<>(repo.findAllByTitleContaining(title), HttpStatus.OK);
    }

    public ResponseEntity<List<Books>> findByPublished(Boolean published) {
        return new ResponseEntity<>(repo.findAllByPublished(published), HttpStatus.OK);
    }

    public ResponseEntity<Books> insert(Books data) {
        data.setPublished(true);
        return new ResponseEntity<>(repo.save(data), HttpStatus.OK);
    }

    public ResponseEntity<Books> update(Long id, Books data) {
        Optional<Books> opt = repo.findById(id);
        if (opt.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Books _entity = opt.get();
        _entity.setTitle(data.getTitle());
        _entity.setDescription(data.getDescription());
        _entity.setPublished(data.getPublished());
        return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
    }

    public ResponseEntity<Books> setInactive(Long id) {
        Optional<Books> opt = repo.findById(id);
        if (opt.isEmpty()) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Books _entity = opt.get();
        _entity.setPublished(false);
        return new ResponseEntity<>(repo.save(_entity), HttpStatus.OK);
    }
}