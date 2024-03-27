/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi2.client.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import trabajoisi2.client.Fachada;
import trabajoisi2.client.Pantalla_2;
import trabajoisi2.personas.Persona;

/**
 *
 * @author Parri
 */
public class PanelGlowingGradient1 extends JComponent{
    
    private int shadowSize = 20;
    private int borderSize = 2;
    private Color gradientColor2 = new Color(255, 245, 0);
    private Color gradientColor1 = new Color(0, 185, 210);
    private Color BackgroundLight = new Color(35,35,35);
    private BufferedImage imageRender;
    private JTextField nombreField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton registrarButton;
    private JFrame Ventana;
    
    public PanelGlowingGradient1(JFrame ventana) {
        this.Ventana= ventana;
        setBorder(new EmptyBorder(shadowSize,shadowSize,shadowSize,shadowSize));
        setBackground(new Color(20,20,20));
        
        setLayout(new GridLayout(2, 1,10,10));
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(0,2,10,10));

        
        JLabel nombreLabel = createGradientLabel("Nombre:", gradientColor1, gradientColor2);
        nombreLabel.setForeground(gradientColor1);

        nombreField = new CustomTextField(15,gradientColor1,gradientColor2);
        nombreField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JLabel emailLabel = createGradientLabel("Correo electrónico:", gradientColor1, gradientColor2);
        emailLabel.setForeground(gradientColor2);

        emailField = new CustomTextField(15,gradientColor1,gradientColor2);
        emailField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JLabel passwordLabel = createGradientLabel("Contraseña:", gradientColor1, gradientColor2);
        passwordLabel.setForeground(gradientColor1);

        passwordField = new CustomPasswordField(15,gradientColor1,gradientColor2);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        registrarButton = new CustomButton("Iniciar Sesion");

        panel.add(emailLabel);

        panel.add(emailField);

        panel.add(passwordLabel);
        panel.add(passwordField);
        
        registrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // Obtener los valores de los campos de texto
                String nombre = nombreField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                
                Object[] aux = Fachada.Login(email,password);
                
                if((boolean)aux[0]){
                    if(ventana instanceof Pantalla_2 pantalla){
                        pantalla.close((Persona)aux[3]);
                    }
                }else{
                    
                }
            }
        });
        
        add(panel);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue()); // Espacio flexible
        buttonPanel.add(registrarButton);
        registrarButton.setPreferredSize(new Dimension(200, 60));
        buttonPanel.add(Box.createHorizontalGlue()); // Espacio flexible
        add(buttonPanel);
    }
    
