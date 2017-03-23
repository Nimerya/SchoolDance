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
 * @author Vale
 */


/**
 * Realizzazione della sottoclasse Insegnante che estende la superclasse Persona
 */
public class Insegnante extends Persona {
    private String specializzazione;

    
    /**
     * Costruttore della sottoclasse Insegnante
     * @param n stringa contente il nome dell'Isegnante
     * @param c stringa contenente il cognome dell'Insegnante
     * @param d data di nascita dell'Insegnante di tipo Calendar
     * @param cf codice fiscale dell'Insegnante
     * @param s stringa contenente la specializzazione dell'Insegnante
     */
    public Insegnante(String n, String c, Calendar d, String cf, String s) {
        super(n, c, d, cf);
        specializzazione = s;
        super.addElencoFile("Insegnanti",cf);
    }
    
    
    /**
     * Metodo che restituisce la specializzazione dell'Insegnante
     * @return una stringa contente la specializzazione
     */
    public String get_sp() {
        return specializzazione;
    }

    
    /**
     * Metodo che permette il settaggio della specializzazione
     * @param s stringa contenente la nuova specializzazione
     */
    public void set_sp(String s) {
        specializzazione = s;
    }

    
    /**
     * Metodo che restituisce tutte le informazioni relative ad un Insegnante
     * @return stringa contenente le informazioni
     */
    @Override
    public String toString() {
        return super.toString() + " " + specializzazione;
    }

}
