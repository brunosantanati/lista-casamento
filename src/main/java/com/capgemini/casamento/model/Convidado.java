package com.capgemini.casamento.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Convidado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Type(type="yes_no")
	private boolean presencaConfirmada;
	private String nome;
	private String email;
	private String telefone;
	private byte quantidadeAdultos;
	private byte quantidadeCriancas;
	private String mensagem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isPresencaConfirmada() {
		return presencaConfirmada;
	}
	public void setPresencaConfirmada(boolean presencaConfirmada) {
		this.presencaConfirmada = presencaConfirmada;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public byte getQuantidadeAdultos() {
		return quantidadeAdultos;
	}
	public void setQuantidadeAdultos(byte quantidadeAdultos) {
		this.quantidadeAdultos = quantidadeAdultos;
	}
	public byte getQuantidadeCriancas() {
		return quantidadeCriancas;
	}
	public void setQuantidadeCriancas(byte quantidadeCriancas) {
		this.quantidadeCriancas = quantidadeCriancas;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	@Override
	public String toString() {
		return "Convidado [ id=" + id + ", presencaConfirmada=" + presencaConfirmada + ", nome=" + nome + ", email="
				+ email + ", telefone=" + telefone + ", quantidadeAdultos=" + quantidadeAdultos
				+ ", quantidadeCriancas=" + quantidadeCriancas + ", mensagem=" + mensagem + " ]";
	}
	
}