//    private JPanel createPanelWithComponent(Component comp1, Component comp2) {
//    JPanel panel = new JPanel();
//    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
//    panel.add(Box.createHorizontalGlue());
//    panel.add(comp1);
//    panel.add(Box.createRigidArea(new Dimension(10, 0)));
//    panel.add(comp2);
//    panel.add(Box.createHorizontalGlue());
//    return panel;
//}
    
    // Método para crear un JLabel con efecto de degradado en el texto
    private JLabel createGradientLabel(String text, Color color1, Color color2) {
    JLabel label = new JLabel(text) {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            int w = getWidth();
            int h = getHeight();
            g2d.setFont(getFont().deriveFont(Font.PLAIN, 18f)); // Ajustar el tamaño del texto
            FontMetrics fm = g2d.getFontMetrics();
            int lineHeight = fm.getHeight();
            int y = lineHeight; // Comenzar en la primera línea de texto

            // Crear un gradiente para el texto
            Paint gradient = new LinearGradientPaint(0, 0, w, h, new float[]{0.0f, 1.0f}, new Color[]{color1, color2});
            g2d.setPaint(gradient);

            // Iterar sobre cada línea de texto
            for (String line : text.split("\n")) {
                // Calcular la anchura de la línea de texto actual
                int lineWidth = fm.stringWidth(line);
                // Calcular la posición x para centrar el texto
                int x = (w - lineWidth) / 2;

                // Dibujar la línea de texto actual
                g2d.drawString(line, x, y);

                // Mover a la siguiente línea de texto
                y += lineHeight;
            }
            g2d.dispose(); // Liberar recursos
        }
    };
    label.setHorizontalAlignment(SwingConstants.CENTER); // Alinear el texto al centro horizontalmente
    label.setVerticalAlignment(SwingConstants.CENTER); // Alinear el texto al centro verticalmente
    label.setForeground(Color.WHITE); // Establecer el color del texto en blanco
    return label;
}
    
    public int getShadowSize() {
        return shadowSize;
    }

    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
        setBorder(new EmptyBorder(shadowSize, shadowSize, shadowSize, shadowSize));
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
        refresh();
    }

    public Color getGradientColor1() {
        return gradientColor1;
    }

    public void setGradientColor1(Color gradientColor1) {
        this.gradientColor1 = gradientColor1;
        refresh();
    }

    public Color getGradientColor2() {
        return gradientColor2;
    }

    public void setGradientColor2(Color gradientColor2) {
        this.gradientColor2 = gradientColor2;
        refresh();
    }

    public Color getBackgroundLight() {
        return BackgroundLight;
    }

    public void setBackgroundLight(Color backgroundLight) {
        this.BackgroundLight = backgroundLight;
        refresh();
    }
    
    private void refresh() {
        createImageRender();
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        if(imageRender!=null){
            Graphics2D g2 = (Graphics2D)g.create();
            g2.drawImage(imageRender, 0, 0, null);
            g2.dispose();
        }
        super.paintComponent(g);
    }
    
    private void createImageRender() {
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            Insets inset = getInsets();
            imageRender = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = imageRender.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //  Draw shadow left
            g2.drawImage(createShadow(width, height, inset, gradientColor1, true), 0, 0, null);
            //  Draw shadow right
            g2.drawImage(createShadow(width, height, inset, gradientColor2, false), 0, 0, null);
            Area area = new Area(new Rectangle2D.Double(inset.left, inset.top, width - inset.left - inset.right, height - inset.top - inset.bottom));
            g2.setColor(getBackground());
            g2.fill(area);
            area.subtract(new Area(new Rectangle2D.Double(width / 2, 0, width / 2, height)));
            g2.setColor(BackgroundLight);
            g2.fill(area);
            g2.drawImage(createBorder(width, height, inset), 0, 0, null);
            g2.dispose();
        }
    }
    
    private BufferedImage createShadow(int width, int height, Insets inset, Color color, boolean leftShadow) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        Path2D p = new Path2D.Double();
        double w = width - inset.left - inset.right;
        double h = height - inset.top - inset.bottom;
        if (leftShadow) {
            p.moveTo(0, 0);
            p.lineTo(w, h);
            p.lineTo(0, h);
        } else {
            p.moveTo(0, 0);
            p.lineTo(w, 0);
            p.lineTo(w, h);
        }
        g2.fill(p);
        g2.dispose();
        return new ShadowRenderer(shadowSize, 0.45f, color).createShadow(img);
    }
    
    private BufferedImage createBorder(int width, int height, Insets inset) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = width - inset.left - inset.right;
        int h = height - inset.top - inset.bottom;
        Color tranColor1 = toTranslucentColor(gradientColor1);
        Color tranColor2 = toTranslucentColor(gradientColor2);
        //  Draw Left
        g2.setPaint(new GradientPaint(0, h * 0.1f, tranColor1, 0, h, gradientColor1));
        g2.fill(new Rectangle2D.Double(inset.left, inset.top, borderSize, h));
        //  Draw Bottom
        g2.setPaint(new GradientPaint(0, 0, gradientColor1, w * 0.9f, 0, tranColor1));
        g2.fill(new Rectangle2D.Double(inset.left, height - inset.bottom - borderSize, w, borderSize));
        //  Draw Top
        g2.setPaint(new GradientPaint(w * 0.1f, 0, tranColor2, w, 0, gradientColor2));
        g2.fill(new Rectangle2D.Double(inset.left, inset.top, w, borderSize));
        //  Draw Right
        g2.setPaint(new GradientPaint(0, 0, gradientColor2, 0, h * 0.9f, tranColor2));
        g2.fill(new Rectangle2D.Double(width - inset.right - borderSize, inset.top, borderSize, h));
        g2.dispose();
        return img;
    }

    private Color toTranslucentColor(Color color) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), 0);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        createImageRender();
        //  Update or create new image render when componet has resize or change size
    }
    
    public class CustomButton extends JButton {

    private Color bgColor = new Color(30, 30, 30);
    private Color textColor = Color.WHITE;
    private Color hoverColor = new Color(50, 50, 50);
    private Color borderColor = new Color(100, 100, 100);
    private int arcWidth = 15;
    private int arcHeight = 15;

    public CustomButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setForeground(textColor);
        setFont(new Font("Arial", Font.BOLD, 16));
        setFocusPainted(false);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                setBackground(hoverColor);
            }

            public void mouseExited(MouseEvent evt) {
                setBackground(bgColor);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape border = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
        g2.setColor(getBackground());
        g2.fill(border);

        g2.setColor(borderColor);
        g2.draw(border);

        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No queremos que se pinte el borde predeterminado
    }
    }
    
    public class CustomTextField extends JTextField {

    private Color textColor = Color.WHITE;
    private Color lineColor = new Color(70, 70, 70); // Gris oscuro
    private Color focusedLineColor = gradientColor1; // Rojo cuando enfocado
    private Color unfocusedLineColor = gradientColor2;
    private int lineHeight = 3; // Grosor de la línea
    private boolean isSelected = false;
    private Timer timer;

    public CustomTextField(int columns,Color gradientColor1, Color gradientColor2) {
        super(columns);
        this.focusedLineColor = gradientColor1;
        this.unfocusedLineColor = gradientColor2;
        setOpaque(false);
        setForeground(textColor);
        setCaretColor(textColor);
        setFont(new Font("Arial", Font.PLAIN, 16));
        setBorder(new EmptyBorder(0, 0, lineHeight, 0)); // Establecemos un borde vacío en la parte inferior

        // Agregamos un listener de foco para cambiar el color de la línea
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                isSelected = true;
                startAnimation();
            }

            @Override
            public void focusLost(FocusEvent e) {
                isSelected = false;
                stopAnimation();
                lineColor = new Color(70, 70, 70); // Cambiar a gris oscuro cuando pierde el foco
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        // No pintamos el fondo
        super.paintComponent(g);

        // Dibujamos la línea inferior
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(lineColor);
        g2d.fillRect(0, getHeight() - lineHeight, getWidth(), lineHeight);
    }

    // Método para iniciar la animación de cambio de color de la línea
    private void startAnimation() {
        timer = new Timer(10, new ActionListener() {
            float progress = 0;
            long startTime = System.currentTimeMillis();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSelected) {
                    long currentTime = System.currentTimeMillis();
                    long elapsedTime = currentTime - startTime;
                    if (elapsedTime >= 1000) {
                        progress = 1;
                    } else {
                        progress = (float) elapsedTime / 1000;
                    }
                    int red = (int) (lineColor.getRed() + (focusedLineColor.getRed() - lineColor.getRed()) * progress);
                    int green = (int) (lineColor.getGreen() + (focusedLineColor.getGreen() - lineColor.getGreen()) * progress);
                    int blue = (int) (lineColor.getBlue() + (focusedLineColor.getBlue() - lineColor.getBlue()) * progress);
                    lineColor = new Color(red, green, blue);
                    repaint();
                    if (progress >= 1) {
                        startTime = System.currentTimeMillis();
                        Color tempColor = focusedLineColor;
                        focusedLineColor = unfocusedLineColor;
                        unfocusedLineColor = tempColor;
                    }
                } else {
                    timer.stop();
                    lineColor = unfocusedLineColor;
                    repaint();
                }
            }
        });
        timer.start();
    }

    // Método para detener la animación
    private void stopAnimation() {
        if (timer != null) {
            timer.stop();
        }
    }


    }
    
    
