/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.personas;

import trabajoisi2.PatronObservador.IObserver;
import trabajoisi2.PatronObservador.ISubject;
import trabajoisi2.personas.suscriptores.ISuscriptor;
import trabajoisi2.personas.suscriptores.SuscriptorFactory;

/**
 *
 * @author darkn
 */
public class Persona implements IPersona,IObserver{

    private String Nombre;
    private String IDUsuario;
    private String Email;
    private String Tlf;
    private ISuscriptor type;

    public Persona(String Nombre, String IDUsuario, String Email, String Tlf,String type) {
        this.Nombre = Nombre;
        this.IDUsuario = IDUsuario;
        this.Email = Email;
        this.Tlf = Tlf;
        this.type = SuscriptorFactory.createSuscriptor(type,this);
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

    @Override
    public void setType(String type) {
        this.type = SuscriptorFactory.createSuscriptor(type,this);
    }

    @Override
    public String toString() {
        return "Persona{" + "Nombre=" + Nombre + ", IDUsuario=" + IDUsuario + ", Email=" + Email + ", Tlf=" + Tlf + "type=" + type.toString() + '}';
    }  

    @Override
    public void update(ISubject o, Object data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
