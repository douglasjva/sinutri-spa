package br.ufc.quixada.spa.controller;


import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufc.quixada.spa.exceptions.ForbiddenException;
import br.ufc.quixada.spa.model.LoginData;
import br.ufc.quixada.spa.model.Pessoa;
import br.ufc.quixada.spa.model.Usuario;
import br.ufc.quixada.spa.service.PessoaService;
import br.ufc.quixada.spa.service.UsuarioService;

@Named
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Inject
	private PessoaService pessoaService;
	
	@Inject
	private UsuarioService usuarioService;
	
	@RequestMapping(value="{cpf}", method = RequestMethod.GET)
	private @ResponseBody Pessoa getPessoaCpf(@PathVariable String cpf){
		Usuario usuario = usuarioService.getByCpf(cpf);
		Pessoa pessoa = pessoaService.getPessoaByCpf(cpf);
		pessoa.setDataNascimento(usuario.getNascimento());
		pessoa.setEmail(usuario.getEmail());
		pessoa.setTelefone(usuario.getTelefone());
		pessoa.setNome(usuario.getNome());
		
		return pessoa;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	private @ResponseBody boolean autenticacaoPessoa(@RequestBody LoginData loginData){
		System.out.println("parametros "+loginData.getCpf()+" "+loginData.getPassword());
		
		if(usuarioService.autentica(loginData.getCpf(), loginData.getPassword())){
			return true;
		} else {
			throw new ForbiddenException("CPF ou Senha incorretos");
		}
	}

}
