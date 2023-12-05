package day1;

import java.util.ArrayList;
import day.Day;

public class Day1 extends Day{

    public int sumCalbrationValues(){
        ArrayList<String> wordList = new ArrayList<>();
        wordList = this.scan("/day1/input.txt");
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
