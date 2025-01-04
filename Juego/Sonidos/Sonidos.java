package Juego.Sonidos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

public class Sonidos {

    public  void reproducirDisparo(){
        try {
            // Cargar el archivo de audio
            File archivoAudio = new File("Disparo2.wav");

            // Crear un flujo de audio
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoAudio);

            // Obtener un clip de audio
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            // Establecer el volumen (por ejemplo, -10.0f reduce el volumen, 0.0f es el volumen máximo)
            gainControl.setValue(-15.0f); 

            // Cargar el audio en el clip

            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException  e) {
            System.out.println("Error al reproducir el sonido: " + e);
        }
    }
    public  void reproducirGolpe(){
        try {
            // Cargar el archivo de audio
            File archivoAudio = new File("RobloxGolpe2.wav");

            // Crear un flujo de audio
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoAudio);

            // Obtener un clip de audio
            Clip clip = AudioSystem.getClip();

            // Cargar el audio en el clip
            clip.open(audioStream);

            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException  e) {
            System.out.println("Error al reproducir el sonido: " + e);
        }
    }
}
