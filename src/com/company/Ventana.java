package com.company;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame {

    Juego juego;
    Texto texto;
    Titulo titulo;

    Ventana() {
        setTitle("Hundir la Flota 2.0");

        //--CARACTERISTICAS DE LA VENTANA

        this.setResizable(false);
        this.setIconImage(new ImageIcon("src\\imagenes\\icono.png").getImage());

        setBounds(100, 100, 490, 1010);
        setLocationRelativeTo(null);

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        juego = new Juego();
        add(juego, BorderLayout.CENTER);

        texto = new Texto();
        add(texto, BorderLayout.SOUTH);

        titulo = new Titulo();
        add(titulo, BorderLayout.NORTH);

        setVisible(true);
    }
}


