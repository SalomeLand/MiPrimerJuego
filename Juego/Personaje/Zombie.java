package Juego.Personaje;

import java.awt.*;

public class Zombie extends Personaje {

    private int t = 1;
    protected int daño;
    
    public Zombie(double x2, double y2, int salud,int daño) {
        super(x2, y2, 21, 36, salud);
        this.daño = daño;
    }

    public void follow(Jugador player) {
        if (x > player.x + player.width - 5) x -= 0.5;
        if ((x + width) < player.x + 15) x += .5;
        if (y > player.y + player.height - 5) y -= .5;
        if ((y + height) < player.y + 15) y += .5;
    }

    public void setSalud(double daño) {
        this.vidaActual -= daño;;
    }
    
    public int getDaño() {
        return daño;
    }

    public void paint(Graphics g){
        //Cabeza
        int x2 = (int)x;
        int y2 = (int)y;
        g.setColor(Color.decode("#d2f8bc"));
        g.fillRect(x2*t,y2*t, 20*t, 20*t);
        //Ropa
        g.setColor(Color.decode("#ffc00e"));
        g.fillRect((x2+5)*t,(y2+23)*t, 13*t, 7*t);
        g.setColor(Color.decode("#ff7e00"));
        g.fillRect((x2+13)*t,(y2+21)*t, 5*t, 5*t);
        //Ojos y2 boca
        g.setColor(Color.BLACK);
        g.fillRect((x2+3)*t,(y2+6)*t, 2*t, 1*t);
        g.setColor(Color.BLACK);
        g.fillRect((x2+11)*t,(y2+6)*t, 4*t, 1*t);
        g.setColor(Color.BLACK);
        g.fillRect((x2+6)*t,(y2+14)*t, 7*t, 1*t);

        int[] pelo = {1,1,2,1,0,1};
        int m = 9;
        //pelo
        g.setColor(Color.decode("#464646"));
        for(int k = 0;k < 9;k++){
            g.fillRect(((x2+20) - m)*t, (y2 + k)*t,m*t, 1*t);
            if (k < 6) {
                m -= pelo[k];
            }
        }
        //cejas
        g.fillRect((x2+2)*t,(y2+5)*t,3*t,1*t);
        g.fillRect((x2+10)*t,(y2+5)*t,5*t, 1*t);
        //Manos
        g.setColor(Color.decode("#d2f8bc"));
        g.fillRect((x2+2)*t, (y2+22)*t, 4*t, 2*t);

        g.fillRect((x2+1)*t,(y2+25)*t, 5*t, 3*t);
        g.fillRect((x2+6)*t, (y2+26)*t, 1*t,2*t);
        //botas
        g.setColor(Color.decode("#b4b4b4"));
        g.fillRect((x2+9)*t, (y2+31)*t, 3*t, 3*t);
        g.fillRect((x2+15)*t, (y2+31)*t, 3*t, 3*t);

        //sangre
        //Mano
        g.setColor(Color.red);
        g.fillRect((x2+1)*t, (y2+22)*t, 1*t, 2*t);
        g.fillRect((x2+1)*t, (y2+26)*t, 1*t, 2*t);
        g.fillRect((x2+2)*t, (y2+27)*t, 2*t, 1*t);
        //cara        
        g.fillRect((x2+2)*t, (y2+9)*t, 3*t, 1*t);
        g.fillRect((x2+1)*t, (y2+10)*t, 2*t, 2*t);

        g.fillRect((x2+3)*t, y2*t, 3*t, 3*t);
        g.fillRect((x2+3)*t, (y2+1)*t, 3*t, 3*t);
        
        //boca
        g.fillRect((x2+12)*t, (y2+14)*t, 1*t, 4*t);
        g.fillRect((x2+10)*t, (y2+15)*t, 2*t, 1*t);
        g.fillRect((x2+13)*t, (y2+17)*t, 1*t, 2*t);

        //ropa
        g.fillRect((x2+8)*t,(y2+27)*t, 2*t, 1*t);
        g.fillRect((x2+9)*t, (y2+28)*t, 2*t, 2*t);
        g.fillRect((x2+11)*t, (y2+29)*t, 2*t, 2*t);

        g.fillRect((x2+16)*t, (y2+26)*t, 2*t, 2*t);
        g.fillRect((x2+17)*t, (y2+28)*t, 1*t, 1*t);

        g.setColor(Color.white);
        g.fillRect((x2+6)*t, (y2+21)*t, 6*t, 1*t);

        //contorno
        g.setColor(Color.BLACK);
        g.fillRect((x2+1)*t, (y2+20)*t, 18*t, 1*t);
        g.fillRect((x2-1)*t, (y2)*t, 1*t, 17*t);
        g.fillRect((x2+20)*t, (y2+1)*t, 1*t, 16*t);
        g.fillRect((x2-1)*t, (y2)*t, 21*t, 1*t);
        g.fillRect((x2+18)*t, (y2+22)*t, 1*t, 8*t);
        //contorno botas 2
        int[] largo2 = {1,1,1,1,1,1,5,1,1,1,1,1,5};
        int[] fila2 = {31,31,32,32,33,33,34,31,32,32,33,33,34};
        int[] columna2 = {11,14,10,14,10,14,10,17,16,20,16,20,16};

        for(int i = 0;i < largo2.length;i++){
            g.fillRect(((x2-2)+columna2[i])*t, (y2+fila2[i])*t, largo2[i]*t, 1*t);
        }
        //Contorno
        int[] largo = {2,1,1,2,2,2,2,2,2,9,1,2,1,1,3,1,1,2,4,5};
        int[] fila = {17,17,18,18,19,19,21,21,21,22,23,23,24,24,25,26,28,29,30,30};
        int[] columna = {1,22,2,21,2,20,6,13,18,6,6,14,6,15,15,17,7,7,9,15};

        for(int i = 0;i < largo.length;i++){
            g.fillRect(((x2-2)+columna[i])*t, (y2+fila[i])*t, largo[i]*t, 1*t);
        }
    }
}//Fin Class
