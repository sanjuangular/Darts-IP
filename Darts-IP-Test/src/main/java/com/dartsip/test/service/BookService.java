package com.dartsip.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.dartsip.test.domain.Book;
import com.dartsip.test.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Iterable<Book> list() {
		return bookRepository.findAll();
	}

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public Iterable<Book> saveAll(List<Book> books) {

		return bookRepository.saveAll(books);

	}

	// Return Single Book
	public Book getBook(int id) {
		Optional<Book> optionalBook = bookRepository.findById((long) id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		}
		return null;
	}

	// Return book details by book title
	public List<Book> findBooksByTitle(String title) {

		List<Book> bookTitle = bookRepository.findByTitle(title.toString());

		return bookTitle;
	}

}
