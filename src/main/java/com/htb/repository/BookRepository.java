package com.htb.repository;

import com.htb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT b FROM Book b WHERE b.language = 'Chinese'")
    List<Book> findBooksWithLanguage();

    @Query(value = "SELECT b FROM Book b WHERE b.paperback > 1000")
    List<Book> findBooksWithPaperback();

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Book WHERE language = 'Chinese'")
    void deleteBookWithLanguage();
}
