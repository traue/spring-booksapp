package br.mack.booksap.service;

import org.springframework.stereotype.Service;

import br.mack.booksap.model.Autor;
import br.mack.booksap.repository.AutorRepository;

@Service
public class AutorService {
	
	private final AutorRepository autorRepository;
	
	public AutorService(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	public Autor salvarAutor(Autor autor) {
		
		return autorRepository.save(autor);
	}
	
}
