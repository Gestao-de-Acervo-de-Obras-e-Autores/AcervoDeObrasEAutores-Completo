package example.AcervoObrasEAutores.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Autores implements Serializable{ 

	private static final long serialVersionUID = 1L;
	
	/**Atributos basicos
	 * 
	 * Gerando chave primaria no BD de teste H2 com o @GeneratedValue
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String nome;
	private String paisOrigem;
	private String cpf; 
	private String dataNasc; 
	
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
	public Autores() {}

	public Autores(String nome, String paisOrigem, String cpf, String dataNasc) {
		super();
		setNome(nome);
		setPaisOrigem(paisOrigem);
		setCpf(cpf);
		setDataNasc(dataNasc);
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

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
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
		Autores other = (Autores) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n" + "   Autor [" + "\n"
				+ "     id: " + id + "\n"
				+ "     nome: " + nome + "\n"
				+ "     paisOrigem: " + paisOrigem + "\n"
				+ "     cpf: " + cpf + "\n"
				+ "     dataNasc: " + dataNasc + "\n"
				+ "   ]" + "\n";
	}

}
