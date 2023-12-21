package day9;

import java.util.Arrays;

import day.Day;

public class Day9 extends Day{

    public void init(){
        for (String line : scan("/day9/input.txt")) {
            String[] stringArray = line.split(" ");
            int[] intArray = Arrays.stream(stringArray)
                                .mapToInt(Integer::parseInt)
                                .toArray();
            
        }
        
    }

    public int getNextInt(int[] arr){
        buildRows(arr, arr[arr.length-1]);
    }

    private int[] buildRows(int[] row, int next) {
        int j=1;
        for (int i = 0; i < row.length-1; i++) {
            row[j++] - row[i]
        }
    }
    
}
