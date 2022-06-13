package com.company;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Titulo extends JPanel {
    JPanel barra;
    JPanel panel_titulo = new JPanel();
    JLabel titulo;

    Titulo() {
        barra = new JPanel();
        setLayout(new GridLayout(2, 1));
        panel_titulo.setBorder(new EmptyBorder(0, 0, 0, 0));
        add(barra);

        //------------------------------

        add(panel_titulo);

        this.setBorder(new EmptyBorder(0, 0, 0, 0));

        //TITULO
        titulo = new JLabel("HUNDIR LA FLOTA - BY VOLKAN :)", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial Black", 1, 20));
        titulo.setForeground(new Color(51, 133, 255));
        titulo.setVisible(true);
        panel_titulo.add(titulo);
    }
}


