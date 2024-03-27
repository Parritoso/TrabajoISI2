/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.personas.suscriptores;

import trabajoisi2.EstrategiaNotificacion.IStrategy;
import trabajoisi2.Logic.Contenido.IContenido;
import trabajoisi2.Logic.Contenido.Pelicula;
import trabajoisi2.Logic.Contenido.Serie;

/**
 *
 * @author Parri
 */
public abstract class Suscriptor implements ISuscriptor {

    public abstract void update(IContenido contenido); 
    
    @Override
    public abstract boolean verPelicula(Pelicula pPelicula);

    @Override
    public abstract boolean verSerie(Serie pSerie);
    
    @Override
    public abstract String getNivel(); 
    
}
