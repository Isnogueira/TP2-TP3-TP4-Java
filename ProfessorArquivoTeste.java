
package br.edu.infnet.tp2javasistemaescolar;

import br.edu.infnet.tp2javasistemaescolar.domain.Professor;
import br.edu.infnet.tp2javasistemaescolar.exceptions.NegativeNumberException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author IngridNogueira
 */
public class ProfessorArquivoTeste {
   
    private static Professor[] professores;
    
    private static void imprimirSalariosAcimaMedia(float media){
        
        for (Professor prof : professores) {
            
            if(prof != null){
                
                float salarioCalculado = prof.calcularSalario();
                
                if (salarioCalculado < media) {
                    
                    System.out.println("-" + prof.getNome() + " | R$" + salarioCalculado);
                }
            }
        }
    }
    
    private static void imprimirSalariosAbaixoMedia(float media){
        
        for (Professor prof : professores) {
            
            if(prof != null){
                
                float salarioCalculado = prof.calcularSalario();
                
                if (salarioCalculado < media) {
                    
                    System.out.println("-" + prof.getNome() + " | R$" + salarioCalculado);
                }
            }
        }
    }
    
    private static void imprimirProfessoresSemPos(float media){
        
        for (Professor prof : professores) {
            
            if (prof != null){
                
                String posGraduacao = prof.calcularPosGradução();
                float salarioCalculado = prof.calcularSalario();
                
                if("Não".equals(posGraduacao) && salarioCalculado < media){
                   
                    System.out.println("-" + prof.getNome() + " | R$" + salarioCalculado);
                    
                }
                
            }
        }
    }
        
    public static void main(String[] args) {

        String dirP = "C:/Users/Ingrid Nogueira/Desktop/";
        String arqP = "professores.txt";
        
        professores = new Professor[999];

        try {
            try {
                FileReader file = new FileReader(dirP+arqP);
                BufferedReader leitura = new BufferedReader(file);
                String linha = leitura.readLine();

                int qtde = 0;
                float somaSalarial = 0;

                while (linha != null) {    

                    String[] campos = linha.split(";");

                    Professor professor = new Professor();
                    professor.setNome(campos[0]);
                    professor.setIdade(Integer.valueOf(campos[1]));
                    professor.setEmail(campos[2]);
                    professor.setOcupacao(campos[3]);
                    professor.setDisciplina(campos[4]);
                    professor.setPosGraduacao(campos[5]);
                    professor.setValorHora(Float.valueOf(campos[6]));
                    professor.setHorasTrabalhadas(Integer.valueOf(campos[7]));
                    professor.setDiasTrabalhados(Integer.valueOf(campos[8]));

                    professor.imprimir();
                    System.out.println("=====================================");

                    // ler a próxima linha
                    linha = leitura.readLine();
                    
                    professores[qtde] = professor;
                    qtde++;
                    somaSalarial += professor.calcularSalario();
                }

                file.close();
                leitura.close();

                float mediaSalarial = somaSalarial / qtde;
                
                System.out.printf("Quantidade: %d\nSoma salarial: R$%.2f \nMédia salarial: R$%.2f \n\n",
                        qtde,
                        somaSalarial,
                        mediaSalarial
                        );

                System.out.println("Professores com salarios acima da média: ");
                imprimirSalariosAcimaMedia(mediaSalarial);

                System.out.println("-----------------------------------------");
                
                System.out.println("Professores com salarios abaixo da media:");
                imprimirSalariosAbaixoMedia(mediaSalarial);
                
                 System.out.println("----------------------------------------------------");
                
                System.out.println("Professores que não fizerem pós graduação e com salário abaixo da média:");
                imprimirProfessoresSemPos(mediaSalarial);
                
            } catch (IOException | NegativeNumberException ex) {
                System.out.println(ex.getMessage());
            }
        } finally {
            System.out.println("Processamento finalizado!");
    }
}
}
