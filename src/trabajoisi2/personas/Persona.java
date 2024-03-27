/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.personas;

import trabajoisi2.EstrategiaNotificacion.EmailStrategy;
import trabajoisi2.EstrategiaNotificacion.SMSStrategy;
import trabajoisi2.Logic.Contenido.IContenido;
import trabajoisi2.Logic.Contenido.Pelicula;
import trabajoisi2.Logic.Contenido.Serie;
import trabajoisi2.Logic.Decorator_Restriccion.RestriccionFactory;
import trabajoisi2.personas.suscriptores.ISuscriptor;
import trabajoisi2.personas.suscriptores.Suscriptor;
import trabajoisi2.personas.suscriptores.SuscriptorFactory;

/**
 *
 * @author darkn
 */
public class Persona implements IPersona{

    private String Nombre;
    private String IDUsuario;
    private String Email;
    private String Tlf;
    private ISuscriptor type;
    private String Contraseña;

    public Persona(String Nombre, String IDUsuario, String Email, String Tlf,String type,String Contraseña) {
        this.Nombre = Nombre;
        this.IDUsuario = IDUsuario;
        this.Email = Email;
        this.Tlf = Tlf;
        this.type = SuscriptorFactory.createSuscriptor(type);
        this.Contraseña = Contraseña;
        if(Tlf == null){
            this.type.setNotificacionType(new EmailStrategy(this.Email));
        } else {
            this.type.setNotificacionType(new SMSStrategy(this.Tlf));
        }
        this.type = RestriccionFactory.createRestriccion(type, this.type);
    }

    @Override
    public String getNombre() {
        return Nombre;
    }

    @Override
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String getIDUsuario() {
        return IDUsuario;
    }

    @Override
    public void setIDUsuario(String IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    @Override
    public String getEmail() {
        return Email;
    }

    @Override
    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String getTlf() {
        return Tlf;
    }

    @Override
    public void setTlf(String Tlf) {
        this.Tlf = Tlf;
    }
    
    @Override
    public ISuscriptor getType() {
        return type;
    }
    
    public String getPassword(){
        return Contraseña;
    }
    
    @Override
    public boolean ver(IContenido contenido){
        if(contenido instanceof Pelicula){
            return this.verPelicula((Pelicula)contenido);
        } else {
            return this.verSerie((Serie)contenido);
        }
    }
    
    private boolean verPelicula(Pelicula pPelicula) {
        return type.verPelicula(pPelicula);
    }

    private boolean verSerie(Serie pSerie) {
        return type.verSerie(pSerie);
    }

    @Override
    public void setType(String type) {
        this.type = SuscriptorFactory.createSuscriptor(type);
    }

    @Override
    public String toString() {
        return "Persona{" + "Nombre=" + Nombre + ", IDUsuario=" + IDUsuario + ", Email=" + Email + ", Tlf=" + Tlf + "type=" + type.toString() + '}';
    }  
}
