package day7;

import java.util.HashMap;
import java.util.Map; 
import day6.Day6;

public class Day7 extends Day6 {
    Map<Integer, Integer> betMap = new HashMap<>();
    Map<Integer, String> cardMap = new HashMap<>();

    Map<String, Integer> replaceNum = new HashMap<>();
    Map<Integer, String> replaceSign = new HashMap<>();

    

    public Day7() {
        replaceNum.put("A", 14);
        replaceNum.put("K", 13);
        replaceNum.put("Q", 12);
        replaceNum.put("J", 11);
        replaceNum.put("T", 10);

        replaceSign.put(14, "A");
        replaceSign.put(13, "K");
        replaceSign.put(12, "Q");
        replaceSign.put(11, "J");
        replaceSign.put(10, "T");
    }

    public void init(){
        int i = 0;
        for (String line : this.scan("/day7/input.txt")) {
            betMap.put(i++, Integer.parseInt(line.split(" ")[1]));
        }
        for (String line : this.scan("/day7/input.txt")) {
            cardMap.put(i++, line.split(" ")[0]);
        }

        for (String hand : cardMap.values()) {
            hand = sort(hand);
        }
        

        
        
    }

    public String sort(String hand) {
        int [] intHand = convertToArr(hand);
        intHand = bubbleSort(intHand);
        hand = convertBackToString(intHand);
        return hand;
    }

    private String convertBackToString(int[] intHand) {
        String hand = "";

         for (int i = 0; i < intHand.length; i++) {
            hand += intHand[i] < 10 ? intHand[i] : "";
            for (int value : replaceNum.values()) {
                hand += intHand[i] == value  ? replaceSign.get(value)+"" : "";
            }  
        }
        return hand;
    }

    public int [] convertToArr(String hand){
        String [] strgArr = removeEmptyFields(hand.split(""));

       
        for (int i = 0; i < strgArr.length; i++) {
            for (String key : replaceNum.keySet()) {
                strgArr[i] = strgArr[i].equals(key) ? replaceNum.get(key)+"" : strgArr[i];
            }  
        }
        
        return convertStringArrayToIntArray(strgArr);

    }
    public static int[] convertStringArrayToIntArray(String[] stringArray) {
        int length = stringArray.length;
        int[] intArray = new int[length];

        for (int i = 0; i < length; i++) {
            try {
                intArray[i] = Integer.parseInt(stringArray[i]);
            } catch (NumberFormatException e) {
                System.err.println("Error parsing string to int at index " + i + ": " + e.getMessage());
                intArray[i] = 0; 
            }
        }

        return intArray;
    }

    public int [] bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    
}
