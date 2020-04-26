
package contrarreloj;

/**
 * declaramos aquí un nuevo objeto dorti  ( dorsal-tiempo)
 * y la tabla de clasificacion que es un array de dortis
 */
public class Dorti {

    // atributos
    int dorsal;
    int tiempo;

    // metodo constructor 
    public Dorti(int dorsal, int tiempo) {
        this.dorsal = dorsal;
        this.tiempo = tiempo;
    }

    public static void inicializar(Dorti aaa[]) {

        /* le paso un dorsal, un tiempo, y lo pone en el array de clasificacion en la última celda libre */
        for (int i = 0; i < aaa.length; i++) {
            
            aaa[i] = new Dorti(-1, 99999);    
            
        }
    }

    public static int clasificar(int dorsal, int tiempo, Dorti aaa[], int llegados) {

        /* le paso un dorsal, un tiempo, y lo pone en el array de clasificacion en la última celda libre */
        
        aaa[llegados].dorsal = dorsal;
 
        aaa[llegados].tiempo = tiempo;

        /* ahora ordena el array por el tiempo , método de los jugadores de cartas */
        int puesto;
        //MÉTODO BURBUJA
        for (int i = 0; i < aaa.length; i++) {
            int auxtiempo = 0; 
            int auxdorsal = 0;
            /*aquí ordeno el tiempo con su dorsal*/
            if (aaa[i].tiempo > aaa[llegados].tiempo ) {
                auxtiempo = aaa[i].tiempo;                
                aaa[i].tiempo = aaa[llegados].tiempo;    
                aaa[llegados].tiempo = auxtiempo;
                                
                auxdorsal = aaa[i].dorsal;                
                aaa[i].dorsal = aaa[llegados].dorsal;    
                aaa[llegados].dorsal = auxdorsal;    
                puesto = i;
            }
        }        
        /* y devuelve en que puesto quedó */ 
        return (llegados);

    }

    public static void mostrarClasificacion(Dorti aaa[], int llegados) {
        
        System.out.println("Posición | Tiempo | Dorsal  |  Nombre   |   Equipo");
        for (int i = 0; i < llegados; i ++) {
            System.out.println("---------------------------");
            System.out.println("   "+ (i+1) +"     |   " + aaa[i].tiempo + "   |   " + aaa[i].dorsal + "  |  ");
        }
        System.out.println(" * - * - * - * ");

    }
    public static int comprobar( int dorsal , Corredor corredores [], Dorti clasificacion []) {

        int valido = 0; 
        boolean inscrito= false; 
        boolean yaLlego= false;
        
        //se comprueba que es un dorsal de un corredor que está inscrito
        for ( Corredor aux  :  corredores ) {
            if ( aux.dorsal == dorsal) inscrito =true ;
        }
        
        // se comprueba si ese dorsal ya está anotado como llegado
        for ( Dorti aux  :  clasificacion ) {
            if ( aux.dorsal == dorsal) yaLlego =true ;
        }
        if ( inscrito && !yaLlego) 
            valido = 0;  
        
        if ( !inscrito ) 
            valido = 1;
        
        if ( inscrito && yaLlego) 
            valido = 2;
        
        return (valido);
        
    }

}
