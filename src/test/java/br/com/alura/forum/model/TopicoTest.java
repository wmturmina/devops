package br.com.alura.forum.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TopicoTest {

	Usuario autor;
	Categoria categoria;
	Curso curso;
	Topico topico;
	
	@Before
	public void antes() {
		autor = new Usuario("Newton", "newton@caelum.com", "abc123");
		categoria = new Categoria("Programação");
		curso = new Curso("Java Básico", categoria);
		topico = new Topico("Me ajudem", "O Java não funciona no meu computador!", autor, curso);
	}

	@Test
	public void o_estado_inicial_de_um_topico_deve_ser_nao_respondido() {
		assertEquals(StatusTopico.NAO_RESPONDIDO, topico.getStatus());
	}

	@Test
	public void o_estado_deve_ser_fechado_quando_fechar_um_topico() throws InterruptedException {
		topico.fechar();

		assertEquals(StatusTopico.FECHADO, topico.getStatus());
	}

	@Test
	public void ao_adicionar_uma_resposta_a_lista_de_respostas_deve_ter_mais_uma_resposta() {
		Resposta resposta = new Resposta("Adicione o Java no PATH", topico, autor);

		assertEquals(1, topico.getRespostas().size());
	}

	@Test(expected = IllegalStateException.class)
	public void deve_lancar_excecao_ao_tentar_marcar_como_solucionado_um_topico_sem_resposta() {
		topico.marcarComoSolucionado();
	}

	@Test
	public void deve_marcar_como_solucionado_um_topico_com_pelo_menos_uma_resposta() {
		new Resposta("Adicione o Java no PATH", topico, autor);
		topico.marcarComoSolucionado();

		assertEquals(StatusTopico.SOLUCIONADO, topico.getStatus());
	}

}
