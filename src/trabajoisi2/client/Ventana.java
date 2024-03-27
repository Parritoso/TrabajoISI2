package trabajoisi2.client;


import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import trabajoisi2.Logic.Contenido.IContenido;
import trabajoisi2.personas.IPersona;
import trabajoisi2.personas.Persona;


public class Ventana extends javax.swing.JFrame {

    static Persona getPersona() {
        return (Persona) Persona;
    }
    
    private List<IContenido> Contenido;
    private static IPersona Persona;
    protected IContenido aux;
    private String internalName;
    private String name;
    private ImagePanel panelVerde;
    private JLabel labelEncima;
    private ListIterator it;
    private JLabel titleLabel;
    private String duracion;
    private String Genero;
    private String Suscription;
    private String Descripcion;
    JLabel generoLabel;
    JLabel duracionLabel;
    JLabel suscripcionLabel;
    JTextArea descripcionLabel;
    
    public Ventana(List<IContenido> contenido, Persona persona) {
        this.Contenido = contenido;
        this.Persona = persona;
        
        it = this.Contenido.listIterator();
        
        // Crear el frame principal
        setTitle("Ventana Java Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Crear el panel azul (1/3 de la pantalla)
        JPanel panelAzul = new JPanel();
        panelAzul.setBackground(Color.CYAN); // Cambio de color a CYAN
        panelAzul.setLayout(new BoxLayout(panelAzul, BoxLayout.Y_AXIS));

        // Configurar el tamaño del panel
        int panelWidth = screenWidth / 3;
        panelAzul.setPreferredSize(new Dimension(panelWidth, screenHeight));

        // Espacio en blanco en la parte superior del panel
        panelAzul.add(Box.createVerticalStrut(20)); // Ajusta el valor según sea necesario

        // Crear la imagen (GIF) en el panel azul
        ImageIcon gifIcon = new ImageIcon(this.getClass().getResource("../resources/giphy.gif"));
        JLabel gifLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                // Establecer el color de la línea y dibujar el círculo
                g2d.setColor(this.ColorFactory(Persona.getType().getNivel())); // Color por defecto de la línea
                g2d.setStroke(new BasicStroke(10)); // Grosor de la línea
                g2d.drawOval(10, 10, getWidth() - 20, getHeight() - 20); // Dibujar el círculo
                // Establecer la máscara para recortar el GIF en forma de círculo
                Shape circle = new Ellipse2D.Float(10, 10, getWidth() - 20, getHeight() - 20);
                g2d.setClip(circle);
                // Dibujar el GIF
                super.paintComponent(g2d);
                g2d.dispose();
            }

            private Color ColorFactory(String toString) {
                Color aux = Color.BLACK;
                switch(toString){
                    case "SuscriptorNormal" -> aux = new Color(205,127,50);
                    case "SuscriptorPremium" -> aux = new Color(192,192,192);
                    case "SuscriptorUniversal" -> aux = new Color(255,215,0);
                }
                return aux;
            }
        };
        gifLabel.setIcon(gifIcon);
        gifLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelAzul.add(gifLabel);

         panelAzul.add(Box.createVerticalStrut(10));

        // Etiquetas de texto en el panel azul
        String Usuario = Persona.getIDUsuario();
        JLabel usuarioLabel = new JLabel("@"+ Usuario);
        usuarioLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelAzul.add(usuarioLabel);

        // Línea separadora
        panelAzul.add(Box.createRigidArea(new Dimension(0, 5)));
        panelAzul.add(new JSeparator(SwingConstants.HORIZONTAL));
        panelAzul.add(Box.createRigidArea(new Dimension(0, 5)));

        // Box para contener los botones y centrarlos verticalmente
        Box buttonBox = Box.createVerticalBox();

        // Botones debajo de la línea separadora
        JButton button1 = new JButton("All");
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button1.setMaximumSize(new Dimension(panelWidth - 100, button1.getPreferredSize().height));
        buttonBox.add(button1);
        
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Contenido = Fachada.getAll();
                System.out.println("ALL");
                it = Contenido.listIterator();
               
                aux = (IContenido) it.next();
        
                String internalName_ = aux.getInternalName();
                name = aux.getName();
                duracion = aux.getDuracion();
                Genero = aux.getGenero();
                Suscription = aux.getSuscriptionType().toString();

