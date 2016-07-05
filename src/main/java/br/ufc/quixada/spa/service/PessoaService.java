package br.ufc.quixada.spa.service;

import java.util.List;

import br.ufc.quixada.npi.service.GenericService;
import br.ufc.quixada.spa.model.Pessoa;

public interface PessoaService extends GenericService<Pessoa> {

	public abstract Pessoa getPessoaByCpf(String cpf);
	
	public abstract List<Pessoa> getPessoasByCpf(String cpf);	

	public abstract List<Pessoa> getPessoasByNome(String nome);
	
	public abstract List<Pessoa> getPessoasByNomeOuCpf(String busca);
	
	public abstract List<Pessoa> getPareceristas(Long id);
}
