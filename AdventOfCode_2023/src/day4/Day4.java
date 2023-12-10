package day4;

import day.Day;

public class Day4 extends Day{

    public void init(){
        int totalPoints = 0;

        for (String line : this.scan("/day4/input.txt")) {

            String firstCut = line.split(":")[1];
            
            String [] winningNumbersStringArr = removeEmptyFields(firstCut.split("\\|")[0].split(" "));
            String [] playedNumbersStringArr = removeEmptyFields(firstCut.split("\\|")[1].split(" "));
            
            int i = -1;
            int pointPerLine = 0;
            for (String string : winningNumbersStringArr) {
                for (String string2 : playedNumbersStringArr) {
                    i += string2.equals(string) ? 1 : 0;
                }
            }
            pointPerLine = i >= 0 ? towSqared(i) : 0;
            System.out.println(pointPerLine);
            totalPoints += pointPerLine;
            System.out.println(totalPoints);
            


        }
    }

    private int towSqared(int i) {
        if (i == 0) {
            return 1;
        }
        return 2*towSqared(--i);

    }
    public String[] removeEmptyFields(String[] inputArray) {
        int countNonEmpty = 0;
        for (String element : inputArray) {
            if (!element.trim().isEmpty()) {
                countNonEmpty++;
            }
        }

        String[] newArray = new String[countNonEmpty];
        int newIndex = 0;
        for (String element : inputArray) {
            if (!element.trim().isEmpty()) {
                newArray[newIndex] = element;
                newIndex++;
            }
        }

        return newArray;
    }
}
