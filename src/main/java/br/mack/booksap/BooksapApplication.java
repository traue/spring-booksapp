package br.mack.booksap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BooksapApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksapApplication.class, args);
	}

}
