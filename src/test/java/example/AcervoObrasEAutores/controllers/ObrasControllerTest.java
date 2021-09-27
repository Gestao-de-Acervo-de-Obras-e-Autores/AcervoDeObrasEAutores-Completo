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

import example.AcervoObrasEAutores.domain.Autores;
import example.AcervoObrasEAutores.domain.Obras;
import example.AcervoObrasEAutores.services.ObrasService;

public class ObrasControllerTest {
	
	@Mock ObrasService repositorioMock = mock(ObrasService.class);
	ObrasController controllerMock = new ObrasController(repositorioMock);

	@Test
	public void findAllTest() {
		List<Obras> obras = new ArrayList<Obras>();
		List<Autores> autores = new ArrayList<Autores>();
		
		obras.add(new Obras("Nome 1", "Descrição 1", "Data Publicação 1"));
		autores.add(new Autores("Autor 1", "Pais 1", "Data de Nascimento 1", "CPF 1"));
		autores.add(new Autores("Autor 3", "Pais 3", "Data de Nascimento 3", "CPF 3"));
		obras.get(0).setId(Long.valueOf(1));
		obras.get(0).setAutores(autores);
	
		obras.add(new Obras("Nome 2", "Descrição 2", "Data Publicação 2"));
		autores.add(new Autores("Autor 2", "Pais 2", "Data de Nascimento 2", "CPF 2"));
		obras.get(1).setId(Long.valueOf(2));
		obras.get(1).setAutores(autores);
		
		when(repositorioMock.listaTodas())
							.thenReturn(obras);

		List<Obras> retorno = controllerMock.listarTodasAsObras();
		
		assertNotNull(retorno);
		assertNotNull(obras.get(0).getAutores().equals(autores));
		assertNotNull(obras.get(1).getAutores().equals(autores));
	}

	@Test
	public void findByIdTest(){
		Optional<Obras> teste = Optional.of(new Obras("Nome 1", "Descrição 1", "Data de Publicação 1"));
		teste.get().setId(Long.valueOf(1));

		when(repositorioMock.consultaObra(Long.valueOf(1))).thenReturn(teste);

		/*Optional<Obras> retorno = controllerMock.consultarObra(Long.valueOf(1));
		assertNotNull(retorno);*/
	}

}
