import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class ID {
    private Taotlus taotlus;
    private String id;


    public ID(Taotlus taotlus) throws FileNotFoundException {
        this.taotlus = taotlus;
        this.id = generateID();
    }

    private String generateID() throws FileNotFoundException {
        this.id = taotlus.getTaotluseKuupäev().toString().replaceAll("-", "").substring(2) + "-" +
                taotlus.getTaotlejaNimi().substring(0, 2).toUpperCase() + taotlus.getTooteNimi().substring(0, 4).toUpperCase();
        if (idSobivuseKontroll(new File("andmebaas.txt"), this.id) == false) {
            this.id = taotlus.getTaotluseKuupäev().toString().replaceAll("-", "").substring(2) + "-" +
                    taotlus.getTaotlejaNimi().substring(0, 2).toUpperCase() + taotlus.getTooteNimi().substring(0, 4).toUpperCase()+
                    + (int) (Math.random() * 5); //ID genereerimisel ka juhuslikkuse kasutamine
            if (idSobivuseKontroll(new File("andmebaas.txt"), this.id) == false)
                return veaTeade();}
        else
            try(PrintWriter pw = new PrintWriter(new FileOutputStream("andmebaas.txt", true))) {
                pw.println(taotlus.getTaotluseKuupäev() + " " +  taotlus.getTaotlejaNimi() + " " + taotlus.getTooteNimi() + " " + this.id);
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

    public void salvestaAndmebaasi() throws FileNotFoundException {
        if (generateID() != null) {
            try(PrintWriter pw = new PrintWriter(new FileOutputStream("andmebaas.txt", true))) {
                pw.println(taotlus.getTaotluseKuupäev() + " " + taotlus.getTooteNimi() + " " + taotlus.getTaotlejaNimi() + " " + this.id);
            }
        }
    }


    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        if (this.id == null)
            return veaTeade();
        else
            return "Taotlus: " + id + " (" + taotlus.getTaotlejaNimi() + ", " + taotlus.getTooteNimi() + ", " + taotlus.getTaotluseKuupäev() +")";
    }

}
