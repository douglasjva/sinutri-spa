package br.ufc.quixada.spa.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.spa.dao.UsuarioDao;
import br.ufc.quixada.spa.model.Usuario;
import br.ufc.quixada.spa.service.UsuarioService;

@Named
public class UsuarioServiceFakeImpl implements UsuarioService {

	@Inject
	private UsuarioDao usuarioDao;
	
	@Override
	public Usuario getByCpf(String cpf) {
		List<Usuario> usuarios = usuarioDao.getByCpf(cpf);
		System.out.println(" "+usuarios.isEmpty());
		if (usuarios != null && !usuarios.isEmpty()) {
			Usuario user = usuarios.get(0);
			return user;
		}
		return null;
	}

	@Override
	public boolean autentica(String cpf, String password) {
		return usuarioDao.autentica(cpf, password);
	}

	@Override
	public List<Usuario> getAll() {
		return usuarioDao.getAll();
	}

	@Override
	public List<Usuario> getByCpfOrNome(String busca) {
		return usuarioDao.getByCpfOrNome(busca);
	}

}
