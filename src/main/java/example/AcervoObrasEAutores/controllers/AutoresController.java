package example.AcervoObrasEAutores.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import example.AcervoObrasEAutores.domain.Autores;
import example.AcervoObrasEAutores.domain.Obras;
import example.AcervoObrasEAutores.services.AutoresService;
import example.AcervoObrasEAutores.exceptions.Exception;

/**
 * @author Grupo 1 : Débora, Larissa, Maia, Roberta, Stefane, Viviane
 * @since Planejamento, Sprint 2 da aplicação
 * @version 1.4
 * 
 * 
 * Controlador REST com os endpoints requisitando os serviços da classe Service 
 * */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class AutoresController {

	@Autowired
	private AutoresService autoresService;
	
	public AutoresController(AutoresService repository) {
        this.autoresService = repository;
    }
	
	@GetMapping("/autores")
	public List<Autores> listarTodosOsAutores(){
	    return autoresService.listaTodos(); 
	}

    @GetMapping("/autores/{id}")
    public ResponseEntity<?> consultarAutor(@PathVariable Long id) {
        Optional<Autores> autor = autoresService.consultaAutor(id);
        
        if(!autor.isPresent()) {
        	return Exception.erroAutorNaoEncontrado(id);
        }
        
        return new ResponseEntity<Autores>(autor.get(), HttpStatus.OK);     
    }
    
    @PostMapping("/autores")
    public ResponseEntity<?> inserirAutor(@RequestBody Autores autor) {
    	if(autor.getNome().length() > 120) {
    		return Exception.erroNomeAutorInvalido();
    	}
    	if(autor.getNome().equals("")) {
    		return Exception.erroNomeAutorObrigatorio(); 
    	}
    	if(autor.getPaisOrigem().equals("")) {
    		return Exception.erroPaisAutorObrigatorio(); 
    	}
    	if(autor.getPaisOrigem().equals("Brasil") && autor.getCpf().equals("")) {
    		return Exception.erroCpfBrasileiroObrigatorio(); 
    	}
    	
    	autoresService.insereAutor(autor);
    	
    	return Exception.mensagemAutorInserido();
    }
    
    @DeleteMapping("/autores/{id}")
    public ResponseEntity<?> excluirAutor(@PathVariable Long id) {
    	Optional<Autores> autor = autoresService.consultaAutor(id);
        
        if(!autor.isPresent()) {
        	return Exception.erroAutorNaoEncontrado(id);
        }
    	
    	autoresService.excluiAutor(id);
    	
    	return Exception.mensagemAutorExcluido();
    } 
    
    @PutMapping("/autores/{id}")
    public ResponseEntity<?> alterarAutor(@PathVariable Long id, @RequestBody Autores novoAutor) {
    	Optional<Autores> autor = autoresService.consultaAutor(id);
        
        if(!autor.isPresent()) {
        	return Exception.erroAutorNaoEncontrado(id);
        }
        if(novoAutor.getNome().length() > 120) {
    		return Exception.erroNomeAutorInvalido();
    	}
  
    	 autoresService.alteraAutor(id, novoAutor);
    	 
    	 return Exception.mensagemAutorAlterado();
    }
    
    @GetMapping("/autoresObras/{id}")
	public ResponseEntity<?> listarObrasDoAutor(@PathVariable Long id){
    	Optional<Autores> autor = autoresService.consultaAutor(id);
        
        if(!autor.isPresent()) {
        	return Exception.erroAutorNaoEncontrado(id);
        }
        
	    List<Obras> obras = autoresService.listaObrasDoAutor(id); 
	    
	    return new ResponseEntity<List<Obras>>(obras, HttpStatus.OK);
	}
    
}

