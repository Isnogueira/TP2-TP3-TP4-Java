
package br.edu.infnet.tp2javasistemaescolar.domain;


/**
 *
 * @author IngridNogueira
 */
public abstract class Pessoa {
    
    private String nome;
    private String sobrenome;
    private String ultimoNome;
    private int idade;
    private String email;
    private String ocupacao;

    public Pessoa() {
    }

    public Pessoa(String nome, String sobrenome, String ultimoNome, int idade, String email, String ocupacao) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.ultimoNome = ultimoNome;
        this.idade = idade;
        this.email = email;
        this.ocupacao = ocupacao;
    }
    
    public StringBuilder getNome() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.nome);
        sb.append(this.sobrenome);
        sb.append(this.ultimoNome);
        
        return sb;
    }

    public void setNome(String nome){
    
         
        int posFinal = nome.lastIndexOf(" ");
        
        int posInicial = nome.indexOf(" ");
        
        this.nome = nome.substring(0, posInicial);
        this.sobrenome = nome.substring(posInicial, posFinal);
        this.ultimoNome = nome.substring(posFinal);
               
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
                
                + "\n" + this.toString());
    }
}
