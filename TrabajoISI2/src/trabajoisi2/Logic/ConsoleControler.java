/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import trabajoisi2.Logic.Contenido.Pelicula;
import trabajoisi2.Logic.Contenido.Serie;
import trabajoisi2.personas.suscriptores.ISuscriptor;
import trabajoisi2.personas.suscriptores.SuscriptorFactory;

/**
 *
 * @author Parri
 */
public class ConsoleControler {
    private static BufferedReader consoleReader;
    
    public static void iniciarConsola() {
        System.out.println("¡Bienvenido al lado logico de la aplicación!");
        System.out.println("Permiteme comentarle lo que aqui puede hacer:\nSi desea añadir una pelicula, escriba \"addPelicula\"\nSi desea ñadir una Serie, escriba \"addSerie\"");
        // Redirigir la salida estándar a la GUI
//        PrintStream printStream = new PrintStream(new OutputStream() {
//            @Override
//            public void write(int b) {
//                textArea.append(String.valueOf((char) b));
//            }
//        });
//        System.setOut(printStream);

        // Iniciar un lector de consola para leer los comandos
        consoleReader = new BufferedReader(new InputStreamReader(System.in));

        // Crear un hilo separado para leer los comandos de la consola
        Thread consoleThread = new Thread(() -> {
            String input;
            try {
                while ((input = consoleReader.readLine()) != null) {
//                    System.out.println("Comando recibido desde la consola: " + input);
                    // Aquí puedes interpretar y procesar los comandos recibidos desde la consola
                    if(input.startsWith("addPelicula")){
                        addPelicula();
                    }else if(input.startsWith("addSerie")){
                        addSerie();
                    }else{
                        System.out.println("INVALID COMMAND!");
                    } 
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        consoleThread.start();
    }
    
    private static void addPelicula(){
        String Name = null;
        String Duracion = null;
        String Genero = null;
        ISuscriptor SuscriptionType = null;
        System.out.print("Añadamos una pelicula!\n Lo primero, como se llama: ");
        try {
            Name = consoleReader.readLine();
            System.out.println("Bien, ahora que sabemos que se llama \""+Name+"\", necesitaremos saber su duración. ¿Cual es?");
            Duracion = consoleReader.readLine();
            System.out.println("Bien, la pelicula \""+ Name + "\n dura " + Duracion +". Pero, los suscriptores no lo veran si no saben de que genero es. Pongamosle el genero");
            Genero = consoleReader.readLine();
            System.out.println("Entonces, \""+Name+"\" que dura "+Duracion+" y es del genero \""+Genero+"\". Bien!, ya lo tenemos todo, pero nos falta el nivel de suscripción al que pertenecera.\n- Normal\n- Plus\n- Premium");
//            SuscriptorFactory.createSuscriptor(type);
        } catch (IOException ex) {
            Logger.getLogger(ConsoleControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataBase.getInstance().agregarContenido(new Pelicula(Name,Duracion,Genero,SuscriptionType));
    }
    
    private static void addSerie(){
        String Nombre = null;
        int NumCapitulos = 0;
        String Genero = null;
        ISuscriptor SuscripcionType = null;
        try{
            System.out.print("Añadamos una Serie!\nLo primero, como se llama: ");
            Nombre = consoleReader.readLine();
            System.out.println("Bien, ahora que sabemos que se llama \""+Nombre+"\", necesitaremos saber su duración, es decir la cantidad de capitulos. ¿Cual es?");
            NumCapitulos = Integer.getInteger(consoleReader.readLine());
            System.out.println("Bien, la Serie \""+ Nombre + "\n dura " + NumCapitulos +" capitulos. Pero, los suscriptores no lo veran si no saben de que genero es. Pongamosle el genero");
            Nombre = consoleReader.readLine();
            System.out.println("Entonces, \""+Nombre+"\" que dura "+NumCapitulos+" capitulos y es del genero \""+Genero+"\". Bien!, ya lo tenemos todo, pero nos falta el nivel de suscripción al que pertenecera.\n- Normal\n- Plus\n- Premium");
        }catch (IOException ex){
            Logger.getLogger(ConsoleControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataBase.getInstance().agregarContenido(new Serie(Nombre, NumCapitulos, Genero, SuscripcionType));
    }
}
