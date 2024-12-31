package Juego.Armas;

import java.awt.*;
import java.util.ArrayList;

public class Metralleta extends Arma {

    public Metralleta(int velocidad,int daño, int width, int height,int x, int y){
        super(velocidad, daño,width,height,x,y);
    }


    public void disparo(Graphics g){
        if(ladoDisparo == 1) paintArma(g);
        if(ladoDisparo == 2) paintArmaIzquierda(g);
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

    public void paintArmaIzquierda(Graphics g){
        int x2 = x  - 50;
        g.setColor(Color.black);
        g.fillRect(x2 - 14 + 37 - 7, y, 7,1);
        g.fillRect(x2 - 13 + 37 - 3, y + 1, 3,1);
        g.fillRect(x2 - 19 + 37 - 3, y + 1, 3,1);
        g.fillRect(x2 - 12 + 37 - 3, y + 2, 3,1);
        g.fillRect(x2 - 20 + 37 - 9, y + 2, 9,1);
        g.fillRect(x2 + 37 - 32, y + 3, 32,3);
        g.fillRect(x2 + 37 - 5, y + 6, 5,1);
        g.fillRect(x2 + 37 - 3, y + 7, 3,2);
        g.fillRect(x2 + 37 - 1, y + 9, 1,1);
        g.fillRect(x2 - 9 + 37 - 13, y + 6, 13,1);
        g.fillRect(x2 - 9 + 37 - 4, y + 7, 4,1);
        g.fillRect(x2 - 8 + 37 - 4, y + 8, 4,3);
        g.fillRect(x2 - 9 + 37 - 2, y + 11, 2,1);
        g.fillRect(x2 - 32 + 37 - 5, y + 3, 5, 1);
        g.fillRect(x2 - 17 + 37 - 1, y + 7, 1,3);
        g.fillRect(x2 - 21 + 37 - 1, y + 7, 1,3);
        g.fillRect(x2 - 18 + 37 - 1, y + 10, 2,1);
        g.fillRect(x2 - 19 + 37 - 1, y + 12, 1,1);
        g.fillRect(x2 - 20 + 37 - 3, y + 13, 3,1);
        g.fillRect(x2 - 22 + 37 - 1, y + 10, 1,1);
        g.fillRect(x2 - 23 + 37 - 1, y + 11, 1,2);

        g.setColor(Color.decode("#b4b4b4"));
        g.fillRect(x2 - 18 + 37 - 3, y + 7, 3,3);
        g.fillRect(x2 - 19 + 37 - 3, y + 10, 3,2);
        g.fillRect(x2 - 20 + 37 - 3 , y + 11, 3,2);
    }

}
