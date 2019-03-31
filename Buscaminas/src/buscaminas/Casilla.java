package buscaminas;

/**
 *
 * @author alumno
 */
public class Casilla {
    private boolean mina;
    private boolean blanco;
    private boolean bandera;
    private boolean visible;
    private int numero;

    public Casilla() {
        this.mina = false;
        this.blanco = true;
        this.bandera = false;
        this.visible = false;
        this.numero = 0;
    }

    /**
     * @return the mina
     */
    public boolean isMina() {
        return mina;
    }

    /**
     * @param mina the mina to set
     */
    public void setMina(boolean mina) {
        this.mina = mina;
    }

    /**
     * @return the blanco
     */
    public boolean isBlanco() {
        return blanco;
    }

    /**
     * @param blanco the blanco to set
     */
    public void setBlanco(boolean blanco) {
        this.blanco = blanco;
    }

    /**
     * @return the bandera
     */
    public boolean isBandera() {
        return bandera;
    }

    /**
     * @param bandera the bandera to set
     */
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    public String imprimirPrueba() {
        String sol="*";
        
        if(!this.isVisible()){
            return sol;
        }
        
        if(bandera){
            return "B";
        }
        
        if(mina){
            return "M";
        }
        
        if(this.numero>0){
            sol = ""+numero;
        }
        
        return sol;
    }
    
        public String imprimirPruebaSol() {
        String sol="*";

        
        if(bandera){
            return "B";
        }
        
        if(mina){
            return "M";
        }
        
        if(this.numero>0){
            sol = ""+numero;
        }
        
        return sol;
    }
    
    
    
}
