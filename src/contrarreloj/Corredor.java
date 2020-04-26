package contrarreloj;

import java.util.Scanner;

public class Corredor {

    // atributos    
    int dorsal;
    String nombre;
    String equipo,nacionalidad;

    // metodo constructor
    public Corredor(int dorsal, String nombre, String equipo, String nacionalidad) {

        this.dorsal = dorsal;
        this.nombre = nombre;
        this.equipo = equipo;
        this.nacionalidad = nacionalidad;

    }

    public static void mostrarDatos(Corredor aaa[]) {
        
        System.out.println("Dorsal  |  Nombre    ->    Equipo   ->  Nacionalidad");
        System.out.println("---------------------------");
        for (int d = 0; d < aaa.length; d++) {  
            
            System.out.println("  " + aaa[d].dorsal + "    |  " + aaa[d].nombre + "    ->    " + aaa[d].equipo + "     ->    "+aaa[d].nacionalidad);
        }
        System.out.println(" * - * - * - * ");

    }

    public static void cargarDatos(Corredor aaa[]) {

        int dorsal = 10;
        String nombre = "Merck";
        String equipo = "TDK";
        String nacionalidad = "ALEM";

        // Corredor uno;
        Corredor uno = new Corredor(dorsal, nombre, equipo, nacionalidad);

        aaa[0] = uno;

        aaa[1] = new Corredor(20, "Perico", "Banesto","POR ");
        aaa[2] = new Corredor(30, "Cristian", "Banesto","POR");
        aaa[3] = new Corredor(15, "Mickel", "Red bull","FRA");
        aaa[4] = new Corredor(22, "Indurain", "Red bull","ALEM");
        aaa[5] = new Corredor(25, "Mariano", "Movistar","ESP");

    }

    public static int menu() {

        int leido;
        Scanner entradaTeclado = new Scanner(System.in);

        System.out.println(" ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("1 : Mostrar la clasificación");
        System.out.println("3 : Llegada de un corredor");
        System.out.println("5 : Mostrar información de un corredor");
        System.out.println("7 : Mostrar la lista de corredores/corredores participantes ");
        System.out.println("8 : Mostrar los equipos participantes");
        System.out.println("9 : Mostrasr información de un equipo");
        System.out.println("99 : Salir");

        leido = entradaTeclado.nextInt();
        return (leido);
    } // fin del método menu

    public void mostrarUno(int dorsal) {

        // muestra los datos de un corredor
        System.out.println("Corredor : " + this.dorsal /*+ " >> " + this.nombre + " >> " + this.equipo*/);

    }

} // fin de la class corredor