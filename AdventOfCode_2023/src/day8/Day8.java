package day8;

import day.Day;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class Day8 extends Day{
    
    Map<String, Map<Character, String>> directions = new HashMap<>();
    String leftRigthString; 

    
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

        String[] parts;

        for (String line : scan) {
            parts = line.split("[=(),\\s]+");
            System.out.print(parts.length != 3 ? line : "");
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
