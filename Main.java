
import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        Persona persona = new Persona(nome,cognome,dataN,sesso,comune);
        String CFcognome = persona.Cognome(persona.cognome);
        String CFnome = persona.nome(persona.nome);
        String[] data = dataN.split("/");
        String Giorno = data[0];
        String Mese = data[1];
        String Anno = data[2];
        String AnnoCF = Anno.substring(Anno.length()-2);
        String MeseCF = persona.mese(Mese);
        String GiornoSesso = persona.GiornoSesso(Giorno,sesso);
        System.out.print(CFcognome);
        System.out.print(CFnome);
        System.out.print(AnnoCF);
        System.out.print(MeseCF);

        sc.close();
    }
}
