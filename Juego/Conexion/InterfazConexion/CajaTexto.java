package Juego.Conexion.InterfazConexion;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CajaTexto extends JTextField {

    private Color color;
    public CajaTexto(Color color) {

        setFont(new Font("Arial",Font.BOLD,15));
        setForeground(color);
        setOpaque(false); 
        setBorder(new EmptyBorder(5, 10, 5, 10));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the rounded background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15,15);

        // Draw the border
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);

        g2.dispose();
        super.paintComponent(g);
    }


    @Override
    public void setBorder(Border border) {
        // Prevent setting a new border to keep the custom look
        if (border instanceof EmptyBorder) {
            super.setBorder(border);
        }
    }
}
