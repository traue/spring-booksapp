package br.mack.booksap.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.mack.booksap.controller.dto.AutorDTO;
import br.mack.booksap.model.Autor;
import br.mack.booksap.service.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	private final AutorService autorService;
	
	public AutorController(AutorService autorService) {
		this.autorService = autorService;
	}
	
	@PostMapping
	public ResponseEntity<Void> salvarAutor(@RequestBody AutorDTO autor) {
		Autor autorEntity = autor.map();
		autorService.salvarAutor(autorEntity);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(autorEntity.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();		
	}
}
