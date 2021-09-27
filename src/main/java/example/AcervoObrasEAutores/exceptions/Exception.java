package example.AcervoObrasEAutores.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Exception {

	static final String AUTOR_INSERIDO = "Autor inserido com sucesso!";
	static final String AUTOR_EXCLUIDO = "Autor excluído com sucesso!";
	static final String AUTOR_ALTERADO = "Autor alterado com sucesso!";
	static final String AUTOR_NAO_CADASTRADO = "Autor com id %s não está cadastrado";
	static final String CARACTERES_NOME_AUTOR = "O nome do autor deve conter no máximo 120 caracteres";
	static final String NOME_AUTOR_OBRIGATORIO = "O nome do autor é obrigatório";
	static final String PAIS_AUTOR_OBRIGATORIO = "O pais de origem do autor é obrigatório";
	static final String CPF_BRASILEIRO_OBRIGATORIO = "O CPF de um autor Brasileiro é obrigatório";
	
	static final String OBRA_INSERIDA = "Obra inserida com sucesso!";
	static final String OBRA_EXCLUIDA = "Obra excluída com sucesso!";
	static final String OBRA_ALTERADO = "Obra alterada com sucesso!";
	static final String OBRA_NAO_CADASTRADA = "Obra com id %s não está cadastrada";
	static final String CARACTERES_NOME_OBRA = "O nome da obra deve conter no máximo 240 caracteres";
	static final String NOME_OBRA_OBRIGATORIO = "O nome da obra é obrigatório";
	static final String CARACTERES_DESCRICAO_OBRA = "A descrição da obra deve conter no máximo 240 caracteres";
	static final String DESCRICAO_OBRA_OBRIGATORIO = "A descrição da obra é obrigatória";
	
	
	public static ResponseEntity<?> erroAutorNaoEncontrado(long id) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(Exception.AUTOR_NAO_CADASTRADO, id)),
                HttpStatus.BAD_REQUEST);
    }

	public static ResponseEntity<?> erroNomeAutorInvalido() {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(Exception.CARACTERES_NOME_AUTOR),
                HttpStatus.CONFLICT);
	}

	public static ResponseEntity<?> erroNomeAutorObrigatorio() {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(Exception.NOME_AUTOR_OBRIGATORIO),
                HttpStatus.CONFLICT);
	}

	public static ResponseEntity<?> erroPaisAutorObrigatorio() {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(Exception.PAIS_AUTOR_OBRIGATORIO),
                HttpStatus.CONFLICT);
	}

	public static ResponseEntity<?> erroCpfBrasileiroObrigatorio() {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(Exception.CPF_BRASILEIRO_OBRIGATORIO),
                HttpStatus.CONFLICT);
	}
	
	public static ResponseEntity<?> mensagemAutorInserido() {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(Exception.AUTOR_INSERIDO),
                HttpStatus.OK);
	}

	public static ResponseEntity<?> mensagemAutorExcluido() {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(Exception.AUTOR_EXCLUIDO),
                HttpStatus.OK);
	}

	public static ResponseEntity<?> mensagemAutorAlterado() {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(Exception.AUTOR_ALTERADO),
                HttpStatus.OK);
	}

	public static ResponseEntity<?> erroObraNaoEncontrada(Long id) {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(Exception.OBRA_NAO_CADASTRADA, id)),
                HttpStatus.BAD_REQUEST);
	}

	public static ResponseEntity<?> erroNomeObraInvalida() {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(Exception.CARACTERES_NOME_OBRA),
                HttpStatus.CONFLICT);
	}

	public static ResponseEntity<?> erroNomeObraObrigatoria() {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(Exception.NOME_OBRA_OBRIGATORIO),
                HttpStatus.CONFLICT);
	}

	public static ResponseEntity<?> erroDescricaoObraInvalida() {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(Exception.CARACTERES_DESCRICAO_OBRA),
                HttpStatus.CONFLICT);
	}

	public static ResponseEntity<?> erroDescricaoObraObrigatoria() {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(Exception.DESCRICAO_OBRA_OBRIGATORIO),
                HttpStatus.CONFLICT);
	}

	public static ResponseEntity<?> mensagemObraInserida() {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(Exception.OBRA_INSERIDA),
                HttpStatus.OK);
	}

	public static ResponseEntity<?> mensagemObraExcluida() {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(Exception.OBRA_EXCLUIDA),
                HttpStatus.OK);
	}

	public static ResponseEntity<?> mensagemObraAlterada() {
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(Exception.OBRA_ALTERADO),
                HttpStatus.OK);
	}

}
