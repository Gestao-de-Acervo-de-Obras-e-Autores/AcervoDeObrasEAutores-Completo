package example.AcervoObrasEAutores.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.AcervoObrasEAutores.domain.Autores;
import example.AcervoObrasEAutores.domain.AutoresTest;
import example.AcervoObrasEAutores.domain.Obras;
import example.AcervoObrasEAutores.repositories.AutoresRepository;

class AutorServiceTest {

	private static final Logger log = LoggerFactory.getLogger(AutorServiceTest.class);
	@Mock AutoresRepository repositorioMock = mock(AutoresRepository.class);
	AutoresService controllerMock = new AutoresService(repositorioMock);
	
	List<Autores> autores = new ArrayList<Autores>();
	List<Obras> obras = new ArrayList<Obras>();

	
	@Test
	public void main() {
		log.info("-----------AutorServiseTest------------");
		findAllAutoresMaisObrasTest();
		findByIdTest();
		log.info("---------------------------------------");
	}
	
	public void findAllAutoresMaisObrasTest() {	
		obras.add(new Obras("Nome1", "Descrição1", "Data Publicação1"));
		autores.add(new Autores("nome1", "paisOrigem1", "000000000001","00/00/1981"));
		autores.add(new Autores("nome1", "paisOrigem2", "000000000002","00/00/1982"));
		obras.get(0).setId(Long.valueOf(1));
		
		obras.add(new Obras("Nome2", "Descrição2", "Data Publicação2"));
		autores.add(new Autores("nome1", "paisOrigem1", "000000000001","00/00/1981"));
		autores.add(new Autores("nome1", "paisOrigem2", "000000000002","00/00/1982"));
		obras.get(0).setId(Long.valueOf(2));
		obras.get(0).setAutores(autores);
		obras.get(1).setAutores(autores);
	
		obras.add(new Obras("Nome 2", "Descrição 2", "Data Publicação 2"));
		autores.add(new Autores("Autor 2", "Pais 2", "Data de Nascimento 2", "CPF 2"));
		obras.get(1).setId(Long.valueOf(2));
		obras.get(1).setAutores(autores);
		
		when(repositorioMock.findAll())
							.thenReturn(autores);

		List<Autores> retorno = controllerMock.listaTodos();
		
		assertNotNull(retorno);
		assertNotNull(obras.get(0).getAutores().equals(autores));
		assertNotNull(obras.get(1).getAutores().equals(autores));
		assertNotNull(obras.get(0).getId().equals(1));
		assertNotNull(obras.get(1).getId().equals(2));
		
	}
	
	public void findByIdTest(){
		Optional<Autores> teste = Optional.of(new Autores("nome1", "paisOrigem1", "000000000001","00/00/1981"));
		teste.get().setId(Long.valueOf(1));

		when(repositorioMock.findById(Long.valueOf(1))).thenReturn(teste);

		Optional<Autores> retorno = controllerMock.consultaAutor(Long.valueOf(1));
		assertNotNull(retorno);		
	}
}

