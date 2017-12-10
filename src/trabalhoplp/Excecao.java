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
 public class Excecao extends Exception {
    private String msg;
    public Excecao(String msg) {
        super(msg);
        this.msg = msg;
    }
    
    public String getMessage(){
      return msg;
    }
    
 }
