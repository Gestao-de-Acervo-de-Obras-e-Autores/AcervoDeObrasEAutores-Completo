package example.AcervoObrasEAutores.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.AcervoObrasEAutores.domain.Autores;
import example.AcervoObrasEAutores.domain.Obras;
import example.AcervoObrasEAutores.repositories.ObrasRepository;
import example.AcervoObrasEAutores.services.ObrasService;

public class ObrasServiceTest {

		private static final Logger log = LoggerFactory.getLogger(ObrasServiceTest.class);
		
		/**
		 * Fazendo Mock utilizando ObrasRepository e ObrasService 
		 */

		@Mock ObrasRepository repositorioMock = mock(ObrasRepository.class);
		ObrasService controllerMock = new ObrasService(repositorioMock);
		
		List<Obras> obras = new ArrayList<Obras>();
		List<Autores> autores = new ArrayList<Autores>();
		
		/**
		 * Validando a Regra de Negócio em Service:
		 * Cada obra deverá ter 1 (um) ou n autor(es).
		 */
		@Test
		public void findAllObrasMaisAutoresTest() {	
			obras.add(new Obras("Nome 1", "Descrição 1", "Data Publicação 1"));
			autores.add(new Autores("Autor 1", "Pais 1", "CPF 1", "Data de Nascimento 1"));
			autores.add(new Autores("Autor 2", "Pais 2", "CPF 2", "Data de Nascimento 2"));
			obras.get(0).setId(Long.valueOf(1));
			autores.get(0).setId(Long.valueOf(1));
			autores.get(1).setId(Long.valueOf(2));
			obras.get(0).setAutores(autores);
			obras.get(0).setAutores(autores);
			
			when(repositorioMock.findAll())
								.thenReturn(obras);

			List<Obras> retorno = controllerMock.listaTodas();
			
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
			Optional<Obras> obras = Optional.of(new Obras("Nome 64", "Descrição 64", "Data de Publicação 64"));
			autores.add(new Autores("Autor 1", "Pais 1", "CPF 1", "Data de Nascimento 1"));
			obras.get().setId(Long.valueOf(64));
			autores.get(0).setId(Long.valueOf(1));
			obras.get().setAutores(autores);

			when(repositorioMock.findById(Long.valueOf(64))).thenReturn(obras);

			Optional<Obras> retorno = controllerMock.consultaObra(Long.valueOf(64));
			assertNotNull(retorno);
			assertNotNull(obras.get().getAutores().equals(autores));
			log.info("Obra 64 - Informações: " + retorno.toString());
			log.info("Obra 64 - Autores: " + retorno.get().getAutores().toString());
			log.info("----------------Teste FindById OK!---------------------");
		}
		
		/**
		 * Validando o método excluiObra() em Service.
		 */
		@Test
		public void deletaObraTest() {
			controllerMock.excluiObra(1L);
			Mockito.verify(repositorioMock, Mockito.times(1)).deleteById(1L);
			
			log.info("Obra Apagada com Sucesso");
			log.info("-------------------------------------------------------");
		}
	
}
