package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    
    public ArrayList<String> scan(String path){
        String absolutePath = System.getProperty("user.dir")+path;
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

    public int sumCalbrationValues(){
        ArrayList<String> wordList = new ArrayList<>();
        wordList = this.scan("/AdventOfCode_2023/src/Day1/input.txt");
        int firstDiget;
        int lastDiget;
        int sum = 0;

        for (String string : wordList) {
            firstDiget = this.firstDiget(string)*10;
            lastDiget = this.lastDiget(string);
            System.out.println(lastDiget+firstDiget);
            sum += firstDiget+lastDiget;
        }
        return sum;
    }

    public int firstDiget(String word){
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                return Character.valueOf(c);
            }
        }
        return -1;
    }

    public int lastDiget(String word){
        int ret = -1;
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                ret = Character.valueOf(c);
            }
        } 
        return ret;
    }


}
