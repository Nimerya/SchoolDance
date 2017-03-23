/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scuola;
/**
 * Importo le librerie necessarie:
 * File, FileNotFoundException, Scanner e PrintWriter verranno utilizzate per la scrittura e per la lettura dei file;
 * Calendar verrà utilizzata nel momento in cui si andranno a manipolare le date;
 * HashMap verrà utilizzata per la realizzazione di un HashMap.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Calendar;

/**
 * @author Vale
 */


/**
 * Realizzazione della classe Scuola.
 */
public class Scuola {

    private String nome;
    private String citta;
    private String regione;
    private Proprietario proprietario;
    private HashMap<String, Corso> corsi;


    /**
     * Realizzazione di un primo costruttore che crea gli oggetti Scuola.
     * @param n il nome della scuola 
     * @param l la ciità in cui si trova la scuola
     * @param r la regione in cui si trova la scuola
     * @param p l'oggetto "Proprietario" che identifica il proprietario della scuola
     */
    public Scuola(String n, String l, String r, Proprietario p) {
        nome = n;
        citta = l;
        regione = r;
        proprietario = p;
        corsi = new HashMap<>();
    }

    
    /**
     * Realizzazione di un secondo costruttore che crea gli oggetti Scuola.
     * @param n il nome della scuola 
     */
    public Scuola(String n) {
        nome = n;
        corsi = new HashMap<>();
    }

   
    /**
     * Metodo che restituisce il nome della Scuola.
     * @return una stringa contenente il nome della Scuola
     */
    public String get_nome() {
        return nome;
    }

    
    /**
     * Metodo che restituisce la città dove si trova la Scuola.
     * @return una stringa contenente la città dove si trova la Scuola
     */
    public String get_citta() {
        return citta;
    }

    
    /**
     * Metodo che restituisce la regione dove si trova la Scuola.
     * @return la stringa contenente la regione dove si trova la Scuola
     */
    public String get_regione() {
        return regione;
    }

    
    /**
     * Metodo che restituisce il proprietario della Scuola.
     * @return l'oggetto proprietario della Scuola
     */
    public Proprietario get_p() {
        return proprietario;
    }
    
    
     /**
     * Metodo che restituisce l'HashMap di corsi.
     * @return l'HashMap di corsi
     */
    public  HashMap get_corsi(){
        return corsi;
    }
    
    
    /**
     * Metodo per il settaggio dell'attributo nome di Scuola.
     * @param n strnga contenente il nome della Scuola
     */
    public void set_nome(String n) {
        nome = n;
    }

    
     /**
     * Metodo per il settaggio dell'attributo città di Scuola.
     * @param c strnga contenente la città in cui si trova la Scuola
     */
    public void set_citta(String c) {
        citta = c;
    }

    
     /**
     * Metodo per il settaggio dell'attributo regione di Scuola.
     * @param r strnga contenente la regione in cui si trova la Scuola
     */
    public void set_regione(String r) {
        regione = r;
    }

    
     /**
     * Metodo per il settaggio dell'attributo proprietario di Scuola.
     * @param p oggetto Proprietario corrispondente al prorietario della Scuola.
     */
    public void setP(Proprietario p) {
        proprietario = p;
    }
    
    
     /**
     * Metodo che aggiunge gli oggetti Corso, relativi ad una Scuola, nell'HashMap.
     * @param c l'oggetto "Corso" da inserire nell'HashMap
     */
    public void add(Corso c) {
        if (!cerca(c.get_codice()))
            corsi.put(c.get_codice(), c);
    }

    
    /**
     * Metodo "toString" che restituisce le informazioni relative al singolo oggetto Scuola.
     * @return una stringa di caratteri da cui si possono ricavare il nome, la città e il proprietario della Scuola
     */ 
    @Override
    public String toString() {
        return nome + " " + citta + " " + regione+ " "+proprietario.toString();
    }


