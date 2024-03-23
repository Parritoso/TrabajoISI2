/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package trabajoisi2.Logic;

import java.util.ArrayList;
import trabajoisi2.Logic.Contenido.IContenido;
import trabajoisi2.Logic.Contenido.Pelicula;
import trabajoisi2.Logic.Contenido.Serie;
import trabajoisi2.PatronObservador.IObserver;
import trabajoisi2.PatronObservador.ISubject;
import trabajoisi2.personas.IPersona;
import trabajoisi2.personas.suscriptores.ISuscriptor;

/**
 *
 * @author eps
 */
public class DataBase implements ISubject{
    
    private ArrayList<IPersona> Personas = new ArrayList();
    private ArrayList<IContenido> contenidos = new ArrayList();
    
    private static DataBase Instance = null;
    
    private DataBase() {
    }
    
    public static DataBase getInstance() {
        if(Instance==null){
            Instance = new DataBase();
        }
        return Instance;
    }
    
    public void addPersona(IPersona pPersona){
        Personas.add(pPersona);
    }
    
    public void agregarContenido(IContenido contenido){
        contenidos.add(contenido);
    }
    
//    public void addPelicula(Pelicula pPelicula){
//        ISuscriptor aux = pPelicula.getSuscriptionType();
//        switch(aux.getClass().getSimpleName()){
//            case "SuscriptorNormal":
//                ListPeliculasNormal.add(pPelicula);
//                break;
//            case "SuscriptorPremium":
//                ListPeliculasPremium.add(pPelicula);
//                break;
//            case "SuscriptorUniversal":
//                ListPeliculasUniversal.add(pPelicula);
//                break;
//        }
//    }
//    
//    public void addSerie(Serie pPelicula){
//        ISuscriptor aux = pPelicula.getSuscripcionType();
//        switch(aux.getClass().getSimpleName()){
//            case "SuscriptorNormal":
//                ListSeriesNormal.add(pPelicula);
//                break;
//            case "SuscriptorPremium":
//                ListSeriesPremium.add(pPelicula);
//                break;
//            case "SuscriptorUniversal":
//                ListSeriesUniversal.add(pPelicula);
//                break;
//        }
//    }

    @Override
    public void addObserver(IObserver Observer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteObserver(IObserver Observer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void notifyObserver() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void notifyObservers(Object data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void notifyObserver(IObserver Observer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
