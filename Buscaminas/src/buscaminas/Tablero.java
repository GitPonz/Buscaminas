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
        
        //Tablero en sí
        
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
    
        public void imprimirPruebaSol(){
        System.out.print("  ");
        for (int i = 0; i < numColumnas; i++) {
            System.out.print(i+" ");
        }
        System.out.println("");
        
        //Tablero en sí
        
        for (int i = 0; i < this.numFilas; i++) {
                System.out.print(i+"|");
                
            for (int j = 0; j < this.numColumnas; j++) {
                
                System.out.print(this.tabla[i][j].imprimirPruebaSol()+" ");
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
    
    
    public Casilla getCasilla(int fila, int columna){ 
        return this.tabla[fila][columna];
    }
    
    public int calcularnumCasillas(int fila, int columna){
        int minascerca=0;
        
        
        for (int i = fila-1; i <= fila+1; i++) {
            
            if(i>=0 && i<numFilas){
                
                for (int j = columna-1; j <= columna+1; j++) {
                
                    if((j>=0 && j<numColumnas) && (tabla[i][j].isMina())){                           
                        minascerca++;    
                    }           
                } 
            }

        }
        
        return minascerca;
    }
    
    public void calculartablero(){
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                if(tabla[i][j].isMina()){
                    
                }else{
                    tabla[i][j].setNumero(calcularnumCasillas(i,j));
                }
            }
        }
    }
    
    public boolean meterCasilla(int filas, int columnas){
        boolean fin=true;
        if(tabla[filas][columnas].isMina()){
            fin=false;
        }
        tabla[filas][columnas].setVisible(true);
        
        return fin;
    }
    
    public void meterBandera(int filas, int columnas){
        boolean fin=true;
        if(tabla[filas][columnas].isBandera()){
            System.out.println("La bandera ya esta puesta");
        }else{
            tabla[filas][columnas].setBandera(true);
            tabla[filas][columnas].setVisible(true);
        }
 
    }
 
       public void quitarBandera(int filas, int columnas){
        boolean fin=true;
        if(tabla[filas][columnas].isBandera()){
            
            tabla[filas][columnas].setBandera(false);
            tabla[filas][columnas].setVisible(false);
            }
       }
       
       //A veces gana porque si
       public boolean comprobarVictoria(){
           boolean ganado=true;
           for (int i = 0; i < numFilas; i++) {
               for (int j = 0; j < numColumnas; j++) {
                   if(tabla[i][j].isMina()){
                       
                   }else{
                       if(tabla[i][j].isVisible()){
                           
                       }else{
                          ganado=false; 
                          break;
                       }
                   }
               }
           }
           return ganado;
       }
}

