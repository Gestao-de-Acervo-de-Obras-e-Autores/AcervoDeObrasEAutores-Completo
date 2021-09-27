package example.AcervoObrasEAutores.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.AcervoObrasEAutores.domain.Autores;
import example.AcervoObrasEAutores.domain.Obras;
import example.AcervoObrasEAutores.repositories.AutoresRepository;
import example.AcervoObrasEAutores.repositories.ObrasRepository;


/**
 * @author Grupo 1 : Débora, Larissa, Maia, Roberta, Stefane, Viviane
 * @since Execução, Sprint 3 da apliacação
 * @version 1.4
 * 
 * Os serviçoes requisitam e enviam para os repositórios
 * */
@Service
public class ObrasService {
	
	/**Dependência**/
	@Autowired 
	private ObrasRepository obrasRepository; 
	
	@Autowired 
	private AutoresRepository autoresRepository;
	
	public ObrasService(ObrasRepository repository) {
	   this.obrasRepository = repository;
    }

	public List<Obras> listaTodas() {
		return obrasRepository.findAll();
	}

	public Optional<Obras> consultaObra(Long id) {
		return obrasRepository.findById(id);
	}

	public void insereObra(Obras obra, List<Long> idAutores) {
		List<Autores> autores = autoresRepository.findAll();
		List<Autores> autoresDaObra = new ArrayList<>();
		
	    for (Autores autor : autores) {
	    	for(Long id : idAutores) {
	    		if(autor.getId() == id) {
	    			autoresDaObra.add(autor);
	    		}
	    	}
	    }
	    
	    obra.setAutores(autoresDaObra);	   
	    
		obrasRepository.save(obra);
	}
	
	public void excluiObra(Long id) {
		obrasRepository.deleteById(id);
	}

	public void alteraObra(Long id, Obras novaObra) {
		Obras obra = obrasRepository.findById(id).get();
		
		String novoNome = novaObra.getNome();
		String novaDescricao = novaObra.getDescricao();
		String novaDataPubli = novaObra.getDataPubli();
		
		if(!novoNome.equals("")) {
			obra.setNome(novoNome);
		}
		if(!novaDescricao.equals("")) {
			obra.setDescricao(novaDescricao);
		}
		if(!novaDataPubli.equals("")) {
			obra.setDataPubli(novaDataPubli);
		}
        
		obrasRepository.save(obra);
	}

}
