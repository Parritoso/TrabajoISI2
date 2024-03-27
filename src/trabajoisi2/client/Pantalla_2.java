/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import trabajoisi2.Logic.Starflix;
import trabajoisi2.client.util.PanelGlowingGradient;
import trabajoisi2.client.util.PanelGlowingGradient1;
import trabajoisi2.personas.IPersona;
import trabajoisi2.personas.Persona;

/**
 *
 * @author Parri
 */
public class Pantalla_2 extends JFrame {
    
    private JButton button2;
    private JButton button1;
    private PanelGlowingGradient centerPanel;
    private Color activeColor;
    private Timer timer;
    
    public Pantalla_2() {
        setTitle("Nueva Ventana");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 540);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar el GIF de fondo
                ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("../resources/giphy_1.gif"));
                Image backgroundImage = imageIcon.getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);
        
        JPanel centeringPanel = new JPanel(new GridBagLayout());
        
        PanelGlowingGradient registroPanel = new PanelGlowingGradient(this);
        PanelGlowingGradient1 LogginPanel = new PanelGlowingGradient1(this);

        // Crear botones semitransparentes en la parte superior
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.setOpaque(false);

        Color buttonColor = new Color(255, 255, 255, 150);
        Color activeButtonColor = new Color(100, 100, 100,150);
        
        button1 = new JButton("Registro");
        button1.setBackground(activeButtonColor);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 20)); // Ajustar tamaño del texto
        button1.setPreferredSize(new Dimension(200, 80));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar el estado del botón
                button1.setBackground(activeButtonColor);
                button2.setBackground(buttonColor);
                activeColor = Color.BLACK;
                centeringPanel.removeAll();
                centeringPanel.add(registroPanel);
                centeringPanel.revalidate();
                centeringPanel.repaint();
                
            }
        });

        button2 = new JButton("Loggin");
        button2.setBackground(buttonColor);
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 20)); // Ajustar tamaño del texto
        button2.setPreferredSize(new Dimension(200, 80));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar el estado del botón
                button2.setBackground(activeButtonColor);
                button1.setBackground(buttonColor);
                activeColor = Color.WHITE;
                centeringPanel.removeAll();
                centeringPanel.add(LogginPanel);
                LogginPanel.setPreferredSize(new Dimension(700, 700));
                LogginPanel.setGradientColor1(new Color(0, 185, 210));
                LogginPanel.setGradientColor2(new Color(255, 245, 0));
                centeringPanel.revalidate();
                centeringPanel.repaint();
                startFadeOutAnimation();
                startFadeAnimation();
            }
        });

        buttonPanel.add(button1);
        buttonPanel.add(button2);

        contentPane.add(buttonPanel, BorderLayout.NORTH);
        
        centeringPanel.setOpaque(false);
        contentPane.add(centeringPanel, BorderLayout.CENTER);
        
        centerPanel = registroPanel;
        centerPanel.setPreferredSize(new Dimension(700, 700)); // Ajustar tamaño del panel
        centeringPanel.add(centerPanel);
    }
    
    // Método para iniciar la animación de desvanecimiento
    private void startFadeAnimation() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        timer = new Timer(100, new ActionListener() {
            float alpha = 0.0f;
            boolean fadeIn = alpha == 0.0f;

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
                centerPanel.setBackground(new Color(activeColor.getRed(), activeColor.getGreen(), activeColor.getBlue(), (int) (alpha * 255)));
                if (!fadeIn && alpha == 1.0f) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }
    
    private void startFadeOutAnimation() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        timer = new Timer(100, new ActionListener() {
            float alpha = 1.0f;
            boolean fadeIn = alpha == 1.0f;

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
                centerPanel.setBackground(new Color(activeColor.getRed(), activeColor.getGreen(), activeColor.getBlue(), (int) (alpha * 255)));
                if (!fadeIn && alpha == 0.0f) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    public void close(IPersona nueva) {
        dispose();
        // Crear una nueva instancia de la ventana que deseas abrir
        Ventana nuevaVentana = new Ventana((Starflix.getInstance()).getContenido(),(Persona)nueva);
        nuevaVentana.setVisible(true);
    }
}
