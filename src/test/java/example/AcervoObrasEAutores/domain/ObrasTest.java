package example.AcervoObrasEAutores.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;

import example.AcervoObrasEAutores.domain.Obras;
import example.AcervoObrasEAutores.repositories.ObrasRepository;



class ObrasTest {
	
	/**
	 * Validando o POJO da Classe Obras.
	 * */
	private static final Logger log = LoggerFactory.getLogger(ObrasTest.class);
	
	private List<Obras> obras =  new ArrayList<Obras>();
	
	private List<Autores> autores = new ArrayList<Autores>();
	
	private Obras addObraMock(Integer id) {
		Obras obras = new Obras("Nome "+id, "Descrição "+id, "Data Publicação "+id);
		obras.setId((long) id);
		obras.setAutores(autores);
		return obras;
		
	}
	
	
	private void loadObras() {
                obras =  new ArrayList<Obras>();
                autores = new ArrayList<Autores>();

        obras.add(addObraMock(1));
		obras.add(addObraMock(2));
	}

	@MockBean
	private ObrasRepository mockRepositorio;
	
	@Test
	public void	obraVazia() {
		Obras obra = new Obras();
		assertNotNull(obra);
	}
	
	@Test
	public void consultaTodosTest() {
		
		loadObras();
	
		ObrasRepository mockRepositorio = mock(ObrasRepository.class);
		
		when(mockRepositorio.findAll())
			.thenReturn(obras);
		
		List<Obras> listaRetornoGET = mockRepositorio.findAll();
			
		log.info("Qtd na lista = "+ listaRetornoGET.size());
		assertTrue(listaRetornoGET.size()>0);
		
		log.info("Lista(0) = "+ listaRetornoGET.get(0).toString());
		assertEquals(listaRetornoGET.get(0).getId(), 1);
		assertTrue(listaRetornoGET.get(0).getNome().equals("Nome 1"));
		assertTrue(listaRetornoGET.get(0).getDescricao().equals("Descrição 1"));
		assertTrue(listaRetornoGET.get(0).getDataPubli().equals("Data Publicação 1"));
		assertTrue(listaRetornoGET.get(0).getAutores().equals(autores));
		
		log.info("Teste Consulta todos das Obras - OK");
	}

	@Test
	public void objetoHashToStringEqualsTest(){
		Obras obra = new Obras("Nome ", "Descrição ", "Data Publicação ");
		Long id = Long.valueOf(1);
		obra.setId(id);

		Obras obraDois = new Obras("Nome ", "Descrição ", "Data Publicação ");
		obraDois.setId(id);

		Obras obraVazia = new Obras();

		int hashObjeto = obra.hashCode();
		assertNotNull(hashObjeto);
		assertNotNull(obra.toString());
		assertFalse(obra.equals(null));
		assertFalse(obra.equals(obraVazia));
		assertFalse(obra.equals(id));
		assertTrue(obra.equals(obraDois));
		assertTrue(obra.equals(obra));
	}
}

