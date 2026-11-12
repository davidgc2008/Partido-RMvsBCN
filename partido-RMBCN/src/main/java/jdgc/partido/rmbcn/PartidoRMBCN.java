/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package jdgc.partido.rmbcn;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author usuariom
 */
public class PartidoRMBCN {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==== Nombre equipo 1 ====");
        String eq1 = sc.nextLine();
        System.out.println("==== Nombre equipo 2 ====");
        String eq2 = sc.nextLine();
        System.out.println("Partido entre: " + eq1 + " y " + eq2);

        jugadoresEquipos(eq1, eq2);
    }

    public static void jugadoresEquipos(String eq1, String eq2) {
        System.out.println("Introduzca los jugadores del " + eq1);

        String[] jugadores = new String[11];

        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("Introduce el nombre del jugador " + (i + 1) + ":");

            jugadores[i] = sc.nextLine();
        }

        System.out.println("Introduzca los jugadores del " + eq2);

        String[] jugadores2 = new String[11];

        for (int i = 0; i < jugadores2.length; i++) {
            System.out.println("Introduce el nombre del jugador " + (i + 1) + ":");

            jugadores2[i] = sc.nextLine();
        }
        eleccionTitulares1(jugadores, eq1);
    }

    public static void eleccionTitulares1(String jugadores[], String eq1) {
        System.out.println("===== Seleccion aleatoria de titulares =====");

        String[] titulares1 = new String[5];

        System.out.println("=== Titulares " + eq1 + " ===");
        for (int e = 0; e < titulares1.length; e++) {

            int titularesPos1 = ThreadLocalRandom.current().nextInt(jugadores.length);
            titulares1[e] = jugadores[titularesPos1];
            System.out.println(titulares1[e]);

        }
        
        return titulares1[];
    }

    public static void eleccionTitulares2(String jugadores2[], String eq2) {
        
        String[] titulares2 = new String[5];
        
        System.out.println("=== Titulares " + eq2 + " ===");
        
        for (int e = 0; e < titulares2.length; e++) {

            int titularesPos2 = ThreadLocalRandom.current().nextInt(jugadores2.length);
            titulares2[e] = jugadores2[titularesPos2];
            System.out.println(titulares2[e]);

        }

    }

}
