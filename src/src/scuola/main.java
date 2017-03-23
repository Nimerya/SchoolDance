/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scuola;

import java.util.Calendar;


/**
 * @author Vale
 */
public class main {
    public static void main(String[] arghs) {
        //Creazione degli oggetti
        
            //Creazione degli oggetti Calendar
            /*    Calendar c1=Calendar.getInstance();
                    c1.set(1990,4,3);
                Calendar c2=Calendar.getInstance();
                    c2.set(1985,2,7);
                Calendar c3=Calendar.getInstance();
                    c3.set(1987,5,12);
                Calendar c4=Calendar.getInstance();
                    c4.set(1994,11,15);
                Calendar c5=Calendar.getInstance();
                    c5.set(1996,10,5);
                Calendar c6=Calendar.getInstance();
                    c6.set(1994,7,14);
                Calendar c7=Calendar.getInstance();
                    c7.set(1996,11,8);
                Calendar c8=Calendar.getInstance();
                    c8.set(1993,8,8);
                Calendar c9=Calendar.getInstance();
                    c9.set(1992,2,5);
                Calendar c10=Calendar.getInstance();
                    c10.set(1996,3,26);
                Calendar c11=Calendar.getInstance();
                    c11.set(1996,6,3);
                Calendar c12=Calendar.getInstance();
                    c12.set(1996,1,25);
            
            //Creazione degli oggetti Proprietario
                Proprietario p1= new Proprietario ("Anna","Verdi",c1,"1PROPRIETARIO");
                Proprietario p2= new Proprietario ("Gaia", "Seddi",c2,"2PROPRIETARIO");
                 
            //Creazione degli oggetti Scuola
                Scuola s1= new Scuola("Etoile","L'Aquila","Abruzzo",p1);
                Scuola s2= new Scuola("Dance","Roma","Lazio",p2);
               
            //Creazione degli oggetti Insegnante
                Insegnante i1=new Insegnante ("Rosa","Rossi",c2,"1INSEGNANTE","Classica");
                Insegnante i2=new Insegnante ("Rossana","Rosi", c3,"2INSEGNANTE","Moderna");
                Insegnante i3=new Insegnante ("Valeria","Losi", c2,"3INSEGNANTE","HipHop");
                Insegnante i4=new Insegnante ("Sara","Risi", c1,"4INSEGNANTE","Modernjazz");
                Insegnante i5=new Insegnante ("Selena","Fosi", c1,"5INSEGNANTE","Moderna");
        
            //Creazione degli oggetti Allievi
                Allievo a1=new Allievo("Lisa","Fiori",c4,"1ALUNNO",5);
                Allievo a2=new Allievo("Allia","Fio",c5,"2ALUNNO",3);
                Allievo a3=new Allievo("Isa","Fi",c6,"3ALUNNO",2);
                Allievo a4=new Allievo("Lia","Firi",c7,"4ALUNNO",1);
                Allievo a5=new Allievo("Delia","Anti",c12,"5ALUNNO",4);
                Allievo a6=new Allievo("Maria","Lusi",c2,"6ALUNNO",1);
                Allievo a7=new Allievo("Asia","Era",c10,"7ALUNNO",8);
                Allievo a8=new Allievo("Monia","Luis",c1,"8ALUNNO",1);
                Allievo a9=new Allievo("Lia","Firzi",c8,"9ALUNNO",1);
                Allievo a10=new Allievo("Sira","Merli",c11,"10ALUNNO",3);
                Allievo a11=new Allievo("Kelly","Firi",c6,"11ALUNNO",1);
                Allievo a12=new Allievo("Liana","Firissi",c8,"12ALUNNO",1);
            
            //Creazione degli oggetti corso
                Corso co1=new Corso ("001","Clasica",i1);
                Corso co2=new Corso ("002","Moderna",i2);
                Corso co3=new Corso ("003","HipHop",i3);
                Corso co4=new Corso ("004","Modernjazz",i4);
                Corso co5=new Corso ("005","Contemporaneo",i5);
                
            //Aggiunta degli allievi nei corsi
                co1.add(a1);
                co1.add(a2);
                co1.add(a3);
                co1.add(a4);
                co2.add(a1);
                co2.add(a5);
                co2.add(a6);
                co2.add(a9);
                co2.add(a11);
                co3.add(a4);
                co3.add(a1);
                co3.add(a10);
                co4.add(a7);
                co4.add(a8);
                co4.add(a9);
                co4.add(a12);
                co4.add(a4);
                co5.add(a9);
                co5.add(a7);
         
            //Aggiunta dei corsi nell'HashMap della Scuola
                s1.add(co1);
                s1.add(co2);
                s1.add(co4);
                s2.add(co5);
                s2.add(co3);
                
            
            //Si salvano tutti i dati inseriti scrivendoli in un file
                s1.ScriviFile();
                s2.ScriviFile();*/
        

        //Operazioni su file
        
            //Lettura del file
        /*    Scuola x = new Scuola("Dance");
            x.LeggiFile();
            x.StampaInfo();*/
        
            //Aggiunta di un corso 
        /*    Scuola x = new Scuola("Dance");
            x.LeggiFile();
            Calendar c2=Calendar.getInstance();
                c2.set(1985,2,7);
            Insegnante i1=new Insegnante ("Rosalba","Roui",c2,"1INSEGNANTE","Classica");
            Corso co3=new Corso ("006","HipHop",i1);
            x.add(co3);
            x.ScriviFile();
            x.LeggiFile();
            x.StampaInfo();*/
        
            //Eliminazione di un corso
        /*    Scuola x = new Scuola("Dance");
            x.LeggiFile();
            x.elimina ("003");
            x.ScriviFile();
            x.LeggiFile();
            x.StampaInfo();*/
        
            //Prova interfaccia grafica
            Scuola x = new Scuola("Dance");
            x.LeggiFile();
            NewJFrame inter= new NewJFrame();
            inter.setVisible(true);
            inter.gui(x);
        
        
    }
}
