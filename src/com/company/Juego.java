package com.company;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class Juego extends JPanel {

    Tablero t_contrincante;
    Tablero t_jugador;

    Juego() {
        GridLayout layout = new GridLayout(2, 1);
        setLayout(layout);

        //--TABLERO CONTRINCANTE------

        t_contrincante = new Tablero(false);
        add(t_contrincante);

        //--AÑADIR TABLERO JUGADOR------

        t_jugador = new Tablero(true);
        add(t_jugador);
    }
}

