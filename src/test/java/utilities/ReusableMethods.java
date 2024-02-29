package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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

    /**
     * Bu method işlem yapılacak elementi renkli çerçeve içine alarak testin okunurluğunu arttırır.
     * @param locate işlem yapılacak elementin locate i xpath türünde girilmelidir.
     */
    public  static  void showElementWithFrame(String locate){
        WebElement element=Driver.getDriver().findElement(By.xpath(""+locate+""));
        String script="arguments[0].style.border='3px solid red';";
        //String script="arguments[0].style.border='3px solid green';";
        ((JavascriptExecutor) Driver.getDriver()).executeScript(script, element);
    }
}
