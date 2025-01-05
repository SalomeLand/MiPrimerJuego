package Juego.Personaje;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import Juego.Armas.Metralleta;

public class BossUno extends Personaje{
    
    private int contador=0;
    private Metralleta metralleta = new Metralleta(5, 30, 37, 14,(int) x,(int)y + height/4);
    Timer time;
    
    public BossUno(int x, int y,int width, int height, int salud){
        super(x, y, width, height, salud);
    }

    public void follow(Jugador player){
        if (contador > 10) {
            if (x > player.x + player.width - 5) x -= .3;
            if ((x + width) < player.x + 15) x += .3;
            if (y > player.y + player.height - 5) y -= .3;
            if ((y + height) < player.y + 15) y += .3;
            if (contador >=50){
                contador = 0;
            }
            if(time == null) disparar(player);
        }contador++;
    }

    public void disparar(Jugador player){
        time = new Timer(1100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metralleta.guardarBalas((int)x,(int)y,height,width, (int)player.getX(),(int) player.getY());
            }});
            time.start();
    }

    public void recibirDaño(double daño) {
        if (vidaActual <= 0) {
            estaVivo = false;
        }else{
            this.vidaActual -= daño;
            contador = 0;
        }
    }

    public Metralleta getMetralleta(){
        return metralleta;
    }

    public void paint(Graphics g){
        g.fillRect((int)x,(int) y, width, height);
    }


}
