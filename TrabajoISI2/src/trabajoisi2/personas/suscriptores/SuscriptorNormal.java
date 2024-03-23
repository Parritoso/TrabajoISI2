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
public class SuscriptorNormal implements ISuscriptor,IObserver{
    
    private int MesesSuscritos;
    private IStrategy strategy = new EmailStrategy(null);
    private IObserver observer;

    public SuscriptorNormal(IObserver observer) {
        this.observer = observer;
    }

    @Override
    public void setNotificacionType(IStrategy strategia) {
        this.strategy = strategia;
    }

    @Override
    public void verPelicula(Pelicula pPelicula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void verSerie(Serie pSerie) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ISubject o, Object data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}