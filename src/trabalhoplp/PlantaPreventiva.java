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
public class PlantaPreventiva extends Planta {
    
    private String indicacao;
    private final int codigo = 1;
    
    public PlantaPreventiva(String nomePopular, String nomeCientifico, float preco, String classificacao,
                           String utilizacao, String indicacao, Local localizacao) {
        super(nomePopular, nomeCientifico, preco, classificacao, utilizacao, localizacao);
        this.indicacao = indicacao;
    }
    
    public String getIndicacao(){
        return indicacao;
    }
    
    //o codigo serve para quando ler uma planta de um arquivo, ele saber de onde a planta e
    //e construir seu objeto corretamente
    public int getCodigo() {
        return codigo;
    }
    
    @Override
    public String toString() {
        String resultado;
        resultado = "ID: " + getIdentificador() + "\n" + "Nome Popular: " + getNomePopular() + "\n" +
                "Nome Cientifico: " + getNomeCientifico() + "\n" + "Classificação: " + getClassificacao() + 
                "\n" + "Utilizacao: " + getUtilizacao() + "\nIndicaçao: " + indicacao + "\nPais de Origem: " +
                getNomePais() + "\nTipo de Clima: " + getTipoClima() + "\nTemperatura Media: " + getTemperaturaMedia() + "\n";
        return resultado;
    }
}
