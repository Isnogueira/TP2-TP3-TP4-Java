
package br.edu.infnet.tp2javasistemaescolar;

import java.util.Scanner;
import br.edu.infnet.tp2javasistemaescolar.domain.*;
import br.edu.infnet.tp2javasistemaescolar.auxiliar.Constante;
import br.edu.infnet.tp2javasistemaescolar.exceptions.NegativeNumberException;
import br.edu.infnet.tp2javasistemaescolar.exceptions.FullStorageException;

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
    
    public static void main(String[] args) {
            
                pessoas = new Pessoa[Constante.QTD];

                String opcao = null;
                boolean terminou = false;

                do {

                    System.out.println("==================");
                    System.out.println("Sistema Acadêmico");
                    System.out.println("==================");
                    System.out.println("[1] Registrar Aluno");
                    System.out.println("[2] Registrar Professor");
                    System.out.println("[3] Listar todos os cadastrados");
                    System.out.println("[4] Consultar situação de um docente/discente");
                    System.out.println("[5] Sair");

                    System.out.println("Informe a opçao desejada: ");                        
                    
                    opcao = ler().next();
                    
                    switch (opcao) { 

                        case "1" :  {    

                                try {
                                    try{
                                        Aluno aluno = new Aluno();
                                        System.out.println("Informe o nome completo do aluno: ");
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


                                        System.out.println("Aluno cadastrado com sucesso!");
                                        index++;
                                        if (index >= Constante.QTD){
                                            throw new FullStorageException("Armazenamento cheio!"); 
                                        }
                                    } catch (NegativeNumberException | FullStorageException e) {
                                        System.out.println(e.getMessage());
                                       
                                    }
                                }finally{
                                    System.out.println("Processo finalizado!");
                                }
                       
                    }
                      break;

                        case "2" : {
                            try {
                                try {
                                        Professor professor = new Professor();
                                        System.out.println("Informe o nome completo do professor: ");
                                        professor.setNome(ler().nextLine().trim());
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
                                        professor.setDiasTrabalhados(ler().nextInt());

                                        pessoas[index] = professor;

                                        System.out.println("Professor cadastrado com sucesso!");

                                        index++;
                                        if (index >= Constante.QTD){
                                            throw new FullStorageException("Armazenamento cheio!"); 
                                        }

                                    } catch (NegativeNumberException | FullStorageException e) {
                                        System.out.println(e.getMessage());
                                    }
                            } finally {
                            }
    
                          
                                
                                
                            
                        }
                        break;

                        case "3" : {

                            imprimirCadastrados();
                        }
                        break;

                        case "4" : {

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

                        case "5" : {
                            terminou = true;
                        }
                        break;

                        default : System.out.println("Opção inválida!");
                       }
                        
                } while (!opcao.equals("5") && terminou == false);
                                                
                ler().close();
    }
    
    public static void imprimirCadastrados(){
        System.out.println("Listagem de inscritos");
        System.out.println("=====================");
        for (int i = 0; i < index; i++) {
           
            System.out.println(i+"-"+pessoas[i].getNome());
            
        }
            
    }
    
}
