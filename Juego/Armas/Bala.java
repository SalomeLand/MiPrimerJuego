package Juego.Armas;

import java.awt.*;

public class Bala {

    private int ladoDisparo;
    private int x;
    private int y;

    public Bala(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void movimiento(int movimiento1){
        x += movimiento1;
    }

    public int getLadoDisparo() {
        return ladoDisparo;
    }

    public void setLadoDisparo(int ladoDisparo) {
        this.ladoDisparo = ladoDisparo;
    }

    public Rectangle getHitboxBala(){
        return new Rectangle(x, y, 6,3);
    }

    public void paintBala(Graphics g){
        g.setColor(Color.black);
        g.fillRect(x, y, 5,3);
        g.fillRect(x + 5, y + 1, 1, 1);
        g.setColor(Color.ORANGE);
        g.fillRect(x+1, y+1, 4, 1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}