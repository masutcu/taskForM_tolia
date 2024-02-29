package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReusableMethods {
    public static void raporuAc(){
        // Rapor dosyasının tam yolu
        String raporYolu = System.getProperty("user.dir")+"\\raporlar\\CucumberRapor.html";

        boolean isRaporExist= Files.exists(Paths.get(raporYolu));

        if(isRaporExist==true){
            try {
                // Google Chrome'un çalıştırılması
                String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
                String command = chromePath + " " + raporYolu;
                Process process = Runtime.getRuntime().exec(command);

                // İşlemi bekleyin
                process.waitFor();

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }else System.out.println("DİKKAT: rapor oluşmadığı için açılamadı");


    }
}
