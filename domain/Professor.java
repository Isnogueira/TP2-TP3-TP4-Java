
package br.edu.infnet.tp2javasistemaescolar.domain;

import br.edu.infnet.tp2javasistemaescolar.auxiliar.Constante;
import br.edu.infnet.tp2javasistemaescolar.exceptions.NegativeNumberException;
import br.edu.infnet.tp2javasistemaescolar.exceptions.InvalidOptionException;
/**
 *
 * @author IngridNogueira
 */
public class Professor extends Pessoa{
    
   private String disciplina;
   private String posGraduacao;
   private float valorHora;
   private int horasTrabalhadas;
   private int diasTrabalhados;

    public Professor() {
        this.setOcupacao("Professor");
    }

    public Professor(String disciplina, String posGraduacao, float valorHora, int horasTrabalhadas, int diasTrabalhados) {
        this.disciplina = disciplina;
        this.posGraduacao = posGraduacao;
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
        this.diasTrabalhados = diasTrabalhados;
    }

    public Professor(String disciplina, String posGraduacao, float valorHora, int horasTrabalhadas, int diasTrabalhados, String nome, String sobrenome, String ultimoNome, int idade, String email, String ocupacao) {
        super(nome, sobrenome, ultimoNome, idade, email, ocupacao);
        this.disciplina = disciplina;
        this.posGraduacao = posGraduacao;
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
        this.diasTrabalhados = diasTrabalhados;
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

    public void setPosGraduacao(String posGraduacao){
       
        this.posGraduacao = posGraduacao;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) throws NegativeNumberException {
        if (valorHora < 0){
            throw new NegativeNumberException("Valor Negativo");
        } 
        this.valorHora = valorHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) throws NegativeNumberException {
        if (horasTrabalhadas < 0){
            throw new NegativeNumberException("Valor Negativo");
        } 
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public int getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(int diasTrababalhados) throws NegativeNumberException {
        if (diasTrababalhados < 0){
            throw new NegativeNumberException("Valor Negativo");
        } 
        this.diasTrabalhados = diasTrababalhados;
    }
   
    public String calcularPosGradução(){
        return "S".equalsIgnoreCase(this.getPosGraduacao()) ? "Sim" : "Não";
    }
    
    public float calcularSalario(){
        String temPos = calcularPosGradução();
        
        return "Sim".equals(temPos) ? 
                ((this.getValorHora() * this.getHorasTrabalhadas()) * this.getDiasTrabalhados()) + Constante.ACRESCIMO_POS : 
                (this.getValorHora() * this.getHorasTrabalhadas()) * this.getDiasTrabalhados();
    }
    
    @Override
    public String toString() {
        return String.format("Disciplina: %s\nFez pós graduação? %s\nSalário bruto mensal: R$%.2f", 
                this.getDisciplina(), 
                this.calcularPosGradução(),
                this.calcularSalario());
    }    
}
