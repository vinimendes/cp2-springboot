package br.com.fiap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_SALDO")
public class Saldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_saldo;	
	
    @Column(name="saldo")
	private int saldo;
	
    @Column(name="usuario")
	private String usuario;
	
	
	public Saldo() {}
	
	public Saldo(int saldo, String usuario) {
		this.saldo = saldo;
		this.usuario = usuario;
	}



	public int getSaldo() {
		return saldo;
	}


	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
