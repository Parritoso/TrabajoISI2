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
        Intance.agregarContenido(new Serie("Juego de Tronos",73,"Drama. Fantástico. Acción. Intriga. Fantasía medieval. Espada y brujería. Venganza. Dragones",SuscriptorFactory.createSuscriptor("Premium"),"Donde los veranos duran décadas y los inviernos pueden durar una vida, los problemas acechan. Desde las maquinaciones del sur a las salvajes tierras del este, al helado norte y el Muro, dos familias se enfrentan por los Siete Reinos."));
        Intance.agregarContenido(new Serie("La Casa del Dragon",10,"Drama. Fantástico. Acción. Intriga. Espada y brujería. Fantasía medieval. Venganza. Dragones. Spin-off. Precuela",SuscriptorFactory.createSuscriptor("Universal"),"Ambientada 172 años \"antes de Daenerys Targaryen\", y en el noveno año del reinado de Viserys Targaryen, un rey cuya línea de sucesión está en peligro. Su esposa Aemma está embarazada, aunque no hay garantía de que dé a luz a un heredero varón. Si no lo hace, entonces el Trono de Hierro recaerá, bien sobre el hermano de Viserys, Daemon, un gobernante impulsivo y potencialmente tiránico; o bien, rompiendo con la tradición de preferencia del varón, en la hija adolescente de Viserys, Rhaenyra, cuyo reclamo del trono está destinado a tener una fuerte oposición."));
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
