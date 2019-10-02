package com.dartsip.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dartsip.test.domain.Book;
import com.dartsip.test.repository.BookRepository;
import com.dartsip.test.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private BookRepository bookRepo;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/list")
	public Iterable<Book> list() {
		return bookService.list();
	}

	@GetMapping(value = "/booksDetails/{id}")
	public Book getBookById(@PathVariable int id) {
		return bookService.getBook(id);
	}

	@GetMapping(value = "/books/{title}")
	public List<Book> getBooksByTitle(Book book) {
		return bookService.findBooksByTitle(book.getTitle());
	}

}
