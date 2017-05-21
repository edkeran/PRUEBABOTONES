/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebabotones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author edgar
 */
public class Nivel1 extends JFrame implements MouseListener,ActionListener{
    JButton boton1;
    JButton boton2;
    JButton boton3;
    String cabeza1,cabeza2,cabeza3,cabeza4,cabeza5,cabeza6;
    JButton aux;
    int filas = 10;
    int columnas = 10;
    int contador = 1;
    int auxX = 0;
    int auxY = 0;
    int color=0;
    private Map<String, JButton> mapaBoton;
    public Nivel1() {
        setSize(600,600);
        aux= new JButton("....");
        aux.setBackground(Color.white);
        aux.addMouseListener(this);
        aux.setBounds(0, 200, 200, 20);
        add(aux);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        mapaBoton = new HashMap<String, JButton>();
        for(int i = 0; i < filas; i++) {
            auxX = 0;
            for(int j = 0; j < columnas; j++) {
                JButton boton = new JButton("Boton " + contador);
                boton.setBounds(auxX, auxY, 20, 20);
                boton.setActionCommand("Boton " + contador);
                boton.setBackground(Color.BLACK);
                if (contador==1){
                boton.setBackground(Color.red);
                cabeza1="Boton " + contador;
                }
                if (contador==10){
                boton.setBackground(Color.red);
                cabeza2="Boton " + contador;
                }
                if (contador==21){
                boton.setBackground(Color.BLUE);
                cabeza3="Boton " + contador;
                }
                if(contador==39){
                boton.setBackground(Color.BLUE);
                cabeza4="Boton " + contador;
                }
                if (contador==100){
                boton.setBackground(Color.yellow);
                cabeza5="Boton " + contador;
                }
                if (contador==50){
                boton.setBackground(Color.yellow);
                cabeza6="Boton " + contador;
                }
                boton.addMouseListener(this);
                boton.addActionListener(this);
                mapaBoton.put("Boton " + contador, boton);
                add(boton);         
                auxX += 20;
                contador++;
            }
            auxY += 20;
        }
       /* boton1= new JButton("1");
        boton1.setBackground(Color.red);
        boton1.addMouseListener(this);
        boton1.addActionListener(this);
        boton2= new JButton("2");
        boton2.addMouseListener(this);
        boton3= new JButton("3");
        boton3.addMouseListener(this);
        boton1.setBounds(0, 0, 20, 20);
        boton2.setBounds(20, 0, 20, 20);
        boton3.setBounds(40, 0, 20, 20);
        add(boton1);
        add(boton2);
        add(boton3);*/
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e){
       if (((JButton) e.getSource()).getBackground()== Color.white){
           repintar(color);
           color=0;
           System.out.println("SALIO");
           
       }else{
            if (((JButton) e.getSource()).getBackground()==Color.red){
            color=1;
            }
            if (((JButton) e.getSource()).getBackground()==Color.BLUE){
                color=2;
            }
            if(((JButton) e.getSource()).getBackground()==Color.yellow){
                color=3;
            }
            if (color==1){
                ((JButton) e.getSource()).setBackground(Color.red);
            }
            if (color==2){
                ((JButton) e.getSource()).setBackground(Color.BLUE);
            }
            if (color==3){
                ((JButton) e.getSource()).setBackground(Color.yellow);
            }
       }
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    private void repintar(int a){
        contador=1;
        for (int i=1;i<=100;i++){
            if (a==3){
                if (mapaBoton.get("Boton " + contador).getBackground()==Color.yellow){
                        mapaBoton.get("Boton " + contador).setBackground(Color.BLACK);
                        mapaBoton.get(cabeza5).setBackground(Color.yellow);
                        mapaBoton.get(cabeza6).setBackground(Color.yellow);
                }
            }
            if (a==2){
                if (mapaBoton.get("Boton " + contador).getBackground()==Color.BLUE){
                            mapaBoton.get("Boton " + contador).setBackground(Color.BLACK);
                            mapaBoton.get(cabeza3).setBackground(Color.BLUE);
                            mapaBoton.get(cabeza4).setBackground(Color.BLUE);
                    }
            }
            if(a==1){
                if (mapaBoton.get("Boton " + contador).getBackground()==Color.red){
                            mapaBoton.get("Boton " + contador).setBackground(Color.BLACK);
                            mapaBoton.get(cabeza1).setBackground(Color.red);
                            mapaBoton.get(cabeza2).setBackground(Color.red);
                    }
            }                     
            contador++;
        }
    }
    
}
