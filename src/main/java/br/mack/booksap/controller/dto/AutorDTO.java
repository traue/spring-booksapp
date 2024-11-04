package br.mack.booksap.controller.dto;

import java.time.LocalDate;
import java.util.UUID;

import br.mack.booksap.model.Autor;

public record AutorDTO(
		UUID uuid,
		String nome,
		LocalDate dataNascimento,
		String nacionalidade) {

	public Autor map() {
		Autor autor = new Autor();
		autor.setNome(this.nome);
		autor.setDataNascimento(this.dataNascimento);
		autor.setNacionalidade(this.nacionalidade);
		return autor;
	}
}
