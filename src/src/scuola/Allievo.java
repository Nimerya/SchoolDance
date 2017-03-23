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
 * Realizzazione della sottoclasse Allievo che estende la superclasse Persona
 */
public class Allievo extends Persona {
    private int anni_frequenza;

    
    /**
     * Costruttore della sottoclasse Allievo
     * @param n stringa contenente il nome dell'Allievo
     * @param c stringa contenente il cognome dell'Allievo
     * @param d data di nascita dell'allievo di tipo Calendar
     * @param cf stringa contenente il codice fiscale dell'Allievo
     * @param af intero contenente gli anni di frequenza dell' Allievo
     */
    public Allievo(String n, String c, Calendar d, String cf, int af) {
        super(n,c,d,cf);
        anni_frequenza = af;
        super.addElencoFile("Allievi",cf);
        }
    
    
    /**
     * Metodo che restituisce gli anni di frequenza dell'Allievo
     * @return intero contenente gli anni di frequenza dell'Allievo
     */
    public int get_af() {
        return anni_frequenza;
    }

    
    /**
     * Metodo che permette il settaggio degli anni di frequenza dell'Allievo
     * @param af intero contenente i nuovi anni di frequenza
     */
    public void set_af(int af) {
        anni_frequenza = af;
    }

    
    /**
     * Metodo che restituisce  tutte le informazioni dell'Allievo
     * @return una stringa contenente le informazioni dell'Allievo
     */
    @Override
    public String toString() {
        return super.toString() + " " + anni_frequenza;
    }

    
    /**
     * Metodo che permette il confronto tra due oggetti di tipo Allievo
     * @param a Allievo da confrontare con quello che richiama il metodo
     * @return un booleano: true se i due oggetti sono uguali, false altrimenti
     */
    public boolean equals(Allievo a) {
        return this.cfiscale.equals(a.get_cfiscale());
    }
}
