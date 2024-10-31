 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartasEmparejadas;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author FP
 */
public class Ventana {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    
    ArrayList<Cartas> baraja = new ArrayList<>();
    
    JLabel carta1 = new JLabel();
    JLabel carta2 = new JLabel();
    JLabel carta3 = new JLabel();
    JLabel carta4 = new JLabel();
    JLabel carta5 = new JLabel();
    JLabel carta6 = new JLabel();
    
    Cartas primeraCartaGirada = null;
    Cartas segundaCartaGirada = null;
    JLabel primeraCartaLabel = null;
    JLabel segundaCartaLabel = null;
    boolean bloquearCartas = false;
    
    int contador1 = 0, contador2 = 0;
    
    int random1 = 0, random2 = 0, random3 = 0, random4 = 0, random5 = 0, random6 = 0;
    
    public Ventana() {
        frame.setVisible(true);
        frame.setTitle("");
        frame.setBounds(700, 200, 515, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        frame.add(panel);
        
        CrearBaraja();
        FondoPantalla();
        panel.updateUI();
    }
    
    public void CrearBaraja() {
        for (int i = 0; i < 6; i++) {
            if (i < 2) {
                baraja.add(new Cartas(i,"imagenes/reverso.jpg", "imagenes/scraggy.jpg"));
            }else if (i < 4) {
                baraja.add(new Cartas(i,"imagenes/reverso.jpg", "imagenes/raikou.png"));
            } else if (i < 7 ) {
                baraja.add(new Cartas(i,"imagenes/reverso.jpg", "imagenes/sylveon.png"));
            }
        }
        
        while ((random1 == random2) || (random1 == random3) || (random1 == random4) || (random1 == random5) || (random1 == random6) || (random2 == random3) || (random2 == random4) || (random2 == random5) || (random2 == random6) || (random3 == random4) || (random3 == random5) || (random3 == random6) || (random4 == random5) || (random4 == random6) || (random5 == random6))  {
            random1 = (int) (Math.random()*6);
            random2 = (int) (Math.random()*6);
            random3 = (int) (Math.random()*6);
            random4 = (int) (Math.random()*6);
            random5 = (int) (Math.random()*6);
            random6 = (int) (Math.random()*6);
        }
        
        ImageIcon imagen = new ImageIcon(baraja.get(2).reverso);
        
        colocarCarta(carta1, 50, 50, random1, imagen);
        colocarCarta(carta2, 200, 50, random2, imagen);
        colocarCarta(carta3, 350, 50, random3, imagen);
        colocarCarta(carta4, 50, 250, random4, imagen);
        colocarCarta(carta5, 200, 250, random5, imagen);
        colocarCarta(carta6, 350, 250, random6, imagen);
        
        panel.add(carta1);
        panel.add(carta2);
        panel.add(carta3);
        panel.add(carta4);
        panel.add(carta5);
        panel.add(carta6);
    }
        public void colocarCarta(JLabel carta, int x, int y, int random, ImageIcon reverso) {
            carta.setBounds(x, y, 100, 150);
            carta.setIcon(new ImageIcon(reverso.getImage().getScaledInstance(carta.getWidth(), carta.getHeight(), Image.SCALE_DEFAULT)));
            carta.setOpaque(true);
        
            carta.addMouseListener (new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {}

                @Override
                public void mousePressed(MouseEvent e) {
                    if (bloquearCartas) return;
                    
                    ImageIcon imagenCara = new ImageIcon(baraja.get(random).cara);
                    carta.setIcon(new ImageIcon(imagenCara.getImage().getScaledInstance(carta.getWidth(), carta.getHeight(), Image.SCALE_DEFAULT)));
                    
                    if (primeraCartaGirada == null) {
                        primeraCartaGirada = baraja.get(random);
                        primeraCartaLabel = carta;
                    } else if (segundaCartaGirada == null) {
                        segundaCartaGirada = baraja.get(random);
                        segundaCartaLabel = carta;
                        bloquearCartas = true;
                        compararCartas();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {}

                @Override
                public void mouseExited(MouseEvent e) {}
        });
    }
        
    public void compararCartas() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                if (primeraCartaGirada.cara.equals(segundaCartaGirada.cara)) {
                    contador1++;
                    primeraCartaGirada = null;
                    segundaCartaGirada = null;
                    if (contador1 == 3) {
                        JOptionPane.showMessageDialog(frame, "Has ganado en un total de " + (contador1 + contador2) + " intentos");
                    }
                } else {
                    contador2++;
                    primeraCartaLabel.setIcon(new ImageIcon(new ImageIcon(primeraCartaGirada.reverso).getImage().getScaledInstance(primeraCartaLabel.getWidth(), primeraCartaLabel.getHeight(), Image.SCALE_DEFAULT)));
                    segundaCartaLabel.setIcon(new ImageIcon(new ImageIcon(segundaCartaGirada.reverso).getImage().getScaledInstance(segundaCartaLabel.getWidth(), segundaCartaLabel.getHeight(), Image.SCALE_DEFAULT)));

                    primeraCartaGirada = null;
                    segundaCartaGirada = null;
                }
                bloquearCartas = false;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
    
    public void FondoPantalla(){
        JLabel fondo = new JLabel();
        
        fondo.setBounds(0, 0, 515, 500);
        ImageIcon imagen = new ImageIcon("imagenes/fondo.png");
        fondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT)));
        
        panel.add(fondo);
    }
}
