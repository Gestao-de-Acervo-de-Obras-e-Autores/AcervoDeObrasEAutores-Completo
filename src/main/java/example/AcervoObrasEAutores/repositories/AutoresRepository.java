package example.AcervoObrasEAutores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import example.AcervoObrasEAutores.domain.Autores;

/**
 * @author Grupo 1 : Débora, Larissa, Maia, Roberta, Stefane, Viviane
 * @since Planejamento, Sprint 1 da apliacação
 * @version 1.4
 * 
 * Conecta com o BD Herdando tudo que a classe JpaRepository faz
 * */
public interface AutoresRepository extends JpaRepository<Autores, Long>{

}

