/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoplp;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Rodrigo
 */
public class CadastroPlanta {
    ArrayList<Planta> vetorPlantas = new ArrayList<Planta>();
    
    public void insere(Planta planta) {
        vetorPlantas.add(planta);
    }
    
    public boolean remove(String nomePlanta){
        int indice = -1;
        boolean continua = true;
        for (int i = 0; ((i < vetorPlantas.size()) && continua); ++i) {
            Planta planta = vetorPlantas.get(i);
            if (planta.getNomePopular().equals(nomePlanta)) {
                indice = i;
                continua = false;
            }           
        }
        
        if (indice >= 0) {
            vetorPlantas.remove(indice);
            return true;
        }
        return false;
    }
    
    public void imprime() {
        for (Planta planta : vetorPlantas) {
            /*
            if(p instanceof PlantaPreventiva) {
                PlantaPreventiva pp = (PlantaPreventiva) p;
                pp.toString();
            }
            */
            System.out.println(planta.toString());
            System.out.println();
        }
    }
    
    public boolean vazio() {
        return vetorPlantas.isEmpty();
    }
    
    public void escreverArquivo(String nomeArquivo) throws IOException {
        try (FileWriter fw = new FileWriter(nomeArquivo)) {
            //coloca o cabecalho no arquivo
            fw.write("NomePopular;NomeCientifico;Preço;Classificacao;Utilizacao;Indicacao/PropriedadesCurativas;Localizacao\n");
            for (Planta p : vetorPlantas) {
                //ler cada planta e verifica qual a sua instancia, depois converte e escreve
                //no arquivo com os seus respectivos atributos
                if(p instanceof PlantaPreventiva) {
                    PlantaPreventiva plantaPrev = (PlantaPreventiva) p;
                    fw.write(plantaPrev.getNomePopular() + ";" + plantaPrev.getNomeCientifico() + ";" + plantaPrev.getPreco() + ";"
                            + plantaPrev.getClassificacao() + ";" + plantaPrev.getUtilizacao() + ";" + plantaPrev.getIndicacao() + ";" 
                            + plantaPrev.getCodigo() + ";" + plantaPrev.getNomePais() + ";" + plantaPrev.getTipoClima() + ";"
                            + plantaPrev.getTemperaturaMedia() + "\n");
                }
                else {
                    PlantaCurativa plantaCur = (PlantaCurativa) p;
                    fw.write(plantaCur.getNomePopular() + ";" + plantaCur.getNomeCientifico() + ";" + plantaCur.getPreco() + ";"
                            + plantaCur.getClassificacao() + ";" + plantaCur.getUtilizacao() + ";" + plantaCur.getPropriedadesCurativas() + ";" 
                            + plantaCur.getCodigo() + ";" + plantaCur.getNomePais() + ";" + plantaCur.getTipoClima() + ";"
                            + plantaCur.getTemperaturaMedia() + "\n");
                }
            }
        }
    }
    
    public void lerArquivo(String nomeArquivo) throws FileNotFoundException, IOException {
        
        String nomePopular;
        String nomeCientifico;
        float preco;
        String classificacao;
        String utilizacao;
        String propriedadesCurativas_indicacao;
        int codigo;
        Local localizacao = new Local();
        /*
        String nomePais;
        String tipoClima;
        double temperaturaMedia;
        */
        
        FileReader fr = new FileReader(nomeArquivo);        
        BufferedReader br = new BufferedReader(fr);
        
        //descartando a primeira linha, a linha do cabeçalho
        String linha = br.readLine();
        //enquanto houver mais linhas
        while((linha = br.readLine()) != null){ //lê a proxima linha
            //divide a string lida, em um array de string com 10 posicoes
            //onde cada posicao e um atributo de planta e sao separados por ";"
            String array[] = new String[10];
            array = linha.split(";");
            nomePopular = array[0];
            nomeCientifico = array[1];
            preco = Float.parseFloat(array[2]);
            classificacao = array[3];
            utilizacao = array[4];
            propriedadesCurativas_indicacao = array[5];
            codigo = Integer.parseInt(array[6]);
            
            localizacao.setNomePais(array[7]);
            localizacao.setTipoClima(array[8]);
            localizacao.setTemperaturaMedia(Double.parseDouble(array[9]));
            
            if (codigo == 1) {
                //constroi a planta e adiciona no arquivo
                PlantaPreventiva planta = new PlantaPreventiva(nomePopular, nomeCientifico, preco, classificacao, utilizacao, 
                propriedadesCurativas_indicacao, localizacao);
                insere(planta);
            }
            else {
                PlantaCurativa planta = new PlantaCurativa(nomePopular, nomeCientifico, preco, classificacao, utilizacao, 
                propriedadesCurativas_indicacao, localizacao);
                insere(planta);
            }
        }
    }
}

