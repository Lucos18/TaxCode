
import java.io.IOException;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        /*
        System.out.println("Inserisci le seguenti informazioni per calcolare il tuo codice fiscale: ");
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Cognome: ");
        String cognome = sc.nextLine();
        System.out.println("Data di nascita (Formato GG/MM/YYYY): ");
        String dataN = sc.nextLine();
        String sesso;
        do
        {
            System.out.println("Sesso (Maschio/Femmina): ");
            sesso = sc.nextLine();
        }
        while (sesso == "Maschio" || sesso == "Femmina");
        System.out.println("Comune: ");
        String comune = sc.nextLine();
        */
        //Persona persona = new Persona(nome,cognome,dataN,sesso,comune);
        String dataN = "23/01/2004";
        Persona persona = new Persona("Luca","Buonpane","23/01/2004","Maschio","CASAPULLA");
        String[] data = dataN.split("/");
        String Giorno = data[0];
        String Mese = data[1];
        String Anno = data[2];
        String CFProvv = persona.Cognome(persona.cognome) + persona.nome(persona.nome) + Anno.substring(Anno.length()-2) + persona.mese(Mese) + persona.GiornoSesso(Giorno,persona.sesso) + persona.GetRequestEx(persona.comune);
        String CF = CFProvv + persona.codiceControllo(CFProvv);
        System.out.println(CF);
        sc.close();
    }
}
