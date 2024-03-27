/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajoisi2;

import javax.swing.SwingUtilities;
import trabajoisi2.Logic.Contenido.Pelicula;
import trabajoisi2.Logic.Contenido.Serie;
import trabajoisi2.Logic.Starflix;
import trabajoisi2.client.Pantalla;
import trabajoisi2.personas.Persona;
import trabajoisi2.personas.suscriptores.SuscriptorFactory;

/**
 *
 * @author darkn
 */
public class TrabajoISI2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Starflix Intance = Starflix.getInstance();
        Intance.agregarContenido(new Pelicula("La sociedad de la nieve","144 min","Aventuras, cine biográfico, drama, cine histórico y suspenso",SuscriptorFactory.createSuscriptor("Normal"),"En 1972, un vuelo procedente de Uruguay se estrella en un glaciar en los Andes. Solo 29 de sus 45 pasajeros sobreviven al accidente. Atrapados en uno de los entornos más hostiles del planeta, se ven obligados a luchar por sus vidas."));
        Intance.agregarContenido(new Pelicula("The End of Evangelion","87 min","Ciencia ficción, filosófico, misterio, mecha, psicológico, post-apocalíptico",SuscriptorFactory.createSuscriptor("Premium"),"Seele ordena un ataque sin cuartel contra NERV con el objetivo de destruir los Evas antes de que Gendo pueda provocar el Tercer Impacto y la unión de las almas humanas."));
        Intance.agregarContenido(new Pelicula("Dune 2","165 min","Ciencia ficción, Epico",SuscriptorFactory.createSuscriptor("Universal"),"Paul Atreides se une a Chani y a los Fremen mientras busca venganza contra los conspiradores que destruyeron a su familia. Enfrentándose a una elección entre el amor de su vida y el destino del universo, debe evitar un futuro terrible."));
        Intance.agregarContenido(new Serie("X-men '97",10,"Serie animada", SuscriptorFactory.createSuscriptor("Normal"),"Una banda de mutantes usa sus extraños dones para proteger un mundo que los odia y teme. Se enfrentan a desafíos como nunca antes y se ven obligados a afrontar un nuevo futuro peligroso e inesperado."));
        Intance.agregarContenido(new Serie("Hazbin Hotel",9,"Comedia, Género fantástico, Musical, Melodrama, Humor negro, Animación para adultos", SuscriptorFactory.createSuscriptor("Premium"),"Esta serie musical de animación para adultos narra la misión en principio imposible de Charlie, la princesa del Infierno, que quiere rehabilitar a los demonios para reducir la sobrepoblación de su reino. Tras uno de los exterminios anuales impuestos por el Cielo, abre un hotel esperando que los huéspedes se vayan después de demostrar que pueden redimir sus almas."));
        Intance.agregarContenido(new Serie("Lupin",17,"acción, comedia, fantasía, aventura", SuscriptorFactory.createSuscriptor("Universal"),"Inspirado por las aventuras de Arsène Lupin, el ladrón de guante blanco Assane Diop se propone vengar la injusticia sufrida por su padre a manos de una familia rica."));
        Intance.addObserver(new Persona("Test01","Normal",null,"123456789","Normal","Normal"));
        Intance.addObserver(new Persona("Test02","Premium","Premium@Premium.es",null,"Premium","Premium"));
        Intance.addObserver(new Persona("Test03","Universal","Universal@Universal.es",null,"Universal","Universal"));
        SwingUtilities.invokeLater(() -> {
            Pantalla ventana = new Pantalla();
            ventana.setVisible(true);
        });
        // TODO code application logic here
    }
    
}
