/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package trabajoisi2.Logic.Contenido;

import trabajoisi2.personas.suscriptores.ISuscriptor;

/**
 *
 * @author Parri
 */
public interface IContenido {
    
    String getTipoStrategy();
    @Override
    String toString();
    String getName();
    String getInternalName();
    String getGenero();
    String getDuracion();
    ISuscriptor getSuscriptionType();

    public String getDescripcion();
}
