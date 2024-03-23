/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.client;

import java.util.regex.Pattern;
import trabajoisi2.Logic.ConsoleControler;
import trabajoisi2.Logic.DataBase;
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
            DataBase Instance = DataBase.getInstance();
            Instance.addPersona(new Persona(Nombre,IDUsuario,Email,Tlf,type));
            return true;
        } else {
            return false;
        }
    }
    
    public static void iniciarConsola(){
        ConsoleControler.iniciarConsola();
    }
    
}
