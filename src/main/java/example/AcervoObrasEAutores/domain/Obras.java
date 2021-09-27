package example.AcervoObrasEAutores.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author Grupo 1 : Débora, Larissa, Maia, Roberta, Stefane, Viviane
 * @since Planejamento, Sprint 1 da apliacação
 * @version 1.4
 * 
 * Classe entidade @Entity utilizada para informar que uma classe também é uma entidade. 
 * A partir disso, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados, 
 * onde os dados de objetos desse tipo poderão ser persistidos.
 * 
 * O Serializable A classe pode converter os atributos para dados 
 * para que eles possam ser gravados em arquivos, trafegados em rede, etc.
 * Exige controle de versão serialVersionUID = 1L
 * 
 * */
@Entity 
public class Obras implements Serializable{ 

	private static final long serialVersionUID = 1L;
	
	/**Atributos basicos
	 * 
	 * Gerando chave primaria no BD de teste H2 com o @GeneratedValue
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String dataPubli; 
	
	/**
	 * Mapeando muitos para muitos entre as duas entidades
	 * Criando tabela auxiliar com os ids (chave primária) de obras de autores chamada AUTORES_OBRAS
	 * Elas se tornam chaves estrageiras
	 * Criando array para obras, com os ids deles, para serem mostrados na requisição*/
    @ManyToMany  
    @JoinTable(name = "AUTORES_OBRAS",
        joinColumns = @JoinColumn(name = "obras_id", referencedColumnName="id"),
        inverseJoinColumns = @JoinColumn(name = "autores_id", referencedColumnName="id")
    )
    private List<Autores> autores = new ArrayList<>();
	
    /**Construtor 
	 * 
	 * alt + shift + s para gerar o que precisamos
	 * Encapsulamos com gets e sets, evitando polimorfismo
	 * 
	 * hashCode e equals
	 * Organizam o código e garante mais rapidez 
	 * Reflexo, simetria, transitividade, consistência
	 * 
	 * toString()
	 * */
	public Obras() {}

	public Obras(String nome, String descricao, String dataPubli) {
		super();
		setNome(nome);
		setDescricao(descricao);
		setDataPubli(dataPubli);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataPubli() {
		return dataPubli;
	}

	public void setDataPubli(String dataPubli) {
		this.dataPubli = dataPubli;
	}
	
	public List<Autores> getAutores() {
		return autores;
	}

	public void setAutores(List<Autores> autores) {
		this.autores = autores;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Obras other = (Obras) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n" + "   Obra [" + "\n"
				+ "     id: " + id + "\n"
				+ "     nome: " + nome + "\n"
				+ "     descricao: " + descricao + "\n"
				+ "     dataPubli: " + dataPubli + "\n"
				+ "   ]" + "\n";
	}

}