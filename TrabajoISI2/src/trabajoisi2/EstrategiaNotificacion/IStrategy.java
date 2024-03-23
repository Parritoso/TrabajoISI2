/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoisi2.EstrategiaNotificacion;

/**
 *
 * @author eps
 */
public interface IStrategy {

    void enviar(String noticia);

    String getTipoStrategy();
    
}
