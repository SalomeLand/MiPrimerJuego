package Juego.Interfaz;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

import javax.swing.*;

import Juego.Armas.Bala;
import Juego.Armas.Metralleta;
import Juego.Personaje.Jugador;
import Juego.Personaje.Zombie;

public class Juego extends JPanel implements ActionListener, KeyListener {

    private Jugador player;
    private ArrayList<Zombie> zombies;
    private ArrayList<Bala> balas;
    private Metralleta metralleta;
    private Timer timer;
    private Timer timer2;
    private int cantidadZombie = 2;
    private int seleccion, tiempoDisparo;
    private Timer timeEspada,timeArma;
    


    public Juego(int seleccion) {
        this.seleccion = seleccion;
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.ORANGE);

        player = new Jugador(300, 300,200);
        zombies = new ArrayList<>();
        balas = new ArrayList<>();
        metralleta = new Metralleta(5, 50, 37, 14, player.getX() + 25, player.getY() + player.getHeight()/4);

        timeEspada = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Zombie zombie : zombies) {
                    // Verificar si la espada del jugador golpea al zombie
                    Rectangle swordBounds = player.getSwordBounds();
                    if (Math.abs(zombie.getX() - player.getX()) < 200 && Math.abs(zombie.getY() - player.getY()) < 200) {
                        if (swordBounds != null && swordBounds.intersects(zombie.getBounds())) {
                            zombies.remove(zombie);
                            break; 
                        }
                    }
                }
                repaint();
            }
        });
        timeArma = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bandera = false;
                Iterator<Bala> balaIterator = balas.iterator(); // Iterator para balas
                Iterator<Zombie> zombieIterator = zombies.iterator(); // Iterator para zombies
                
                while (balaIterator.hasNext()) {
                    Bala bala = balaIterator.next();
                    bala.movimiento();
                
                    if (bala.getX() > player.getX() + 600) {
                        balaIterator.remove(); // Eliminar la bala
                        break;
                    }
                
                    // Iterar sobre los zombies
                    while (zombieIterator.hasNext()) {
                        Zombie zombie = zombieIterator.next();
                        if (!bandera) {
                            if (bala.getHitboxBala().intersects(zombie.getBounds())) {
                                if (zombie.getSalud() <= 0) {
                                    zombieIterator.remove(); // Eliminar el zombie
                                }else zombie.setSalud(zombie.getSalud() - metralleta.getDaño());
                                balaIterator.remove(); // Eliminar la bala
                                bandera = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                
                    // Resetear el iterator para zombies al final de cada iteración
                    zombieIterator = zombies.iterator(); // Resetear el iterator de zombies
                }
                metralleta.follow(player);
                repaint();
            }
        });
        switch (seleccion) {
            case 1:
                timeEspada.start();
                espada();
                break;
            case 2:
                timeArma.start();
                arma();
                break;
        
            default:
                break;
        }

        timer =  new Timer(16, this);
        timer.start();
        
        addKeyListener(this);
        setFocusable(true);
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);

    }

    public void espada(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                if (x > player.getX() + player.getWidth()/2) {
                    player.setLadoEspada(2);
                }else player.setLadoEspada(1);
                player.setSwordSwinging(true);
                
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                player.setSwordSwinging(false);
            }
        });
    }

    public void arma(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {  
                Bala bala = new Bala(player.getX() + 40, player.getY() + player.getHeight()/4);
                    int x = e.getX();    
                    if (x > player.getX() + player.getWidth()/2) {
                        bala.setLadoDisparo(1);
                    }else bala.setLadoDisparo(2);
                    balas.add(bala);
                    metralleta.setDisparo(true);
                    startSending();
    
                }
            public void mouseReleased(MouseEvent e) {
                metralleta.setDisparo(false);
                stopSending();
            }
        });
    }
     private void startSending() {
        if (timer2 == null) {
            // Crear un timer que envíe el 1 cada segundo
            timer2 = new Timer(150, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (metralleta.getDisparo()) {
                        Bala bala = new Bala(player.getX() + 40, player.getY() + player.getHeight()/4);
                        balas.add(bala);
                    }
                }
            });
            timer2.start();// 0 de retardo inicial, 1000 milisegundos (1 segundo)
        }
    }

    private void stopSending() {
        if (timer2 != null) {
            timer2.stop(); // Detener el timer
            timer2 = null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        player.attack(g);

        if(seleccion == 2){
            metralleta.paintArma(g);
            for(Bala bala : balas){
                bala.paintBala(g);
            }
        }

        // Dibujar zombies
        for (Zombie zombie : zombies) {
            zombie.paint(g);
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (zombies.size() < cantidadZombie) {
            zombies.add(creacionZombie(player));
        }
        for (Zombie zombie : zombies) {
            zombie.follow(player);
            Rectangle hitboxJugador = player.getBounds();
            if(hitboxJugador.intersects(zombie.getBounds())){
                if (zombie.getContador()%10 == 0){
                    if (!player.getInmunidad()) {
                        System.out.println("golpe");
                        if(player.getSalud() <= 0){
                            System.out.println("Jugador sin vida");
                            JOptionPane.showMessageDialog(this, "Te quedaste sin vidas");
                        }else player.setSalud(player.getSalud() - zombie.getDaño());
                        player.setInmunidad(true);
                        player.setContador(0);
                    }else if(player.getContador() >= 30) {
                        player.setInmunidad(false);
                    }
                }
            zombie.setContador(zombie.getContador()+1); 
            }
        }  
        if (player.getInmunidad()) {
            player.setContador(player.getContador() + 1);
        }
        repaint();
    }

    public Zombie creacionZombie(Jugador player){
        Random ran = new Random();
        int intentos = 20;
        while(intentos > 0)
        {
            int x = ran.nextInt(800);
            int y = ran.nextInt(600);
            Rectangle area = new Rectangle(player.getX() - 100,player.getY() + 100, 200 + player.getWidth(), 200 + player.getHeight());
            Rectangle areaZombie = new Rectangle(x,y, 25, 36);
            if(!area.intersects(areaZombie)){
                return new Zombie(x, y,200,20);
            }
            intentos--;
        }
        return new Zombie(player.getX() - 100,player.getY() -175,200,20);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) player.move(0, -15);
        if (key == KeyEvent.VK_S) player.move(0, 15);
        if (key == KeyEvent.VK_A) player.move(-15, 0);
        if (key == KeyEvent.VK_D) player.move(15, 0);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    /*public static void main(String[] args) {
        JFrame frame = new JFrame("Zombie Game Prototype");
        Juego game = new Juego();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }*/
}