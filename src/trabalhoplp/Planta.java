package trabalhoplp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo
 */
public class Planta {
    static int id;
    private final int identificador;
    private final String nomePopular;
    private final String nomeCientifico;
     private float preco;
    private String classificacao;//briófita, pteridófita, gmnosperma ou angiosperma.
    private String utilizacao;
    private Local localizacao;

     public Planta(){
        this.identificador = 0;
        this.nomePopular = " ";
        this.nomeCientifico = " ";
        this.preco = 0.f;
        this.classificacao = " ";
        this.utilizacao = " ";
    }
     
    public Planta(String nomePopular, String nomeCientifico, float preco, String classificacao, String utilizacao, Local localizacao){
        ++id;
        this.identificador = id;
        this.nomePopular = nomePopular;
        this.nomeCientifico = nomeCientifico;
        this.preco = preco;
        this.classificacao = classificacao;
        this.utilizacao = utilizacao;
        this.localizacao = localizacao;
    }
    
    public int getIdentificador() {
        return identificador;
    }

    public String getNomePopular(){
        return nomePopular;
    }
    
    public String getNomeCientifico(){
        return nomeCientifico;
    }
    
    public Float getPreco() {
        return preco;
    }
    
    public String getClassificacao(){
        return classificacao;
    }
    
    public String getUtilizacao(){
        return utilizacao;
    }
    
    public String getNomePais() {
        return localizacao.getNomePais();
    }
    
    public String getTipoClima() {
        return localizacao.getTipoClima();
    }
    
    public double getTemperaturaMedia() {
        return localizacao.getTemperaturaMedia();
    }
        
}
