package br.mack.booksap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mack.booksap.model.Autor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
	
	Optional<Autor> findById(UUID uuid);

	List<Autor> findByNome(String nome);

	List<Autor> findByNacionalidade(String nacionalidade);

	List<Autor> findByNomeAndNacionalidade(String nome, String nacionalidade);
}