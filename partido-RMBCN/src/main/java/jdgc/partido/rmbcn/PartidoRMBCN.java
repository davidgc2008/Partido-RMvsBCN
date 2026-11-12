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
        //Pido nombres de los equipos 
        System.out.println("==== Nombre equipo 1 ====");
        String eq1 = sc.nextLine();
        System.out.println("==== Nombre equipo 2 ====");
        String eq2 = sc.nextLine();
        System.out.println("Partido entre: " + eq1 + " y " + eq2);
        //Defino los arrays que voy a usar en los demas cajones
        String[] jugadores = new String[11];
        String[] jugadores2 = new String[11];

        String[] titulares1 = new String[5];
        String[] titulares2 = new String[5];
        //Defino el enum de los puntajes
        enum puntajes {
            GOL, ASISTENCIA, REGATE, NADA
        }
        //Defino los cajones para que el main los ejecute en ese orden
        jugadoresEquipos(eq1, eq2, jugadores, jugadores2);

        System.out.println("===== Seleccion aleatoria de titulares =====");

        eleccionTitulares1(jugadores, eq1, titulares1);
        eleccionTitulares2(jugadores2, eq2, titulares2);
        puntajesEquipo1(titulares1, eq1);
    }

    public static void jugadoresEquipos(String eq1, String eq2, String[] jugadores, String[] jugadores2) {
        System.out.println("Introduzca los jugadores del " + eq1);
        //Bucle para que se me rellene el array completo a traves del usuario 
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("Introduce el nombre del jugador " + (i + 1) + ":");

            jugadores[i] = sc.nextLine();
        }

        System.out.println("Introduzca los jugadores del " + eq2);
        //+ de lo mismo pero con el otro equipo
        for (int i = 0; i < jugadores2.length; i++) {
            System.out.println("Introduce el nombre del jugador " + (i + 1) + ":");

            jugadores2[i] = sc.nextLine();
        }
    }

    public static void eleccionTitulares1(String jugadores1[], String eq1, String[] titulares1) {

        System.out.println("=== Titulares " + eq1 + " ===");

        for (int e = 0; e < titulares1.length; e++) {
            //titulares2 es array en el que se van a guardar
            //jugadores2 es el array que he introducido los nombres
            boolean repe; //Boolean para saber que no se vayan a repetir los nombres de los titulares
            String elegido;

            do {
                repe = false; // se reinicia en cada intento

                int titularesPos1 = ThreadLocalRandom.current().nextInt(jugadores1.length);
                elegido = jugadores1[titularesPos1];

                // comparo con los titulares ya guardados (de 0 a e-1)
                for (int j = 0; j < e; j++) {
                    if (titulares1[j].equals(elegido)) {
                        repe = true;
                    }
                }
            } while (repe == true); // si estaba repetido, vuelve a buscar otro

            titulares1[e] = elegido; // solo se guarda cuando ya no se repite
            System.out.println(titulares1[e]);
        }
    }

    public static void eleccionTitulares2(String jugadores2[], String eq2, String[] titulares2) { // +de lo mismo que el 1

        System.out.println("=== Titulares " + eq2 + " ===");

        for (int e = 0; e < titulares2.length; e++) {

            boolean repe;
            String elegido;

            do {
                repe = false;

                int titularesPos2 = ThreadLocalRandom.current().nextInt(jugadores2.length);
                elegido = jugadores2[titularesPos2];

                for (int j = 0; j < e; j++) {
                    if (titulares2[j].equals(elegido)) {
                        repe = true;
                    }
                }
            } while (repe == true);

            titulares2[e] = elegido;
            System.out.println(titulares2[e]);
        }
    }

    public static void puntajesEquipo1(String[] titulares1,  enum puntaje, String eq1) {
        System.out.println("Introduce lo que ha hecho cada jugador");
        System.out.println("=== Puntajes ===\nGol: 3 ptos.\nAsistencia: 2 ptos.\nRegate: 1 pto.\nNada: 0 ptos.");

        puntaje equipo1 = switch (equipo1) {
            case GOL:
                System.out.println("+3 puntos para " + eq1 + " por " +);
                break;
            case ASISTENCIA:
                System.out.println("+2 para " + eq1 + " por " +);
                break;
            case REGATE:
                System.out.println("+1 para " + eq1 + " por " +);
                break;
            case NADA:
                System.out.println("+0 para" + eq1 + " por " +);
                break;
            default:
                System.out.println("Valor mal añadido");
        } 
    }

}
