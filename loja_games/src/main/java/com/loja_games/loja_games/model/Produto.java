package com.loja_games.loja_games.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;



	@Entity // gerar tabela no banco de dados
	@Table(name = "tb_Produto") // nomeando a tabela do banco de dados
	public class Produto {

		@Id // indicando que esse atributo do tipo id será a minha primary key
		@GeneratedValue(strategy = GenerationType.IDENTITY) // essa chave criada sera gerada pelo banco de dados, e o
															// strategy irá gerar um auto_increment
		private long id;

		@NotBlank(message = "Este atributo é de preenchimento obrigatório")
		@Size(min = 1, max = 80, message = "Este atributo tem que ter no minimo 1 caracteres e no máximo 80 caracteres")
		private String nome;

		
		@Size(min = 10, max = 1000, message = "Este atributo tem que ter no minimo 10 caracteres e no máximo 1000 caracteres")
		private String descricao;

		@NotNull(message = "Preço é obrigatório!")
		@Positive(message = "O preço deve ser maior do que zero!")
		private BigDecimal preco;

		@ManyToOne
		@JsonIgnoreProperties("Produto")
		private Categoria categoria;
		
		@ManyToOne
		@JsonIgnoreProperties("Produto")
		private Usuario usuario;
		
		
		
		@UpdateTimestamp
		private LocalDateTime data;


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getDescricao() {
			return descricao;
		}


		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}


		public BigDecimal getPreco() {
			return preco;
		}


		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}


		public LocalDateTime getData() {
			return data;
		}


		public void setData(LocalDateTime data) {
			this.data = data;
		}


		public Usuario getUsuario() {
			return usuario;
		}


		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		
		
}

	