package buscaminas;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Juego {
    private Tablero tablero;
    private int numMinas;
    private int numFilas;
    private int numColumnas;

    public Juego() {

    }

    public void configurarJuego(){
        boolean bandera=true;
        System.out.println("**** BUSCAMINAS ****");
        System.out.println("");
        System.out.println("Configuración:");
        
        do{
            
            try{
                bandera=true;
                Scanner leer = new Scanner(System.in);
                System.out.println("Dame el número de filas");
                numFilas= leer.nextInt();

                System.out.println("Dame el número de columnas");
                numColumnas = leer.nextInt();
     
            }catch(Exception e){
                System.out.println("Error en los datos introducidos");
                bandera=false;
            }
        }while(bandera==false);
        
        
        do{
            Scanner leer = new Scanner(System.in);
            System.out.println("Dame el números de bombas");
            numMinas =leer.nextInt();
                
        }while((numFilas*numColumnas)<numMinas);
        
        iniciarJuego();
            
    }
    
    public void iniciarJuego(){
        tablero = new Tablero(numFilas, numColumnas);
        tablero.insertarMinas(numMinas);
        tablero.calculartablero();
        //tablero.imprimirPrueba();
        System.out.println("");
        tablero.imprimirPruebaSol();
        System.out.println("");
        
    }
    
    public void juego(){
        int filas,columnas,opcion;
        mostrarTablero();
        do{
            opcion=elegirOperacion();
            switch(opcion){
                case 1: 
                        Scanner leer = new Scanner(System.in);
                        System.out.println("Dame las coordenadas(fila,columnas)");
                        filas=leer.nextInt();
                        columnas=leer.nextInt();
                        if(coordenadasCorrectas(filas, columnas)){
                           tablero.getCasilla(filas, columnas);
                           descubrirCasilla(filas, columnas);
                           mostrarTablero(); 
                           if(partidaGanada()==true){
                                System.out.println("***********************");
                                System.out.println("    VICTORIA ROYALE    ");
                                System.out.println("***********************");
                                System.exit(1);
                            }
                        }
                    break;
                    case 2:
                        Scanner leer2 = new Scanner(System.in);
                        System.out.println("Dame las coordenadas(fila,columnas)");
                        filas=leer2.nextInt();
                        columnas=leer2.nextInt();
                        if(coordenadasCorrectas(filas, columnas)){
                           tablero.getCasilla(filas, columnas);
                           descubrirBandera(filas, columnas);
                           mostrarTablero(); 
                        };
                        break;
                    case 3:
                        Scanner leer3 = new Scanner(System.in);
                        System.out.println("Dame las coordenadas(fila,columnas)");
                        filas=leer3.nextInt();
                        columnas=leer3.nextInt();
                        if(coordenadasCorrectas(filas, columnas)){
                           tablero.getCasilla(filas, columnas);
                            quitarBandera(filas, columnas);
                            mostrarTablero(); 
                        };
                        break;    
                        
            }
        }while(opcion!=0);
    }
    
    
    private void mostrarTablero(){
        tablero.imprimirPrueba();
    }
    
    private int elegirOperacion(){
        
        boolean bandera=true;
        int opcion=0;
        
        do{
            
        
            try{
                bandera=true;
                Scanner leer = new Scanner(System.in);
                System.out.println("**** MENU ****");
                System.out.println("1. Descubrir casilla");
                System.out.println("2. Poner bandera");
                System.out.println("3. Quitar bandera");
                System.out.println("0. Rendirse");
                opcion=leer.nextInt();
            }catch(Exception e){
                System.out.println("Error en el dato introducido");
                bandera=false;
            }
        }while(bandera==false || opcion>3 || opcion<0);
        

        
        return opcion;
    }
    
    private void descubrirCasilla(int filas, int columnas){
        if(tablero.meterCasilla(filas,columnas)==false){
            acabarJuegoMina();
            tablero.imprimirPruebaSol();
            System.exit(0);
        };
        
    }  
    
   private void descubrirBandera(int filas, int columnas){
        tablero.meterBandera(filas,columnas);

    }
   
     private void quitarBandera(int filas, int columnas){
        tablero.quitarBandera(filas,columnas);

    }
    
    
    private boolean coordenadasCorrectas(int filas, int columnas){
        Scanner leer = new Scanner(System.in);
        boolean bandera=true;
        
        do{
            try{ 
                    leer = new Scanner(System.in);
                    while(filas>numFilas-1){
                        leer = new Scanner(System.in);
                        System.out.println("El numero de fila no se encuentra en el tablero");
                        System.out.println("Dame otra fila");
                        filas=leer.nextInt();
                    }
                    while(columnas>numColumnas-1){
                        leer = new Scanner(System.in);
                        System.out.println("El numero de columna no se encuentra en el tablero");
                        System.out.println("Dame otra columna");
                        columnas=leer.nextInt();
                    }
  
            }catch(Exception e){
                System.out.println("Error en el dato introducido");
                bandera=false;
            }
          
        }while(bandera==false);
        return bandera;
    }
    
      private boolean partidaGanada(){
        boolean ganado=tablero.comprobarVictoria();
        return ganado;
    }
    
    private void acabarJuegoMina(){
        System.out.println("*******************");
        System.out.println("    HAS PERDIDO    ");
        System.out.println("*******************");
    }
    
  
}


















