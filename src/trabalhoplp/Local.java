/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoplp;
/**
 *
 * @author Rodrigo, Mauricio e Matheus Bento
 */
public class Local {
    
    private String nomePais;
    private String tipoClima;
    private double temperaturaMedia;
    
    public Local() {
        this.nomePais = " ";
        this.nomePais = " ";
        this.temperaturaMedia = 0.0;
    }
    
    public Local(String nomePais, String tipoClima, double temperaturaMedia) {
        this.nomePais = nomePais;
        this.tipoClima = tipoClima;
        this.temperaturaMedia = temperaturaMedia;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getTipoClima() {
        return tipoClima;
    }

    public void setTipoClima(String tipoClima) {
        this.tipoClima = tipoClima;
    }

    public double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }
    
    
    
    @Override
    public String toString() {
        String resultado;
        resultado = "Nome do Pais de Origem: " + nomePais + "\nTipo do clima: " + tipoClima + "\nTemperatura media: " + 
                temperaturaMedia + "\n";        
        return resultado;
    }
}

