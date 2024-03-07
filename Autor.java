public class Autor {
    private String nome;
    private String cpf;
    private String anoNasc;

    public Autor (String nome, String anoNasc, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.anoNasc = anoNasc;


        //===
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getAnoNasc() {
        return anoNasc;
    }
    //===
}