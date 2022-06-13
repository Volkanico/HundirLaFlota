package com.company;
import javax.swing.*;

public class Partida {
    private Ventana juego = new Ventana();
    public Tablero t_jugador = juego.juego.t_jugador;
    private Tablero t_contrincante = juego.juego.t_contrincante;
    private Texto texto = juego.texto;
    private int[] barco_colocado = new int[5];
    private int bucle = 1;
    private JLabel titulo;

    private int contador1 = 0;
    private int contador2 = 0;

    //----METODOS---

    public void colocarBarco(Tablero tablero, int n_barcos) throws InterruptedException {

        tablero.anadirBarco(n_barcos);

        while (tablero.proceso == 1) {
            Thread.sleep(1);
        }
    }

    public void colocarBarcoAleatorio(Tablero tablero, int n_barcos, int barco_contador) {

        int aleatorio = (int) (Math.random() * 2 + 1);

        if (aleatorio == 1) {
            colocarBarcoAleatorioHorizontal(tablero, n_barcos, barco_contador);
        } else {
            colocarBarcoAleatorioVertical(tablero, n_barcos, barco_contador);
        }
    }

    public void colocarBarcoAleatorioHorizontal(Tablero tablero, int n_barcos, int barco_contador) {
        int aleatorio = (int) (Math.random() * 99 + 1);
        boolean valido = true;
        int bucle = 1;

        while (bucle == 1) {
            valido = true;
            aleatorio = (int) (Math.random() * 99 + 1);

            for (int i = 0; i < 5; i++) {
                if (barco_colocado[i] == aleatorio) {
                    valido = false;
                }
            }

            if (aleatorio % 10 > 10 - n_barcos) {
                valido = false;
            }
            if (tablero.boton[aleatorio].getActivo()) {
                valido = false;
            }

            if (tablero.anadirBarcoHorizontal(tablero.boton[aleatorio], n_barcos, barco_contador) == true && valido) { //la coordenada 0 da problemas y multiplica los barcos

                for (int x = 0; x < 100; x++) {
                    if (tablero.boton[x].getIluminado()) {
                        tablero.boton[x].setActivo(true);
                        tablero.boton[x].setColorDefault();
                        tablero.boton[x].setIdBarco(barco_contador);
                        tablero.boton[x].setIluminado(false);
                    }
                }
                barco_colocado[barco_contador - 1] = aleatorio;
                bucle = 0;
            }
        }
        tablero.barcosHorizontalBorrar(null);
    }

    public  void colocarBarcoAleatorioVertical(Tablero tablero, int n_barcos, int barco_contador) {
        int aleatorio = (int) (Math.random() * 99 + 1);
        boolean valido = true;
        setBucle(1);

        while (bucle == 1) {

            aleatorio = (int) (Math.random() * 99 + 1);

            for (int i = 0; i < 5; i++) {
                if (barco_colocado[i] == aleatorio) {
                    valido = false;
                }
            }
            if (aleatorio / 10 < n_barcos - 1) {
                valido = false;
            }
            if (tablero.boton[aleatorio].getActivo()) {
                valido = false;
            }
            if (tablero.anadirBarcoVertical(tablero.boton[aleatorio], n_barcos, barco_contador) == true && valido) {

                for (int x = 0; x < 100; x++) {
                    int contador_interno = 0;

                    if (contador_interno < n_barcos)

                        if (tablero.boton[x].getIluminado()) {
                            tablero.boton[x].setActivo(true);
                            tablero.boton[x].setColorDefault();
                            tablero.boton[x].setIdBarco(barco_contador);
                            tablero.boton[x].setIluminado(false);
                            contador_interno++;
                        }
                }
                barco_colocado[barco_contador - 1] = aleatorio;
                setBucle(0);
                valido = false;
            } else {
                valido = true;
            }
        }
        tablero.barcosHorizontalBorrar(null);
    }

    public void turno() throws InterruptedException {


        t_contrincante.elegirCasilla(-1);
        while (t_contrincante.proceso == 1) {
            Thread.sleep(1);
        }

        //-------------------------------------------------------------

        for (int x = 0; x < 100; x++) {
            if (t_contrincante.boton[x].getActivo()) {
                contador1++;
            }
            if (t_contrincante.boton[x].getTocado()) {
                contador2++;
            }
        }
        System.out.println("contador1:" + getContador1());
        System.out.println("contador2:" + getContador2());

        eventoGanado();

        //--------------------------------------------------------------

        if (getContador1() != getContador2()) {


            System.out.println("La I.A. está eligiendo la casilla para atacar.");
            Thread.sleep((int) (Math.random() * 3000 + 500));

            int aleatorio = (int) (Math.random() * 100);
            t_jugador.elegirCasilla(aleatorio);

            for (int x = 0; x < 100; x++) {
                if (t_jugador.boton[x].getActivo()) {
                    setContador1(getContador1() + 1);
                }
                if (t_jugador.boton[x].getHundido()) {
                    setContador2(getContador2() + 1);
                }
            }
            eventoPerdido();

            setContador1(0);
            setContador2(0);

        }
    }

    public void eventoGanado () {
        if (getContador1() == getContador2()) {
            setBucle(0);
            System.out.println("¡¡¡HAS GANADO!!!");
        }
    }
    public void eventoPerdido () {
        if (getContador1() == getContador2()) {
            setBucle(0);
            System.out.println("¡¡¡HAS PERDIDO!!!");
        } else {
            System.out.println("La I.A. ha atacado. Es tu turno.");
        }
    }

    public Tablero getT_jugador() {
        return t_jugador;
    }

    public Tablero getT_contrincante() {
        return t_contrincante;
    }

    public int getBucle() {
        return bucle;
    }

    public void setBucle(int bucle) {
        this.bucle = bucle;
    }

    public int getContador1() {
        return contador1;
    }

    public int getContador2() {
        return contador2;
    }

    public void setContador1(int contador1) {
        this.contador1 = contador1;
    }

    public void setContador2(int contador2) {
        this.contador2 = contador2;
    }

}

