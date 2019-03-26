package buscaminas;

/**
 *
 * @author alumno
 */
public class Casilla {
    private Boolean mina;
    private Boolean blanco;
    private Boolean bandera;
    private Boolean visible;
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
    public Boolean getMina() {
        return mina;
    }

    /**
     * @param mina the mina to set
     */
    public void setMina(Boolean mina) {
        this.mina = mina;
    }

    /**
     * @return the blanco
     */
    public Boolean getBlanco() {
        return blanco;
    }

    /**
     * @param blanco the blanco to set
     */
    public void setBlanco(Boolean blanco) {
        this.blanco = blanco;
    }

    /**
     * @return the bandera
     */
    public Boolean getBandera() {
        return bandera;
    }

    /**
     * @param bandera the bandera to set
     */
    public void setBandera(Boolean bandera) {
        this.bandera = bandera;
    }

    /**
     * @return the visible
     */
    public Boolean getVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(Boolean visible) {
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

 
    
    
}
