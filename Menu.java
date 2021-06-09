
package br.edu.infnet.tp2javasistemaescolar;

import java.util.Scanner;
import sistemaEscolar.domain.*;
import sistemaEscolar.auxiliar.Constante;
/**
 *
 * @author IngridNogueira
 */
public class Menu {
    
    private static int index;
    private static Pessoa[] pessoas; 
    
    private static Scanner ler(){
        Scanner in = new Scanner(System.in);
        return in;
    }
    
    public static void main(String[] args){
        
        pessoas = new Pessoa[Constante.QTD];
        
        String opcao = null;
        
        do {
            System.out.println("==================");
            System.out.println("Sistema Acadêmico");
            System.out.println("==================");
            System.out.println("[1] Registrar Aluno");
            System.out.println("[2] Registrar Professor");
            System.out.println("[3] Consultar situação de um docente/discente");
            System.out.println("[4] Consultar Todos cadastrados");
            System.out.println("[5] Sair");

            System.out.println("Informe a opçao desejada: ");
            opcao = ler().next();

                switch (opcao) {
                    
                    case "1" : {
                        
                        if (index < Constante.QTD){ 
                            
                            Aluno aluno = new Aluno();  
                            System.out.println("Informe o nome do aluno: ");
                            aluno.setNome(ler().nextLine());
                            System.out.println("Informe a idade: ");
                            aluno.setIdade(ler().nextInt());
                            System.out.println("Informe o email do aluno: ");
                            aluno.setEmail(ler().nextLine());
                            System.out.println("Informe o curso: ");
                            aluno.setCurso(ler().nextLine());
                            System.out.println("Informe o período em que o aluno está: ");
                            aluno.setPeriodo(ler().nextInt());
                            System.out.println("Informe o valor da mensalidade do aluno: R$");
                            aluno.setMensalidade(ler().nextFloat());
                            System.out.println("Informe os meses de Inadimplência: ");
                            aluno.setMesesInadimplencia(ler().nextInt());
                            
                            pessoas[index] = aluno;
                            
                            System.out.println("=====================================");
                            pessoas[index].imprimir();
                            System.out.println("=====================================");
                            
                            System.out.println("Aluno cadastrado com sucesso!");
                            
                            index++;
                            
                        } else{
                            System.out.println("Amazenamento cheio.");
                        }
                    }
                    
                    break;
                    
                    case "2" : {
                        
                        if (index < Constante.QTD){ 
                            
                            Professor professor = new Professor();
                            System.out.println("Informe o nome do professor: ");
                            professor.setNome(ler().nextLine());
                            System.out.println("Informe a idade: ");
                            professor.setIdade(ler().nextInt());
                            System.out.println("Informe o email do professor: ");
                            professor.setEmail(ler().nextLine());
                            System.out.println("Informe a disciplina lecionada: ");
                            professor.setDisciplina(ler().nextLine());
                            System.out.println("Fez pós graduação? [S][N]");
                            professor.setPosGraduacao(ler().next());
                            System.out.println("Informe o valor por hora trabalhada: R$");
                            professor.setValorHora(ler().nextFloat());
                            System.out.println("Informe a quantidade de horas trabalhadas por dia: ");
                            professor.setHorasTrabalhadas(ler().nextInt());
                            System.out.println("Informe a quantidade de dias trabalhados no mes: ");
                            professor.setDiasTrababalhados(ler().nextInt());
                                                      
                            
                            pessoas[index] = professor;
                            
                            System.out.println("=====================================");
                            pessoas[index].imprimir();
                            System.out.println("=====================================");
                            
                            System.out.println("Professor cadastrado com sucesso!");
                            
                            index++;
                            
                        } else{
                            System.out.println("Amazenamento cheio.");
                        }
                    }
                    
                    break;
                    
                    case "3" : {
                        
                        System.out.println("Informe a posição do aluno/professor:");
                        int idx = ler().nextInt();
                        
                        if (idx >= 0 && idx < index){
                            
                            pessoas[idx].imprimir();                     
                        }
                        else{
                            System.out.println("Posição inválida");
                        }
                    }
                    break;
                    
                     case "4" : {
                       
                        imprimirCadastrados();
                    }
                    break;
                    
                    case "5" : {
                    }
                    break;
                    
                    default : System.out.println("Opção inválida!");
                   }
                
            } while (!opcao.equals("5"));
         
        ler().close();
    }
    
    public static void imprimirCadastrados(){
        System.out.println("Listagem de inscritos");
        System.out.println("=====================");
        for (int i = 0; i < index; i++) {
            
            pessoas[i].imprimir();
            System.out.println("============================");
        }
    }
}
