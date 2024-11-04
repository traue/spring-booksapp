package br.mack.booksap.repository;

import java.time.LocalDate;

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
        autor.setNacionalidade("Italiano");
        autor.setDataNascimento(LocalDate.of(1987, 4, 26));
        var autorSalvo = autorRepository.save(autor);
        System.out.println("Autor salvo: " + autorSalvo);
    }

}
