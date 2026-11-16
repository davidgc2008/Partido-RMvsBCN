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

    enum Puntajes {
        GOL, ASISTENCIA, REGATE, NADA
    }

    public static void main(String[] args) {
        final int TAMA = 5;
        final int CONVO = 11;
        //Pido nombres de los equipos 
        System.out.println("==== Nombre equipo 1 ====");
        String eq1 = sc.nextLine();
        System.out.println("==== Nombre equipo 2 ====");
        String eq2 = sc.nextLine();
        System.out.println("Partido entre: " + eq1 + " y " + eq2);
        //Defino los arrays que voy a usar en los demas cajones
        String[] jugadores = new String[CONVO];
        String[] jugadores2 = new String[CONVO];

        String[] titulares1 = new String[TAMA];
        String[] titulares2 = new String[TAMA];
        //Defino el enum de los puntajes en String
        Puntajes[] puntos = Puntajes.values();
        //puntajesFurbol ptos = puntajesEquipo1(puntos);
        //Creo 2 arrays para guardar las puntuaciones de cada equipo
        int[] puntuacionesEq1 = new int[TAMA];
        int[] puntuacionesEq2 = new int[TAMA];
        //Defino los cajones para que el main los ejecute en ese orden
        jugadoresEquipos(eq1, eq2, jugadores, jugadores2);
        //Seleccion titulares
        System.out.println("===== Seleccion aleatoria de titulares =====");

        eleccionTitulares1(jugadores, eq1, titulares1);
        eleccionTitulares2(jugadores2, eq2, titulares2);
        //Puntuaciones
        System.out.println("===== Puntuaciones por jugador =====");
        //Aqui esta el switch con los valores de las puntuaciones
        puntajesEquipo(titulares1, eq1, puntuacionesEq1, puntos);
        puntajesEquipo(titulares2, eq2, puntuacionesEq2, puntos);
        //Variables para sumar los puntos y goles para el resultado final
        int totalEq1 = sumaPuntos(puntuacionesEq1);
        int totalEq2 = sumaPuntos(puntuacionesEq2);
        int golesEq1 = contarGoles(puntuacionesEq1);
        int golesEq2 = contarGoles(puntuacionesEq2);
        //Resultado final (Ganador)
        resultadoFinal(eq1, eq2, totalEq1, totalEq2, golesEq1, golesEq2);
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
        //Bucle for para rellenar en aleatorio el titulares 2
        for (int e = 0; e < titulares2.length; e++) {

            boolean repe;//boolean para comprobar que no salen 2 veces el mismo jugador
            String elegido;//Lo uso para guardar los nombres antes de meterlos al array 

            do {
                repe = false;

                int titularesPos2 = ThreadLocalRandom.current().nextInt(jugadores2.length);
                elegido = jugadores2[titularesPos2];
                //Compara para 100% no haya repetido y reinicia si lo esta cambiando el boolean a true
                for (int j = 0; j < e; j++) {
                    if (titulares2[j].equals(elegido)) {
                        repe = true;
                    }
                }
            } while (repe == true); //Mientras sea true (que se repita) va a seguir dando numeros

            titulares2[e] = elegido;
            System.out.println(titulares2[e]); //Imprime la posicion e del array (variable e del bucle for, no del anidado do while
        }
    }

    public static void puntajesEquipo(String[] titulares1, String eq1, int[] puntuacionesEq1, Puntajes[] puntos) {

        System.out.println("Introduce lo que ha hecho cada jugador");
        System.out.println("=== Puntajes ===\nGol: 3 ptos.\nAsistencia: 2 ptos.\nRegate: 1 pto.\nNada: 0 ptos.");
        //For longitud titulares1
        for (int x = 0; x < titulares1.length; x++) {
            System.out.println("Introduzca la accion del jugador:  " + titulares1[x]);
            //ptos toma su valor del metodo puntuacionesGenerales donde se lee lo que dice el usuario
            Puntajes ptos = puntuacionesGenerales(puntos, titulares1);
            //Coge puntos y da un valor en funcion de lo que ha escrito el usuario
            switch (ptos) {
                case GOL:
                    puntuacionesEq1[x] = 3;
                    break;
                case ASISTENCIA:
                    puntuacionesEq1[x] = 2;
                    break;
                case REGATE:
                    puntuacionesEq1[x] = 1;
                    break;
                case NADA:
                    puntuacionesEq1[x] = 0;
                    break;
                default:
                    System.out.println("");
            }
        }
    }

    public static Puntajes puntuacionesGenerales(Puntajes[] puntos, String[] titulares1) {
        //Mientras la condicion del while sea TRUE entra a preguntar al usuario para que escriba infinitamente (Por si salta el try/catch) hasta que se ejecuta el return
        while (true) {
            System.out.println("GOL, ASISTENCIA, REGATE, NADA");
            String entrada = sc.nextLine().toUpperCase();//Lo pone todo en mayus el Upper case

            try {
                return Puntajes.valueOf(entrada);//Distingue mayus y minus para lanzar illegalArgumentException si algo no va bien (Si no se pone en mayus)
            } catch (IllegalArgumentException e) {
                System.out.println("Mal añadido, inténtalo de nuevo");
            }
        }
    }

    public static int sumaPuntos(int[] puntuaciones) {
        //Definicion en 0 de la variable
        int total = 0;
        for (int i = 0; i < puntuaciones.length; i++) { //Bucle para sumar
            total += puntuaciones[i];//Asigna
        }
        return total; //Devuelve a la variable total lo que ha sumado
    }

    public static int contarGoles(int[] puntuaciones) { //Hace comparacion en puntuaciones para saber si es 3, lo que significa que es gol
        int goles = 0;
        for (int i = 0; i < puntuaciones.length; i++) {
            if (puntuaciones[i] == 3) {
                goles++;
            }
        }
        return goles;
    }

    public static void resultadoFinal(String eq1, String eq2, int totalEq1, int totalEq2, int golesEq1, int golesEq2) {
        System.out.println("===== Resultado final =====");
        System.out.println(eq1 + ": " + totalEq1 + " ptos");
        System.out.println(eq2 + ": " + totalEq2 + " ptos");
        System.out.println("Marcador: " + eq1 + " " + golesEq1 + " - " + golesEq2 + " " + eq2);

        if (golesEq1 > golesEq2) {
            System.out.println("Gana " + eq1);
        } else if (golesEq2 > golesEq1) {
            System.out.println("Gana " + eq2);
        } else {
            System.out.println("Empate");
        }
    }
}
