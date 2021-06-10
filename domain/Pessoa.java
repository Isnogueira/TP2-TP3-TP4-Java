
package br.edu.infnet.tp2javasistemaescolar.domain;

/**
 *
 * @author IngridNogueira
 */
public abstract class Pessoa {
    
    private String nome;
    private int idade;
    private String email;
    private String ocupacao;

    public Pessoa() {
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa(String email, String nome, int idade, String ocupacao) {
        this(nome, idade);
        this.email = email;
        this.ocupacao = ocupacao;
    }
    
    public String getNome() {
        
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }
    
    public void imprimir(){
        System.out.println("Nome: " + this.getNome()
                + "\nIdade: " + this.getIdade()
                + "\nEmail: " + this.getEmail()
                + "\nOcupação: " + this.getOcupacao()
                
                + this.toString());
    }
}
