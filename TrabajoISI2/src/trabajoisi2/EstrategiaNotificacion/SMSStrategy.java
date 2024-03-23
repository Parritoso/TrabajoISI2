/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.EstrategiaNotificacion;

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
    public void enviar(String noticia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTipoStrategy() {
        return "SMS";
    }
    
}