    /**
     * Metodo che restituisce tutte le informazioni relative alla Scuola,compreso l'eleco dei corsi e degli alunni che li frequentano.
     * @return un 'array di stringhe
     */
    public String[] info() {

        //Informazioni relative alla scuola, fino al proprietario
        String s1 = this.nome + " " + this.citta + " " + this.regione + " " + this.proprietario.get_cfiscale(); 

        int count = 0;//Contatore da utilizzare per contare quanti Corsi sono presenti nella HashMap
        for (String key : corsi.keySet())//Ciclo generalizzato."keySet()" è un metodo della classe HashMap che passata la chiave restituisce il valore
            count++;
        
        String[] s = new String[count + 1];//Creo un array di stringhe lungo count+1, in quanto il primo posto dell'array andrà occupato da s1.
        s[0] = s1;
        int j = 1;//Contatore che farà da indice per scorrere l'array di stringhe
        for (String key : corsi.keySet()) {//Scorro corsi
            String s2 = "";//Creo una stringa vuota
            Corso temp = corsi.get(key);//Dichiaro una variabile temporanea di tipo Corso
            //Riempio man mano la stringa s2 prima con le informazioni del corso in considerazione e poi con le informazione relative ad ogni allievo che frequenta il corso
            s2 = s2 + key + " " + temp.get_nome() + " " + temp.get_insegnante().get_cfiscale();
            for (int i = 0; i < temp.get_index(); i++) {//Scorro array degli allievi che frequentano il corso
                s2 = s2 + " " + temp.get_allievi()[i].get_cfiscale();
            }
            //Inserisco la stringa s2 nel posto successivo dell'array
            s[j] = s2;
            j++;
        }

        return s;//Ritorno l'array di strighe.
    }
    
    
    /**
     * Metodo che stampa le informazioni relative a un certo oggetto Scuola,
     * prendendole dall'array di stringhe fornito dalla funzione info().
     */
    public void StampaInfo(){
         String[] b = this.info();
        for (int i = 0; i < b.length; i++)
            System.out.println(b[i] + "\n");
    }
    

    /**
     * Metodo che cerca un corso nell'HashMap.
     * @param c stringa contenente il codice delCorso da cercare nell'HashMap
     * @return true se il corso è stato trovato, altrimenti false
     */
    public boolean cerca(String c){
        return corsi.containsKey(c); //containsKey: metodo dell'HashMap che torna true se la chiave passata è presente nell'HashMap.
    } 
    
        
    /**
     * Metodo che elimina un corso dall'HashMap passandogli l'oggetto corso.
     * @param c corso da eliminare
     */
    public void elimina(Corso c) {
         if (cerca(c.get_codice()))
            corsi.remove(c.get_codice());//Metodo dell'HashMap
        else
            System.out.println("Il Corso non è presnte nell'elenco.");
        }
    
    
    /**
     * Metodo che elimina un corso dall'HashMap passandogli il codice,quindi la chiave, del corso.
     * @param key codice del corso da eliminare
     */
    public void elimina(String key){
        if (cerca(key))
            corsi.remove(key);
        else
            System.out.println("Il Corso non è presnte nell'elenco.");    
    }

    
    /**
     * Metodo che crea un file dove verrano registrate tutte le informazioni riguardanti la Scuola con i relativi corsi e gli allievi che li frequentano.
     */
    
