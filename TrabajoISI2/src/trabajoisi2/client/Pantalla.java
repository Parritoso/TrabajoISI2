/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.client;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Parri
 */
public class Pantalla extends javax.swing.JFrame{
    private JLabel logoLabel;
//    private JLabel textLabel;
    private JLabel bottomTextLabel;
    private Timer timer;
    private Image backgroundImage;
    private JPanel currentPanel;
    private JPanel contentPane;
    
    public Pantalla(){
        setTitle("Ventana con GIF de fondo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 540);
        setLocationRelativeTo(null);
        backgroundImage = new ImageIcon(this.getClass().getResource("../resources/giphy.gif")).getImage();
        
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar y dibujar el GIF de fondo
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                currentPanel.setOpaque(false);
                currentPanel.paint(g);
            }
        };
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        setContentPane(contentPane);
        
        JPanel logoPanel = new JPanel();
        logoPanel.setOpaque(false); // Hacer el panel transparente
        logoPanel.setBackground(Color.red);
        contentPane.add(logoPanel);
        
        logoLabel = new JLabel(new ImageIcon(this.getClass().getResource("../resources/logo.png")));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoPanel.add(logoLabel);
        
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setOpaque(false); // Hacer el panel transparente
        contentPane.add(textPanel,BorderLayout.CENTER);
        
        currentPanel = new JPanel(new BorderLayout());
        currentPanel.setOpaque(false);
        currentPanel.setBackground(Color.red);
        contentPane.add(currentPanel,BorderLayout.CENTER);  
                
        
        
        JLabel textLabel = new JLabel("¡Hola, Mundo!");
        textLabel.setFont(new Font("Arial", Font.BOLD, 36));
        textLabel.setForeground(Color.DARK_GRAY);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textPanel.add(textLabel, BorderLayout.CENTER);
        
        bottomTextLabel = new JLabel("Texto inferior izquierdo");
        bottomTextLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        bottomTextLabel.setForeground(Color.WHITE);
        bottomTextLabel.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(bottomTextLabel);
        
        
        timer = new Timer(100, new ActionListener() {
            float alpha = 0.0f;
            boolean fadeIn = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += fadeIn ? 0.05f : -0.05f;
                if (alpha >= 1.0f) {
                    alpha = 1.0f;
                    fadeIn = false;
                } else if (alpha <= 0.0f) {
                    alpha = 0.0f;
                    fadeIn = true;
                }
                textLabel.setForeground(new Color(0.2f, 0.2f, 0.2f, alpha)); // Color con opacidad ajustada
            }
        });
        timer.start();
        
         addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                cambiarVentana();
                timer.stop();
               Fachada.iniciarConsola();
            }
        });
        setFocusable(true);
    }

    private void cambiarVentana() {
        // Crear un nuevo panel para la próxima ventana
        JPanel nextPanel = new JPanel(new BorderLayout());
        nextPanel.setBackground(Color.BLACK); // Cambiar el color de fondo para que coincida con el nuevo panel

        // Crear el texto para la nueva ventana
        JLabel newText = new JLabel("Nueva ventana");
        newText.setFont(new Font("Arial", Font.BOLD, 24));
        newText.setForeground(Color.WHITE);
        newText.setHorizontalAlignment(SwingConstants.CENTER);
        nextPanel.add(newText, BorderLayout.CENTER);

        // Aplicar efecto de transición (desvanecimiento)
        Timer timer = new Timer(30, null);
        timer.addActionListener(new ActionListener() {
            private float opacity = 1f;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 0.05f;
                if (opacity <= 0) {
                    // Cuando la opacidad alcanza 0, cambia el panel y detiene el temporizador
                    currentPanel = nextPanel;
                    ((Timer) e.getSource()).stop();
                    contentPane.removeAll();
                    contentPane.add(currentPanel, BorderLayout.CENTER);
                    contentPane.revalidate();
                    contentPane.repaint(); // Repintar el contenido para actualizar la opacidad
                }
                
            }
        });
        timer.start();
    }
}
