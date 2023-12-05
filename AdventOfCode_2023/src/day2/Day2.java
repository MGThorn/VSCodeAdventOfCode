package day2;

import day.Day;

public class Day2 extends Day{
    
    public void init(){
        for (String line : this.scan("/day2/input.txt")) {
            final int red = 12;
            final int green = 13;
            final int blue = 14;

            String firstCut = line.split(":")[1];
            for (String word : firstCut.split(";|,")) {
                if (word.split(" ")[1].equals("red")) {
                    
                }
            }
            



        }
    }
}
