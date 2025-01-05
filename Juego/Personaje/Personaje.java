package Juego.Personaje;
import java.awt.*;

// Clase base para todos los objetos del juego
public class Personaje {
    protected double x;
    protected double y;
    protected int width;
    protected int height;
    protected int salud;
    protected double vidaActual;
    protected int contador = 10;
    protected boolean estaVivo = true;


    public Personaje(double x, double y, int width, int height,int salud) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.salud = salud;
        vidaActual = salud;
    }

    public void paintBarraVida(Graphics g){
        int anchoVida = (int) ((width-4) * (vidaActual/salud));
        g.setColor(Color.black);
        g.fillRect((int)x,(int) y-20, width, 8);
        g.setColor(Color.red);
        g.fillRect((int)x + 2, (int)y - 18, anchoVida,4);
    }
    
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int) y, width+1, height+1);
    }

    public double getX() {
        return x;
    }

    public boolean estaVivo(){
        return estaVivo;
    }

    public int getContador() {
        return contador;
    }


    public double getY() {
        return y;
    }


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }

    public void setX(double x) {
        this.x = x;
    }


    public void setY(double y) {
        this.y = y;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public void setHeight(int height) {
        this.height = height;
    }


    public double getSalud() {
        return vidaActual;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    

    
}
