package com.crud.crud.repository;

import com.crud.crud.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    List<Books> findAllByPublished(boolean published);
    List<Books> findAllByTitleContaining(String title);
}