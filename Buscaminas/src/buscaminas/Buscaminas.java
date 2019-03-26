package buscaminas;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Buscaminas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int numFilas,numColum;
        
        System.out.println("Dame filas y columnas");
        numFilas= leer.nextInt();
        numColum= leer.nextInt();
        Tablero t = new Tablero(numFilas, numColum);
        t.insertarMinas();
        t.imprimirPrueba();
        
    }
    
}
