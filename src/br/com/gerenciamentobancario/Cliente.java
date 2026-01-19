package br.com.gerenciamentobancario;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Cliente(String nome, String cpf, String telefone, String email) {
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
        setEmail(email);
    }

    // ========== GETTERS & SETTERS ==========

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarCampo(nome, "Nome");
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validarCampo(cpf, "CPF");
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        validarCampo(telefone, "Telefone");
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validarCampo(email, "Email");
        this.email = email;
    }

    //METODO DE VALIDAÇÃO PADRÃO
    private void validarCampo(String valor, String nomeCampo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(nomeCampo + " não pode ser nulo ou vazio.");
        }
    }

    // ========== TO STRING (SAÍDA CLARA E ORGANIZADA) ==========
    @Override
    public String toString() {
        return "=== Dados do Cliente ===\n" +
                "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Telefone: " + telefone + "\n" +
                "Email: " + email + "\n";
    }
}
