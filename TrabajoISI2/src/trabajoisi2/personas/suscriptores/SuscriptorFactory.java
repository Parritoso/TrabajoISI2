/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.personas.suscriptores;

import trabajoisi2.PatronObservador.IObserver;

/**
 *
 * @author darkn
 */
public class SuscriptorFactory {
    
    public static ISuscriptor createSuscriptor(String type,IObserver observer){
        ISuscriptor aux = null;
        switch(type){
            case "Normal" -> aux = new SuscriptorNormal(observer);
            case "Premium" -> aux = new SuscriptorPremium(observer);
            case "Universal" -> aux = new SuscriptorUniversal(observer);
        }
        return aux;
    }
    
}
