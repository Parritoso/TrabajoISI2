/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.Logic.Decorator_Restriccion;

import trabajoisi2.Logic.Contenido.IContenido;
import trabajoisi2.Logic.Contenido.Pelicula;
import trabajoisi2.Logic.Contenido.Serie;
import trabajoisi2.personas.suscriptores.ISuscriptor;

/**
 *
 * @author Parri
 */
public abstract class SuscriptionDecorator implements ISuscriptor{
    protected ISuscriptor nivel;
    
    public SuscriptionDecorator(ISuscriptor Contenido){
        this.nivel = Contenido;
    }

    @Override
    public void verSerie(Serie pSerie){
        nivel.verSerie(pSerie);
    }

    @Override
    public void verPelicula(Pelicula pPelicula){
        nivel.verPelicula(pPelicula);
    }
    
    
}
