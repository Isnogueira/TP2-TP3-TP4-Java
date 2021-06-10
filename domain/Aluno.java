
package br.edu.infnet.tp2javasistemaescolar.domain;

import br.edu.infnet.tp2javasistemaescolar.auxiliar.Constante;
/**
 *
 * @author IngridNogueira
 */
public class Aluno extends Pessoa{
    
    private String curso;
    private int periodo;
    private String situacao;
    private float mensalidade;
    private int mesesInadimplencia;
    
    public Aluno(){
        this.setOcupacao("Aluno");
    }

    public Aluno(String curso, int periodo, String situacao, float mensalidade, int mesesInadimplencia) {
        this.curso = curso;
        this.periodo = periodo;
        this.situacao = situacao;
        this.mensalidade = mensalidade;
        this.mesesInadimplencia = mesesInadimplencia;
    }

    public Aluno(String curso, int periodo, String situacao, float mensalidade, int mesesInadimplencia, String string, int i) {
        super(string, i);
        this.curso = curso;
        this.periodo = periodo;
        this.situacao = situacao;
        this.mensalidade = mensalidade;
        this.mesesInadimplencia = mesesInadimplencia;
    }

    public Aluno(String curso, int periodo, String situacao, float mensalidade, int mesesInadimplencia, String string, String string1, int i, String string2) {
        super(string, string1, i, string2);
        this.curso = curso;
        this.periodo = periodo;
        this.situacao = situacao;
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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
     public float getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
    }

    public int getMesesInadimplencia() {
        return mesesInadimplencia;
    }

    public void setMesesInadimplencia(int mesesInadimplencia) {
        this.mesesInadimplencia = mesesInadimplencia;
    }
    
    private String calcularSituacao() {
        return mesesInadimplencia > 0 ? "Irregular" : "Regular";                       
    }
    
    private float calcularInadimplencia(){
        String situacao = calcularSituacao();
        return "Regular".equals(situacao)? 0 : (this.getMensalidade() * this.getMesesInadimplencia()) + (Constante.PORC_MULTA * getMesesInadimplencia());
    }
    
    @Override
    public String toString() {
        return String.format("Curso: %s\nPeríodo: %d\nSituação: %s\nMeses de inandimplência: %d\nTotal da dívida: R$%.2f",
                this.getCurso(),                     
                this.getPeriodo(),
                this.calcularSituacao(),
                this.getMesesInadimplencia(),
                this.calcularInadimplencia()); 
    }
    
    
}
