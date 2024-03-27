/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.EstrategiaNotificacion;

import trabajoisi2.Logic.Contenido.IContenido;

/**
 *
 * @author darkn
 */
public class SMSStrategy implements IStrategy {
    
    private String Tlf;

    public SMSStrategy(String tlf) {
        this.Tlf = tlf;
    }
    
    public String getTlf() {
        return Tlf;
    }

    public void setTlf(String tlf) {
        this.Tlf = tlf;
    }

    @Override
    public void enviar(IContenido contenido) {
        System.out.println("Enviando al telefono: "+ Tlf + " la notificacion de :\n"+contenido.toString());
    }

    @Override
    public String getTipoStrategy() {
        return "SMS";
    }
    
}
