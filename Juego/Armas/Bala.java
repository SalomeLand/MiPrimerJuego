package Juego.Armas;

import java.awt.*;

import Juego.Personaje.Jugador;

public class Bala {

    private int ladoDisparo;
    private double x,x2,puntoX;
    private double y,y2,puntoY;

    public Bala(double x, double y, int ladoDisparo,int puntoX,int puntoY){
        this.x = x;
        this.y = y;
        this.ladoDisparo = ladoDisparo;
        this.puntoX = puntoX;
        this.puntoY = puntoY;
        this.x2 = x;
        this.y2 = y;
    }


    public void bala(int movimiento){
        double dx = puntoX - x; // Diferencia en X
        double dy = puntoY - y; // Diferencia en Y

        // Calcular la magnitud del vector
        double magnitude = Math.sqrt(dx * dx + dy * dy);

        // Calcular el vector dirección unitario
        double directionX = dx / magnitude;
        double directionY = dy / magnitude;

        // Incrementar la posición de la bala
        x2 += directionX * movimiento; // Movimiento en X
        y2 += directionY * movimiento ;
    }

    public void bala2(int movimiento){
        double dx = puntoX - x; // Diferencia en X
        double dy = puntoY - y; // Diferencia en Y

        // Calcular la magnitud del vector
        double magnitude = Math.sqrt(dx * dx + dy * dy);

        // Calcular el vector dirección unitario
        double directionX = dx / magnitude;
        double directionY = dy / magnitude;

        // Incrementar la posición de la bala
        x2 += directionX * movimiento; // Movimiento en X
        y2 += directionY * movimiento ;
    }

    public void movimientoBala(int movimiento){
        switch (ladoDisparo) {
            case 2:
                bala(movimiento);
                break;
            case 1:
                bala2(movimiento);
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
        return new Rectangle((int)x2,(int) y2, 6,3);
    }

    public void paintBala(Graphics g){
        if (puntoY < 300 ) {
            paintBalaIzquierdaArriba(g);
        }else if(ladoDisparo == 1) paintBalaDerecha(g);
        else if(ladoDisparo == 2) paintBalaIzquierda(g);
    }

    public void paintBalaDerecha(Graphics g){
        int x2 = (int) this.getX();
        int y2 = (int) this.getY();
        g.setColor(Color.black);
        g.fillRect(x2, y2, 5,3);
        g.fillRect(x2 + 5, y2 + 1, 1, 1);
        g.setColor(Color.ORANGE);
        g.fillRect(x2+1, y2+1, 4, 1);
    }
    public void paintBalaIzquierdaArriba(Graphics g){
        int x2 = (int) this.getX();
        int y2 = (int) this.getY();
        g.setColor(Color.black);
        g.fillRect(x2, y2, 2,1);
        g.fillRect(x2, y2 + 1, 1, 1);
        g.fillRect(x2 + 2, y2 + 1, 1, 1);
        g.fillRect(x2 + 2, y2 + 3, 1, 1);
        g.fillRect(x2 + 2, y2 + 3, 1, 1);
        g.fillRect(x2 + 3, y2 + 4, 1, 1);
        g.fillRect(x2 + 3, y2 + 2, 1, 1);
        g.fillRect(x2 + 4, y2 + 3, 1, 1);
        g.setColor(Color.ORANGE);
        g.fillRect(x2+1, y2+1, 1, 1);
        g.fillRect(x2+2, y2+2, 1, 1);
        g.fillRect(x2+3, y2+3, 1, 1);
    }
    public void paintBalaIzquierda(Graphics g){
        int x2 = (int) this.getX();
        int y2 = (int) this.getY();
        g.setColor(Color.black);
        g.fillRect(x2 + 1,  y2, 5,3);
        g.fillRect(x2 - 5 + 6 - 1, y2 + 1, 1, 1);
        g.setColor(Color.ORANGE);
        g.fillRect(x2 - 1 + 6 - 4, y2+1, 4, 1);
    }

    public double getX() {
        return x2;
    }

    public double getY() {
        return y2;
    }

    public void setX(int x2) {
        this.x2 = x2;
    }

    public void setY(int y2) {
        this.y2 = y2;
    }
    
}
