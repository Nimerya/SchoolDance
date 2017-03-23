/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scuola;

/**
 * Importo la libreria Calendar per la gestione della data di nascita
 */
import java.util.Calendar;

/**
 *
 * @author Vale
 */


/**
 * Realizzazione della classe Proprietario che estende la superclasse Persona
 */
public class Proprietario extends Persona{
    
    
    /**
     * Costruttore della classe Proprietario
     * @param n nome del Proprietario
     * @param c cognome del Proprietario
     * @param d data di nascita del Proprietario
     * @param cf codice fiscale del Propretario  
     */
    public Proprietario(String n, String c, Calendar d, String cf) {
        super(n,c,d,cf);
        super.addElencoFile("Proprietari",cf);
    }
    
}