                ImageIcon imagenEncima = new ImageIcon(getClass().getResource("../resources/"+internalName_+".jpg"));
                Image imagenRedimensionada = imagenEncima.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
                ImageIcon imagenRectangular = new ImageIcon(imagenRedimensionada);
                labelEncima.setIcon(imagenRectangular);
                titleLabel.setText(name);
                titleLabel.setText(name);
                generoLabel.setText("Género: " + Genero);
                duracionLabel.setText("Duración: "+duracion);
                suscripcionLabel.setText("Tipo de Suscripción: "+ Suscription);
                try {
                    panelVerde.setBackgroundImage(internalName_);
                } catch (IOException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                panelVerde.repaint();
                titleLabel.repaint();
                labelEncima.repaint();
            }
        });

        buttonBox.add(Box.createRigidArea(new Dimension(0, 5))); // Reducir la separación entre botones

        JButton button2 = new JButton("Pelis");
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setMaximumSize(new Dimension(panelWidth - 100, button2.getPreferredSize().height));
        buttonBox.add(button2);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               Contenido = Fachada.getPelis();
               System.out.println("Pelis");
               it = Contenido.listIterator();
               
                aux = (IContenido) it.next();
        
                String internalName_ = aux.getInternalName();
                name = aux.getName();
                duracion = aux.getDuracion();
                Genero = aux.getGenero();
                Suscription = aux.getSuscriptionType().toString();

                ImageIcon imagenEncima = new ImageIcon(getClass().getResource("../resources/"+internalName_+".jpg"));
                Image imagenRedimensionada = imagenEncima.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
                ImageIcon imagenRectangular = new ImageIcon(imagenRedimensionada);
                labelEncima.setIcon(imagenRectangular);
                titleLabel.setText(name);
                titleLabel.setText(name);
                generoLabel.setText("Género: " + Genero);
                duracionLabel.setText("Duración: "+duracion);
                suscripcionLabel.setText("Tipo de Suscripción: "+ Suscription);
                try {
                    panelVerde.setBackgroundImage(internalName_);
                } catch (IOException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                panelVerde.repaint();
                titleLabel.repaint();
                labelEncima.repaint();
            }
        });
        
        buttonBox.add(Box.createRigidArea(new Dimension(0, 5))); // Reducir la separación entre botones

        JButton button3 = new JButton("Series");
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setMaximumSize(new Dimension(panelWidth - 100, button3.getPreferredSize().height));
        buttonBox.add(button3);
        
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Contenido = Fachada.getSeries();
                System.out.println("Series");
                it = Contenido.listIterator();
               
                aux = (IContenido) it.next();

                String internalName_ = aux.getInternalName();
                name = aux.getName();
                duracion = aux.getDuracion();
                Genero = aux.getGenero();
                Suscription = aux.getSuscriptionType().toString();

                ImageIcon imagenEncima = new ImageIcon(getClass().getResource("../resources/"+internalName_+".jpg"));
                Image imagenRedimensionada = imagenEncima.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
                ImageIcon imagenRectangular = new ImageIcon(imagenRedimensionada);
                labelEncima.setIcon(imagenRectangular);
                titleLabel.setText(name);
                titleLabel.setText(name);
                generoLabel.setText("Género: " + Genero);
                duracionLabel.setText("Duración: "+duracion);
                suscripcionLabel.setText("Tipo de Suscripción: "+ Suscription);
                try {
                    panelVerde.setBackgroundImage(internalName_);
                } catch (IOException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                panelVerde.repaint();
                titleLabel.repaint();
                labelEncima.repaint();
            }
        });
        
        buttonBox.add(Box.createRigidArea(new Dimension(0, 5))); // Reducir la separación entre botones
        
        JButton button4 = new JButton("LogOut");
        button4.setAlignmentX(Component.CENTER_ALIGNMENT);
        button4.setMaximumSize(new Dimension(panelWidth - 100, button4.getPreferredSize().height));
        buttonBox.add(button4);
        
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                
                Pantalla_2 nuevaVentana = new Pantalla_2();
                nuevaVentana.setVisible(true);
            }
        });
        
        panelAzul.add(buttonBox);
        
        // Agregar un relleno para centrar los botones
        int fillerHeight = (screenHeight - gifIcon.getIconHeight() - 20 - 5 - 10 - buttonBox.getPreferredSize().height - 10 - 5 - 5) / 2;
        panelAzul.add(Box.createVerticalStrut(fillerHeight));

        
        // Línea separadora debajo de los botones
        panelAzul.add(Box.createRigidArea(new Dimension(0, 10)));
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 5)); // Ajustar la altura de la línea
        panelAzul.add(separator);
        panelAzul.add(Box.createRigidArea(new Dimension(0, 5)));

        // Etiquetas debajo de la línea separadora
        JLabel label1 = new JLabel("StarFlix©");
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelAzul.add(label1);

        panelAzul.add(Box.createVerticalStrut(5)); // Espacio entre las etiquetas

        JLabel label2 = new JLabel("By [] & Parritoso");
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelAzul.add(label2);

        // Espacio entre la línea y las etiquetas
        panelAzul.add(Box.createVerticalStrut(5));
        
