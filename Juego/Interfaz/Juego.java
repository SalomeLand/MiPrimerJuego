package Juego.Interfaz;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.Border;

import Juego.Armas.Bala;
import Juego.Armas.Espada;
import Juego.Armas.Metralleta;
import Juego.Conexion.BdJugador.ConexionJugador;
import Juego.Escenarios.TerrenoInicial;
import Juego.Modificaciones.Boton;
import Juego.Modificaciones.BotonSetting;
import Juego.Personaje.BossUno;
import Juego.Personaje.Jugador;
import Juego.Personaje.Zombie;

public class Juego extends JPanel implements  KeyListener {

    private Jugador player;
    private BufferedImage buffer;
    private Graphics2D bufferGraphics;
    private TerrenoInicial terreno;
    private ArrayList<Zombie> zombies;
    private Metralleta metralleta;
    private Espada espada;
    private Timer timer2,timerMaestro;
    private Timer timeEspada, timeCrearZombies;
    private ArrayList<Timer> todosTimers = new ArrayList<>();
    private int cantidadZombie = 3;
    private JFrame frame;
    long lastMoveTime = 0;    
    private BossUno boss;
    private BotonSetting btnSetting;
    private JPanel panelSetting;


    public Juego(int seleccion) {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.DARK_GRAY);
        setLayout(null);

