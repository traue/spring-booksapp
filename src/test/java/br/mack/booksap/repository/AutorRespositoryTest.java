package br.mack.booksap.repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.mack.booksap.model.Autor;

@SpringBootTest
public class AutorRespositoryTest {

	@Autowired
	AutorRepository autorRepository;

	@Test
	public void salvarTeste() {
		Autor autor = new Autor();
		autor.setNome("Thiago Traue");
		autor.setNacionalidade("Bobolandia");
		autor.setDataNascimento(LocalDate.of(1987, 4, 26));
		var autorSalvo = autorRepository.save(autor);
		System.out.println("Autor salvo: " + autorSalvo);
	}

	@Test
	public void atualizaAutorExistenteTest() {
		UUID uuid = UUID.fromString("be473ca4-d5b3-4936-9e1d-e9062af9f0d7");

		Optional<Autor> autorAtualizado = autorRepository.findById(uuid);

		if (autorAtualizado.isPresent()) {
			Autor autor = autorAtualizado.get();
			System.out.println("Autor sendo atualizado: " + autor);

			autor.setNome("Leticia Moraes Gutierrez de Oliveira da Silva Sauro");
			autor.setNacionalidade("Polonesa");

			autorRepository.save(autor);

			System.out.println("Novos dados: " + autor);
		} else {
			System.out.println("Autor não localizado!");
		}
	}
	
	@Test
	public void deletarAutorPorIdTest() {
		UUID uuid = UUID.fromString("39f813a6-816b-4e51-8162-bb982ffb17d7");

		Optional<Autor> autorDeletado = autorRepository.findById(uuid);
		
		if (autorDeletado.isPresent()) {
			System.out.println("Deletando o autor...: " + autorDeletado);
			autorRepository.delete(autorDeletado.get());
		}

	}

}
 