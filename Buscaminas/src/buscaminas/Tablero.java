package buscaminas;

import java.util.Random;

/**
 *
 * @author Jorge
 * @version 1.0
 */
public class Tablero {
    private int numFilas;
    private int numColumnas;
    private int numMinas;
    private Casilla[][] tabla;

    /**
     *
     * @param nFilas Numero de filas del tablero
     * @param nColumnas Numero de columnas el tablero
     */
    public Tablero(int nFilas, int nColumnas) {
        tabla = new Casilla[nFilas][nColumnas];
        numFilas= nFilas;
        numColumnas= nColumnas;
        
        //INICIALIZAR LAS CASILLAS YA QUE ESTA LA MATRIZ A NULL
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {               
                tabla[i][j] = new Casilla();
            }
        }
            
    }
    
    /**
     * @param 
     */
    public void insertarMinas(int minas){
        int vaFila;
        int vaColum;
        this.numMinas= minas;
        minas=4; // Las minas se pediran en siguientes versiones
   
  
        for (int i = 0; i < numMinas; i++) {
            
            Random r = new Random();
            Random r2 = new Random();
              
            vaFila = r.nextInt(numFilas);
            vaColum = r2.nextInt(numColumnas);
              
            if(tabla[vaFila][vaColum].isMina()){
                i--;                
                }else{
                    tabla[vaFila][vaColum].setMina(true); 
                    tabla[vaFila][vaColum].setBlanco(false);
                }
            } 
    }
    
    /**
     *
     */
    public void imprimirPrueba(){
        System.out.print("  ");
        for (int i = 0; i < numColumnas; i++) {
            System.out.print(i+" ");
        }
        System.out.println("");
        
        for (int i = 0; i < this.numFilas; i++) {
                System.out.print(i+"|");
            for (int j = 0; j < this.numColumnas; j++) {
                
                System.out.print(this.tabla[i][j].imprimirPrueba()+" ");
            }
            System.out.print("|"+i);
            System.out.println("");
        }
        
        System.out.print("  ");
       
        for (int i = 0; i < numColumnas; i++) {
            System.out.print(i+" ");
        }
        
        System.out.println("");
   
      
    }
    
    public int calcularnumCasillas(int fila, int columna){
        int num=0;
        int minascerca=0;
        for (int i = fila-1; i < fila+1; i++) {
            for (int j = columna-1; j < columna+1; j++) {
                if(tabla[i][j].isMina()){
                    
                }else{
                    if(i==0 || j==0){
                        if(tabla[i][j].isMina()){
                            minascerca++;
                        }
                    }
                }
            }
        }
        
        return num;
    }
    
 
}

