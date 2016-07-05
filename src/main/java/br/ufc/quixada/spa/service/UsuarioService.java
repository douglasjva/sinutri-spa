package br.ufc.quixada.spa.service;

import java.util.List;

import br.ufc.quixada.spa.model.Usuario;

public interface UsuarioService {
	
	public Usuario getByCpf(String cpf);
	
	public boolean autentica(String cpf, String password);
	
	public List<Usuario> getAll();

	public List<Usuario> getByCpfOrNome(String busca);
}
