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

    @Query(value = "SELECT * FROM Book WHERE language = 'Vietnamese'",
    nativeQuery = true)
    List<Book> findBooksWithLanguage();

    @Query(value = "SELECT * FROM Book WHERE paperback > 500",
    nativeQuery = true)
    List<Book> findBooksWithPaperback();

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Book WHERE id = :id", nativeQuery = true)
    void deleteBook(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Book SET language = ?1, paperback = ?2 WHERE id = ?3", nativeQuery = true)
    void updateBook(String language, int paperback, int id);
}
