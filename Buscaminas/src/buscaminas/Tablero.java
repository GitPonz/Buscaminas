package buscaminas;

import java.util.Random;

/**
 *
 * @author alumno
 */
public class Tablero {
    private int numFilas;
    private int numColumnas;
    private int numMinas;
    private Casilla[][] tabla;

    public Tablero(int nFilas, int nColumnas) {
        tabla = new Casilla[nFilas][nColumnas];
        numFilas= nFilas;
        numColumnas= nColumnas;
        
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {               
                tabla[i][j] = new Casilla();
            }
        }
            
    }
    
    public void insertarMinas(){
        int vaFila;
        int vaColum;
        int minas=4; // Las minas se pediran mas adelante
   
  
        for (int i = 0; i < minas; i++) {
            
              Random r = new Random();
              Random r2 = new Random();
              
              vaFila = r.nextInt(numFilas);
              vaColum = r2.nextInt(numColumnas);
              
              tabla[vaFila][vaColum].setMina(true); 
              tabla[vaFila][vaColum].setBlanco(false); 
              
            }            
    }
    
    public void imprimirPrueba(){
        //PONER LOS NUMEROS ARRIBA
        System.out.print("    ");
        for (int i = 0; i < numColumnas; i++) {
            System.out.print(i+" ");
        }
        System.out.println("");
        

        System.out.print("    ");
        
        for (int i = 0; i < numColumnas; i++) {
            System.out.print("- ");
        }
        System.out.println("");
       
        
        //TABLERO 
        for (int i = 0; i < numFilas; i++) {
            System.out.print(i+" | ");
            for (int j = 0; j < numColumnas; j++) {
                tabla[i][j].setVisible(true);
                
                if(tabla[i][j].getMina()){
                   System.out.print("M ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println("| "+i);
        }
        
        //PONER LOS NUMEROS ABAJO

        System.out.print("    ");
        
        for (int i = 0; i < numColumnas; i++) {
            System.out.print("- ");
        }
        System.out.println("");
        
        System.out.print("    ");
        for (int i = 0; i < numColumnas; i++) {
            System.out.print(i+" ");
        }
        System.out.println("");
        

        
        
    }
 
}

