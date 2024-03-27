/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.Logic.Decorator_Restriccion;

import trabajoisi2.EstrategiaNotificacion.IStrategy;
import trabajoisi2.Logic.Contenido.IContenido;
import trabajoisi2.Logic.Contenido.Pelicula;
import trabajoisi2.Logic.Contenido.Serie;
import trabajoisi2.personas.suscriptores.ISuscriptor;

/**
 *
 * @author Parri
 */
public class RestriccionUniversal extends SuscriptionDecorator {

    public RestriccionUniversal(ISuscriptor Contenido) {
        super(Contenido);
    }

    @Override
    public void setNotificacionType(IStrategy strategia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean verPelicula(Pelicula pPelicula) {
        if(EsAccesible(pPelicula)){
            return super.verPelicula(pPelicula);
        } else {
            System.out.println("¡Acceso restringido para usuarios Universales!");
            return false;
        }
    }

    @Override
    public boolean verSerie(Serie pSerie) {
        if(EsAccesible(pSerie)){
            return super.verSerie(pSerie);
        } else {
            System.out.println("¡Acceso restringido para usuarios Universales!");
            return false;
        }
    }
    
    private boolean EsAccesible(IContenido contenido) {
        return true;
    }
    
}
