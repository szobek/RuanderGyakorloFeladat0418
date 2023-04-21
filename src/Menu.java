import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Menu {
    public void show(BufferedReader br, String[] nevek)  {
        String menupont = "";
        System.out.println("Válasszon");
        do {
            System.out.println("1 - Lista");
            System.out.println("2 - fájlba írás");
            System.out.println("3 - Rendezett lista a teljes névhossz alapján");
            System.out.println("4 - Az átlaghosszal egyező nevek listázása");
            System.out.println("5 - Kilépés");
            try {
                menupont = br.readLine();
            } catch (IOException e) {
                System.out.println("I/O hiba van");
            }
            switch (menupont) {
                case "1" -> listazas(nevek);
                case "2" -> fajlbaIras(nevek);
                case "3" -> listaHosszAlapjan(nevek);
                case "4" -> listaAtlagHosszAlapjan(nevek);
            }

        } while (!menupont.equals("5"));

    }

    private void listaAtlagHosszAlapjan(String[] nevek) {
        int atlagHossz;
        int osszesen = 0;
        for (String nev : nevek) {
            osszesen += nev.length();
        }
        atlagHossz =  osszesen / nevek.length;
        for (String nev : nevek) {
            if (nev.length() ==  atlagHossz) {
                System.out.println(nev);
            }
        }


    }

    private void listaHosszAlapjan(String[] nevek) {
        Arrays.sort(nevek, (str1, str2) -> Integer.compare(str2.length(), str1.length()));
        listazas(nevek);
    }

    private void fajlbaIras(String[] nevek) {
        String fajl = "teszt.txt";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fajl)); ){
            for (String nev : nevek) {
                bw.append(nev);
            }
            System.out.println("fájlbaírás kész");
        }catch (IOException e){
            System.out.println("I/O hiba");
        }



    }

    private void listazas(String[] nevek) {
        for (String nev : nevek) {
            System.out.println(nev);
        }
    }
}
