package com.example.bookapi;

import com.example.bookapi.entity.Book;
import com.example.bookapi.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class BookApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(BookRepository repository) {
		return args -> {
			Random random = new Random();
			String[] authors = {"Author A", "Author B", "Author C", "Author D"};
			String[] genres = {"Fiction", "Science", "Fantasy", "History"};

			for (int i = 1; i <= 1000; i++) {
				repository.save(new Book(null, "Book " + i, authors[random.nextInt(authors.length)], 1900 + random.nextInt(124), genres[random.nextInt(genres.length)]));
			}
		};
	}
}
