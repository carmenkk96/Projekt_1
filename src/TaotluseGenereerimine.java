import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaotluseGenereerimine {
    public static void main(String[] args) throws FileNotFoundException {
        //küsime admed
        Scanner scan = new Scanner(System.in);
        System.out.println("Sisesta taotleja nimi:");
        String taotlejaNimi = scan.nextLine();
        System.out.println("Sisesta toote nimi: ");
        String tooteNimi = scan.nextLine();

        //lisame uued andmed uute taotluse isendisse
        Taotlus uusTaotlus = new Taotlus(taotlejaNimi, tooteNimi);
        System.out.println(uusTaotlus);

        //genereerime uue ID
        ID uus = new ID(uusTaotlus);
        System.out.println(uus);

    }
}