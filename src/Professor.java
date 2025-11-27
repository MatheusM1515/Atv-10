import java.util.Date;

public class Professor {
    private int id;
    private String nome;
    private String email;
    private java.sql.Date data_nascimento;
    private String cpf;
    private String cidade;
    private String estado_civil;
    private String data_cadastro;
    private String data_atualizacao;
    private String data_remocao;

    public Professor(String nome, String email,java.sql.Date  data_nascimento, String cpf,String cidade, String estado_civil){
        this.nome = nome;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.cidade=cidade;
        this.estado_civil = estado_civil;
    }

    public Professor(int id, String nome, String email,java.sql.Date  data_nascimento, String cpf,String cidade, String estado_civil) {
        this.id=id;
        this.nome = nome;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.cidade=cidade;
        this.estado_civil = estado_civil;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.sql.Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(java.sql.Date  data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade){
        this.cidade=cidade;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }


}
