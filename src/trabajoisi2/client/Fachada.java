/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.client;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import trabajoisi2.Logic.ConsoleControler;
import trabajoisi2.Logic.Contenido.IContenido;
import trabajoisi2.Logic.Starflix;
import trabajoisi2.personas.IPersona;
import trabajoisi2.personas.Persona;

/**
 *
 * @author eps
 */
public class Fachada {

        static Pattern tlfPattern = Pattern.compile("(\\+34|0034|34)?[ -]*(6|7)[ -]*([0-9][ -]*){8}");
        static Pattern EmailPattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    
    public static boolean crearPersona(String Nombre, String IDUsuario, String Email, String Tlf,String type){
        if(tlfPattern.matcher(Tlf).find() && EmailPattern.matcher(Email).find()){
            Starflix Instance = Starflix.getInstance();
//            Instance.addObserver(new Persona(Nombre,IDUsuario,Email,Tlf,type));
            return true;
        } else {
            return false;
        }
    }
    
    public static void iniciarConsola(){
        ConsoleControler.iniciarConsola();
    }
    
    public static Object[] Registration(String Nombre, String IDUsuario, String email, String password, String password1, String Type){
        Object[] aux = new Object[4];
        Starflix Instance = Starflix.getInstance();
        Persona nueva = null;
        if(!password.equals(password1)){
            aux[0] = false;
            aux[1] = 2;
            aux[2] = "Contraseñas distintas";
            return aux;
        } else {
            if(tlfPattern.matcher(email).find()){
                nueva = new Persona(Nombre,IDUsuario,null,email,Type,password);
            } else if(EmailPattern.matcher(email).find()){
                nueva = new Persona(Nombre,IDUsuario,email,null,Type,password);
            }
        }
        Instance.addObserver(nueva);
        aux[0] = true;
        aux[3] = nueva;
        return aux;
    }
    
    public static Object[] Login(String email, String password){
        Object[] aux = new Object[4];
        Starflix Instance = Starflix.getInstance();
        List<IPersona> personas = Instance.getobservadores();
        for(IPersona o : personas){
            if(o.getEmail()==null){
                if( o.getTlf().equals(email) && ((Persona)o).getPassword().equals(password)){
                aux[0] = true;
                aux[3] = o;
                return aux;
                }
            } else if(o.getEmail().equals(email) && ((Persona)o).getPassword().equals(password)){
                aux[0] = true;
                aux[3] = o;
                return aux;
            }
        }
        aux[0] = false;
        return aux;
    }

    static List<IContenido> getAll() {
        return Starflix.getInstance().getContenido();
    }
    
    static List<IContenido> getPelis(){
        return Starflix.getInstance().getPeliculas();
    }
    
    static List<IContenido> getSeries(){
        return Starflix.getInstance().getSeries();
    }

    public static Starflix getInstance() {
        return Starflix.getInstance();
    }

    public static Persona getSesion() {
        return Ventana.getPersona();
    }
    
}
