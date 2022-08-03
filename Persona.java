import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.*;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Persona {
    String nome;
    String cognome;
    String dataN;
    String sesso;
    String comune;
    String CF;
    public Persona(String nome, String cognome, String dataN, String sesso, String comune){
        this.nome = nome;
        this.cognome = cognome;
        this.dataN = dataN;
        this.sesso = sesso;
        this.comune = comune;
    }
    public String codiceControllo(String CVProvv){

        return ("ciao");
    }
    public String GetRequestEx(String comune) throws IOException, InterruptedException {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.gerriquez.com/comuni/ws.php?dencomune=" + comune))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            JSObject jsonObject = JSONSerializer
            System.out.println(response.body());
            return ("ciao");
    }
    public String GiornoSesso(String Giorno, String sesso)
    {
        int CFgiorno = Integer.parseInt(Giorno);
        //if (Integer.parseInt(Giorno)  >= 0 && Integer.parseInt(Giorno) <= 9) CFgiorno = 0 + CFgiorno;
        if (sesso == "Femmina") CFgiorno = CFgiorno + 40;
        return String.valueOf(CFgiorno);
    }
    public String mese(String mese)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("01", "A");
        map.put("02", "B");
        map.put("03", "C");
        map.put("04", "D");
        map.put("05", "E");
        map.put("06", "H");
        map.put("07", "L");
        map.put("08", "M");
        map.put("09", "P");
        map.put("10", "R");
        map.put("11", "S");
        map.put("12", "T");
        return map.get(mese);
    }
    public String Cognome(String Cognome){
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        char[] ch = Cognome.toCharArray();
        int numConsonanti = 0;
        int numVocali = 0;
        String CFcognome = "";
        boolean vocale = false;
        for (int i = 0; i < Cognome.length(); i++)
        {
            if (numConsonanti == 3) break;
            for (int j = 0; j < vowels.length; j++)
            {
                if (ch[i] == vowels[j]) 
                {
                    vocale = true;
                    break;
                }
            }
            if (vocale) vocale = false;
            else {
                numConsonanti++;
                CFcognome = CFcognome + ch[i];
            }
        }
        if (numConsonanti < 3){
            for (int i = 0; i < Cognome.length(); i++)
            {
                if ((numConsonanti + numVocali) == 3) break;
                for (int j = 0; j < vowels.length; j++)
                {
                    if (ch[i] == vowels[j]) 
                    {
                        vocale = true;
                        break;
                    }
                }
                if (vocale) 
                {
                    numVocali++;
                    CFcognome = CFcognome + ch[i];
                }
            }
        }
        return CFcognome;
    }
    public String nome(String nome)
    {
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        char[] nomech = nome.toCharArray();
        int numConsonanti = 0;
        int numVocali = 0;
        String CFnome = "";
        boolean vocale = false;
        for (int i = 0; i < nome.length(); i++)
        {
            if (numConsonanti == 3) break;
            for (int j = 0; j < vowels.length; j++)
            {
                if (nomech[i] == vowels[j]) 
                {
                    vocale = true;
                    break;
                }
            }
            if (vocale) vocale = false;
            else {
                numConsonanti++;
                CFnome = CFnome + nomech[i];
            }
        }
        if (numConsonanti < 3){
            for (int i = 0; i < nome.length(); i++)
            {
                if ((numConsonanti + numVocali) == 3) break;
                for (int j = 0; j < vowels.length; j++)
                {
                    if (nomech[i] == vowels[j]) 
                    {
                        vocale = true;
                        break;
                    }
                }
                if (vocale) 
                {
                    numVocali++;
                    CFnome = CFnome + nomech[i];
                }
            }
        }
        return CFnome;
    }
}
