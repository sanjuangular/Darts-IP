package com.dartsip.test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.dartsip.test.domain.Book;
import com.dartsip.test.repository.BookRepository;
import com.dartsip.test.service.BookService;

import junit.framework.Assert;
import mockit.Mock;
import mockit.MockUp;

@RunWith(JUnit4.class)
public class TestBookService {

	BookRepository bookRepository = new BookRepository() {

		@Override
		public <S extends Book> Iterable<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Book> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Optional<Book> findById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Book> findAllById(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Book> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean existsById(Long id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void deleteById(Long id) {
			// TODO Auto-generated method stub

		}

		@Override
		public void deleteAll(Iterable<? extends Book> entities) {
			// TODO Auto-generated method stub

		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub

		}

		@Override
		public void delete(Book entity) {
			// TODO Auto-generated method stub

		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public List<Book> findByTitle(String title) {
			// TODO Auto-generated method stub
			return null;
		}
	};
	BookService unitTestObj = new BookService(bookRepository);

	// test method
	@SuppressWarnings("deprecation")
	@Test
	public void testfindBooksByTitle() {
		String title = "SQL book";
		List books = new ArrayList<>();
		books.add(title);
		Mock obj = new Mock() {
			List<Book> findByTitle(String title) {
				return null;
			}

			@Override
			public Class<? extends Annotation> annotationType() {
				// TODO Auto-generated method stub
				return null;
			}

		};
		unitTestObj.findBooksByTitle(title);
		Assert.assertNotNull(books);
	}
}
