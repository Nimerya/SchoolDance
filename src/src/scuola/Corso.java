/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scuola;

/**
 * @author Vale
 */

/**
 * Classe eccezione che estende la superclasse Exception
 * verrà utilizzata nel caso in cui non vi sia un certo Allievo nell'array degli allievi
 * @author Vale
 */
class NotFoundExc extends Exception{}

/**
 * Classe eccezione che estende la superclasse Exception
 * verrà utilizzata nel caso in cui l'arrey contenente gli allievi sia pieno
 * @author Vale
 */
class ArrayPienoExc extends Exception{}


/**
 * Realizzazione della classe Corso
 */
public class Corso {
    private String codice;
    private String nome_c;
    private Insegnante professore;
    private Allievo[] allievi = new Allievo[40];
    private int index;
    
    
    /**
     * Costruttore della clsse Corso
     * @param c codice del Corso
     * @param n nome del Corso
     * @param i oggetto Insegnante del Corso
     */
    public Corso(String c, String n, Insegnante i) {
        codice = c;
        nome_c = n;
        professore = i;
    }
    
    
    /**
     * Metodo che ritorna il codice del corso
     * @return la stringa corrispondente al codice
     */
    public String get_codice() {
        return codice;
    }

    
    /**
     * Metodo che ritorna il nome del corso
     * @return la stringa corrispondente al nome
     */
    public String get_nome() {
        return nome_c;
    }

    
    /**
     * Metodo che ritorna l'insegnante del corso
     * @return l'oggetto Insegnante
     */
    public Insegnante get_insegnante() {
        return professore;
    }

    
    /**
     * Metodo che ritorna la prima posizione libera dell'array allievi del corso
     * @return intero
     */
    public int get_index() {
        return index;
    }
    
    
    /**
     * Metodo che restituisce l'array contenente gli allievi del Corso
     * @return array di allievi
     */
    public Allievo[] get_allievi(){
        return allievi;
    }

    
    /**
     * Metodo che permette il settaggio del codice del corso
     * @param c stringa contenente il nuovo codice
     */
    public void set_c(String c) {
        codice = c;
    }

    
    /**
     * Metodo che permette il settaggio del nome del corso
     * @param n stringa contenente il nuovo nome
     */
    public void set_n(String n) {
        nome_c = n;
    }

    /**
     * Metodo che permette il settaggio dell'insegnante del corso
     * @param i nuovo oggetto Insegnante
     */
    public void set_i(Insegnante i) {
        professore = i;
    }

    
    /**
     * Metodo che ritorna una stringa contenete le informazioni del corso
     * @return una stringa
     */
    @Override
    public String toString() {
        
        return nome_c + " " + codice + " " + professore + " " + index + " ";
    }
    

    /**
     * Metodo che aggiunge gli allievi che frequentano il corso nell'array
     * @param a  ogetto Allievo
     */
    public void add(Allievo a) {
        try{
            cerca(a.get_cfiscale());
            System.out.println("L'allievo è già presente nel corso.");
        } catch (NotFoundExc ex){
            try{
                if (index < allievi.length) {
                    allievi[index] = a;
                    index++;
                }
                else throw new ArrayPienoExc();
            } catch (ArrayPienoExc ex2){
                    System.out.println("Il corso è pieno.");
                }            
            }
    }
        
    
    /**
     * Metodo che restituisce L'elenco degli allievi che frequentano il corso
     */
    public void elenco() {
        System.out.println("Gli allievi che frequentano il corso sono:\n ");
        for (Allievo e : allievi)
            System.out.println(e.get_nome() + " " + e.get_cognome());
    }

    
    /**
     * Metodo che permette l'eliminazione di un allievo dall'array
     * @param cf codice fiscale dell'Allievo da eliminare
     */
    public void elimina_a(String cf) {
        int pos = 0;
        try {
            pos = cerca(cf);
        } catch (NotFoundExc ex) {
            System.out.println("L'Allievo non frequenta questo corso!");
        }
        for (int i = pos; i < index; i++) {
            allievi[i] = allievi[i + 1];
            index--;
        }
    }


    /**
     * Metodo che permette la ricerca di un Allievo nell'array
     * @param cf codice fiscale dell'Allievo da cercare
     * @return la posizione di tale Allievo nell'array
     * @throws NotFoundExc eccezione lanciata se l'Allievo non viene trovato nell'array
     */
    public int cerca(String cf) throws NotFoundExc {
        for (int i = 0; i < index; i++)
            if (allievi[i].get_cfiscale().equals(cf)) 
                return i;
        throw new NotFoundExc();
    }
}
