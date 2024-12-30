package Juego.Interfaz;

import javax.swing.*;

public class Inicio extends JFrame{
    
    private JButton btnEspada,btnArma;
    private JPanel panel;

    public Inicio(){
        panel = new JPanel();
        panel.setLayout(null);
        componentes();
        listener();
        add(panel);
        setSize( 500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void listener(){
        btnEspada.addActionListener(e->{
            new Juego(1);
        });
        btnArma.addActionListener(e->{
            new Juego(2);
        });
    }

    public void componentes(){
        btnEspada = new JButton("Espada");
        btnEspada.setBounds(50,20,150,40);
        panel.add(btnEspada);

        btnArma =  new JButton("Arma");
        btnArma.setBounds(50, 80, 150, 40);
        panel.add(btnArma);
    }

    public static void main(String[] args) {
        new Inicio();
    }
}
