import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] vezetekNev = {"Kovács", "Kis", "Nagy", "Fehér", "Kerekes"};
    static String[] keresztNev = {"Edit", "Zoltán", "Orsolya", "Szabolcs", "Erika"};
    int nevNumIndex = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] nevek = new String[vezetekNev.length * keresztNev.length];

    public static void main(String[] args)  {
        new Main().nevekOsszeAllitasa();
        Menu menu = new Menu();
        menu.show(br,nevek);
    }

    public void nevekOsszeAllitasa() {
        for (String vn : vezetekNev) {
            for (String kn : keresztNev) {
                nevek[nevNumIndex++] = vn + " " + kn;
            }
        }
    }
}