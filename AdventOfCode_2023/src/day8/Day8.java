package day8;

import day7.Day7;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class Day8 extends Day7{
    
    Map<String, Map<Character, String>> directions = new HashMap<>();
    String leftRigthString; 

    @Override
    public void init() {
        for (Map<Character, String> direction : directions.values()) {
            direction = new HashMap<>();
        }

        leftRigthString = "";
        ArrayList<String> scan = scan("/day8/input.txt");
        leftRigthString += scan.get(0);
        leftRigthString += scan.get(1);
        scan.remove(0);
        scan.remove(1);
        scan.remove(2);

        for (String line : scan) {
            String[] parts = line.split("[=(),\\s]+");
            System.out.println(parts.length);
            for (String s : parts) {
                System.out.println(s);
            }
            String firstKey = parts[0];
            String firstValue = parts[0];
            String secondValue = parts[0];

            directions.put(firstKey, new HashMap<>());
            directions.get(firstKey).put('L', firstValue);
            directions.get(firstKey).put('R', secondValue);

            //System.out.println(directions.get(firstKey).get('L'));
            //System.out.println(directions.get(firstKey).get('R'));
        }
        
    }
}
