package Juego.Armas;

import java.awt.*;

import Juego.Personaje.Jugador;

public class Bala {

    private int ladoDisparo;
    private double x,puntoX;
    private double y,puntoY;

    public Bala(double x, double y, int ladoDisparo,int puntoX,int puntoY){
        this.x = x;
        this.y = y;
        this.ladoDisparo = ladoDisparo;
        this.puntoX = puntoX;
        this.puntoY = puntoY;
    }


    public void bala(Jugador player,int movimiento){
        double dx = puntoX - player.getX(); // Diferencia en X
        double dy = puntoY - player.getY(); // Diferencia en Y

        // Calcular la magnitud del vector
        double magnitude = Math.sqrt(dx * dx + dy * dy);

        // Calcular el vector dirección unitario
        double directionX = dx / magnitude;
        double directionY = dy / magnitude;

        // Incrementar la posición de la bala
        x += directionX * movimiento; // Movimiento en X
        if (puntoY>300) {
            y += directionY * movimiento - 1;
        }else y+= directionY * movimiento - 2;
    }

    public void bala2(Jugador player,int movimiento){
        double dx = puntoX - player.getX(); // Diferencia en X
        double dy = puntoY - player.getY(); // Diferencia en Y

        // Calcular la magnitud del vector
        double magnitude = Math.sqrt(dx * dx + dy * dy);

        // Calcular el vector dirección unitario
        double directionX = dx / magnitude;
        double directionY = dy / magnitude;

        // Incrementar la posición de la bala
        x += directionX * movimiento; // Movimiento en X
        if (puntoY>300) {
            y += directionY * movimiento - 1;
        }else y+= directionY * movimiento -2 ;
    }

    public void movimientoBala(int movimiento,Jugador player){
        switch (ladoDisparo) {
            case 1:
                bala(player,movimiento);
                break;
            case 2:
                bala2(player,movimiento);
                break;
            default:
                break;
        }
    }

    public int getLadoDisparo() {
        return ladoDisparo;
    }

    public void setLadoDisparo(int ladoDisparo) {
        this.ladoDisparo = ladoDisparo;
    }

    public Rectangle getHitboxBala(){
        return new Rectangle((int)x,(int) y, 6,3);
    }

    public void paintBala(Graphics g){
        int x = (int) this.getX();
        int y = (int) this.getY();
        g.setColor(Color.black);
        g.fillRect(x, y, 5,3);
        g.fillRect(x + 5, y + 1, 1, 1);
        g.setColor(Color.ORANGE);
        g.fillRect(x+1, y+1, 4, 1);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
