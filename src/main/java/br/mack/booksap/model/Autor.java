package br.mack.booksap.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "autor", schema = "public")
@Getter // o lombok gera em tempo de compilação os get e sets!
@Setter
//@ToString(exclude = { "livros" })
@EntityListeners(AuditingEntityListener.class) // classe usada para as auditorias (timestamps da criação / alteração)
public class Autor {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "nome", length = 80, nullable = false)
	private String nome;

	@Column(name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "nacionalidade", nullable = false)
	private String nacionalidade;

//    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL) //nome da variável de autor
//    private List<Livro> livros;

	@CreatedDate // registra automaticamente a data da criação do objeto
	@Column(name = "data_cadastro")
	private LocalDateTime dataCadastro;

	@LastModifiedDate // registra automaticmente a ultima modificação
	@Column(name = "data_atualizacao")
	private LocalDateTime dataAtualizacao;

	@Column(name = "idUsuario")
	private UUID idUsuario;

//	public UUID getId() {
//		return id;
//	}
//
//	public void setId(UUID id) {
//		this.id = id;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public LocalDate getDataNascimento() {
//		return dataNascimento;
//	}
//
//	public void setDataNascimento(LocalDate dataNascimento) {
//		this.dataNascimento = dataNascimento;
//	}
//
//	public String getNacionalidade() {
//		return nacionalidade;
//	}
//
//	public void setNacionalidade(String nacionalidade) {
//		this.nacionalidade = nacionalidade;
//	}
//
//	public LocalDateTime getDataCadastro() {
//		return dataCadastro;
//	}
//
//	public void setDataCadastro(LocalDateTime dataCadastro) {
//		this.dataCadastro = dataCadastro;
//	}
//
//	public LocalDateTime getDataAtualizacao() {
//		return dataAtualizacao;
//	}
//
//	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
//		this.dataAtualizacao = dataAtualizacao;
//	}
//
//	public UUID getIdUsuario() {
//		return idUsuario;
//	}
//
//	public void setIdUsuario(UUID idUsuario) {
//		this.idUsuario = idUsuario;
//	}
//
//	@Override
//	public String toString() {
//		return "Autor [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", nacionalidade="
//				+ nacionalidade + ", dataCadastro=" + dataCadastro + ", dataAtualizacao=" + dataAtualizacao
//				+ ", idUsuario=" + idUsuario + "]";
//	}
	
	
}
