package example.AcervoObrasEAutores.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;

import example.AcervoObrasEAutores.repositories.AutoresRepository;

@TestMethodOrder(OrderAnnotation.class)
public class AutoresTest {

	private static final Logger log = LoggerFactory.getLogger(AutoresTest.class);
	
	private java.util.List<Autores> autor =  new ArrayList<Autores>();
	
	private Long id = Long.valueOf(1);
	private String nome = "nome"+id;
	private String paisOrigem= "paisOrigem"+id;
	private String cpf = "00000000000"+id;
	private String dataNasc = "00/00/198"+id; 

	private Autores addAutorMock(Integer id) {
		Autores autores = new Autores(nome, paisOrigem, cpf,dataNasc);
		autores.setId((long)id);
		return autores;
	}
	
	private void LoadAutores() {
		autor = new ArrayList<Autores>();
		/*Carrega o objeto de Autor*/
		autor.add(addAutorMock(1));
	}
	
	@MockBean
	private AutoresRepository mockRepository;
	
	@Test
	public void main() {
		log.info("-----------AutoresTest------------");
		getAllTest();
		hashCodeTest();
		log.info("----------------------------------");
		
	}
	
	
	public void getAllTest() {
		LoadAutores();
		
		/* mockando classe AutoresRepository*/
		AutoresRepository mockRepository = mock(AutoresRepository.class);
		
		/* mockando o retorno dop Repositorio*/
		when(mockRepository.findAll())
			.thenReturn(autor);
		
		/* chamando serviso mockado*/
		List<Autores> listReurnGET = mockRepository.findAll();
		
		log.info("O numero de Autores na lista é : " + listReurnGET.size());
		/*verificando tamanho da lista*/
		assertTrue(listReurnGET.size()>0);
		
		log.info("Lista (0) = " + listReurnGET.get(0).toString());
		assertEquals(listReurnGET.get(0).getId(),1);
		assertEquals(listReurnGET.get(0).getNome(), "nome1");
		assertEquals(listReurnGET.get(0).getPaisOrigem(), "paisOrigem1");
		assertEquals(listReurnGET.get(0).getCpf(), "000000000001");
		assertEquals(listReurnGET.get(0).getDataNasc(), "00/00/1981" );
		
		log.info("------------getAllTest------------");
		
	}
	
		public void hashCodeTest() {
		Autores autores = new Autores(nome, paisOrigem, cpf,dataNasc);
		autores.setId((long)id);
		
		Autores autores2 = new Autores(nome, paisOrigem, cpf,dataNasc);
		autores2.setId(id);
		
		Autores autorVazio = new Autores();
		
		int hashObjeto = autores.hashCode();
		assertNotNull(hashObjeto);
		assertNotNull(autores.toString());
		assertFalse(autores.equals(null));
		assertFalse(autores.equals(autorVazio));
		assertFalse(autores.equals(id));
		assertTrue(autores.equals(autores2));
		assertTrue(autores.equals(autores));
		
		
		
		
	}
		
}