    public void ScriviFile() {
        try {

            PrintWriter out = new PrintWriter(this.nome + ".txt");//Creo un nuovo file di tipo PrintWriter

            String[] b = info();
            out.println(b[0]);//Scrivo nel file la prima stringa con tutte le informazioni della Scuola
            for (int i = 1; i < b.length; i++)
                out.println(b[i]);//Aggiungo man mano le stringhe con le informazioni sui corsi e sugli allievi
            out.close();//Chiudo il file

        } catch (FileNotFoundException ex) {//Eccezione propria dei file
            System.out.println("Impossibile creare il file");
        }
    }

    
    /**
     * Metodo che conta le righe di un file.
     * @param file il nome del file su cui lavorare
     * @return l'intero rappresentate il numero di righe
     */
    public int contaElementiFile(String file){
        File in = new File(file+".txt");
        int count=0;
        try{
            Scanner input=new Scanner(in);
            while (input.hasNextLine() && input.hasNext()){
                input.nextLine();
                count++;
            }
        } catch (FileNotFoundException ex){
            System.out.println("Errore nella lettura del file.");
        }
        return count+1;
    }
        
    
    /**
     * Metodo che legge il file "Insegnanti" e restituisce un'arrey di oggetti Insegnante (uno per ogni riga).
     * @return arrey di insegnanti
     */
    public Insegnante[] FiletoArrayI(){
        File in = new File("Insegnanti.txt");
        Insegnante[]elenco =new Insegnante[contaElementiFile("Insegnanti")];
        int j=0;
        try{
            Scanner fileScanner=new Scanner(in);
            while (fileScanner.hasNextLine()) {//Scorre le righe fino a quando ce n'è una successiva
                String line = fileScanner.nextLine();//Leggo la riga su cui mi trovo e la salvo su una stringa e poi faccio andare lo scanner alla riga successiva
                Scanner lineScanner = new Scanner(line);//Creo una nuova variabile scanner che scorre le parole presenti nella stringa line
                while (lineScanner.hasNext()){
                    String cf =lineScanner.next();
                    String ni =lineScanner.next();
                    String ci =lineScanner.next();
                    int dgi = Integer.parseInt(lineScanner.next());//giorno:leggo il numero del giorno come stringa e poi lo trasformo in intero,
                    int dmi = Integer.parseInt(lineScanner.next());//mese,
                    int dai = Integer.parseInt(lineScanner.next());//anno.
                    String si = lineScanner.next();
                    Calendar d1= Calendar.getInstance();
                        d1.set(dai, dmi,dgi);
                    Insegnante i = new Insegnante(ni, ci, d1, cf, si);
                    elenco[j]=i;
                    j++;
                }
                lineScanner.close();//Chiudo lo scanner che scorre la stringa line
            }
            fileScanner.close();//Chiudo lo scanner che scorre le righe del file
        } catch (FileNotFoundException ex){ 
            System.out.println("Errore nella lettura del file.");
        }
        return elenco;
    }
                
    
     /**
     * Metodo che legge il file "Allievi" e restituisce un'arrey di oggetti Allievo (uno per ogni riga).
     * @return arrey di allievi
     */
    public Allievo[] FiletoArrayA(){
        File in = new File("Allievi.txt");
        int j=0;
        Allievo[]elenco =new Allievo[contaElementiFile("Allievi")];
        try{      
            Scanner fileScanner=new Scanner(in);
            while (fileScanner.hasNextLine()) {//Scorre le righe fino a quando ce n'è una successiva
                String line = fileScanner.nextLine();//Leggo la riga su cui mi trovo e la salvo su una stringa e poi faccio andare lo scanner alla riga successiva
                Scanner lineScanner = new Scanner(line);//Creo una nuova variabile scanner che scorre le parole presenti nella stringa line
                while (lineScanner.hasNext()){
                    String cf =lineScanner.next();
                    String ni =lineScanner.next();
                    String ci =lineScanner.next();
                    int dgi = Integer.parseInt(lineScanner.next());//giorno:leggo il numero del giorno come stringa e poi lo trasformo in intero,
                    int dmi = Integer.parseInt(lineScanner.next());//mese,
                    int dai = Integer.parseInt(lineScanner.next());//anno.
                    int af = Integer.parseInt(lineScanner.next());
                    Calendar d1= Calendar.getInstance();
                        d1.set(dai, dmi,dgi);
                    Allievo i = new Allievo(ni, ci, d1, cf, af);
                    elenco[j]=i;
                    j++;
                }
                lineScanner.close();//Chiudo lo scanner che scorre la stringa line
            }
            fileScanner.close();//Chiudo lo scanner che scorre le righe del file
        } catch (FileNotFoundException ex){ 
            System.out.println("Errore nella lettura del file.");
        }
        return elenco;
        }
        
    
     /**
     * Metodo che legge il file "Proprietari" e restituisce un'arrey di oggetti Proprietario (uno per ogni riga).
     * @return arrey di proprietari
     */
    public Proprietario[] FiletoArrayP(){
        File in = new File("Proprietari.txt");
        int j=0;
        Proprietario[]elenco= new Proprietario[contaElementiFile("Proprietari")];
        try{    
            Scanner fileScanner=new Scanner(in); 
            while (fileScanner.hasNextLine()) {//Scorre le righe fino a quando ce n'è una successiva
                String line = fileScanner.nextLine();//Leggo la riga su cui mi trovo e la salvo su una stringa e poi faccio andare lo scanner alla riga successiva
                Scanner lineScanner = new Scanner(line);//Creo una nuova variabile scanner che scorre le parole presenti nella stringa line
                while (lineScanner.hasNext()){
                    String cf =lineScanner.next();
                    String ni =lineScanner.next();
                    String ci =lineScanner.next();
                    int dgi = Integer.parseInt(lineScanner.next());//giorno:leggo il numero del giorno come stringa e poi lo trasformo in intero,
                    int dmi = Integer.parseInt(lineScanner.next());//mese,
                    int dai = Integer.parseInt(lineScanner.next());//anno.
                    Calendar d1= Calendar.getInstance();
                        d1.set(dai, dmi,dgi);
                    Proprietario i = new Proprietario(ni, ci, d1, cf);
                    elenco[j]=i;
                    j++;
                }
                lineScanner.close();//Chiudo lo scanner che scorre la stringa line
            }
            fileScanner.close();//Chiudo lo scanner che scorre le righe del file
        } catch (FileNotFoundException ex){ 
            System.out.println("Errore nella lettura del file.");
        }
    return elenco;
    }
    
    
    /**
     * Metodo che legge un file da memoria.
     * @return l'oggetto Scuola
     */
    public Scuola LeggiFile(){
        File in = new File(this.nome + ".txt");//Apro il file in lettura
        Insegnante[] i= FiletoArrayI();//Realizzo una array di insegnanti    
        Allievo[] a= FiletoArrayA(); //Realizzo una array di alievi  
        Proprietario[] p= FiletoArrayP();  //Realizzo una array di proprietari   
            try {
            //Faccio uso di tre oggetti di tipo Scanner:il primo verrà utilizzato come "puntatore" per la prima riga del file;
            //Il secondo per scorrere tutte le altre righe del file; e il terzo per scorrere le stringhe presenti in ogni riga
            Scanner input = new Scanner(in);//Scanner 1
            input.next();//Salto la prima parola del file che è il nome della scuola che già conosco
            String c = input.next();//Salvo la città in una stringa temporanea
            String r = input.next();//Faccio lo stesso per la regione
            String cfiscale=input.next();//e per il codice fiscale del proprietario 
            boolean trovato=false;//Dichiaro un booleano
            Proprietario ptemp=null;//Dichiaro un riferimento a un oggetto persona inizialmente nullo
            //Controllo se il codice fiscale corrisponde a uno di quelli dei propritari presenti nell'array p
            for (int j=0;j<p.length && !trovato;j++ )//Scorro l'array p
                if (p[j].get_cfiscale().equals(cfiscale)){//Se il codice fiscale è uguale a uno di quelli dei proprietari
                    trovato=true;//Allora trovato deve essere settato a true cosicché appena lo trova esce dal ciclo
                     ptemp=p[j];//E assegno il riferimento all'oggetto proprietario trovato
                }
            input.close();//Chiudo la lettura del file per il primo scanner (ho finito la prima riga)
            //Aggiungo città, regione e proprietario all'oggetto Scuola, creato nel main.
            this.set_citta(c);
            this.set_regione(r);
            this.setP(ptemp);
            //Leggo le righe successive alla prima
            Scanner fileScanner = new Scanner(in);//Creazione dello scanner che scorrerà le righe del file
            fileScanner.nextLine();//Questo comando mi permette di iniziare a leggere dalla seconda riga
            Insegnante itemp=null;//Mi dichiaro un riferimento a un oggetto insegnante, inizialemente nullo
            while (fileScanner.hasNextLine()) {//Scorre le righe fino a quando ce n'è una successiva
                String line = fileScanner.nextLine();//Leggo la riga su cui mi trovo e la salvo su una stringa e poi faccio andare lo scanner alla riga successiva
                Scanner lineScanner = new Scanner(line);//Creo un nuovo scanner che scorre le parole presenti nella stringa line
                    //A questo punto mi trovo a scorrere la stringa parola per parola
                    String cod = lineScanner.next();//Leggo il codice del corso e lo metto in una stringa di appoggio;
                    String nom = lineScanner.next();//Lo stesso per il nome del corso
                    String cf = lineScanner.next();//e per il codice fiscale dell'insegnante
                    trovato=false;//Risetto trovato a false
                    //Controllo se il codice fiscale corrisponde a uno di quelli degli insegnanti presenti nell'array i[]
                    for(int j=0;j<i.length && !trovato;j++)//Scorro l'array i[]
                        if (i[j].get_cfiscale().equals(cf)){//Controllo i codici fiscali degli insegnanti
                            trovato=true;//Se trova il codice fiscale allora setta trovato uguale a true cosicché appena lo trova esce dal ciclo
                            itemp=i[j];//Assegno il riferimento itemp all'oggetto i trovato
                        }
                    Corso cor = new Corso(cod, nom, itemp);//Creo l'oggetto corso che ha le caratteristiche appena lette dal file
                        Allievo atemp=null;//Mi dichiaro un riferimento a un oggetto allievo, inizialemente nullo
                        while (lineScanner.hasNext()) {//Continua a scorrere la stringa finchè ci sono parole
                            String codf=lineScanner.next();//Leggo il codice fiscsle dell'allievo e lo salvo in una stringa d'appoggio
                            trovato=false;//Risetto trovato a false
                            //Controllo se il codice fiscale corrisponde a uno di quelli degli alleievi presenti nell'array a[]
                            for(int j=0;j<a.length && !trovato;j++)//Scorro l'array a[]
                                if (a[j].get_cfiscale().equals(codf)){//Se codf è uguale a quello di uno degli allievi presenti nell'array
                                    trovato=true;//Allora setta trovato uguale a true cosicché appena lo trova esce dal ciclo
                                    atemp=a[j];//Assegno il riferimento all'allievo avente quel codice fiscale 
                        }
                            cor.add(atemp);//Aggiungo gli allievi al corso
                        }

                lineScanner.close();//Chiudo lo scanner che scorre la stringa line
                this.add(cor); //Aggiungo il corso (con tutti gli allievi che lo frequentano) alla scuola
            }
            fileScanner.close();//Chiudo lo scanner che scorre le righe del file
        } catch (FileNotFoundException ex) {//Se il file non viene trovato lancia l'eccezione
            System.out.println("Il file non e' presente!!!");
        }
        return this;
    }
}

