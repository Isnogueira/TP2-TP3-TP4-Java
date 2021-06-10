
package br.edu.infnet.tp2javasistemaescolar.domain;

import br.edu.infnet.tp2javasistemaescolar.auxiliar.Constante;
/**
 *
 * @author IngridNogueira
 */
public class Professor extends Pessoa{
    
   private String disciplina;
   private String posGraduacao;
   private float valorHora;
   private int horasTrabalhadas;
   private int diasTrababalhados;

    public Professor() {
        this.setOcupacao("Professor");
    }

    public Professor(String disciplina, String posGraduacao, float valorHora, int horasTrabalhadas, int diasTrababalhados) {
        this.disciplina = disciplina;
        this.posGraduacao = posGraduacao;
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
        this.diasTrababalhados = diasTrababalhados;
    }

    public Professor(String disciplina, String posGraduacao, float valorHora, int horasTrabalhadas, int diasTrababalhados, String string, int i) {
        super(string, i);
        this.disciplina = disciplina;
        this.posGraduacao = posGraduacao;
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
        this.diasTrababalhados = diasTrababalhados;
    }

    public Professor(String disciplina, String posGraduacao, float valorHora, int horasTrabalhadas, int diasTrababalhados, String string, String string1, int i, String string2) {
        super(string, string1, i, string2);
        this.disciplina = disciplina;
        this.posGraduacao = posGraduacao;
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
        this.diasTrababalhados = diasTrababalhados;
    }

        public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getPosGraduacao() {
        return posGraduacao;
    }

    public void setPosGraduacao(String posGraduacao) {
        this.posGraduacao = posGraduacao;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public int getDiasTrababalhados() {
        return diasTrababalhados;
    }

    public void setDiasTrababalhados(int diasTrababalhados) {
        this.diasTrababalhados = diasTrababalhados;
    }
   
    private String calcularPosGradução(){
        return "S".equalsIgnoreCase(this.getPosGraduacao()) ? "Sim" : "Não";
    }
    
    private float calcularSalario(){
        String temPos = calcularPosGradução();
        
        return "Sim".equals(temPos) ? 
                ((this.getValorHora() * this.getHorasTrabalhadas()) * this.getDiasTrababalhados()) + Constante.ACRESCIMO_POS : 
                (this.getValorHora() * this.getHorasTrabalhadas()) * this.getDiasTrababalhados();
    }
    
    @Override
    public String toString() {
        return String.format("\nDisciplina: %s\nFez pós graduação? %s\nSalário bruto mensal: R$%.2f", 
                this.getDisciplina(), 
                this.calcularPosGradução(),
                this.calcularSalario());
    }    
}
