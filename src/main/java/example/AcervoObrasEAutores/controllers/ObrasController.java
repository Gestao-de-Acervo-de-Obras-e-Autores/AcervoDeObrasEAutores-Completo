package example.AcervoObrasEAutores.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import example.AcervoObrasEAutores.domain.Obras;
import example.AcervoObrasEAutores.exceptions.Exception;
import example.AcervoObrasEAutores.services.ObrasService;

/**
 * @author Grupo 1 : Débora, Larissa, Maia, Roberta, Stefane, Viviane
 * @since Planejamento, Sprint 2 da apliacação
 * @version 1.4
 * 
 * 
 * Controlador REST com os endpoints requisitando os serviços da classe Service 
 * */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ObrasController {

	@Autowired
	private ObrasService obrasService;
	
	ObrasController(ObrasService repository) {
	   this.obrasService = repository;
    }
	
	@GetMapping("/obras")
    public List<Obras> listarTodasAsObras(){
        return obrasService.listaTodas();
    }

    @GetMapping("/obras/{id}")
    public ResponseEntity<?> consultarObra(@PathVariable Long id) {
    	Optional<Obras> obra = obrasService.consultaObra(id);
         
        if(!obra.isPresent()) {
        	return Exception.erroObraNaoEncontrada(id);
        }
         
        return new ResponseEntity<Obras>(obra.get(), HttpStatus.OK); 
    }

    @PostMapping("/obras/{idAutores}")
    public ResponseEntity<?> inserirObra(@PathVariable List<Long> idAutores, @RequestBody Obras obra) {
    	if(obra.getNome().length() > 240) {
    		return Exception.erroNomeObraInvalida();
    	}
    	if(obra.getNome().equals("")) {
    		return Exception.erroNomeObraObrigatoria(); 
    	}
    	if(obra.getDescricao().length() > 240) {
    		return Exception.erroDescricaoObraInvalida();
    	}
    	if(obra.getDescricao().equals("")) {
    		return Exception.erroDescricaoObraObrigatoria(); 
    	}
    	
    	obrasService.insereObra(obra, idAutores);
    	
        return Exception.mensagemObraInserida();
    }

    @DeleteMapping("/obras/{id}")
    public ResponseEntity<?> excluirObra(@PathVariable Long id) {
    	Optional<Obras> obra = obrasService.consultaObra(id);
        
        if(!obra.isPresent()) {
        	return Exception.erroObraNaoEncontrada(id);
        }
        
    	obrasService.excluiObra(id);
    	
    	return Exception.mensagemObraExcluida();
    }
    
    @PutMapping("/obras/{id}")
    public ResponseEntity<?> alterarObra(@PathVariable Long id, @RequestBody Obras novaObra) {
    	Optional<Obras> obra = obrasService.consultaObra(id);
        
        if(!obra.isPresent()) {
        	return Exception.erroObraNaoEncontrada(id);
        }
        if(novaObra.getNome().length() > 240) {
    		return Exception.erroNomeObraInvalida();
    	}
    	if(novaObra.getDescricao().length() > 240) {
    		return Exception.erroDescricaoObraInvalida();
    	}
    	
    	obrasService.alteraObra(id, novaObra);
    	
    	return Exception.mensagemObraAlterada();
    }
	
}
