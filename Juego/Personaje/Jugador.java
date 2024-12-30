package Juego.Personaje;
import java.awt.*;

public class Jugador extends Personaje {
    private boolean swordSwinging=false;
    private int ladoEspada = 0;
    private boolean inmunidad = false;

    public Jugador(int x, int y,int salud) {
        super(x, y, 40, 40,salud);
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void attack(Graphics g) {
        g.fillRect(x, y, width, height);
        if (swordSwinging) { 
            if (ladoEspada == 1) {
                paintEspada2(g);
            }else if(ladoEspada == 2) paintEspada(g);
        }
    }
    
    public void setInmunidad(boolean inmunidad) {
        this.inmunidad = inmunidad;
    }

    public void setSwordSwinging(boolean swinging) {
        this.swordSwinging = swinging;
    }

    public Rectangle getSwordBounds() {
        if (swordSwinging) {
            if (ladoEspada == 1) {
                return new Rectangle(x - 24, y + height / 4, 25, 15);
            }else if(ladoEspada == 2) 
            return new Rectangle(x + width, y + height / 4, 25, 15);
        }
        return null;
    }

    public void setLadoEspada(int lado){
        ladoEspada = lado;
    }

    public int getLadoEspada(){
        return ladoEspada;
    }

    public void paintEspada(Graphics g) {
        int t = 1;
        int x3 = x + width;
        g.setColor(Color.BLACK);
        int y2 = y + height / 4;
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
    public void paintEspada2(Graphics g) {
        int t = 1;
        int x3 = x - 24;
        g.setColor(Color.BLACK);
        int y2 = y + height / 4;
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

    public boolean getInmunidad() {
        return inmunidad;
    }
    
}