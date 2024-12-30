package Juego.Personaje;
import java.awt.*;

// Clase base para todos los objetos del juego
public class Personaje {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int salud;
    private int contador = 10;


    public Personaje(int x, int y, int width, int height,int salud) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.salud = salud;
    }

    
    public Rectangle getBounds() {
        return new Rectangle(x, y, width+1, height+1);
    }

    
    public int getX() {
        return x;
    }


    public int getContador() {
        return contador;
    }


    public int getY() {
        return y;
    }


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }


    public void setY(int y) {
        this.y = y;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public void setHeight(int height) {
        this.height = height;
    }


    public int getSalud() {
        return salud;
    }


    public void setSalud(int salud) {
        this.salud = salud;
    }


    public void setContador(int contador) {
        this.contador = contador;
    }
    

    
}
