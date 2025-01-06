package Juego.Modificaciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Boton extends JButton {
    
    public Boton(String texto){
        super(texto);
        setForeground(Color.white);
        try {
            // Asegúrate de que la ruta sea correcta según la ubicación de tu archivo .ttf
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("PressStart2P-Regular.ttf"))
                                .deriveFont(10f); // Tamaño de la fuente
            setFont(customFont); // Establecer la fuente en el botón
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            setFont(new Font("Arial", Font.PLAIN, 24)); // Fuente alternativa en caso de error
        }
        setFocusPainted(false); 
        setContentAreaFilled(false); 
        setBorderPainted(false);
        setOpaque(false); 
        setBorder(new EmptyBorder(5, 10, 5, 10));
    }
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50,50);
        g2.setColor(Color.decode("#fcfb8a"));
        g2.fillRoundRect(5, 2, getWidth() - 12, getHeight() - 5, 40,80);
        g2.setColor(Color.decode("#5a8aff"));
        g2.fillRoundRect(10, 5, getWidth() - 22, getHeight() - 12, 40,80);
        g2.setColor(Color.decode("#1657f8"));
        g2.fillRoundRect(15, 8, getWidth() - 32, getHeight() - 18, 40,80);
        g2.setColor(Color.black);
        g2.drawRoundRect(10, 5, getWidth() - 22, getHeight() - 12, 40, 80);

        g2.dispose();
        super.paintComponent(g);
    }
}
