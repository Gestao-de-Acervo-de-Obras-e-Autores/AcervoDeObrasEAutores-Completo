package example.AcervoObrasEAutores.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.AcervoObrasEAutores.controllers.AutoresController;
import example.AcervoObrasEAutores.controllers.ObrasController;
import example.AcervoObrasEAutores.domain.Autores;
import example.AcervoObrasEAutores.domain.Obras;
import example.AcervoObrasEAutores.services.AutoresService;
import example.AcervoObrasEAutores.services.ObrasService;

class AutoresControllerTest {
	
	private static final Logger log = LoggerFactory.getLogger(AutoresControllerTest.class);
	
	@Mock AutoresService repositorioMock = mock(AutoresService.class);
    AutoresController controllerMock = new AutoresController(repositorioMock);

    @Test
	public void main() {
		log.info("-----------AutoresTest------------");
		findAllTest();
		log.info("----------------------------------");
		
	}
    public void findAllTest() {
        List<Obras> obras = new ArrayList<Obras>();
        List<Autores> autores = new ArrayList<Autores>();
        
        obras.add(new Obras("Nome 1", "Descrição 1", "Data Publicação 1"));
        obras.get(0).setId(Long.valueOf(1));
        autores.add(new Autores("nome1", "paisOrigem1", "000000000001","00/00/1981"));
        autores.get(0).setId(Long.valueOf(1));
        obras.get(0).setAutores(autores);
        
        
        obras.add(new Obras("Nome 2", "Descrição 2", "Data Publicação 2"));
        obras.get(1).setId(Long.valueOf(2));
        autores.add(new Autores("nome1", "paisOrigem1", "000000000001","00/00/1981"));
        autores.get(0).setId(Long.valueOf(1));
		autores.add(new Autores("nome2", "paisOrigem2", "000000000002","00/00/1982"));
		autores.get(1).setId(Long.valueOf(2));
		obras.get(1).setAutores(autores);
		

        /*List<Obras> retorno = controllerMock.listarTodosOsAutores(Long.valueOf(1));
        List<Obras> retorno2 = controllerMock.listarTodosOsAutores(Long.valueOf(2));
        
        assertNotNull(retorno);
        assertNotNull(obras.get(0).getAutores().equals(obras));
        assertNotNull(obras.get(1).getAutores().equals(obras));
        log.info("autor " +Long.valueOf(1));
        
        assertNotNull(retorno2);
        assertNotNull(obras.get(0).getAutores().equals(obras));
        assertNotNull(obras.get(1).getAutores().equals(obras));
        log.info("autor " +Long.valueOf(2));*/
    }
    

}