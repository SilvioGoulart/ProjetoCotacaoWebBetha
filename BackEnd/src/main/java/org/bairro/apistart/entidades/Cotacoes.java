package org.bairro.apistart.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cotacao")
@SequenceGenerator(name = "COTACAO_SEQ", sequenceName = "COTACAO_SEQ", allocationSize = 1)
public class Cotacoes {

	@Id
	@Column(name = "id_cotacao")
	@GeneratedValue(generator = "COTACAO_SEQ", strategy = GenerationType.SEQUENCE)
	private Integer idCotacao;

	@Column(length = 50, nullable = false)
	private String nome_fornecedor;

	@Column(length = 50, nullable = false)
	private String email;

	@Column(length = 50, nullable = false)
	private String telefone;

	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	@Column(name = "valorProposta", nullable = false)
	private String valorProposta;

	@Column(name = "dataCadastro", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	@Column(name = "dataLimite", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataLimite;

	public Integer getIdCotacao() {
		return idCotacao;
	}

	public void setIdCotacao(Integer idCotacao) {
		this.idCotacao = idCotacao;
	}

	public String getNome_fornecedor() {
		return nome_fornecedor;
	}

	public void setNome_fornecedor(String nome_fornecedor) {
		this.nome_fornecedor = nome_fornecedor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getValorProposta() {
		return valorProposta;
	}

	public void setValorProposta(String valorProposta) {
		this.valorProposta = valorProposta;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}

	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produtos produto;

}