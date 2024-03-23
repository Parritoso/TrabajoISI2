/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.Logic.Decorator_Restriccion;

import trabajoisi2.EstrategiaNotificacion.IStrategy;
import trabajoisi2.personas.suscriptores.ISuscriptor;

/**
 *
 * @author Parri
 */
public class RestriccionPremium extends SuscriptionDecorator {

    public RestriccionPremium(ISuscriptor Contenido) {
        super(Contenido);
    }

    @Override
    public void setNotificacionType(IStrategy strategia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
