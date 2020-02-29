package br.com.alura.forum.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.alura.forum.dao.PerfilDao;
import br.com.alura.forum.dao.UsuarioDao;
import br.com.alura.forum.model.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class CadastroUsuarioServiceTest {

	@Mock
	UsuarioDao usuarioDao;
	
	@Mock
	PerfilDao perfilDao;
	
	@Mock
	Md5Service md5Service;
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_lancar_excecao_quando_ja_existe_o_usuario() {
		Usuario usuario = new Usuario("Bilbo", "bilbo@shire.org", "abc123");
		Mockito.when(usuarioDao.buscarPorEmail("bilbo@shire.org")).thenReturn(usuario);
		CadastroUsuarioService service = new CadastroUsuarioService(usuarioDao, perfilDao, md5Service);
		Usuario novoUsuario = new Usuario("Bilbo", "bilbo@shire.org", "abc123");

		service.cadastrarNovoUsuario(novoUsuario);
	}
	
	@Test
	public void deve_salvar_um_usuario_no_banco_de_dados() {
		CadastroUsuarioService service = new CadastroUsuarioService(usuarioDao, perfilDao, md5Service);
		Usuario bilbo = new Usuario("Bilbo", "bilbo@shire.org", "abc123");

		service.cadastrarNovoUsuario(bilbo);
		
		Mockito.verify(usuarioDao, Mockito.times(1)).salvar(bilbo);
	}

}
