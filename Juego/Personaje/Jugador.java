package Juego.Personaje;
import java.awt.*;

import Juego.Armas.Arma;

public class Jugador extends Personaje {
    private boolean swordSwinging=false;
    private int ladoEspada = 0,aux;
    private boolean inmunidad = false;
    private Arma arma;

    public Jugador(int x, int y,int salud) {
        super(x, y, 27, 40,salud);
    }

    public void move(int dx, int dy) {
            x += dx;
            y += dy;
    }

    public void attack(Graphics g) {
        if (swordSwinging) { 
            if (ladoEspada == 1) {
                paintEspada2(g);
            }else if(ladoEspada == 2) paintEspada(g);
        }
    }

    public void equiparArma(Arma arma){
        this.arma = arma;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }

    public int getAux() {
        return aux;
    }

    public Arma getArma(){
        return arma;
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
    public void paintBarraVida(Graphics g){
        g.setColor(new Color(0,0,0));
        g.fillRect(x , y - 20, 25, 8);
        g.setColor(new Color(255,0,0));
        g.fillRect(x + 2, y - 18, (int)(salud/10),4);
        
    }

    //Dibujar espada a la derecha
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
    //Dibujar la espada a la izquierda
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

    public void paintJugador(Graphics g){
        
        g.setColor(Color.decode("#fff9bd"));
        g.fillRect(x + 2, y + 7, 20, 13);
        g.fillRect(x + 6, y + 20, 12, 1);
        
        g.setColor(Color.decode("#f5e49c"));
        g.fillRect(x + 2, y + 10, 6, 5);
        g.fillRect(x + 2, y + 15, 5, 2);
        g.fillRect(x + 2, y + 17, 4, 3);
        
        g.setColor(Color.decode("#ff7e00"));
        g.fillRect(x + 4, y + 21, 16, 12);
        
        g.setColor(Color.decode("#ffc20e"));
        g.fillRect(x + 9, y + 22, 8, 3);
        g.fillRect(x + 10, y + 25, 5, 1);
        
        g.setColor(Color.decode("#e5aa7a"));
        g.fillRect(x + 4, y + 33, 16, 4);
        g.fillRect(x + 10, y + 32, 7, 1);
        g.fillRect(x + 5, y + 37, 2, 2);
        g.fillRect(x + 17, y + 37, 2, 2);
        
        g.setColor(Color.black);
        //Boca y ojos
        g.fillRect(x + 10, y + 12, 2, 3);
        g.fillRect(x + 17, y + 12, 2, 3);
        g.fillRect(x + 12, y + 19, 5, 1);
        //Cabello
        g.fillRect(x + 4, y , 16, 1);
        g.fillRect(x + 3, y + 1, 19, 2);
        g.fillRect(x + 2, y + 3, 23, 4);
        g.fillRect(x + 1, y + 4, 4, 10);
        g.fillRect(x + 5, y + 7, 9, 1);
        g.fillRect(x + 5, y + 8, 4, 2);
        g.fillRect(x + 5, y + 10, 1, 2);
        g.fillRect(x + 21, y + 2, 2, 1);
        g.fillRect(x + 22, y + 7, 2, 1);

        //contorno
        int[] x1 = {22,1,21,2,3,4,6,20,3,20,11,12,8,4,7,16,19,5,17,21,22,25,26,22,21};
        int[] y1 = {8,14,17,18,19,20,21,19,22,22,22,24,36,37,37,37,37,39,39,24,25,26,27,30,29};
        int[] largo = {1,1,1,1,1,2,12,1,1,1,4,2,8,1,1,1,1,2,2,1,3,2,1,5,2};
        int[] altura = {9,4,3,2,1,1,1,1,15,15,2,2,1,2,2,2,2,1,1,1,1,1,3,1,1};

        for(int i = 0;i < x1.length; i++){
            g.fillRect(x + x1[i],y + y1[i], largo[i], altura[i]);
        }



    }
    public void pintarMano(Graphics g){
        g.setColor(Color.decode("#fff9bd"));
        g.fillRect(x + 9, y + 26, 6, 4);
        g.fillRect(x + 8, y + 27, 1, 2);

        int[] x1 = {7,9,10,14,15,14,8,6,5,5};
        int[] y1 = {24,25,26,26,27,29,30,29,28,26};
        int[] largo = {3,2,4,1,1,1,7,3,2,1};
        int[] altura = {1,1,1,2,3,2,1,1,1,2};
        g.setColor(Color.black);
        for(int i = 0;i < x1.length; i++){
            g.fillRect(x + x1[i],y + y1[i], largo[i], altura[i]);
        }

    }

    public boolean isSwordSwinging() {
        return swordSwinging;
    }

    public boolean getInmunidad() {
        return inmunidad;
    }

}