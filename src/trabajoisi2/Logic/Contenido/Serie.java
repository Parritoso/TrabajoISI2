/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.Logic.Contenido;

import java.util.ArrayList;
import trabajoisi2.personas.suscriptores.ISuscriptor;
/**
 *
 * @author eps
 */
public class Serie implements IContenido{
    private String Nombre;
    private int NumCapitulos;
    private ArrayList<Capitulo> Capitulos;
    private String Genero;
    private ISuscriptor SuscripcionType;
    private String internalName;
    private String Descripcion;

    public Serie(String Nombre, int NumCapitulos,String Genero, ISuscriptor SuscripcionType, String Descripcion) {
        this.Nombre = Nombre;
        this.Genero = Genero;
        this.NumCapitulos = NumCapitulos;
        this.SuscripcionType = SuscripcionType;
        this.internalName = Nombre.replaceAll(" ","_");
        this.Descripcion = Descripcion;
    }

    @Override
    public String getName() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNumCapitulos() {
        return NumCapitulos;
    }

    public void setNumCapitulos(int NumCapitulos) {
        this.NumCapitulos = NumCapitulos;
    }

    public ArrayList<Capitulo> getCapitulos() {
        return Capitulos;
    }

    public void setCapitulos(ArrayList<Capitulo> Capitulos) {
        this.Capitulos = Capitulos;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public ISuscriptor getSuscripcionType() {
        return SuscripcionType;
    }

    public void setSuscripcionType(ISuscriptor SuscripcionType) {
        this.SuscripcionType = SuscripcionType;
    }

    @Override
    public String getTipoStrategy() {
        return "SERIE";
    }

    @Override
    public String toString() {
        return "Serie{" + "Nombre=" + Nombre + ", NumCapitulos=" + NumCapitulos + ", Genero=" + Genero + ", SuscripcionType=" + SuscripcionType + '}';
    }

    @Override
    public String getInternalName() {
        return internalName;
    }

    @Override
    public String getDuracion() {
        return String.valueOf(NumCapitulos) + " Capitulos";
    }

    @Override
    public ISuscriptor getSuscriptionType() {
        return this.getSuscripcionType();
    }

    @Override
    public String getDescripcion() {
        return Descripcion;
    }
     
    
    private class Capitulo{
        private String Nombre;
        private String Duracion;

        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String Nombre) {
            this.Nombre = Nombre;
        }

        public String getDuracion() {
            return Duracion;
        }

        public void setDuracion(String Duracion) {
            this.Duracion = Duracion;
        }
        
        
    }
}
