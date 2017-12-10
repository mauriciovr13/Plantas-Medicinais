/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoplp;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static trabalhoplp.TrabalhoPLP.lerLocal;

/**
 *
 * @author Rodrigo, Mauricio e Matheus Bento
 */
public class TrabalhoPLP {    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        desenho();
        
        Scanner ler = new Scanner(System.in);
        Scanner lerString = new Scanner(System.in);
   
        CadastroPlanta cadastro;
        cadastro = new CadastroPlanta();
        
        int opcao;
        String aux;
        String nome;
        
        System.out.println("Trabalho de Paradigmas de Linguagens de Programação");
        System.out.println("     Sistema de Cadastro de Plantas Medicinais");
        
        menu();        
        opcao = ler.nextInt();
        
        while (opcao != 0) {
            switch(opcao) {
                case 1: 
                    //carregar os dados de um arquivo
                    System.out.print("Digite o nome do arquivo que contem os dados: ");
                    aux = ler.next();
                    cadastro.lerArquivo(aux);
                    break;
                case 2:
                    System.out.println();
                    System.out.println("+-Qual o subtipo de planta que deseja cadastrar?-+");
                    System.out.println("|1. Curativa                                     |");
                    System.out.println("|2. Preventiva                                   |");
                    System.out.println("+------------------------------------------------+");
                    opcao = ler.nextInt();
                    System.out.println();
                    
                    if (opcao == 1) {
                        PlantaCurativa planta = lerPlantaCurativa(ler, lerString);
                        System.out.printf("\n" + planta.toString());
                        System.out.println();
                        escolha();
                        opcao = ler.nextInt();
                        System.out.println();
                        
                        if (opcao == 1) {
                            cadastro.insere(planta);
                            System.out.println("Planta cadastrada com sucesso.");
                        }
                    }
                    else if (opcao == 2) {
                        PlantaPreventiva planta = lerPlantaPreventiva(ler, lerString);
                        System.out.printf("\n" + planta.toString());
                        System.out.println();
                        escolha();
                        opcao = ler.nextInt();
                        System.out.println();
                        
                        if (opcao == 1) {
                            cadastro.insere(planta);
                            System.out.println("Planta cadastrada com sucesso.");
                        }
                    }
                    else {
                        System.out.println("Opcao incorreta!");
                    }
                    
                    break;
                    
                case 3:
                    System.out.println();
                    cadastro.imprime();
                    break;
                    
                case 4:
                    System.out.print("Digite o nome da planta para a remoção: ");
                    nome = lerString.nextLine();
                    
                    if (cadastro.remove(nome)) {
                        System.out.println("Planta removida com sucesso!");
                    }
                    else {
                        System.out.println("Planta não encontrada :(");
                    }
                    System.out.println();
                    break;
            }
            menu();
            opcao = ler.nextInt();
        }
        
    
        if (!cadastro.vazio()) {
            System.out.print("Digite o nome de um arquivo em que sera salvo os dados: ");
            aux = ler.next();
            //abrindo arquivo
            File arquivo = new File(aux);

            if (arquivo.exists()) {
            System.out.println("Arquivo existe");
            }
            else {
            System.out.println("Arquivo nao existe, criaremos um novo para armezer os dados :(");
            arquivo.createNewFile();
            }
            
            cadastro.escreverArquivo(aux);
            
        }
    }
    
    public static Local lerLocal(Scanner ler, Scanner lerString) {
        String nomePais;
        String tipoClima;
        double temperaturaMedia;
        System.out.print("Nome pais origem: ");
        nomePais = lerString.nextLine();
        System.out.print("Tipo de clima do local: ");
        tipoClima = lerString.nextLine();
        System.out.print("Temperatura media: ");
        temperaturaMedia = ler.nextDouble();
        
        Local local = new Local(nomePais, tipoClima, temperaturaMedia);
        return local;
    }
    
    public static void escolha() {
        System.out.println("+-Deseja realmente inserir essa planta?-+");
        System.out.println("|1. Sim                                 |");
        System.out.println("|2. Nao                                 |");
        System.out.println("+---------------------------------------+");
    }
    
    public static PlantaCurativa lerPlantaCurativa(Scanner ler, Scanner lerString) {
        String nomePopular;
        String nomeCientifico;
        float preco;
        String classificacao;
        String utilizacao;
        String propriedadesCurativas;
        
        System.out.print("Nome Popular: ");
        nomePopular = lerString.nextLine();
        System.out.print("Nome Cientifico: ");
        nomeCientifico = lerString.nextLine();
        System.out.print("Preço: ");
        preco = ler.nextFloat();
        System.out.print("Classificaçao: ");
        classificacao = lerString.nextLine();
        System.out.print("Utilizaçao: ");
        utilizacao = lerString.nextLine();
        System.out.print("Propriedades Curativas: ");
        propriedadesCurativas = lerString.nextLine();
        Local localizacao = lerLocal(ler, lerString);
        
        PlantaCurativa planta = new PlantaCurativa(nomePopular, nomeCientifico, preco, classificacao, utilizacao, 
                                                   propriedadesCurativas, localizacao);
        
        return planta;
    }
    
    public static PlantaPreventiva lerPlantaPreventiva(Scanner ler, Scanner lerString) {
        String nomePopular;
        String nomeCientifico;
        float preco;
        String classificacao;
        String utilizacao;
        String indicacao;
        
        System.out.print("Nome Popular: ");
        nomePopular = lerString.nextLine();
        System.out.print("Nome Cientifico: ");
        nomeCientifico = lerString.nextLine();
        System.out.print("Preço: ");
        preco = ler.nextFloat();
        System.out.print("Classificaçao: ");
        classificacao = lerString.nextLine();
        System.out.print("Utilizaçao: ");
        utilizacao = lerString.nextLine();
        System.out.print("Indicacao: ");
        indicacao = lerString.nextLine();
        Local localizacao = lerLocal(ler, lerString);
        
        PlantaPreventiva planta = new PlantaPreventiva(nomePopular, nomeCientifico, preco, classificacao, 
                                                       utilizacao, indicacao, localizacao);
        
        System.out.println();
        return planta;
    }
    
    public static void menu() {
        System.out.println("---------------------------------------------------");
        System.out.println("| 1. Carregar os dados de um arquivo texto        |");
        System.out.println("| 2. Cadastrar planta                             |");
        System.out.println("| 3. Listar plantas                               |");
        System.out.println("| 4. Excluir planta                               |");
        System.out.println("| 0. Finalizar o programa                         |");
        System.out.println("---------------------------------------------------");
        System.out.print("Digite a opcao desejada: ");
    }
    
    public static void desenho() {
    System.out.println("                ##### ##  ###");
    System.out.println("             ######  /###  ###");                                                                                   
    System.out.println("            /#   /  /  ###  ##                              #");
    System.out.println("           /    /  /    ### ##                             ##");                                                    
    System.out.println("               /  /      ## ##                             ##");                                                    
    System.out.println("              ## ##      ## ##      /###   ###  /###     ######## /###      /###");                                 
    System.out.println("              ## ##      ## ##     / ###  / ###/ #### / ######## / ###  /  / #### /");                              
    System.out.println("            /### ##      /  ##    /   ###/   ##   ###/     ##   /   ###/  ##  ###/");                               
    System.out.println("           / ### ##     /   ##   ##    ##    ##    ##      ##  ##    ##  ####");                                    
    System.out.println("              ## ######/    ##   ##    ##    ##    ##      ##  ##    ##    ###");                                   
    System.out.println("              ## ######     ##   ##    ##    ##    ##      ##  ##    ##      ###");                                 
    System.out.println("              ## ##         ##   ##    ##    ##    ##      ##  ##    ##        ###");                               
    System.out.println("              ## ##         ##   ##    /#    ##    ##      ##  ##    /#   /###  ##");                               
    System.out.println("              ## ##         ### / ####/ ##   ###   ###     ##   ####/ ## / #### /");                                
    System.out.println("         ##   ## ##          ##/   ###   ##   ###   ###     ##   ###   ##   ###/");                                 
    System.out.println("        ###   #  /");                                                                                               
    System.out.println("         ###    /");                                                                                                
    System.out.println("          #####/");                                                                                                 
    System.out.println("            ###");                                                                                                  
    System.out.println();
    System.out.println("             #####   ##    ##                ##");                                                                  
    System.out.println("          ######  /#### #####                 ##    #                #                          #");                
    System.out.println("         /#   /  /  ##### #####               ##   ###              ###                        ###");               
    System.out.println("        /    /  /   # ##  # ##                ##    #                #                          #");                
    System.out.println("            /  /    #     #                   ##");                                                                 
    System.out.println("           ## ##    #     #      /##      ### ##  ###       /###   ###   ###  /###     /###   ###        /###");    
    System.out.println("           ## ##    #     #     / ###    ######### ###     / ###  / ###   ###/ #### / / ###  / ###      / #### /"); 
    System.out.println("           ## ##    #     #    /   ###  ##   ####   ##    /   ###/   ##    ##   ###/ /   ###/   ##     ##  ###/");  
    System.out.println("           ## ##    #     #   ##    ### ##    ##    ##   ##          ##    ##    ## ##    ##    ##    ####");       
    System.out.println("           ## ##    #     ##  ########  ##    ##    ##   ##          ##    ##    ## ##    ##    ##      ###");      
    System.out.println("           #  ##    #     ##  #######   ##    ##    ##   ##          ##    ##    ## ##    ##    ##        ###");    
    System.out.println("              /     #      ## ##        ##    ##    ##   ##          ##    ##    ## ##    ##    ##          ###");  
    System.out.println("          /##/      #      ## ####    / ##    /#    ##   ###     /   ##    ##    ## ##    /#    ##     /###  ##");  
    System.out.println("         /  #####           ## ######/   ####/      ### / ######/    ### / ###   ### ####/ ##   ### / / #### /");   
    System.out.println("        /     ##                #####     ###        ##/   #####      ##/   ###   ### ###   ##   ##/     ###/");    
    System.out.println("        #");                                                                                                        
    System.out.println("         ##");     
    }
}