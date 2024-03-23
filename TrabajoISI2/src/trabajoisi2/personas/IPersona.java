/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package trabajoisi2.personas;

import trabajoisi2.personas.suscriptores.ISuscriptor;

/**
 *
 * @author darkn
 */
public interface IPersona {
    String getNombre();
    void setNombre(String nombre);
    String getIDUsuario();
    void setIDUsuario(String IDUsuario);
    String getEmail();
    void setEmail(String email);
    String getTlf();
    void setTlf(String tlf);
    ISuscriptor getType();
    void setType(String type);
}
