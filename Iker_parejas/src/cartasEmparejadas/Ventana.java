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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author FP
 */
public class Ventana {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    
    ArrayList<Cartas> baraja = new ArrayList<>();
    
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
        panel.updateUI();
    }
    
    public void FondoPantalla(){
        JLabel fondo = new JLabel();
        
        fondo.setBounds(0, 0, 500, 500);
        ImageIcon imagen = new ImageIcon("");
        fondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT)));
        
        panel.add(fondo);
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
        
        JLabel carta1 = new JLabel();
        JLabel carta2 = new JLabel();
        JLabel carta3 = new JLabel();
        JLabel carta4 = new JLabel();
        JLabel carta5 = new JLabel();
        JLabel carta6 = new JLabel();
        
        ImageIcon imagen = new ImageIcon(baraja.get(2).reverso);
        
        carta1.setBounds(50, 50, 100, 150);
        carta1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta1.getWidth(), carta1.getHeight(), Image.SCALE_DEFAULT)));
        carta1.setOpaque(true);
        
        carta2.setBounds(200, 50, 100, 150);
        carta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta2.getWidth(), carta2.getHeight(), Image.SCALE_DEFAULT)));
        carta2.setOpaque(true);
        
        carta3.setBounds(350, 50, 100, 150);
        carta3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta3.getWidth(), carta3.getHeight(), Image.SCALE_DEFAULT)));
        carta3.setOpaque(true);
        
        carta4.setBounds(50, 250, 100, 150);
        carta4.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta4.getWidth(), carta4.getHeight(), Image.SCALE_DEFAULT)));
        carta4.setOpaque(true);
        
        carta5.setBounds(200, 250, 100, 150);
        carta5.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta5.getWidth(), carta5.getHeight(), Image.SCALE_DEFAULT)));
        carta5.setOpaque(true);
        
        carta6.setBounds(350, 250, 100, 150);
        carta6.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta6.getWidth(), carta6.getHeight(), Image.SCALE_DEFAULT)));
        carta6.setOpaque(true);
        
        int random1 = 0, random2 = 0, random3 = 0, random4 = 0, random5 = 0, random6 = 0;
        
        while ((random1 == random2) || (random1 == random3) || (random1 == random4) || (random1 == random5) || (random1 == random6) || (random2 == random3) || (random2 == random4) || (random2 == random5) || (random2 == random6) || (random3 == random4) || (random3 == random5) || (random3 == random6) || (random4 == random5) || (random4 == random6) || (random5 == random6))  {
            random1 = (int) (Math.random()*6);
            random2 = (int) (Math.random()*6);
            random3 = (int) (Math.random()*6);
            random4 = (int) (Math.random()*6);
            random5 = (int) (Math.random()*6);
            random6 = (int) (Math.random()*6);
        }
        System.out.println(random1 + " " + random2 + " " + random3 + " " + random4 + " " + random5 + " " + random6);
        
        MouseListener girar1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                imagen.setImage(new ImageIcon(baraja.get(random1).cara).getImage());
                carta1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta1.getWidth(), carta1.getHeight(), Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    Thread.sleep(1000);
                    imagen.setImage(new ImageIcon(baraja.get(random1).reverso).getImage());
                    carta1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta1.getWidth(), carta1.getHeight(), Image.SCALE_DEFAULT)));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        };
        
        MouseListener girar2 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                imagen.setImage(new ImageIcon(baraja.get(random2).cara).getImage());
                carta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta2.getWidth(), carta2.getHeight(), Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    Thread.sleep(1000);
                    imagen.setImage(new ImageIcon(baraja.get(random2).reverso).getImage());
                    carta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta2.getWidth(), carta2.getHeight(), Image.SCALE_DEFAULT)));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        };
        
        MouseListener girar3 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                imagen.setImage(new ImageIcon(baraja.get(random3).cara).getImage());
                carta3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta3.getWidth(), carta3.getHeight(), Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    Thread.sleep(1000);
                    imagen.setImage(new ImageIcon(baraja.get(random3).reverso).getImage());
                    carta3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta3.getWidth(), carta3.getHeight(), Image.SCALE_DEFAULT)));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        };
        
        MouseListener girar4 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                imagen.setImage(new ImageIcon(baraja.get(random4).cara).getImage());
                carta4.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta4.getWidth(), carta4.getHeight(), Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    Thread.sleep(1000);
                    imagen.setImage(new ImageIcon(baraja.get(random4).reverso).getImage());
                    carta4.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta4.getWidth(), carta4.getHeight(), Image.SCALE_DEFAULT)));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        };
        
        MouseListener girar5 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                imagen.setImage(new ImageIcon(baraja.get(random5).cara).getImage());
                carta5.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta5.getWidth(), carta5.getHeight(), Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    Thread.sleep(1000);
                    imagen.setImage(new ImageIcon(baraja.get(random5).reverso).getImage());
                    carta5.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta5.getWidth(), carta5.getHeight(), Image.SCALE_DEFAULT)));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        };
        
        MouseListener girar6 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                imagen.setImage(new ImageIcon(baraja.get(random6).cara).getImage());
                carta6.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta6.getWidth(), carta6.getHeight(), Image.SCALE_DEFAULT)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    Thread.sleep(1000);
                    imagen.setImage(new ImageIcon(baraja.get(random6).reverso).getImage());
                    carta6.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(carta6.getWidth(), carta6.getHeight(), Image.SCALE_DEFAULT)));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        };
        
        carta1.addMouseListener(girar1);
        carta2.addMouseListener(girar2);
        carta3.addMouseListener(girar3);
        carta4.addMouseListener(girar4);
        carta5.addMouseListener(girar5);
        carta6.addMouseListener(girar6);
        
        panel.add(carta1);
        panel.add(carta2);
        panel.add(carta3);
        panel.add(carta4);
        panel.add(carta5);
        panel.add(carta6);
    }
}
