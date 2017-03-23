/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scuola;
/**
 * Importo le librerie necessarie:
 * Calendar è utilizzata per gestire le date di nascita;
 * File,FileWriter,IOException e Scanner le utiizzo per scrivere sui file ;
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

/**
 * @author Vale
 */


/**
 * Realizzazione della classe Persona
 * (classe madre)
 */
public class Persona {
    protected String cfiscale; 
    protected String nome;
    protected String cognome;
    protected Calendar data_n;

    
    /**
     * Realizzazione del costruttore dell'oggetto Persona
     * @param n nome della Persona
     * @param c cognome della Persona
     * @param d data di nascita della Persona
     * @param cf stringa contenente il codice fiscale della Persona
     */
    public Persona(String n, String c, Calendar d, String cf) {
        cfiscale=cf;
        nome = n;
        cognome = c;
        data_n=(Calendar)d.clone();//CAST!!!
    }
    
    
    /**
     * Metodo che restituisce il codice fiscale della Persona
     * @return stringa contenente il codice fiscale
     */
    public String get_cfiscale() {
        return cfiscale;
    }
    
    
    /**
     * Metodo che restituisce il nome della Persona
     * @return stringa contenente il nome
     */
     public String get_nome() {
        return nome;
    }

     
    /**
     * Metodo che restituisce il cognome della Persona
     * @return stringa contenente il cgnome
     */
    public String get_cognome() {
        return cognome;
    }

    
    /**
     * Metodo che restituisce la data di nascita della Persona
     * @return la data di tipo Calendar
     */
    public Calendar get_data() {
        Calendar data= Calendar.getInstance();
        data.set(data_n.get(Calendar.DATE),data_n.get(Calendar.MONTH),data_n.get(Calendar.YEAR)); 
        return data;
    }
    
    
    /**
     * Metodo che permette il settaggio del codice fiscale
     * @param cf stringa contente il nuovo codice fiscale
     */
    public void set_cfiscale(String cf) {
        cfiscale = cf;
    }
    
    
    /**
     * Metodo che permette il settaggio del nome
     * @param n stringa contente il nuovo nome
     */
    public void set_nome(String n) {
        nome = n;
    }

    
    /**
     * Metodo che permette il settaggio del cognome
     * @param c stringa contente il nuovo cognome
     */
    public void set_cognome(String c) {
        cognome = c;
    }
    
    
    /**
     * Metodo che permette il settaggio della data di nascita della persona
     * @param d la nuova data di nascita di tipo Calendar
     */
    public void set_data(Calendar d){
        data_n.set(d.get(Calendar.DATE),d.get(Calendar.MONTH),d.get(Calendar.YEAR)); 
    }
    
    
    /**
     * Metodo che verifica la presenza su file dell'elemento da aggiungere e, se non lo trova lo aggiunge
     * @param file nome del file su cui verranno aggiunti gli elementi
     * @param cf codice fiscale dell'elemento da aggiungere
     */
    public void addElencoFile(String file, String cf){
        boolean trovato=false;
        File in = new File(file+".txt");//Apro il file 
        try {
            //A questo punto controllo se l'oggetto esiste già nel file
            Scanner input = new Scanner(in);
            while (input.hasNextLine() && input.hasNext() && !trovato){
                if(input.next().equals(cf))
                    trovato=true;
                input.nextLine();
            }
            input.close();
            if (!trovato){               
                FileWriter out = new FileWriter(in,true);
                out.append(toString()+System.lineSeparator());
                out.close();
                }
            } catch (IOException ex) {
                System.out.println("Errore nell'apertura/scrittura del file.");
            }
    }
   
    
    /**
     * Metodo che restituisce una stringa contenente le informazioni della data di nascita
     * @return stringa con le informazioni sulla data
     */
    public String DatatoString(){
        return data_n.get(Calendar.DATE) + " " + data_n.get(Calendar.MONTH) + " " + data_n.get(Calendar.YEAR);
    }
    
     /**
     * Metodo che restituisce una stringa contenente le informazioni relative all'oggetto Persona
     * @return stringa contente informazioni
     */
    @Override
    public String toString() {
        return cfiscale +" " + nome + " " + cognome + " " + data_n.get(Calendar.DATE) + " " + data_n.get(Calendar.MONTH) + " " + data_n.get(Calendar.YEAR);
    }
}
