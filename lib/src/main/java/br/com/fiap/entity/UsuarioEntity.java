package br.com.fiap.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name="cd_usuario", sequenceName = "SQ_TB_USUARIO", allocationSize = 1)
public class UsuarioEntity {

    @Id
    @Column(name="cd_usuario")
    @GeneratedValue(generator = "cd_usuario",strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "uuid", unique = true, nullable = false)
    private String uuid;
    
    @Column(name = "email", nullable = false, unique=true)
    private String email;
    
    @Column(name = "nome_mae")
    private String nomeMae;
    
    @Column(name = "senha", nullable = false)
    private String senha;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Embedded
    private String endereco;
    
    @Column(name = "cpf")
    private String cpf;
    
    @Column(name = "rg")
    private String rg;
    
    @Column(name = "pep")
    private Boolean pep;
    
    @Column(name = "renda_mensal")
    private Float rendaMensal;
    
    @Column(name = "valor_patrimonio")
    private Float valorPatrimonio;
    
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
    
    @Column(name = "data_atualizacao")
    private Calendar dataAtualizacao;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Pix> pix = new ArrayList<Pix>();
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cd_saldo", nullable = false)
	private Saldo saldo;

    
	public UsuarioEntity() {
	}
	
	

	public UsuarioEntity(Long id, String nome, String uuid, String email, String nomeMae, String senha, String telefone,
			LocalDate dataNascimento, String endereco, String cpf, String rg, Boolean pep, Float rendaMensal,
			Float valorPatrimonio, LocalDateTime dataCadastro, Calendar dataAtualizacao, List<Pix> pix,
			List<Produto> produto) {
		this.id = id;
		this.nome = nome;
		this.uuid = uuid;
		this.email = email;
		this.nomeMae = nomeMae;
		this.senha = senha;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.cpf = cpf;
		this.rg = rg;
		this.pep = pep;
		this.rendaMensal = rendaMensal;
		this.valorPatrimonio = valorPatrimonio;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.pix = pix;
	}



	public UsuarioEntity(Long id, String nome, String uuid, String email, String nomeMae, String senha, String telefone,
			LocalDate dataNascimento, String endereco, String cpf, String rg, Boolean pep, Float rendaMensal,
			Float valorPatrimonio, LocalDateTime dataCadastro, Calendar dataAtualizacao) {

		this.id = id;
		this.nome = nome;
		this.uuid = uuid;
		this.email = email;
		this.nomeMae = nomeMae;
		this.senha = senha;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.cpf = cpf;
		this.rg = rg;
		this.pep = pep;
		this.rendaMensal = rendaMensal;
		this.valorPatrimonio = valorPatrimonio;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Boolean getPep() {
		return pep;
	}

	public void setPep(Boolean pep) {
		this.pep = pep;
	}

	public Float getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(Float rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public Float getValorPatrimonio() {
		return valorPatrimonio;
	}

	public void setValorPatrimonio(Float valorPatrimonio) {
		this.valorPatrimonio = valorPatrimonio;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}



	public List<Pix> getPix() {
		return pix;
	}



	public void setPix(List<Pix> pix) {
		this.pix = pix;
	}





    
    

}