//####################################################################################################################################################################################################################################################

        aux = (IContenido) it.next();
        
        internalName = aux.getInternalName();
        name = aux.getName();
        duracion = aux.getDuracion();
        Genero = aux.getGenero();
        Suscription = aux.getSuscriptionType().toString();
        Descripcion = aux.getDescripcion();
        
        
        try {
            // Crear el panel verde (2/3 de la pantalla)
            panelVerde = new ImagePanel(internalName);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelVerde.setBackground(Color.GREEN);
        panelVerde.setLayout(new GridLayout(3, 1));

        // Primera sección transparente
        JPanel transparentSection = new JPanel(new BorderLayout());
        transparentSection.setOpaque(false); // Establecer como no opaco para hacerlo transparente
        titleLabel = new JLabel(name);
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40)); 
        titleLabel.setForeground(Color.WHITE);
        transparentSection.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        transparentSection.add(titleLabel, BorderLayout.SOUTH);
        panelVerde.add(transparentSection);

        JLayeredPane section2 = new JLayeredPane();
        ImageIcon imagenFondoOvalo = new ImageIcon(getClass().getResource("../resources/section2.png"));
        Image imagenFondoOvaloRedimensionada = imagenFondoOvalo.getImage().getScaledInstance(2 * screenWidth / 3, screenHeight/3, Image.SCALE_SMOOTH);
        JLabel labelFondoSection2 = new JLabel(new ImageIcon(imagenFondoOvaloRedimensionada));
        labelFondoSection2.setBounds(0, 0, 2 * screenWidth / 3, screenHeight/3);
        section2.add(labelFondoSection2,JLayeredPane.DEFAULT_LAYER);
        
        generoLabel = new JLabel("Género: " + Genero);
        generoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        duracionLabel = new JLabel("Duración: " + duracion);
        duracionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        suscripcionLabel = new JLabel("Tipo de Suscripción: " + Suscription);
        suscripcionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        descripcionLabel = new JTextArea("Descripción: "+Descripcion);
        descripcionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        generoLabel.setForeground(Color.WHITE);
        duracionLabel.setForeground(Color.WHITE);
        suscripcionLabel.setForeground(Color.WHITE);
        descripcionLabel.setForeground(Color.WHITE);
        descripcionLabel.setLineWrap(true);
        descripcionLabel.setWrapStyleWord(true);
        descripcionLabel.setOpaque(false);
        descripcionLabel.setEditable(false);
        
        // Establecer posiciones de los JLabels
        int labelX = 20; // Posición horizontal inicial
        int labelY = 20; // Posición vertical inicial
        int labelSpacing = 30; // Espacio vertical entre los JLabels
        
        generoLabel.setBounds(labelX, labelY, 300, 20); // Tamaño y posición del JLabel de Género
        duracionLabel.setBounds(labelX + 320, labelY, 150, 20); // Tamaño y posición del JLabel de Duración
        suscripcionLabel.setBounds(labelX + 490, labelY, 350, 20); // Tamaño y posición del JLabel de Tipo de Suscripción
        descripcionLabel.setBounds(labelX, labelY + labelSpacing, 400, screenHeight/3);

        
        JButton playButton = new RoundButton("play");
        
        int sectionWidth = 2* screenWidth /3;
        int sectionHeight = screenHeight /3;
        
        int buttonWidth = 80;
        int buttonHeight = 30;
        int buttonX = (sectionWidth - buttonWidth)/2;
        int buttonY = sectionHeight - buttonHeight -30;
        
        playButton.setBounds(buttonX,buttonY,buttonWidth,buttonHeight);
        
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
//                System.out.println("Pelicula vista " + aux.toString());
                if(!Persona.ver(aux)){
                    new VentanaEmergente();
                }
            }
        });
        
        section2.add(playButton, JLayeredPane.PALETTE_LAYER);
        
        section2.add(generoLabel, JLayeredPane.PALETTE_LAYER);
        section2.add(duracionLabel, JLayeredPane.PALETTE_LAYER);
        section2.add(suscripcionLabel, JLayeredPane.PALETTE_LAYER);
        section2.add(descripcionLabel, JLayeredPane.PALETTE_LAYER);
        
        section2.setOpaque(false);
