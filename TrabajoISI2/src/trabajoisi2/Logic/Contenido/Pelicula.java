/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.Logic.Contenido;

import trabajoisi2.personas.suscriptores.ISuscriptor;

/**
 *
 * @author eps
 */
public class Pelicula implements IContenido{
    private String Name;
    private String Duracion;
    private String Genero;
    private ISuscriptor SuscriptionType;

    public Pelicula(String Name, String Duracion, String Genero, ISuscriptor SuscriptionType) {
        this.Name = Name;
        this.Duracion = Duracion;
        this.Genero = Genero;
        this.SuscriptionType = SuscriptionType;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String Duracion) {
        this.Duracion = Duracion;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public ISuscriptor getSuscriptionType() {
        return SuscriptionType;
    }

    public void setSuscriptionType(ISuscriptor SuscriptionType) {
        this.SuscriptionType = SuscriptionType;
    }

    @Override
    public String getTipoStrategy() {
        return "PELICULA";
    }

    
    
}
