/*
 * Vamos a intentar usar GIT  (github) como repositorio del proyecto
 */
package contrarreloj;

import java.util.Scanner;

/**
 * para llevar una contrarreloj ciclista
 *
 * @author ZEMEDU
 */
public class Contrarreloj {

    public static void main(String[] args) {

        //variables globales
        int opcion, dorsal, tiempo , puesto = 0; 
        
        int llegados = 0;  // corredores llegados
        int ultima= -1;  // ultima celda ocupada del array clasificacion
        
        int comprueba; // para saber si el dorsal es válido

        Corredor corredores[] = new Corredor[6];   // el array de los corredores inscritos 
        
        // el array con la clasificación provisional 
        
        Dorti clasificacion []= new Dorti [6];        
        Dorti.inicializar (clasificacion);
        
        // cargar los datos de los corredores 
        Corredor.cargarDatos(corredores); // rellena el array  corredores                 
        
        Scanner z = new Scanner(System.in);
        opcion = Corredor.menu();

        while (opcion != 99) {
            switch (opcion) {

                case 0:  // meter más datos de corredores, opcion oculta
                    break;
                case 1:  // mostrar la clasificación
                    //mostrar solo los que ya llegaron
                    if (llegados > 0) {
                        System.out.println("Posición | Tiempo  | Dorsal  |  Nombre     |   Equipo");
                        for (int i = 0; i < 6; i++) {                
                            System.out.println("-----------------------------------------------------");
                            System.out.println("   "+ (i+1) +"º    |   " + clasificacion[i].tiempo + "    |   " + clasificacion[i].dorsal + "     |  "+ 
                                                corredores[i].nombre+ "    |  "+ corredores[i].equipo);                           
                        }   
                    }else{
                        System.out.println("No llegaron aún los corredores");
                    }
                    System.out.println("  "); 
                    break;
                case 2: // libre
                    break;
                    
                case 3: // anotar la llegada de un corredor
                    System.out.println(" teclea dorsal : ");
                    dorsal = z.nextInt();
                    // comprobar que existe ese dorsal y que no esté ya anotado
                    comprueba = Dorti.comprobar(dorsal, corredores, clasificacion);
                    if (comprueba == 0) {
                        // el dorsal es correcto, lo procesamos                       
                        System.out.println(" teclea tiempo  : ");
                        tiempo = z.nextInt();
                        llegados++;
                        puesto = Dorti.clasificar(dorsal, tiempo, clasificacion, llegados);
                        
                        //saber la posicion y ordenar todos los datos del corredor
                        String auxEquipo;
                        String auxNombre;
                        String auxNacionalidad;
                        puesto = puesto - 1;
                        
                        for (int i = 0; i < corredores.length; i++) {
                            if (corredores[i].dorsal == dorsal) {
                                auxEquipo = corredores[i].equipo ;                
                                corredores[i].equipo = corredores[puesto].equipo;    
                                corredores[puesto].equipo = auxEquipo; 
                            
                                auxNombre = corredores[i].nombre;                
                                corredores[i].nombre = corredores[puesto].nombre;    
                                corredores[puesto].nombre = auxNombre; 
                                
                                auxNacionalidad = corredores[i].nacionalidad;                
                                corredores[i].nacionalidad = corredores[puesto].nacionalidad;    
                                corredores[puesto].nacionalidad = auxNacionalidad; 
                                
                            }     
                        }
                        
                    } else if(comprueba == 1){
                        // el dorsal no es válido o no existe
                        System.out.println(" * * * Dorsal no válido o no existe  ");
                    } else if(comprueba == 2 ){
                        // ya está anotado pero ya llego
                        System.out.println(" * * * El corredor ya llegó ");
                    }

                    break;
                case 4: // libre
                    break;
                    
                case 5: // mostrar la información de un corredor
                    String nombre = null,equipo = null;
                    System.out.println("Dime el dorsal del corredor: ");
                    dorsal = z.nextInt(); 
                    comprueba = Dorti.comprobar(dorsal, corredores , clasificacion);
                    
                    if (comprueba == 0) {
                        // el dorsal es correcto, pero no llego entonces lo procesamos 
                        System.out.println("El dorsal es correcto, pero aún no llegó");
                        for (int i = 0; i < corredores.length; i++) {
                            if (dorsal == corredores[i].dorsal) {
                                System.out.println("Dorsal        -> "+ corredores[i].dorsal
                                                +"\nNombre        -> "+ corredores[i].nombre
                                                +"\nEquipo        -> "+ corredores[i].equipo
                                                +"\nNacionalidad  -> "+ corredores[i].nacionalidad);
                            }
                            
                        }
                    } else if(comprueba == 1){
                        // el dorsal no es válido o no existe
                        System.out.println(" * * * Dorsal no válido o no existe  ");
                    } else if(comprueba == 2){
                        // ya está anotado y ya llego
                        System.out.println(" * * * El corredor llegó ");
                        
                        System.out.println("Posición | Tiempo  | Dorsal  |  Nombre     |   Equipo");
                        for (int i = 0; i < clasificacion.length; i++) {    
                            if (dorsal == clasificacion[i].dorsal) {
                                System.out.println("-----------------------------------------------------");
                                System.out.println("   "+ (i+1) +"º    |   " + clasificacion[i].tiempo + "    |   " + clasificacion[i].dorsal + "     |  "+ corredores[i].nombre+ "    |  "+ corredores[i].equipo);                               
                            }
                        }  
                        
                    }                    
                case 6: // libre
                    break;
                    
                case 7: // mostrar la lista de corredores de la carrera
                    //ORDENACIÓN POR EL MÉTODO DE INSERCIÓN
                    for (int i = 0; i < corredores.length; i++) {
                        int pos = i;
                        int aux = corredores[i].dorsal;
                        
                        while ((pos > 0) && (corredores[pos-1].dorsal > aux)) {
                            corredores[pos].dorsal = corredores[pos-1].dorsal;
                            pos--;
                        }
                        corredores[pos].dorsal = aux;
                    }
                    Corredor.mostrarDatos(corredores);
                    break;
                case 8:// mostrar equipos participantes
                    
                    System.out.println("EQUIPO"
                                   + "\n___________________"); 
                    for (int i = 0; i <6; i++) {
                        String cadena = corredores[i].equipo;    
                        if (corredores[i].equipo == corredores[i+1].equipo) {
                            i++;
                        } 
                        System.out.println(corredores[i].equipo +" --> "+ cadena.substring(0,3));
                    }
                            
                    break;
                case 9: // mostrar información de un equipo
                    System.out.println("Dime el Equipo : ");
                    equipo = z.nextLine();

                    //mostrar los jugadores en el caso de que el equipo exista     
                    System.out.println("Equipo   corredor"
                                   + "\n-----------------");
                    for (int i = 0; i < corredores.length; i++) {                      
                        if ( corredores[i].equipo.equalsIgnoreCase(equipo)){ 
                            System.out.println(corredores[i].equipo + "  --  "+ corredores[i].nombre); 
                        }
                    }                    
                    break;
                default:
                    // podemos mostrar un mensaje de error
                    break;
            } // fin del switch

            opcion = Corredor.menu();

        } // del while 
    } // fin del main

} // fin de la class