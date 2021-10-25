package behaviorpatterns.observer.eventsubscription.suscribers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveFileSubscriber implements Subscriber {

    private FileWriter fileWriter = null;
    private String text;

    @Override
    public void update(File file) {
        try {
            fileWriter = new FileWriter(file);
            PrintWriter writer = new PrintWriter(fileWriter);
            getTextToSave();
            writer.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeFile();
        }
    }

    private void getTextToSave(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce text to save:");
        text = sc.nextLine();
    }

    private void closeFile() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
