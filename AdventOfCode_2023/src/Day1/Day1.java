package day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import day.Day;

public class Day1 extends Day {
    Map<String, String> numberMap = new HashMap<>();

    public Day1() {
        numberMap.put("zero", "0");
        numberMap.put("one", "on1e");
        numberMap.put("two", "tw2o");
        numberMap.put("three", "thre3e");
        numberMap.put("four", "fo4ur");
        numberMap.put("five", "fi5ve");
        numberMap.put("six", "si6x");
        numberMap.put("seven", "sev7en");
        numberMap.put("eight", "ei8ght");
        numberMap.put("nine", "ni9ne");
    }

    public int sumCalbrationValues(int version) {
        ArrayList<String> wordList = new ArrayList<>();
        wordList = this.scan("/day1/input2.txt");
        int firstDiget;
        int lastDiget;
        int sum = 0;

        for (String string : wordList) {
            firstDiget = version == 0 ? firstDiget(string) * 10 : firstDiget(replaceNumber(string)) * 10;
            lastDiget = version == 0 ? lastDiget(string) : lastDiget(replaceNumber(string));
            System.out.println(string);
            System.out.println(firstDiget/10+" | "+lastDiget);
            sum += firstDiget + lastDiget;
            System.out.println(firstDiget + lastDiget);
            System.out.println("");
        }
        return sum;
    }

    public String replaceNumber(String string) {

        for (String string2 : numberMap.keySet()) {
            string = string.replace(string2, numberMap.get(string2));
        }
        return string;
    }

    public int firstDiget(String word) {
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                return Character.getNumericValue(c);
            }
        }
        return 0;
    }

    public int lastDiget(String word) {
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
