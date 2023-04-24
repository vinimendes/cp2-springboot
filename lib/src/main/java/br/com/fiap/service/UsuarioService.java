package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dao.UsuarioRepository;
import br.com.fiap.entity.UsuarioEntity;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioDTO> findAll() {
		List<UsuarioEntity> usuario = usuarioRepository.findAll();
		return usuario.stream().map(user -> new UsuarioDTO(user)).collect(Collectors.toList());
	}

	public Optional<UsuarioEntity> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	public UsuarioEntity inserirUsuario(UsuarioEntity user) throws CpfJaUtilizadoException {

		String cpf = user.getCpf();
		String email = user.getEmail();

		validarCpf(cpf);
		validarEmail(email);

		UsuarioEntity usuarioExistente = usuarioRepository.findByCpf(cpf);

		if (usuarioExistente != null) {
			throw new CpfJaUtilizadoException("O CPF " + cpf + " já está sendo utilizado");
		}
		
	//	if (validarCpfPorConta(usuarioExistente) = true) {
	//	}
	return usuarioRepository.save(user);


	}

	private void validarCpf(String cpf) throws FormatoInvalidoException {
		String regex = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}";
		if (!cpf.matches(regex)) {
			throw new FormatoInvalidoException("CPF em formato inválido");
		}
	}
	

	public List<UsuarioEntity> UsuariosByCpf(String cpf){
		return usuarioRepository.findByCpfAndAtivo(cpf, true);
		
	}
	
    public void validarCpfPorConta(UsuarioEntity usuario){
        List<UsuarioEntity> usuariosPorCpf = UsuariosByCpf(usuario.getCpf());
        if(usuariosPorCpf.size() >=3){
            throw new RuntimeException("Limite de contas por CPF atingido");
        }
    }

	
    public void verificaEmail(UsuarioEntity usuario) throws IllegalAccessException {
    	UsuarioEntity usua = usuarioRepository.findByEmail(usuario.getEmail());
    	if(usua != null) {
    		throw new IllegalAccessException("E-mail já foi cadastado no sistema");
    	}
    }

	public UsuarioEntity atualizarUsuario(UsuarioEntity usuario, Long id) {
		return usuarioRepository.findById(id).map(u -> {
			u.setNome(usuario.getNome());
			return usuarioRepository.save(u);
		}).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	}

	public void delete(Long id) {
		if (usuarioRepository.findById(id).isPresent()) {
			usuarioRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("usuario não foi removido, id não encontrado!");
		}
		
	}

}
