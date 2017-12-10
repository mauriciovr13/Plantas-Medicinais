/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoplp;

/**
 *
 * @author aluno
 */
public class PlantaCurativa extends Planta {
    
    private final String propriedadesCurativas;
    private final int codigo = 2;
    
    public PlantaCurativa(String nomePopular, String nomeCientifico, float peso, String classificacao,
                           String utilizacao, String propriedadesCurativas, Local localizacao) {
        super(nomePopular, nomeCientifico, peso, classificacao, utilizacao, localizacao);
        this.propriedadesCurativas = propriedadesCurativas;
    }
    
    public String getPropriedadesCurativas(){
        return propriedadesCurativas;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    @Override
    public String toString() {
        String resultado;
        resultado = "ID: " + getIdentificador() + "\n" + "Nome Popular: " + getNomePopular() + "\n" +
                "Nome Cientifico: " + getNomeCientifico() + "\n" + "Classificação: " + getClassificacao() + 
                "\n" + "Utilizacao: " + getUtilizacao() + "\n" + "Propriedades Curativas: " + propriedadesCurativas + 
                "\nPais de Origem: " + getNomePais() + "\nTipo de Clima: " + getTipoClima() + "\nTemperatura Media: " + 
                getTemperaturaMedia() + "\n";
        
        return resultado;
    }
    
}
