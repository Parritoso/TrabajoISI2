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
    public void enviar(IContenido contenido) {
       System.out.println("Enviando al email: "+ Email + " la notificacion de: \n"+contenido.toString());
    }

    @Override
    public String getTipoStrategy() {
        return "E-MAIL";
    }
    
}
