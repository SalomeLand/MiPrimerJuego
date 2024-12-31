package Juego.Armas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Juego.Personaje.Jugador;

public class Espada extends Arma {
    private boolean swordSwinging;
    private int contador;
    public Espada(int velocidad,int daño,int width, int height, int x1, int y){
        super(velocidad, daño, width, height, x1, y);
    }
    
    public Rectangle getSwordBounds() {
        if (swordSwinging) {
            if (lado == 1) {
                return new Rectangle(x - 24, y , width, height);
            }else if(lado == 2) 
            return new Rectangle(x, y , width, height);
        }
        return null;
    }

    public void follow(Jugador player){
        y = player.getY() + player.getHeight() / 4 + 10;
        x = player.getX() + 10;
    }

    public void atacar(Graphics g){
        if (swordSwinging) { 
            if (lado == 2) {
                paintEspada(g);
            }else if(lado == 1) {
                paintEspada2(g);
            }
        }
    }

    //Dibujar espada a la derecha
    public void paintEspada(Graphics g) {
        int t = 1;
        int x3 = x;
        g.setColor(Color.BLACK);
        int y2 = y ;
        g.fillRect((x3 + 1) * t, (y2 + 4) * t, 3 * t, 1 * t);
        g.fillRect((x3 + 0) * t, (y2 + 5) * t, 8 * t, 3 * t);
        g.fillRect((x3 + 1) * t, (y2 + 8) * t, 3 * t, 1 * t);
        g.fillRect((x3 + 8) * t, (y2 + 2) * t, 3 * t, 9 * t);
        g.fillRect((x3 + 9) * t, (y2 + 0) * t, 3 * t, 2 * t);
        g.fillRect((x3 + 9) * t, (y2 + 11) * t, 3 * t, 2 * t);
    
        g.setColor(Color.ORANGE);
        g.fillRect((x3 + 2) * t, (y2 + 5) * t, 1 * t, 3 * t);
        g.fillRect((x3 + 1) * t, (y2 + 6) * t, 3 * t, 1 * t);
    
        g.setColor(Color.BLUE);
        g.fillRect((x3 + 5) * t, (y2 + 6) * t, 3 * t, 1 * t);
        g.fillRect((x3 + 8) * t, (y2 + 5) * t, 2 * t, 3 * t);
        g.fillRect((x3 + 9) * t, (y2 + 2) * t, 1 * t, 9 * t);
        g.fillRect((x3 + 10) * t, (y2 + 1) * t, 1 * t, 1 * t);
        g.fillRect((x3 + 10) * t, (y2 + 11) * t, 1 * t, 1 * t);
    
        g.setColor(Color.GRAY);
        g.fillRect((x3 + 11) * t, (y2 + 5) * t, 13 * t, 3 * t);
    
        g.setColor(Color.BLACK);
        g.fillRect((x3 + 11) * t, (y2 + 4) * t, 11 * t, 1 * t);
        g.fillRect((x3 + 11) * t, (y2 + 8) * t, 11 * t, 1 * t);
        g.fillRect((x3 + 22) * t, (y2 + 5) * t, 2 * t, 1 * t);
        g.fillRect((x3 + 22) * t, (y2 + 7) * t, 2 * t, 1 * t);
        g.fillRect((x3 + 24) * t, (y2 + 6) * t, 1 * t, 1 * t);
    }
    //Dibujar la espada a la izquierda
    public void paintEspada2(Graphics g) {
        int t = 1;
        int x3 = x - 24;
        g.setColor(Color.BLACK);
        int y2 = y ;
        g.fillRect((x3 - 1 + 25 - 3) * t, (y2 + 4) * t, 3 * t, 1 * t);
        g.fillRect((x3 + 25 - 8) * t, (y2 + 5) * t, 8 * t, 3 * t);
        g.fillRect((x3 - 1 + 25 - 3) * t, (y2 + 8) * t, 3 * t, 1 * t);
        g.fillRect((x3 - 8 + 25 -3) * t, (y2 + 2) * t, 3 * t, 9 * t);
        g.fillRect((x3 - 9 + 25 -3) * t, (y2 + 0) * t, 3 * t, 2 * t);
        g.fillRect((x3 - 9 + 25 - 3) * t, (y2 + 11) * t, 3 * t, 2 * t);
    
        g.setColor(Color.ORANGE);
        g.fillRect((x3 - 2 + 25 - 1) * t, (y2 + 5) * t, 1 * t, 3 * t);
        g.fillRect((x3 - 1 +25 - 3) * t, (y2 + 6) * t, 3 * t, 1 * t);
    
        g.setColor(Color.BLUE);
        g.fillRect((x3 - 5+25 -3) * t, (y2 + 6) * t, 3 * t, 1 * t);
        g.fillRect((x3 - 8+25 -2) * t, (y2 + 5) * t, 2 * t, 3 * t);
        g.fillRect((x3 - 9+25 -1) * t, (y2 + 2) * t, 1 * t, 9 * t);
        g.fillRect((x3 - 10+25 - 1) * t, (y2 + 1) * t, 1 * t, 1 * t);
        g.fillRect((x3 - 10+25 - 1) * t, (y2 + 11) * t, 1 * t, 1 * t);
    
        g.setColor(Color.GRAY);
        g.fillRect((x3 - 11+25 - 13) * t, (y2 + 5) * t, 13 * t, 3 * t);
    
        g.setColor(Color.BLACK);
        g.fillRect((x3 - 11+25 - 11) * t, (y2 + 4) * t, 11 * t, 1 * t);
        g.fillRect((x3 - 11+25 - 11) * t, (y2 + 8) * t, 11 * t, 1 * t);
        g.fillRect((x3 - 22+25 - 2) * t, (y2 + 5) * t, 2 * t, 1 * t);
        g.fillRect((x3 - 22+25 - 2) * t, (y2 + 7) * t, 2 * t, 1 * t);
        g.fillRect((x3 - 24+25 - 1) * t, (y2 + 6) * t, 1 * t, 1 * t);
    }

    public boolean isSwordSwinging() {
        return swordSwinging;
    }

    public void setSwordSwinging(boolean swordSwinging) {
        this.swordSwinging = swordSwinging;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
}
