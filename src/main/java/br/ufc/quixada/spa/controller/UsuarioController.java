package br.ufc.quixada.spa.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufc.quixada.spa.model.Usuario;
import br.ufc.quixada.spa.service.UsuarioService;

@Named
@RequestMapping("/usuario")
public class UsuarioController {

	@Inject
	private UsuarioService usuarioService;
	
	@RequestMapping(value="{value}", method = RequestMethod.GET)
	private @ResponseBody List<Usuario> getUsuariosCpfOrName(@PathVariable String value){
		List<Usuario> usuarios = usuarioService.getByCpfOrNome(value);
		return usuarios;
	}
}
