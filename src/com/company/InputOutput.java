package com.company;
import javax.swing.border.EmptyBorder;

public class InputOutput {
    private Partida partida = new Partida();
    private int bucle = partida.getBucle();

    public void partida () throws InterruptedException {
        partida.getT_jugador().setBorder(new EmptyBorder(0, 5, 0, 25));

        partida.getT_contrincante().rotar.setVisible(false);
        System.out.println("¡BIENVENIDO A HUNDIR LA FLOTA!");
        System.out.println();
        System.out.println("First game on graphic interface by Volkan with Swing. Enjoy :)");
        System.out.println();
        //-------EL JUGADOR COLOCA LOS 5 BARCOS------------------
        System.out.println("Coloca el barco de 3 casillas.");
        partida.colocarBarco(partida.getT_jugador(), 3);
        System.out.println("Coloca otro barco de 3 casillas.");
        partida.colocarBarco(partida.getT_jugador(), 3);
        System.out.println("Coloca el barco de 4 casillas.");
        partida.colocarBarco(partida.getT_jugador(), 4);
        System.out.println("Coloca otro barco de 4 casillas.");
        partida.colocarBarco(partida.getT_jugador(), 4);
        System.out.println("Coloca el barco de 5 casillas.");
        partida.colocarBarco(partida.getT_jugador(), 5);

        //AHORA EL PROGRAMA COLOCA LOS BARCOS EN EL TABLERO DEL CONTRINCANTE

        partida.colocarBarcoAleatorio(partida.getT_contrincante(), 3, 1);
        partida.colocarBarcoAleatorio(partida.getT_contrincante(), 3, 2);
        partida.colocarBarcoAleatorio(partida.getT_contrincante(), 4, 3);
        partida.colocarBarcoAleatorio(partida.getT_contrincante(), 4, 4);
        partida.colocarBarcoAleatorio(partida.getT_contrincante(), 5, 5);

        System.out.println("Ahora, la I.A. ha colocado sus barcos y puedes comenzar a jugar.");

        //AHORA COMIENZA EL JUEGO Y PUEDES ELEGIR LAS CASILLAS

        while (bucle == 1) {
            partida.turno();
        }
    }
}


