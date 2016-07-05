package br.ufc.quixada.spa.dao;

import java.util.List;

import br.ufc.quixada.spa.model.Usuario;



public interface UsuarioDao {
	
	public List<Usuario> getAll();
	
	public List<Usuario> getByCpf(String cpf);
	
	public boolean autentica(String matricula, String password);

	public List<Usuario> getByCpfOrNome(String busca);
	
}

