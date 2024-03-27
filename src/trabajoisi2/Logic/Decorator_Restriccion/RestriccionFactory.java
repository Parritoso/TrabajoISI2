/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.Logic.Decorator_Restriccion;

import trabajoisi2.personas.suscriptores.ISuscriptor;

/**
 *
 * @author Parri
 */
public class RestriccionFactory {
    public static ISuscriptor createRestriccion(String type, ISuscriptor Contenido){
        ISuscriptor aux = null;
        switch(type){
            case "Normal" -> aux = new RestriccionNormal(Contenido);
            case "Premium" -> aux = new RestriccionPremium(Contenido);
            case "Universal" -> aux = new RestriccionUniversal(Contenido);
        }
        return aux;
    }
}
