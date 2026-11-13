/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package jdgc.ejerciciosemaforo_enums;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author usuariom
 */
public class EjercicioSemaforo_enums {

    enum ColoresSemaforo {
        ROJO, AMARILLO, VERDE
    }

    public static void main(String[] args) {

        ColoresSemaforo[] colores = ColoresSemaforo.values();

        ColoresSemaforo color = numRan(colores);

        switch (color) {
            case ROJO:
                System.out.println("Rojo. Quieto");
                break;
            case AMARILLO:
                System.out.println("Amarillo. Ve parando");
                break;
            case VERDE:
                System.out.println("Verde. Continua");
            default:
                System.out.println("Color no disponible de semaforo");
        }
    }

    public static ColoresSemaforo numRan(ColoresSemaforo[] colores) {
        System.out.println("Pon el color");
        int miNumero = ThreadLocalRandom.current().nextInt(0, colores.length);
        System.out.println(miNumero);

        return colores[miNumero];
    }
}
