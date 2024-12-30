package Juego.Armas;

import java.awt.*;
import java.util.ArrayList;

public class Metralleta extends Arma {

    private boolean disparo;
    private ArrayList<Bala> balas = new ArrayList<>();

    public Metralleta(int velocidad,int daño, int width, int height,int x, int y){
        super(velocidad, daño,width,height,x,y);
    }

    public boolean getDisparo(){
        return disparo;
    }

    public void setDisparo(boolean disparo){
        this.disparo = disparo;
    }

    public void paintArma(Graphics g){
        g.setColor(Color.black);
        g.fillRect(x + 14, y, 7,1);
        g.fillRect(x + 13, y + 1, 3,1);
        g.fillRect(x + 19, y + 1, 3,1);
        g.fillRect(x + 12, y + 2, 3,1);
        g.fillRect(x + 20, y + 2, 9,1);
        g.fillRect(x, y + 3, 32,3);
        g.fillRect(x, y + 6, 5,1);
        g.fillRect(x, y + 7, 3,2);
        g.fillRect(x, y + 9, 1,1);
        g.fillRect(x + 9, y + 6, 13,1);
        g.fillRect(x + 9, y + 7, 4,1);
        g.fillRect(x + 8, y + 8, 4,3);
        g.fillRect(x + 9, y + 11, 2,1);
        g.fillRect(x + 32, y + 3, 5, 1);
        g.fillRect(x + 17, y + 7, 1,3);
        g.fillRect(x + 21, y + 7, 1,3);
        g.fillRect(x + 18, y + 10, 2,1);
        g.fillRect(x + 19, y + 12, 1,1);
        g.fillRect(x + 20, y + 13, 3,1);
        g.fillRect(x + 22, y + 10, 1,1);
        g.fillRect(x + 23, y + 11, 1,2);

        g.setColor(Color.decode("#b4b4b4"));
        g.fillRect(x + 18, y + 7, 3,3);
        g.fillRect(x + 19, y + 10, 3,2);
        g.fillRect(x + 20, y + 11, 3,2);

    }

}
