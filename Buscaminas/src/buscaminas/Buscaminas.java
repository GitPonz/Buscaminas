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
        int numFilas,numColum,minas;
        
        System.out.println("Dame filas, columnas y minas");
        numFilas= leer.nextInt();
        numColum= leer.nextInt();
        minas = leer.nextInt();
        Tablero t = new Tablero(numFilas, numColum);
        t.insertarMinas(minas);
        t.imprimirPrueba();
        
    }
    
}
