package Juego.Personaje;

import java.awt.*;

public class Zombie extends Personaje {

    private int t = 1;
    protected int daño;
    
    public Zombie(int x, int y, int salud,int daño) {
        super(x, y, 21, 36, salud);
        this.daño = daño;
    }

    public void follow(Jugador player) {
        if (x > player.x + player.width - 5) x -= 1;
        if ((x + width) < player.x + 15) x += 1;
        if (y > player.y + player.height - 5) y -= 1;
        if ((y + height) < player.y + 15) y += 1;
    }

    public void paintBarraVida(Graphics g){
        g.setColor(new Color(0,0,0,150));
        g.fillRect(x + 5, y - 20, 20, 8);
        g.setColor(new Color(255,0,0,200));
        g.fillRect(x + 8, y - 18, (int)(salud/14),4);
        
    }
    
    public int getDaño() {
        return daño;
    }

    public void paint(Graphics g){
        //Cabeza
        g.setColor(Color.decode("#d2f8bc"));
        g.fillRect(x*t,y*t, 20*t, 20*t);
        //Ropa
        g.setColor(Color.decode("#ffc00e"));
        g.fillRect((x+5)*t,(y+23)*t, 13*t, 7*t);
        g.setColor(Color.decode("#ff7e00"));
        g.fillRect((x+13)*t,(y+21)*t, 5*t, 5*t);
        //Ojos y boca
        g.setColor(Color.BLACK);
        g.fillRect((x+3)*t,(y+6)*t, 2*t, 1*t);
        g.setColor(Color.BLACK);
        g.fillRect((x+11)*t,(y+6)*t, 4*t, 1*t);
        g.setColor(Color.BLACK);
        g.fillRect((x+6)*t,(y+14)*t, 7*t, 1*t);

        int[] pelo = {1,1,2,1,0,1};
        int m = 9;
        //pelo
        g.setColor(Color.decode("#464646"));
        for(int k = 0;k < 9;k++){
            g.fillRect(((x+20) - m)*t, (y + k)*t,m*t, 1*t);
            if (k < 6) {
                m -= pelo[k];
            }
        }
        //cejas
        g.fillRect((x+2)*t,(y+5)*t,3*t,1*t);
        g.fillRect((x+10)*t,(y+5)*t,5*t, 1*t);
        //Manos
        g.setColor(Color.decode("#d2f8bc"));
        g.fillRect((x+2)*t, (y+22)*t, 4*t, 2*t);

        g.fillRect((x+1)*t,(y+25)*t, 5*t, 3*t);
        g.fillRect((x+6)*t, (y+26)*t, 1*t,2*t);
        //botas
        g.setColor(Color.decode("#b4b4b4"));
        g.fillRect((x+9)*t, (y+31)*t, 3*t, 3*t);
        g.fillRect((x+15)*t, (y+31)*t, 3*t, 3*t);

        //sangre
        //Mano
        g.setColor(Color.red);
        g.fillRect((x+1)*t, (y+22)*t, 1*t, 2*t);
        g.fillRect((x+1)*t, (y+26)*t, 1*t, 2*t);
        g.fillRect((x+2)*t, (y+27)*t, 2*t, 1*t);
        //cara        
        g.fillRect((x+2)*t, (y+9)*t, 3*t, 1*t);
        g.fillRect((x+1)*t, (y+10)*t, 2*t, 2*t);

        g.fillRect((x+3)*t, y*t, 3*t, 3*t);
        g.fillRect((x+3)*t, (y+1)*t, 3*t, 3*t);
        
        //boca
        g.fillRect((x+12)*t, (y+14)*t, 1*t, 4*t);
        g.fillRect((x+10)*t, (y+15)*t, 2*t, 1*t);
        g.fillRect((x+13)*t, (y+17)*t, 1*t, 2*t);

        //ropa
        g.fillRect((x+8)*t,(y+27)*t, 2*t, 1*t);
        g.fillRect((x+9)*t, (y+28)*t, 2*t, 2*t);
        g.fillRect((x+11)*t, (y+29)*t, 2*t, 2*t);

        g.fillRect((x+16)*t, (y+26)*t, 2*t, 2*t);
        g.fillRect((x+17)*t, (y+28)*t, 1*t, 1*t);

        g.setColor(Color.white);
        g.fillRect((x+6)*t, (y+21)*t, 6*t, 1*t);

        //contorno
        g.setColor(Color.BLACK);
        g.fillRect((x+1)*t, (y+20)*t, 18*t, 1*t);
        g.fillRect((x-1)*t, (y)*t, 1*t, 17*t);
        g.fillRect((x+20)*t, (y+1)*t, 1*t, 16*t);
        g.fillRect((x-1)*t, (y)*t, 21*t, 1*t);
        g.fillRect((x+18)*t, (y+22)*t, 1*t, 8*t);
        //contorno botas 2
        int[] largo2 = {1,1,1,1,1,1,5,1,1,1,1,1,5};
        int[] fila2 = {31,31,32,32,33,33,34,31,32,32,33,33,34};
        int[] columna2 = {11,14,10,14,10,14,10,17,16,20,16,20,16};

        for(int i = 0;i < largo2.length;i++){
            g.fillRect(((x-2)+columna2[i])*t, (y+fila2[i])*t, largo2[i]*t, 1*t);
        }
        //Contorno
        int[] largo = {2,1,1,2,2,2,2,2,2,9,1,2,1,1,3,1,1,2,4,5};
        int[] fila = {17,17,18,18,19,19,21,21,21,22,23,23,24,24,25,26,28,29,30,30};
        int[] columna = {1,22,2,21,2,20,6,13,18,6,6,14,6,15,15,17,7,7,9,15};

        for(int i = 0;i < largo.length;i++){
            g.fillRect(((x-2)+columna[i])*t, (y+fila[i])*t, largo[i]*t, 1*t);
        }
    }
}//Fin Class
