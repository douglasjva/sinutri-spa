package br.ufc.quixada.spa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.springframework.stereotype.Component;

import br.ufc.quixada.spa.model.Usuario;


@Named
@Component
public class UsuarioDaoImpl implements UsuarioDao {

	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioDaoImpl(){
		usuarios.add(getNewUser("Douglas Henrique","05786631397", "douglasjvah@gmail.com", "346224","346225","96659465", new Long("769316400000"), "teste"));
		usuarios.add(getNewUser("Emanuel Oliveira","05486532397", "emanuel.oliveira23@gmail.com", "346220","346700","96658521", new Long("749876400000"), "teste"));
		usuarios.add(getNewUser("Guilherme Estevão","05428432397", "guilhermeestevo@gmail.com", "387520","314700","96025521", new Long("686890800000"), "teste"));
		usuarios.add(getNewUser("Alex Oliveira","02478896397", "alex.oliveira@gmail.com", "147852","025879","97853225", new Long("568260000000"), "teste"));
		usuarios.add(getNewUser("Kaynan Coelho","02365547896", "kaynanc.kcl@gmail.com", "258369","963258","98855447", new Long("694666800000"), "teste"));
	}

	private Usuario getNewUser(String nome, String cpf, String email, String matricula, String siape, String telefone, Long dataNascimentoTime, String password){
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setEmail(email);
		usuario.setMatricula(matricula);
		Date dataNascimento = new Date();
		dataNascimento.setTime(dataNascimentoTime);
		usuario.setNascimento(dataNascimento);
		usuario.setPassword(password);
		usuario.setSiape(siape);
		usuario.setTelefone(telefone);
		return usuario;
	}
	
	@Override
	public List<Usuario> getAll() {
		return usuarios;
	}

	@Override
	public List<Usuario> getByCpf(String cpf) {
		List<Usuario> resultadoUsuarios = new ArrayList<Usuario>();
		for(Usuario usuario : usuarios) {
			System.out.println("cpf user banco "+usuario.getCpf()+" cpf requisicao "+cpf);
			if(usuario.getCpf().equals(cpf)){
				System.out.println("achou o cara");
				resultadoUsuarios.add(usuario);
				break;
			}
		}
		return resultadoUsuarios;
	}

	@Override
	public boolean autentica(String cpf, String password) {
		for(Usuario usuario : usuarios) {
			if(usuario.getCpf().equals(cpf) && usuario.getPassword().equals(password)){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public List<Usuario> getByCpfOrNome(String busca) {
		List<Usuario> resultadoUsuarios = new ArrayList<Usuario>();
		for(Usuario usuario : usuarios){
			if(usuario.getCpf().equals(busca) || usuario.getNome().equals(busca)){
				resultadoUsuarios.add(usuario);
			}
		}
		return resultadoUsuarios;
	}

}
