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
	void findBookWithLanguage() {
		List<Book> books = bookRepository.findBooksWithLanguage();
		System.out.println(books);
	}

	@Test
	void findBookWithPaperback() {
		List<Book> books = bookRepository.findBooksWithPaperback();
		System.out.println(books);
	}

	@Test
	void deleteBookWithLanguage() {
		bookRepository.deleteBookWithLanguage();
	}
}
