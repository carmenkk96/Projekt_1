import java.io.FileNotFoundException;
import java.util.Scanner;


public class TaotluseGenereerimine {

    public static void main(String[] args) throws Exception {
        //küsime admed
        Scanner scan = new Scanner(System.in);
        System.out.println("Sisesta taotleja nimi:");
        String taotlejaNimi = scan.nextLine();
        System.out.println("Sisesta toote nimi: ");
        String tooteNimi = scan.nextLine();

        //lisame uued andmed uute taotluse isendisse
        Taotlus uusTaotlus = new ID(taotlejaNimi, tooteNimi);
        System.out.println(uusTaotlus);

    }
}