//        section2.setOpaque(false);
        
        panelVerde.add(section2);

        // Tercera sección con imagen recortada        
        JLayeredPane layeredPane = new JLayeredPane();
        panelVerde.add(layeredPane, BorderLayout.CENTER);
//
        // Cargar la imagen de fondo
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("../resources/section3.png"));
        Image imagenFondoRedimensionada = imagenFondo.getImage().getScaledInstance(2 * screenWidth / 3, screenHeight/3, Image.SCALE_SMOOTH);
        JLabel labelFondo = new JLabel(new ImageIcon(imagenFondoRedimensionada));
        labelFondo.setBounds(0, 0, 2 * screenWidth / 3, screenHeight/3);
        layeredPane.add(labelFondo, JLayeredPane.DEFAULT_LAYER);
//
        // Cargar la imagen rectangular encima
        ImageIcon imagenEncima = new ImageIcon(getClass().getResource("../resources/"+internalName+".jpg"));
        Image imagenRedimensionada = imagenEncima.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
        ImageIcon imagenRectangular = new ImageIcon(imagenRedimensionada);
        labelEncima = new JLabel(imagenRectangular);
        labelEncima.setBounds(((2* screenWidth/3)/2)-125, ((screenHeight/3)/2)-175, 250, 350); // Establecer posición y tamaño
        
        // Crear botones de flecha
        JButton btnIzquierda = new JButton("<");
        JButton btnDerecha = new JButton(">");
        
        btnIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               if(!it.hasPrevious()){
                    it = Contenido.listIterator(Contenido.size());
                }
               aux = (IContenido) it.previous();
               String internalName_ = aux.getInternalName();
               name = aux.getName();
               duracion = aux.getDuracion();
               Genero = aux.getGenero();
               Suscription = aux.getSuscriptionType().toString();
               Descripcion = aux.getDescripcion();

               ImageIcon imagenEncima;
               URL imageURL = getClass().getResource("../resources/"+internalName_+".jpg");
               if(imageURL != null){
                   imagenEncima = new ImageIcon(imageURL);
               } else {
                   imageURL = getClass().getResource("../resources/error.gif");
                   if(imageURL != null){
                       imagenEncima = new ImageIcon(imageURL);
                   } else {
                       imagenEncima = new ImageIcon();
                       System.err.println("No se pudo cargar la imagen de error genérica.");
                   }
               }
               Image imagenRedimensionada = imagenEncima.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
               ImageIcon imagenRectangular = new ImageIcon(imagenRedimensionada);
               labelEncima.setIcon(imagenRectangular);
               titleLabel.setText(name);
               generoLabel.setText("Género: " + Genero);
               duracionLabel.setText("Duración: "+duracion);
               suscripcionLabel.setText("Tipo de Suscripción: "+Suscription);
               descripcionLabel.setText("Descripción: "+Descripcion);
                try {
                    panelVerde.setBackgroundImage(internalName_);
                } catch (IOException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
                
               panelVerde.repaint();
               titleLabel.repaint();
               labelEncima.repaint();
            }
        });
        
        btnDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(!it.hasNext()){
                    it = Contenido.listIterator();
                }
                aux = (IContenido) it.next();
        
                String internalName_ = aux.getInternalName();
                name = aux.getName();
                duracion = aux.getDuracion();
                Genero = aux.getGenero();
                Suscription = aux.getSuscriptionType().toString();
                Descripcion = aux.getDescripcion();

                ImageIcon imagenEncima;
                URL imageURL = getClass().getResource("../resources/"+internalName_+".jpg");
                if(imageURL != null){
                   imagenEncima = new ImageIcon(imageURL);
                } else {
                    imageURL = getClass().getResource("../resources/error.gif");
                    if(imageURL != null){
                       imagenEncima = new ImageIcon(imageURL);
                    } else {
                       imagenEncima = new ImageIcon();
                       System.err.println("No se pudo cargar la imagen de error genérica.");
                    }
                }
                Image imagenRedimensionada = imagenEncima.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
                ImageIcon imagenRectangular = new ImageIcon(imagenRedimensionada);
                labelEncima.setIcon(imagenRectangular);
                titleLabel.setText(name);
                titleLabel.setText(name);
                generoLabel.setText("Género: " + Genero);
                duracionLabel.setText("Duración: "+duracion);
                suscripcionLabel.setText("Tipo de Suscripción: "+ Suscription);
                descripcionLabel.setText("Descripción: "+Descripcion);
                try {
                    panelVerde.setBackgroundImage(internalName_);
                } catch (IOException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                panelVerde.repaint();
                titleLabel.repaint();
                labelEncima.repaint();
            }
        });
        
        JPanel panelBtnIzquierda = new JPanel(new GridLayout(1,2));
        JPanel panelBtnDerecha = new JPanel(new GridLayout(1,2));
        
        panelBtnDerecha.setOpaque(false);
        panelBtnIzquierda.setOpaque(false);
        
        panelBtnIzquierda.add(new JLabel());
        panelBtnIzquierda.add(btnIzquierda);
        
        panelBtnDerecha.add(btnDerecha);
        panelBtnDerecha.add(new JLabel());
        
        
        JPanel panelBotones = new JPanel(new GridLayout(3,3));
        panelBotones.setOpaque(false);
        panelBotones.add(new JLabel());
        panelBotones.add(new JLabel());
        panelBotones.add(new JLabel());
        panelBotones.add(panelBtnIzquierda);
        panelBotones.add(new JLabel());
        panelBotones.add(panelBtnDerecha);
        panelBotones.add(new JLabel());
        panelBotones.add(new JLabel());
        panelBotones.add(new JLabel());
        
        layeredPane.add(labelEncima,JLayeredPane.PALETTE_LAYER);
        
        panelBotones.setBounds(0, 0, (2*screenWidth/3), (screenHeight/3)); // Establecer posición y tamaño
        
        layeredPane.add(panelBotones,JLayeredPane.POPUP_LAYER);
        
        panelVerde.add(layeredPane, BorderLayout.CENTER);
        
        panelVerde.setPreferredSize(new Dimension(2 * screenWidth / 3, screenHeight));

        // Añadir los paneles a la ventana
        getContentPane().add(panelAzul, BorderLayout.WEST);
        getContentPane().add(panelVerde, BorderLayout.CENTER);

        // Ajustar la ventana y hacerla visible
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void setPersona(IPersona Persona){
        this.Persona = Persona;
    }
    
    class RoundButton extends JButton {
        public RoundButton(String label) {
            super(label);
            // Hacer el botón transparente
            setContentAreaFilled(false);
            // Establecer el tamaño del botón
            setPreferredSize(new Dimension(40, 40));
        }

        // Método para dibujar el botón como un círculo
        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isArmed()) {
                g.setColor(Color.lightGray);
            } else {
                g.setColor(getBackground());
            }
            g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
            super.paintComponent(g);
        }

        // Método para pintar el borde del botón
        @Override
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
        }

        // Método para detectar si el punto está dentro del botón
        Shape shape;

        @Override
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
            }
            return shape.contains(x, y);
        }
    }
    
    class ImagePanel extends JPanel {
        private BufferedImage backgroundImage;

        public ImagePanel(String internalName) throws IOException {
            try {
                // Cargar la imagen de fondo inicial
                URL imageURL = getClass().getResource("../resources/"+internalName+".jpg");
                if(imageURL != null){
                   backgroundImage = ImageIO.read(getClass().getResource("../resources/"+internalName+".jpg"));
                } else {
                    imageURL = getClass().getResource("../resources/error.gif");
                    if(imageURL != null){
                       backgroundImage = ImageIO.read(getClass().getResource("../resources/error.gif"));
                    } else {
                       System.err.println("No se pudo cargar la imagen de error genérica.");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                // Dibujar la imagen de fondo
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }

        public void setBackgroundImage(String internalName) throws IOException {
            try {
                // Cargar una nueva imagen de fondo
                URL imageURL = getClass().getResource("../resources/"+internalName+".jpg");
                if(imageURL != null){
                   backgroundImage = ImageIO.read(getClass().getResource("../resources/"+internalName+".jpg"));
                } else {
                    imageURL = getClass().getResource("../resources/error.gif");
                    if(imageURL != null){
                       backgroundImage = ImageIO.read(getClass().getResource("../resources/error.gif"));
                    } else {
                       System.err.println("No se pudo cargar la imagen de error genérica.");
                    }
                }
                // Repintar el panel para reflejar el cambio
                repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public class VentanaEmergente {
        public VentanaEmergente() {
            // Crear el marco principal
            JFrame frame = new JFrame("Mensaje de Disponibilidad");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Crear el panel con el mensaje
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Lo sentimos, esta película no está disponible para tu nivel de suscripción.");
            panel.add(label);

            // Crear el botón para cerrar la ventana
            JButton closeButton = new JButton("Cerrar");
            closeButton.addActionListener(e -> frame.dispose());
            panel.add(closeButton);

            // Agregar el panel al marco
            frame.getContentPane().add(panel);

            // Ajustar el tamaño del marco y hacerlo visible
            frame.setSize(400, 150);
            frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
            frame.setVisible(true);
        }
    }
}