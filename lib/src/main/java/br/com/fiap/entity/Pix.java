package br.com.fiap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_PIX")
public class Pix {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipo")
	private TipoPix tipo;
	
	@Column(name="ativo")
	private boolean ativo;
	
	@ManyToOne()
	@Column(name="usuario")
	private UsuarioEntity usuario;
	
	
	
	
	public Pix() {}

	
	
	public Pix(TipoPix tipo, boolean ativo, UsuarioEntity usuario) {
		this.tipo = tipo;
		this.ativo = ativo;
		this.usuario = usuario;
	}



	public TipoPix getTipo() {
		return tipo;
	}


	public void setTipo(TipoPix tipo) {
		this.tipo = tipo;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public UsuarioEntity getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
