/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajoisi2;

import java.io.BufferedReader;
import javax.swing.SwingUtilities;
import trabajoisi2.client.Pantalla;

/**
 *
 * @author darkn
 */
public class TrabajoISI2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Pantalla ventana = new Pantalla();
            ventana.setVisible(true);
        });
        // TODO code application logic here
    }
    
}