        player = new Jugador(300, 300,200);
        zombies = new ArrayList<>();
        ConexionJugador.traerMetralleta();
        metralleta = new Metralleta(ConexionJugador.velocidadMetralleta, ConexionJugador.dañoMetralleta, 37, 14, (int)player.getX() + 25, (int)player.getY() + player.getHeight()/4);
        espada = new Espada(20,30, 25, 15, 20, (int)player.getY() + player.getHeight()/4);
        terreno = new TerrenoInicial();
        timeEspada = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setLado(espada.getLado());
                player.follow(bufferGraphics);
                espada.atacar(bufferGraphics);
                espada.setContador(espada.getContador() + 1);
                for (Zombie zombie : zombies) {
                    // Verificar si la espada del jugador golpea al zombie
                    Rectangle swordBounds = espada.getSwordBounds();
                    if (Math.abs(zombie.getX() - player.getX()) < 200 && Math.abs(zombie.getY() - player.getY()) < 200) {
                        if (swordBounds != null && swordBounds.intersects(zombie.getBounds())) {
                            if(zombie.getSalud() <= 0){
                                zombies.remove(zombie);
                                break; 
                            }else zombie.setSalud(espada.getDaño());
                        }
                    }
                }
                espada.follow(player);
                repaint();
            }
        });
            todosTimers.add(timeEspada);
        timeCrearZombies = new Timer(350,new ActionListener() {
            public void actionPerformed(ActionEvent e){
                zombies.add(creacionZombie(player));
            }
        });
        timerMaestro = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecucionFija();
                switch (seleccion) {
                    case 1:
                        espada();
                    break;
                    case 2:
                        ejecutacionArma();
                        break;
                    default:
                        break;
                }
                repaint();
            }});
            timerMaestro.start();
        switch (seleccion) {
            case 1:
                timeEspada.start();
                espada();
                break;
            case 2:
                //timeArma.start();
                arma();
                break;
        
            default:
                break;
        }
        reproducirZombie();
        Timer timerSonidoZombi = new Timer(24000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproducirZombie();
            }});
        timerSonidoZombi.start();
        //timer.start();
        
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        componentes();
        frame = new JFrame();
        frame.setSize(800, 600);
        // Opcional: Ocultar la barra de título para una experiencia más inmersiva
        // frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
        
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        bufferGraphics = buffer.createGraphics();

    }
    
    public void ejecucionFija() {
        bufferGraphics.setColor(getBackground());
        bufferGraphics.fillRect(0, 0, getWidth(), getHeight());

        terreno.paintComponent(bufferGraphics);
        player.paintBarraVida(bufferGraphics);

        if (zombies.size() < cantidadZombie) {
            timeCrearZombies.start();
            //zombies.add(creacionZombie(player));
        }else timeCrearZombies.stop();
        for (Zombie zombie : zombies) {
            zombie.follow(player);
            Rectangle hitboxJugador = player.getBounds();
            if(hitboxJugador.intersects(zombie.getBounds())){
                if (zombie.getContador()%10 == 0){
                    if (!player.getInmunidad()) {
                        System.out.println("golpe");
                        player.recibirDaño(zombie.getDaño());
                        /*if(player.getSalud() <= 0){
                            JOptionPane.showMessageDialog(this, "Has muerto");
                            timer.stop();
                            frame.setVisible(false);
                        }else player.setSalud(zombie.getDaño());
                        player.setInmunidad(true);
                        player.setContador(0);*/
                    }else if(player.getContador() >= 30) {
                        player.setInmunidad(false);
                    }
                }
                zombie.setContador(zombie.getContador()+1); 
            }
            zombie.paint(bufferGraphics);
            zombie.paintBarraVida(bufferGraphics);
        }  
        if (player.getInmunidad()) {
            player.setContador(player.getContador() + 1);
        }
        if (player.getZombiesEliminados()%9 == 0 && boss == null) {
            boss = new BossUno(20, 20, 60, 40, 2500);
            cantidadZombie = 0;
        }
        if (boss != null && boss.estaVivo()) {
            boss.follow(player);
            boss.getMetralleta().disparar((int)boss.getX()+500);
            boss.paint(bufferGraphics);
            boss.paintBarraVida(bufferGraphics);
            for(int i =0;i < boss.getMetralleta().getBalas().size();i++){
                boss.getMetralleta().getBalas().get(i).paintBala(bufferGraphics);
                if (boss.getMetralleta().acertarDisparo(player.getBounds(),boss.getMetralleta().getBalas().get(i))) {
                    player.recibirDaño(boss.getMetralleta().getDaño());
                    boss.getMetralleta().getBalas().remove(i);
                    break;
                }
            }
        }else cantidadZombie = 10;
        if (!player.estaVivo()) {
            timerMaestro.stop();
            //frame.setVisible(false);
        }
    }
    public void espada(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                if (x > player.getX() + player.getWidth()/2) {
                    espada.setLado(2);
                }else espada.setLado(1);
                if (espada.getContador() >= 25) {
                    espada.setSwordSwinging(true);
                    espada.setContador(0);
                }else espada.setSwordSwinging(false);
                startSending2(x);
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                espada.setSwordSwinging(false);
                stopSending2();
            }
        });
    }

    public void arma(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {  
                int x = e.getX();    
                int y = e.getY();
                metralleta.guardarBalas((int)player.getX(),(int)player.getY(),player.getHeight(),player.getWidth(), x, y);
                metralleta.reproducirDisparo();
                startSending(x,y);
                }
            public void mouseReleased(MouseEvent e) {
                metralleta.setDisparo(false);
                stopSending();
            }
        });
    }
    private void startSending(int x, int y) {
        if (timer2 == null) {
            timer2 = new Timer(200, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        metralleta.guardarBalas((int)player.getX(),(int)player.getY(),player.getHeight(),player.getWidth(), x, y);
                        metralleta.reproducirDisparo();
                }
            });
            todosTimers.add(timer2);
            timer2.start();
        }
    }

    private void stopSending() {
        if (timer2 != null) {
            timer2.stop(); 
            timer2 = null;
        }
    }
    private void startSending2(int x) {
        if (timer2 == null) {
            timer2 = new Timer(300, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(x > player.getX() + player.getWidth()/2){
                        espada.setLado(2);
                    }else{
                        espada.setLado(1);
                    }
                    if (espada.getContador() >= 20) {
                        espada.setSwordSwinging(true);
                        espada.setContador(0);
                    }else{
                        espada.setSwordSwinging(false);
                        
                    } 
                    //startSending2(x);
                }
            });
            timer2.start();
        }
    }
    public void ejecutacionArma() {
        boolean bandera = false;
        Iterator<Bala> balaIterator = metralleta.getBalas().iterator(); // Iterator para balas
        Iterator<Zombie> zombieIterator = zombies.iterator(); // Iterator para zombies
        
        while (balaIterator.hasNext()) {
            Bala bala = balaIterator.next();
            bala.paintBala(bufferGraphics);
            bala.movimientoBala(metralleta.getVelocidad());
            if (bala.getX() > player.getX() + 600) {
                balaIterator.remove(); // Eliminar la bala
                break;
            }
            if (boss != null && boss.estaVivo()) {
                if (bala.getHitboxBala().intersects(boss.getBounds())) {
                    boss.recibirDaño(metralleta.getDaño());
                    balaIterator.remove();
                    break;
                }
            }
            
            // Iterar sobre los zombies
            while (zombieIterator.hasNext()) {
                Zombie zombie = zombieIterator.next();
                if (!bandera) {
                    if (bala.getHitboxBala().intersects(zombie.getBounds())) {
                        if (zombie.getSalud() <= 0) {
                            zombieIterator.remove(); // Eliminar el zombie
                            player.zombieMuerto();
                        }else {
                            zombie.setSalud( metralleta.getDaño());
                        }
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
        player.setLado(metralleta.getLado());
        player.follow(bufferGraphics);
        metralleta.disparo(bufferGraphics);
    }

    private void stopSending2() {
        if (timer2 != null) {
            timer2.stop(); 
            timer2 = null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 1. Inicializar el buffer si es necesario

        // 2. Limpiar el buffer
       // bufferGraphics.setColor(getBackground());
        //bufferGraphics.fillRect(0, 0, getWidth(), getHeight());

        // 3. Dibujar en el buffer
        //terreno.paintComponent(bufferGraphics);
        //player.paintBarraVida(bufferGraphics);

        /*if (seleccion == 2) {
           // for (int i = 0; i < metralleta.getBalas().size(); i++) {
             //   metralleta.getBalas().get(i).paintBala(bufferGraphics);
           // }

            player.setLado(metralleta.getLado());
            player.follow(bufferGraphics);
            metralleta.disparo(bufferGraphics);
        } else if (seleccion == 1) {
            player.setLado(espada.getLado());
            player.follow(bufferGraphics);
            espada.atacar(bufferGraphics);
        }*/

        // Dibujar zombies
        /*for (Zombie zombie : zombies) {
            zombie.paint(bufferGraphics);
            zombie.paintBarraVida(bufferGraphics);
        }*/

        /*if (boss != null && boss.estaVivo()) {
            boss.paint(bufferGraphics);
            boss.paintBarraVida(bufferGraphics);
            for (int i = 0; i < boss.getMetralleta().getBalas().size(); i++) {
                boss.getMetralleta().getBalas().get(i).paintBala(bufferGraphics);
            }
        }*/

        player.pintarMano(bufferGraphics);
        // terreno.paintArbol(bufferGraphics);
        // terreno.paintPiedra(bufferGraphics);

        // 4. Dibujar el buffer en pantalla
        g.drawImage(buffer, 0, 0, null);
    }

    public Zombie creacionZombie(Jugador player){
        Random ran = new Random();
        int intentos = 20;
        Zombie zombie;
        while(intentos > 0)
        {
            int x = ran.nextInt(1000);
            int y = ran.nextInt(800);
            Rectangle area = new Rectangle((int)player.getX() - 100,(int)player.getY() - 100, 200 + player.getWidth(), 200 + player.getHeight());
            Rectangle areaZombie = new Rectangle(x,y, 25, 36);
            if(!area.intersects(areaZombie)){
                return new Zombie(x, y,500,20);
            }
            intentos--;
        }
        return new Zombie(player.getX() - 100,player.getY() -175,500,20);
    }   

    /*
    @Override
    public void keyPresse2d(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) player.move(0, -15);
        if (key == KeyEvent.VK_S) player.move(0, 15);
        if (key == KeyEvent.VK_A) player.move(-15, 0);
        if (key == KeyEvent.VK_D) player.move(15, 0);
        empezarCaminar();
    }
    */
    public void keyPressed(KeyEvent e) {
        final int INTERVALO = 50;
        // Obtén el tiempo actual
        long currentTime = System.currentTimeMillis();

        // Si ha pasado el intervalo necesario, mueve al jugador
        if (currentTime - lastMoveTime >= INTERVALO) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                if (player.getY()>10) 
                    player.move(0, -15); // Mueve a la izquierda
            }  if (e.getKeyCode() == KeyEvent.VK_S) {
                player.move(0, 15);
            }  if (e.getKeyCode() == KeyEvent.VK_A) {
                espada.setLado(1);
                metralleta.setLado(1);
                if (player.getX()>10) 
                player.move(-15, 0);
            }  if (e.getKeyCode() == KeyEvent.VK_D) {
                metralleta.setLado(2);
                espada.setLado(2);
                player.move(15, 0); // Mueve hacia abajo
            }
            // Actualiza el tiempo de la última vez que se movió
            lastMoveTime = currentTime;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void reproducirZombie(){
        try {

            File archivoAudio = new File("sonidoZombi.wav");

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoAudio);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            // Establecer el volumen (por ejemplo, -10.0f reduce el volumen, 0.0f es el volumen máximo)
            gainControl.setValue(-20.0f); 

            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException  e) {
            System.out.println("Error al reproducir el sonido: " + e);
        }
    }

    public void componentes(){
        btnSetting = new BotonSetting();
        btnSetting.setBounds(10, 10, 30, 30);
        add(btnSetting);
        btnSetting.addActionListener(e->{
            panelSetting();
            add(panelSetting);
        });
    }

    public void panelSetting(){
        panelSetting = new JPanel();
        panelSetting.setBackground(Color.orange);
        panelSetting.setBounds(200,200,400,200);
        panelSetting.setFocusable(false);
        panelSetting.setVisible(true);

        Boton btnMenu = new Boton("Ir al menu",10);
        btnMenu.setBounds(50,125,150,50);
        panelSetting.add(btnMenu);
        btnMenu.addActionListener(e->{
            new Inicio();
            frame.dispose();
            for (Timer timer : todosTimers) {
                if (timer.isRunning()) {
                    timer.stop();  // Detener cada Timer
                }
            }
        });

        Boton btnRegreso = new Boton("Regresar",10);
        btnRegreso.setBounds(200, 125, 150, 50);
        panelSetting.add(btnRegreso);
        btnRegreso.addActionListener(e->{
            remove(panelSetting);
        });

    }
}
