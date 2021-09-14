package com.htb.repository;

import com.htb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * FROM Book WHERE language = 'Vietnamese'",
    nativeQuery = true)
    List<Book> findBooksWithLanguage();

    @Query(value = "SELECT * FROM Book WHERE paperback > 500",
    nativeQuery = true)
    List<Book> findBooksWithPaperback();
}
