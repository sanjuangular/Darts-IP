package com.dartsip.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dartsip.test.domain.Book;
import com.dartsip.test.service.BookService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
public class DartsIpTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DartsIpTestApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(BookService bookService)
	{
		return args->{
			// Read Json and write to database
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Book>> typeReference = new TypeReference<List<Book>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/test.json");
			try {
				List<Book> books = mapper.readValue(inputStream,typeReference);
				bookService.saveAll(books);
				System.out.println("Books Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Books: " + e.getMessage());
			}
	    };
		
	}

}
