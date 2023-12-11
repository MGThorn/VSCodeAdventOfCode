package day7;

import java.util.HashMap;
import java.util.Map;

import day.Day;

public class Day7 extends Day {
    Map<String, Integer> betMap = new HashMap<>();

    public void init(){
        for (String line : this.scan("/day7/test_input.txt")) {
            betMap.put(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
        }
        
    }
}
