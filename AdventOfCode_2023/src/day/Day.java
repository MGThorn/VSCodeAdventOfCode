package day;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day {
    public ArrayList<String> scan(String path){
        String absolutePath = System.getProperty("user.dir")+"/AdventOfCode_2023/src"+path;
        ArrayList<String> returnList = new ArrayList<>();
        
        try {
            Scanner scanner = new Scanner(new File(absolutePath));

            while (scanner.hasNextLine()) {
                returnList.add(scanner.nextLine());
                
            }
            scanner.close();
            return returnList;

        } catch (FileNotFoundException e) {
            System.err.println("Die Datei wurde nicht gefunden: " + e.getMessage());
            return returnList;
        }
    }
}
