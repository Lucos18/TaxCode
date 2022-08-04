
import java.io.IOException;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException, InterruptedException {
        //Dichiarazione di uno scanner per leggere informazioni in input
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci le seguenti informazioni per calcolare il tuo codice fiscale: ");
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Cognome: ");
        String cognome = sc.nextLine();
        System.out.println("Data di nascita (Formato GG/MM/YYYY): ");
        String dataN = sc.nextLine();
        String sesso;
        //chiede all'utente il suo sesso finchè non inserisce Maschio o Femmina
        do
        {
            System.out.println("Sesso (Maschio/Femmina): ");
            sesso = sc.nextLine();
        }
        while (sesso == "Maschio" || sesso == "Femmina");
        System.out.println("Comune: ");
        String comune = sc.nextLine();
        comune = comune.replace(" ","%20");
        //Creazione di un oggetto di tipo persona
        Persona persona = new Persona(nome,cognome,dataN,sesso,comune);
        //Divisione della data di nascita in Giorno/Mese/Anno
        String[] data = dataN.split("/");
        String Giorno = data[0];
        String Mese = data[1];
        String Anno = data[2];
        //Creazione della variabile CFProvv contenente il codice fiscale senza codice di controllo
        String CFProvv = persona.Cognome(persona.cognome) + persona.nome(persona.nome) + Anno.substring(Anno.length()-2) + persona.mese(Mese) + persona.GiornoSesso(Giorno,persona.sesso) + persona.GetRequestEx(persona.comune);
        //Creazione del codice fiscale con la concatenazione dei primi 15 numeri/lettere + il codice di controllo
        String CF = CFProvv + persona.codiceControllo(CFProvv);
        System.out.println("Il tuo codice fiscale e': " + CF.toUpperCase());
        //Chiusura dello scanner
        sc.close();
    }
}
