/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.personas.suscriptores;

import trabajoisi2.EstrategiaNotificacion.EmailStrategy;
import trabajoisi2.EstrategiaNotificacion.IStrategy;
import trabajoisi2.Logic.Contenido.IContenido;
import trabajoisi2.Logic.Contenido.Pelicula;
import trabajoisi2.Logic.Contenido.Serie;
import trabajoisi2.PatronObservador.IObserver;
import trabajoisi2.PatronObservador.ISubject;
import trabajoisi2.personas.Persona;

/**
 *
 * @author darkn
 */
public class SuscriptorNormal extends Suscriptor implements ISuscriptor,IObserver{
    
    private int MesesSuscritos;
    private IStrategy strategy = new EmailStrategy(null);
   

    public SuscriptorNormal() {
    }

    @Override
    public void setNotificacionType(IStrategy strategia) {
        this.strategy = strategia;
    }

    @Override
    public boolean verPelicula(Pelicula pPelicula) {
        System.out.println("Viendo pelicula: " + pPelicula.toString());
        return true;
    }

    @Override
    public boolean verSerie(Serie pSerie) {
        System.out.println("Viendo serie: " + pSerie.toString());
        return true;
    }

    @Override
    public void update(IContenido contenido) {
        strategy.enviar(contenido);
    }   

    @Override
    public String toString() {
        return "SuscriptorNormal";
    }

    @Override
    public String getNivel() {
        return toString();
    }
    
    
}