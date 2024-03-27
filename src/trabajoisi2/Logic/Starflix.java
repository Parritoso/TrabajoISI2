/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package trabajoisi2.Logic;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import trabajoisi2.Logic.Contenido.IContenido;
import trabajoisi2.Logic.Contenido.Pelicula;
import trabajoisi2.Logic.Decorator_Restriccion.SuscriptionDecorator;
import trabajoisi2.PatronObservador.IObserver;
import trabajoisi2.PatronObservador.ISubject;
import trabajoisi2.client.Fachada;
import trabajoisi2.personas.IPersona;
import trabajoisi2.personas.Persona;
import trabajoisi2.personas.suscriptores.Suscriptor;

/**
 *
 * @author eps
 */
public class Starflix implements ISubject{
    
    private ArrayList<IPersona> observadores = new ArrayList();
    private ArrayList<IContenido> contenidos = new ArrayList();
    private ArrayList<IContenido> Peliculas = new ArrayList();
    private ArrayList<IContenido> Series = new ArrayList();
    
    private static Starflix Instance = null;
    
    private Starflix() {
    }
    
    public static synchronized Starflix getInstance() {
        if(Instance==null){
            Instance = new Starflix();
        }
        return Instance;
    }
    
    @Override
    public void addObserver(IPersona newObserver){
        observadores.add(newObserver);
    }
    
    public synchronized void agregarContenido(IContenido contenido){
        this.contenidos.add(contenido);
        if(contenido instanceof Pelicula){
            Peliculas.add(contenido);
        } else {
            Series.add(contenido);
        }
        this.notifyObservers();
    }
    
    public synchronized List<IContenido> getPeliculas(){
        return Peliculas;
    }
    
    public synchronized List<IContenido> getSeries(){
        return Series;
    }
    
    public synchronized List<IPersona> getobservadores(){
        return observadores;
    }
    

    @Override
    public void deleteObserver(IPersona Observer) {
       this.observadores.remove(Observer);
    }

    @Override
    public void notifyObservers() {
        Persona Sesion = Fachada.getSesion();
        if(Sesion!=null){
            for(IPersona o:observadores){
                ((Suscriptor)((SuscriptionDecorator)o.getType()).getSuscripcion()).update(contenidos.get(contenidos.size()-1));
                if(o.equals(Sesion)){
                    JOptionPane.showMessageDialog(null, "Se ha añadido un nuevo Contenido", "Notificación", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            for(IPersona o:observadores){
                ((Suscriptor)o.getType()).update(contenidos.get(contenidos.size()-1));
            }
        }
        
    }

    public synchronized List<IContenido> getContenido() {
        return contenidos;
    }
}
