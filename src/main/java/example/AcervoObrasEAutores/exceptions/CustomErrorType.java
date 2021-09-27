package example.AcervoObrasEAutores.exceptions;

public class CustomErrorType {

    private String Mensagem;

    public CustomErrorType(String Mensagem){
        this.Mensagem = Mensagem;
    }

    public String getMensagem() {
        return Mensagem;
    }

}
