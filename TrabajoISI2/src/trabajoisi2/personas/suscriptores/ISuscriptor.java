/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package trabajoisi2.personas.suscriptores;

import trabajoisi2.EstrategiaNotificacion.IStrategy;
import trabajoisi2.Logic.Contenido.Pelicula;
import trabajoisi2.Logic.Contenido.Serie;

/**
 *
 * @author eps
 */
public interface ISuscriptor {
    
    void setNotificacionType(IStrategy strategia);
    void verPelicula(Pelicula pPelicula);
    void verSerie(Serie pSerie);
    
}
