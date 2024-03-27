/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.personas.suscriptores;

/**
 *
 * @author darkn
 */
public class SuscriptorFactory {
    
    public static ISuscriptor createSuscriptor(String type){
        ISuscriptor aux = null;
        switch(type){
            case "Normal" -> aux = new SuscriptorNormal();
            case "Premium" -> aux = new SuscriptorPremium();
            case "Universal" -> aux = new SuscriptorUniversal();
        }
        return aux;
    }
    
}
