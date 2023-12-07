package day3;

import day.Day;

public class Day3 extends Day {
    String[][] field;

    public void initField() {
        for (String line : this.scan("/day3/test_input.txt")) {
            String[] lineArr = line.split("");
            for (String string : lineArr) {
                System.out.println(string);
            }
        }

    }

    public int[] findNumber() {
        return null;

    }

    public int[][] checkSurroundings() {
        return null;

    }
}
