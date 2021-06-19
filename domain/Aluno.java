
package br.edu.infnet.tp2javasistemaescolar.domain;

import br.edu.infnet.tp2javasistemaescolar.auxiliar.Constante;
import br.edu.infnet.tp2javasistemaescolar.exceptions.NegativeNumberException;
/**
 *
 * @author IngridNogueira
 */
public class Aluno extends Pessoa{
    
    private String curso;
    private int periodo;
    private float mensalidade;
    private int mesesInadimplencia;
    
    public Aluno(){
        this.setOcupacao("Aluno");
    }

    public Aluno(String curso, int periodo, float mensalidade, int mesesInadimplencia) {
        this.curso = curso;
        this.periodo = periodo;
        this.mensalidade = mensalidade;
        this.mesesInadimplencia = mesesInadimplencia;
    }

    public Aluno(String curso, int periodo, String situacao, float mensalidade, int mesesInadimplencia, String nome, String sobrenome, String ultimoNome, int idade, String email, String ocupacao) {
        super(nome, sobrenome, ultimoNome, idade, email, ocupacao);
        this.curso = curso;
        this.periodo = periodo;
        this.mensalidade = mensalidade;
        this.mesesInadimplencia = mesesInadimplencia;
    }

    
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    } 

     public float getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(float mensalidade) throws NegativeNumberException {
        if (mensalidade < 0){
            throw new NegativeNumberException("Valor negativo");
        }
        this.mensalidade = mensalidade;
    }

    public int getMesesInadimplencia () {
        return mesesInadimplencia;
    }

    public void setMesesInadimplencia(int mesesInadimplencia) throws NegativeNumberException {
        if (mesesInadimplencia < 0){
            throw new NegativeNumberException("Valor negativo");
        }
        this.mesesInadimplencia = mesesInadimplencia;
    }
    
    public float calcularInadimplencia(){
        return (this.getMensalidade() * this.getMesesInadimplencia()) + (Constante.PORC_MULTA * getMesesInadimplencia());
    }
    
    @Override
    public String toString() {
        return String.format("Curso: %s\nPeríodo: %s\nMeses de inandimplência: %d\nTotal da dívida: R$%.2f",
                this.getCurso(),                     
                this.getPeriodo(),
                this.getMesesInadimplencia(),
                this.calcularInadimplencia()); 
    }
    
    
}