public class CustomPasswordField extends JPasswordField {

    private Color textColor = Color.WHITE;
    private Color lineColor = new Color(70, 70, 70); // Gris oscuro
    private Color focusedLineColor = gradientColor1; // Rojo cuando enfocado
    private Color unfocusedLineColor = gradientColor2; // Azul cuando no enfocado
    private int lineHeight = 3; // Grosor de la línea
    private boolean isSelected = false;
    private Timer timer;

    public CustomPasswordField(int columns, Color gradientColor1, Color gradientColor2) {
        super(columns);
        this.focusedLineColor = gradientColor1;
        this.unfocusedLineColor = gradientColor2;
        setOpaque(false);
        setForeground(textColor);
        setCaretColor(textColor);
        setFont(new Font("Arial", Font.PLAIN, 16));
        setBorder(new EmptyBorder(0, 0, lineHeight, 0)); // Establecemos un borde vacío en la parte inferior

        // Agregamos un listener de foco para cambiar el color de la línea
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                isSelected = true;
                startAnimation();
            }

            @Override
            public void focusLost(FocusEvent e) {
                isSelected = false;
                stopAnimation();
                lineColor = new Color(70, 70, 70); // Cambiar a gris oscuro cuando pierde el foco
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        // No pintamos el fondo
        super.paintComponent(g);

        // Dibujamos la línea inferior
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(lineColor);
        g2d.fillRect(0, getHeight() - lineHeight, getWidth(), lineHeight);
    }

    // Método para iniciar la animación de cambio de color de la línea
    private void startAnimation() {
        timer = new Timer(10, new ActionListener() {
            float progress = 0;
            long startTime = System.currentTimeMillis();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSelected) {
                    long currentTime = System.currentTimeMillis();
                    long elapsedTime = currentTime - startTime;
                    if (elapsedTime >= 1000) {
                        progress = 1;
                    } else {
                        progress = (float) elapsedTime / 1000;
                    }
                    int red = (int) (lineColor.getRed() + (focusedLineColor.getRed() - lineColor.getRed()) * progress);
                    int green = (int) (lineColor.getGreen() + (focusedLineColor.getGreen() - lineColor.getGreen()) * progress);
                    int blue = (int) (lineColor.getBlue() + (focusedLineColor.getBlue() - lineColor.getBlue()) * progress);
                    lineColor = new Color(red, green, blue);
                    repaint();
                    if (progress >= 1) {
                        startTime = System.currentTimeMillis();
                        Color tempColor = focusedLineColor;
                        focusedLineColor = unfocusedLineColor;
                        unfocusedLineColor = tempColor;
                    }
                } else {
                    timer.stop();
                    lineColor = unfocusedLineColor;
                    repaint();
                }
            }
        });
        timer.start();
    }

    // Método para detener la animación
    private void stopAnimation() {
        if (timer != null) {
            timer.stop();
        }
    }
}
}
