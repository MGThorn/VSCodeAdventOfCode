package day8;

import day.Day;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


public class Day8 extends Day{
    
    
    Map<String, Map<Character, String>> directions = new HashMap<>();
    String leftRigthString;
    String START; 
    String LAST;

    
    public void init() {
        leftRigthString = "";
        ArrayList<String> scan = scan("/day8/input.txt");
        leftRigthString += scan.get(0);
        leftRigthString += scan.get(1);
        scan.remove(0);
        

        String[] parts;

        for (String line : scan) {
            parts = line.split("[=(),\\s]+");
            if (parts.length<3) {
                continue;
            }
            if (START==null) {
                START = parts[0];
            }
            String firstKey = parts[0];
            String firstValue = parts[1];
            String secondValue = parts[2];

            directions.put(firstKey, new HashMap<>());
            directions.get(firstKey).put('L', firstValue);
            directions.get(firstKey).put('R', secondValue);
            LAST = firstKey;
            System.out.println(secondValue);
        }
        
        
    }
    public int countSteps(){
        String nexString = START;
        int counter=0;
        while (!nexString.equals(LAST)) {
            for (char c : leftRigthString.toCharArray()) {
            nexString = directions.get(nexString).get(c);
            counter++;
            if (nexString.equals(LAST)) {
                break;
            }
            }
            
        }
        return counter;
    }
}
