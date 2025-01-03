package Juego.Escenarios;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Juego.Personaje.Jugador;

public class TerrenoInicial {

    public void paintComponent(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(0, 250, 800, 100);
        g.fillRect(600, 0, 100, 250);
        g.fillRect(100, 350, 100, 250);

        int x = 0;
        g.setColor(Color.WHITE);
        for(int i = 0;i < 8; i++){
            g.fillRect(x, 295, 50, 10);
            x += 100;
        }
        x = 0;
        for(int i = 0;i < 3; i++){
            g.fillRect(645, x, 10, 50);
            x += 100;
        }
        x = 350;
        for(int i = 0;i < 3; i++){
            g.fillRect(145, x, 10, 50);
            x += 100;
        }

        g.fillRect(20, 20, 64, 64);


    }

    public void paintArbol(Graphics g){
        int x1 = 20;
        int y1 = 20;

        g.setColor(Color.green);
        g.fillRect(x1 + 8, y1 + 1, 41, 30);
        g.fillRect(x1 + 6, y1 + 6, 4, 8);

        g.setColor(Color.GRAY);
        g.fillRect(x1 + 26, y1 + 26, 13, 40);
    }

    public void paintPiedra(Graphics g, Jugador player, int y){
        int x1 = player.getX() + 464;
        g.setColor(Color.gray);
        g.fillRect(x1, y, 30, 20);
    }

    public void generadorTerreno(Graphics g, Jugador player){
        Random ran = new Random();
        int y = 0;
        for(int i = 0; i < 13; i++){
            int random = ran.nextInt(2);
            if (random == 0) paintArbol(g);
            if (random == 1) paintPiedra(g,player,y);
            y += 64;
        }
    }
}
