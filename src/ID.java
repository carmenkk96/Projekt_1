import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class ID {
    private String taotlejaNimi;
    private String tooteNimi;
    private LocalDate taotluseKuupäev;
    private String id;

    public ID(Taotlus taotlus) throws FileNotFoundException {
        this.taotlejaNimi = taotlus.getTaotlejaNimi();
        this.tooteNimi = taotlus.getTooteNimi();
        this.taotluseKuupäev = taotlus.getTaotluseKuupäev();
        this.id = generateID();
    }

    private String generateID() throws FileNotFoundException {
        String id;
        do {
            id = taotluseKuupäev.toString().replaceAll("-", "").substring(2) + "-" +
                    taotlejaNimi.substring(0, 2).toUpperCase() + tooteNimi.substring(0, 4).toUpperCase();
                    //+ (int) (Math.random() * 20); //ID genereerimisel ka juhuslikkuse kasutamine
            if (idSobivuseKontroll(new File("andmebaas.txt"), id) == false)
                return null;
        } while (!idSobivuseKontroll(new File("andmebaas.txt"), id));

        try(PrintWriter pw = new PrintWriter(new FileOutputStream("andmebaas.txt", true))) {
            pw.println(taotluseKuupäev + " " + taotlejaNimi + " " + tooteNimi + " " + id);
        }
        return id;
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
                pw.println(taotluseKuupäev + " " + taotlejaNimi + " " + tooteNimi + " " + id);
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
            return "Taotlus: " + id + " (" + taotlejaNimi + ", " + tooteNimi + ", " + taotluseKuupäev +")";
    }
}
