package com.company;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Texto extends JPanel {
    JLabel texto = new JLabel("HUNDIR LA FLOTA");

    Texto() {
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 25, 0, new JPanel().getBackground()));
        add(texto);
        texto.setFont(this.getFont().deriveFont(17.0f));
    }
}

