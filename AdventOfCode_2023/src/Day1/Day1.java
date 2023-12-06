package day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import day.Day;

public class Day1 extends Day{
    Map<String, String> numberMap = new HashMap<>();
        

    public Day1() {
        numberMap.put("zero", "0");
        numberMap.put("one", "1");
        numberMap.put("two", "2");
        numberMap.put("three", "3");
        numberMap.put("four", "4");
        numberMap.put("five", "5");
        numberMap.put("six", "6");
        numberMap.put("seven", "7");
        numberMap.put("eight", "8");
        numberMap.put("nine", "9");
    }



    public int sumCalbrationValues(int version){
        ArrayList<String> wordList = new ArrayList<>();
        wordList = this.scan("/day1/input.txt");
        int firstDiget;
        int lastDiget;
        int sum = 0;

        for (String string : wordList) {
            firstDiget = version==0 ? this.firstDiget(string)*10 : this.firstNumber(string)*10;
            lastDiget = version==0 ? this.lastDiget(string) : this.lastNumber(string);
            System.out.println(lastDiget+" "+firstDiget);
            sum += firstDiget+lastDiget;
        }
        return sum;
    }

    

    public int lastNumber(String string) {
        for (String string2 : numberMap.keySet()) {
            string = string.replace(string2, numberMap.get(string2));
        }
        System.err.println(string);
        return 0;
    }



    private int firstNumber(String string) {
        return 0;
    }



    public int firstDiget(String word){
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                return Character.getNumericValue(c);
            }
        }
        return 0;
    }

    public int lastDiget(String word){
        int ret = 0;
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                ret = Character.getNumericValue(c);
            }
        } 
        return ret;
    }

    public int convertWrittenNumberToInt(String writtenNumber) {
               
        return Integer.parseInt(numberMap.getOrDefault(writtenNumber, "-1"));
    }


}
