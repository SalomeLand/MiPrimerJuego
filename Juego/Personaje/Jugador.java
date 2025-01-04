package Juego.Personaje;
import java.awt.*;

import Juego.Armas.Arma;
import Juego.Sonidos.Sonidos;

public class Jugador extends Personaje {

    private int lado = 1,aux;
    private boolean inmunidad = false;
    private Sonidos sonido = new Sonidos();

    public Jugador(int x, int y,int salud) {
        super(x, y, 27, 40,salud);
    }

    public void move(int dx, int dy) {
            x += dx;
            y += dy;
    }
    
    public void follow(Graphics g) {
        //g.fillRect(x, y, width, height);
        if (lado == 1) {
            paintJugadorIzquierda(g);
        }else if(lado == 2) {
            paintJugador(g);
        }
    }
    
        public void reproducirDaño(){
            sonido.reproducirGolpe();
        }

    public void setAux(int aux) {
        this.aux = aux;
    }

    public int getAux() {
        return aux;
    }

    public void setInmunidad(boolean inmunidad) {
        this.inmunidad = inmunidad;
    }

    public void setLado(int lado){
        this.lado = lado;
    }
    public int getLado(){
        return lado;
    }
    public void paintBarraVida(Graphics g){
        g.setColor(new Color(0,0,0));
        g.fillRect(x , y - 20, 25, 8);
        g.setColor(new Color(255,0,0));
        g.fillRect(x + 2, y - 18, (int)(salud/10),4);
        
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

    public void paintJugadorIzquierda(Graphics g){
        g.setColor(Color.decode("#fff9bd"));
        g.fillRect(x - 2 + 27 - 20, y + 7, 20, 13);
        g.fillRect(x - 6+ 27 - 12, y + 20, 12, 1);
        
        g.setColor(Color.decode("#f5e49c"));
        g.fillRect(x - 2 + 27 - 6, y + 10, 6, 5);
        g.fillRect(x - 2 + 27 - 5, y + 15, 5, 2);
        g.fillRect(x - 2 + 27 - 4, y + 17, 4, 3);
        
        g.setColor(Color.decode("#ff7e00"));
        g.fillRect(x - 4 + 27 - 16, y + 21, 16, 12);
        
        g.setColor(Color.decode("#ffc20e"));
        g.fillRect(x - 9 + 27 - 8, y + 22, 8, 3);
        g.fillRect(x - 10 + 27 - 5, y + 25, 5, 1);
        
        g.setColor(Color.decode("#e5aa7a"));
        g.fillRect(x - 4 + 27 - 16, y + 33, 16, 4);
        g.fillRect(x - 10 + 27 - 7, y + 32, 7, 1);
        g.fillRect(x - 5 + 27 - 2, y + 37, 2, 2);
        g.fillRect(x - 17 + 27 - 2, y + 37, 2, 2);
        
        g.setColor(Color.black);
        //Boca y ojos
        g.fillRect(x - 10 + 27 - 2, y + 12, 2, 3);
        g.fillRect(x - 17 + 27 - 2, y + 12, 2, 3);
        g.fillRect(x - 12 + 27 - 5, y + 19, 5, 1);
        //Cabello
        g.fillRect(x - 4 + 27 - 16, y , 16, 1);
        g.fillRect(x - 3 + 27 - 19, y + 1, 19, 2);
        g.fillRect(x - 2 + 27 - 23, y + 3, 23, 4);
        g.fillRect(x - 1 + 27 - 4, y + 4, 4, 10);
        g.fillRect(x - 5 + 27 - 9, y + 7, 9, 1);
        g.fillRect(x - 5 + 27 - 4, y + 8, 4, 2);
        g.fillRect(x - 5 + 27 - 1, y + 10, 1, 2);
        g.fillRect(x - 21 + 27 - 2, y + 2, 2, 1);
        g.fillRect(x - 22 + 27 - 2, y + 7, 2, 1);

        //contorno
        int[] x1 = {22,1,21,2,3,4,6,20,3,20,11,12,8,4,7,16,19,5,17,21,22,25,26,22,21};
        int[] y1 = {8,14,17,18,19,20,21,19,22,22,22,24,36,37,37,37,37,39,39,24,25,26,27,30,29};
        int[] largo = {1,1,1,1,1,2,12,1,1,1,4,2,8,1,1,1,1,2,2,1,3,2,1,5,2};
        int[] altura = {9,4,3,2,1,1,1,1,15,15,2,2,1,2,2,2,2,1,1,1,1,1,3,1,1};

        for(int i = 0;i < x1.length; i++){
            g.fillRect(x - x1[i] + 27 - largo[i],y + y1[i], largo[i], altura[i]);
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

    public boolean getInmunidad() {
        return inmunidad;
    }

}