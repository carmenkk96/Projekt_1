import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ID extends Taotlus {
    private String id;

    public ID(String taotlejaNimi, String tooteNimi) throws Exception {
        super(taotlejaNimi, tooteNimi);
        this.id = generateID();
    }


    private String generateID() throws FileNotFoundException {
        this.id = super.getTaotluseKuupäev().toString().replaceAll("-", "").substring(2) + "-" +
                super.getTaotlejaNimi().substring(0, 2).toUpperCase() + super.getTooteNimi().substring(0, 4).toUpperCase();
        if (idSobivuseKontroll(new File("andmebaas.txt"), this.id) == false) {
            this.id = super.getTaotluseKuupäev().toString().replaceAll("-", "").substring(2) + "-" +
                    super.getTaotlejaNimi().substring(0, 2).toUpperCase() + super.getTooteNimi().substring(0, 4).toUpperCase()+
                    + (int) Math.round(Math.random() * 5); //ID genereerimisel ka juhuslikkuse kasutamine
            if (idSobivuseKontroll(new File("andmebaas.txt"), this.id) == false)
                return veaTeade();
        }
        try(PrintWriter pw = new PrintWriter(new FileOutputStream("andmebaas.txt", true))) {
            pw.println(super.getTaotluseKuupäev() + " " +  super.getTaotlejaNimi() + " " + super.getTooteNimi() + " " + this.id);
            }
        return this.id;
    }


    private boolean idSobivuseKontroll(File fail, String id) throws FileNotFoundException {
        try (Scanner sc = new Scanner(fail, "UTF-8")) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                String[] osad = rida.split(" ");
                if (osad[osad.length - 1].equals(id)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String  veaTeade () {
        return "Taotlust ei registreeritud - ID on juba andmebaasis olemas. Palun proovi uuesti!";
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        if (this.id == null)
            return veaTeade();
        else
            return "Taotlus: " + id + " (" + super.getTaotlejaNimi() + ", " + super.getTooteNimi() + ", " + super.getTaotluseKuupäev() +")";
    }

}
