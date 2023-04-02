import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
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
        ID uusId = new ID(taotlejaNimi, tooteNimi);
        Taotlus uusTaotlus = new Taotlus(taotlejaNimi, tooteNimi);
        System.out.println(uusId);

        //Lihtsalt testimiseks näitan ID listi, mis on salvestatud
        //EI OLE PROGRAMMI TOIMIMISEKS VAJALIK!
        try {
            FileInputStream fileIn = new FileInputStream("idlist.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            List<String> list = (List<String>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Testimiseks näitan ID listi, mis on salvestatud: " + list);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}