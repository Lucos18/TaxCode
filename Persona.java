import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Stream;


public class Persona {
    String nome;
    String cognome;
    String dataN;
    String sesso;
    String comune;
    String CF;

    public Persona(String nome, String cognome, String dataN, String sesso, String comune) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataN = dataN;
        this.sesso = sesso;
        this.comune = comune;
    }

    public String codiceControllo(String CVProvv) {

        String res = null;

        // scompongo cf in array char
        List<Character> cf_scomposto = new ArrayList<>();
        for (char ch : CVProvv.toUpperCase().toCharArray()) {
            cf_scomposto.add(ch);
        }

        // map valori dispari
        Map<Character, String> valore_pari = new HashMap<Character, String>();
        valore_pari.put('A', "0");
        valore_pari.put('B', "1");
        valore_pari.put('C', "2");
        valore_pari.put('D', "3");
        valore_pari.put('E', "4");
        valore_pari.put('F', "5");
        valore_pari.put('G', "6");
        valore_pari.put('H', "7");
        valore_pari.put('I', "8");
        valore_pari.put('J', "9");
        valore_pari.put('0', "0");
        valore_pari.put('1', "1");
        valore_pari.put('2', "2");
        valore_pari.put('3', "3");
        valore_pari.put('4', "4");
        valore_pari.put('5', "5");
        valore_pari.put('6', "6");
        valore_pari.put('7', "7");
        valore_pari.put('8', "8");
        valore_pari.put('9', "9");
        valore_pari.put('K', "10");
        valore_pari.put('L', "11");
        valore_pari.put('M', "12");
        valore_pari.put('N', "13");
        valore_pari.put('O', "14");
        valore_pari.put('P', "15");
        valore_pari.put('Q', "16");
        valore_pari.put('R', "17");
        valore_pari.put('S', "18");
        valore_pari.put('T', "19");
        valore_pari.put('U', "20");
        valore_pari.put('V', "21");
        valore_pari.put('W', "22");
        valore_pari.put('X', "23");
        valore_pari.put('Y', "24");
        valore_pari.put('Z', "25");

        // map valori dispari
        Map<Character, String> valore_dispari = new HashMap<Character, String>();
        valore_dispari.put('A', "1");
        valore_dispari.put('B', "0");
        valore_dispari.put('C', "5");
        valore_dispari.put('D', "7");
        valore_dispari.put('E', "9");
        valore_dispari.put('F', "13");
        valore_dispari.put('G', "15");
        valore_dispari.put('H', "17");
        valore_dispari.put('I', "19");
        valore_dispari.put('J', "21");
        valore_dispari.put('0', "1");
        valore_dispari.put('1', "0");
        valore_dispari.put('2', "5");
        valore_dispari.put('3', "7");
        valore_dispari.put('4', "9");
        valore_dispari.put('5', "13");
        valore_dispari.put('6', "15");
        valore_dispari.put('7', "17");
        valore_dispari.put('8', "19");
        valore_dispari.put('9', "21");
        valore_dispari.put('K', "2");
        valore_dispari.put('L', "4");
        valore_dispari.put('M', "18");
        valore_dispari.put('N', "20");
        valore_dispari.put('O', "11");
        valore_dispari.put('P', "3");
        valore_dispari.put('Q', "6");
        valore_dispari.put('R', "8");
        valore_dispari.put('S', "12");
        valore_dispari.put('T', "14");
        valore_dispari.put('U', "16");
        valore_dispari.put('V', "10");
        valore_dispari.put('W', "22");
        valore_dispari.put('X', "25");
        valore_dispari.put('Y', "24");
        valore_dispari.put('Z', "23");

        // map lettera di controllo
        HashMap<Integer, String> lettera_di_controllo = new HashMap<Integer, String>();
        lettera_di_controllo.put(0, "A");
        lettera_di_controllo.put(1, "B");
        lettera_di_controllo.put(2, "C");
        lettera_di_controllo.put(3, "D");
        lettera_di_controllo.put(4, "E");
        lettera_di_controllo.put(5, "F");
        lettera_di_controllo.put(6, "G");
        lettera_di_controllo.put(7, "H");
        lettera_di_controllo.put(8, "I");
        lettera_di_controllo.put(9, "J");
        lettera_di_controllo.put(10, "K");
        lettera_di_controllo.put(11, "L");
        lettera_di_controllo.put(12, "M");
        lettera_di_controllo.put(13, "N");
        lettera_di_controllo.put(14, "O");
        lettera_di_controllo.put(15, "P");
        lettera_di_controllo.put(16, "Q");
        lettera_di_controllo.put(17, "R");
        lettera_di_controllo.put(18, "S");
        lettera_di_controllo.put(19, "T");
        lettera_di_controllo.put(20, "U");
        lettera_di_controllo.put(21, "V");
        lettera_di_controllo.put(22, "W");
        lettera_di_controllo.put(23, "X");
        lettera_di_controllo.put(24, "Y");
        lettera_di_controllo.put(25, "Z");

        int sommatore = 0;
        for (int i = 1; i <= cf_scomposto.size(); i++) {
            if (i % 2 == 0) {
                sommatore += Integer.parseInt(valore_pari.get(cf_scomposto.get(i - 1)));
            } else {
                sommatore += Integer.parseInt(valore_dispari.get(cf_scomposto.get(i - 1)));
            }
        }
        res = lettera_di_controllo.get(sommatore % 26);
        return res;
    }

    public String GetRequestEx(String comune) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.gerriquez.com/comuni/ws.php?dencomune=" + comune))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        String risposta_stringa = response.body();

        JSONParser jp = new JSONParser();
        JSONArray jrr = new JSONArray();

        try {
            jrr = (JSONArray) jp.parse(risposta_stringa);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String ass = (String) ((JSONObject) jrr.get(0)).get("CodiceCatastaleDelComune");

        System.out.println(ass);

        return (ass);
    }

    public String GiornoSesso(String Giorno, String sesso) {
        int CFgiorno = Integer.parseInt(Giorno);
        //if (Integer.parseInt(Giorno)  >= 0 && Integer.parseInt(Giorno) <= 9) CFgiorno = 0 + CFgiorno;
        if (sesso == "Femmina") CFgiorno = CFgiorno + 40;
        return String.valueOf(CFgiorno);
    }

    public String mese(String mese) {
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

    public String Cognome(String Cognome) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        char[] ch = Cognome.toCharArray();
        int numConsonanti = 0;
        int numVocali = 0;
        String CFcognome = "";
        boolean vocale = false;
        for (int i = 0; i < Cognome.length(); i++) {
            if (numConsonanti == 3) break;
            for (int j = 0; j < vowels.length; j++) {
                if (ch[i] == vowels[j]) {
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
        if (numConsonanti < 3) {
            for (int i = 0; i < Cognome.length(); i++) {
                if ((numConsonanti + numVocali) == 3) break;
                for (int j = 0; j < vowels.length; j++) {
                    if (ch[i] == vowels[j]) {
                        vocale = true;
                        break;
                    }
                }
                if (vocale) {
                    numVocali++;
                    CFcognome = CFcognome + ch[i];
                }
            }
        }
        return CFcognome;
    }

    public String nome(String nome) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        char[] nomech = nome.toCharArray();
        int numConsonanti = 0;
        int numVocali = 0;
        String CFnome = "";
        boolean vocale = false;
        for (int i = 0; i < nome.length(); i++) {
            if (numConsonanti == 3) break;
            for (int j = 0; j < vowels.length; j++) {
                if (nomech[i] == vowels[j]) {
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
        if (numConsonanti < 3) {
            for (int i = 0; i < nome.length(); i++) {
                if ((numConsonanti + numVocali) == 3) break;
                for (int j = 0; j < vowels.length; j++) {
                    if (nomech[i] == vowels[j]) {
                        vocale = true;
                        break;
                    }
                }
                if (vocale) {
                    numVocali++;
                    CFnome = CFnome + nomech[i];
                }
            }
        }
        return CFnome;
    }
}
