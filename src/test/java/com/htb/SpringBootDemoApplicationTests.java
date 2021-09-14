package com.htb;

import com.htb.entity.Book;
import com.htb.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootDemoApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void findAll() {
		List<Book> books = bookRepository.findAll();
		books.forEach(System.out::println);
	}

	@Test
	void createBook() {
		Book book = new Book();
		book.setLanguage("English");
		book.setPaperback(250);
		book.setPublisher("O'Really");
		book.setTitle("Head First Java 2nd");
		bookRepository.save(book);
	}

	@Test
	void updateBook() {
		Book book = new Book();
		book.setId(4);
		book.setLanguage("English");
		book.setPaperback(250);
		book.setPublisher("O'Really");
		book.setTitle("Head First OOP 2nd");
		bookRepository.save(book);
	}

	@Test
	void deleteBook() {
		bookRepository.deleteById(4);
	}
}
