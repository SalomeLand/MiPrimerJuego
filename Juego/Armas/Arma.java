package Juego.Armas;

import Juego.Personaje.Jugador;


public abstract class Arma {
    protected int velocidad;
    protected int daño;
    protected int width;
    protected int height;
    protected int x;
    protected int y;
    protected boolean disparo;
    protected int lado = 1;

    public Arma(int velocidad, int daño,int width, int height,int x, int y){
        this.daño = daño;
        this.velocidad = velocidad;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public abstract void follow(Jugador player);

    public boolean getDisparo(){
        return disparo;
    }

    public void setDisparo(boolean disparo) {
        this.disparo = disparo;
    }

    public void setLado(int ladoDisparo) {
        this.lado = ladoDisparo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getDaño() {
        return daño;
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLado() {
        return lado;
    }
    
    
}
