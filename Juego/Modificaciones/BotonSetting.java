package Juego.Modificaciones;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class BotonSetting extends JButton{
    

    public BotonSetting(){
        setContentAreaFilled(false); 
        setBorderPainted(false);
        setOpaque(false); 
    }
    
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        super.paintComponent(g2);
        g2.setColor(Color.GRAY);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8,8);
        g2.setColor(Color.black);
        g2.drawRoundRect(0, 0, getWidth(), getHeight(), 8,8);
        //g.drawLine(getX(), getY(), getWidth(), getHeight());
       // g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        //g.drawRect(1, 1, getWidth()-3, getHeight()-2);
        //g.drawLine(5, 5, 15, 5);
        //g.drawLine(5, 10, 15, 10);
        //g.drawLine(5, 15, 15, 15);
        g2.setColor(Color.WHITE);
        g2.fillRect(12, 7, 12, 4);
        g2.fillRect(12, 13, 12, 4);
        g2.fillRect(12, 19, 12,4);
        g2.fillOval(7, 7, 4, 4);
        g2.fillOval(7, 13, 4, 4);
        g2.fillOval(7, 19, 4, 4);

        g2.setColor(Color.black);
        g2.drawRect(12, 7, 11, 4);
        g2.drawRect(12, 13, 11, 4);
        g2.drawRect(12, 19, 11, 4);
        g2.drawOval(6, 7, 5, 4);
        g2.drawOval(6, 13, 5, 4);
        g2.drawOval(6, 19, 5, 4);
    }    
}
