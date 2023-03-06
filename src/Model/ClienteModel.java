package Model;

public class ClienteModel {
    private String nome,cpf, senha , email, telefone, endereco;
    private ContaModel conta;



    public ClienteModel(String nome, String cpf, String email, String telefone, String endereco) {
        setNome(nome);
        setCpf(cpf);
        setEmail(email);
        setTelefone(telefone);
        setendereco(endereco);
    }

    public ClienteModel(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getendereco() {
        return endereco;
    }

    public void setendereco(String endereco) {
        this.endereco = endereco;
    }

    public ContaModel getconta() {
        return conta;
    }

    public void setconta(ContaModel conta) {
        this.conta = conta;
    }
}
