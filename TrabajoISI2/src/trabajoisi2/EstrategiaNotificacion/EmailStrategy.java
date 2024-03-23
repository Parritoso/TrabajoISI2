/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.EstrategiaNotificacion;

/**
 *
 * @author darkn
 */
public class EmailStrategy implements IStrategy {
    private String Email;

    public EmailStrategy(String email) {
        this.Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    @Override
    public void enviar(String noticia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTipoStrategy() {
        return "E-MAIL";
    }
    
}
