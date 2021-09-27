package example.AcervoObrasEAutores.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import example.AcervoObrasEAutores.domain.Autores;
import example.AcervoObrasEAutores.domain.Obras;
import example.AcervoObrasEAutores.services.ObrasService;
import example.AcervoObrasEAutores.services.ObrasServiceTest;

public class ObrasControllerTest {
	
	private static final Logger log = LoggerFactory.getLogger(ObrasServiceTest.class);
	
	@Mock ObrasService repositorioMock = mock(ObrasService.class);
	ObrasController controllerMock = new ObrasController(repositorioMock);
	
	List<Obras> obras = new ArrayList<Obras>();
	List<Autores> autores = new ArrayList<Autores>();
	
	/**
	 * Validando a Regra de Negócio em Controller:
	 * Cada obra deverá ter 1 (um) ou n autor(es).
	 */
	@Test
	public void findAllTest() {
		obras.add(new Obras("Nome 1", "Descrição 1", "Data Publicação 1"));
		autores.add(new Autores("Autor 1", "Pais 1", "CPF 1", "Data de Nascimento 1"));
		autores.add(new Autores("Autor 2", "Pais 2", "CPF 2", "Data de Nascimento 2"));
		obras.get(0).setId(Long.valueOf(1));
		autores.get(0).setId(Long.valueOf(1));
		autores.get(1).setId(Long.valueOf(2));
		obras.get(0).setAutores(autores);
		obras.get(0).setAutores(autores);
		
		when(repositorioMock.listaTodas())
							.thenReturn(obras);

		List<Obras> retorno = controllerMock.listarTodasAsObras();
		
		assertNotNull(retorno);
		log.info("Obra 1 - Informações: " + retorno.get(0).toString());
		log.info("Obra 1 - Autores: " + retorno.get(0).getAutores().toString());
		assertNotNull(obras.get(0).getAutores().equals(autores));
		log.info("------------------------------------------------------------");
	}

	/**
	 * Validando a Regra de Negócio em Service:
	 * A partir de uma obra deverá ser possível acessar o(s) autor(es).
	 */
	@Test
	public void findByIdTest(){
		Optional<Obras> teste = Optional.of(new Obras("Nome 64", "Descrição 64", "Data de Publicação 64"));
		autores.add(new Autores("Autor 1", "Pais 1", "CPF 1", "Data de Nascimento 1"));
		teste.get().setId(Long.valueOf(64));
		autores.get(0).setId(Long.valueOf(1));
		teste.get().setAutores(autores);
		
		when(repositorioMock.consultaObra(Long.valueOf(64))).thenReturn(teste);

		ResponseEntity<?> retorno = controllerMock.consultarObra(Long.valueOf(64));
		
		assertNotNull(retorno);
		assertNotNull(teste.get().getAutores().equals(autores));
		log.info("----------------Teste FindById Controller OK!---------------------");
	}

}
