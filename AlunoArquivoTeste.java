
package br.edu.infnet.tp2javasistemaescolar;

import br.edu.infnet.tp2javasistemaescolar.domain.Aluno;
import br.edu.infnet.tp2javasistemaescolar.exceptions.NegativeNumberException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author IngridNogueira
 */
public class AlunoArquivoTeste {
    
    private static Aluno[] alunos;
    
    private static void imprimirMensalidadeMaiorQueMil(){
        
        for (Aluno aln : alunos) {
            
            if (aln != null){
                
               float mensalidade = aln.getMensalidade();
               
               if (mensalidade > 1000){
                   
                   System.out.println("-" + aln.getNome() + " | R$" + mensalidade);
               }
            }
        }
    }
    private static void imprimirMensalidadeMenorQueMil(){
        
        for (Aluno aln : alunos) {
            
            if (aln != null){
                
               float mensalidade = aln.getMensalidade();
               
               if (mensalidade < 1000){
                   
                   System.out.println("-" + aln.getNome() + " | R$" + mensalidade);
               }
            }
        }
    }
    
    private static void imprimirMesesMaiorQuetres(){
        
           for (Aluno aln : alunos) {
            
               if(aln != null){
                   
                   int meses = aln.getMesesInadimplencia();
                   
                   if (meses > 3){
                       
                       System.out.println("-" + aln.getNome() + " | " + meses + " meses");
                   }
               }
        }
    }
    private static void imprimirMesesMenorQuetres(){
        
           for (Aluno aln : alunos) {
            
               if(aln != null){
                   
                   int meses = aln.getMesesInadimplencia();
                   
                   if (meses < 3){
                       
                       System.out.println("-" + aln.getNome() + " | " + meses + " meses");
                   }
               }
        }
    }
    
    public static void main(String[] args) {

        String dirA = "C:/Users/Ingrid Nogueira/Desktop/";
        String arqA = "alunos.txt";

        alunos = new Aluno[999];
        
        try {
            try {
                FileReader file = new FileReader(dirA+arqA);
                BufferedReader leitura = new BufferedReader(file);
                String linhaAlunos = leitura.readLine();

                int qtde = 0;
                float somaInadimplencia = 0;
                
                while (linhaAlunos != null) {    

                    String[] camposAlunos = linhaAlunos.split(";");
                    Aluno aluno = new Aluno();
                    aluno.setNome(camposAlunos[0]);
                    aluno.setIdade(Integer.valueOf(camposAlunos[1]));
                    aluno.setEmail(camposAlunos[2]);
                    aluno.setOcupacao(camposAlunos[3]);
                    aluno.setCurso(camposAlunos[4]);
                    aluno.setPeriodo(Integer.valueOf(camposAlunos[5]));
                    aluno.setMensalidade(Float.valueOf(camposAlunos[6]));
                    aluno.setMesesInadimplencia(Integer.valueOf(camposAlunos[7]));
                    
                    aluno.imprimir();
                    System.out.println("=====================================");

                    // ler a próxima linha
                    linhaAlunos = leitura.readLine();
                    
                    alunos[qtde] = aluno;
                    qtde++;
                    somaInadimplencia += aluno.calcularInadimplencia();
                    
                }

                file.close();
                leitura.close();
                
                System.out.printf("\nQuantidade: %d\nTotal de dívidas: R$%.2f\n",
                        qtde,
                        somaInadimplencia);
                
                System.out.println("\nAlunos que pagam mais de 1000 reais:");
                imprimirMensalidadeMaiorQueMil();
               
                System.out.println("-----------------------------------------");
                
                System.out.println("Alunos que pagam menos de 1000 reais:");
                imprimirMensalidadeMenorQueMil();
                
                System.out.println("-----------------------------------------");
                
                System.out.println("Alunos com mais de 3 meses de inadimplencia:");
                imprimirMesesMaiorQuetres();

                System.out.println("-----------------------------------------");
                
                System.out.println("Alunos com menos de 3 meses de inadimplencia:");
                imprimirMesesMenorQuetres();
                
            } catch (IOException | NegativeNumberException ex) {
                System.out.println(ex.getMessage());
            }
        } finally {
            System.out.println("Processamento finalizado!");
    }
}
}
