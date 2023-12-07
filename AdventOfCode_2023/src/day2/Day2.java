package day2;

import day.Day;

public class Day2 extends Day {

    public String game() {
        int i = 0;
        int sum = 0;
        boolean temp = true;
        for (String line : this.scan("/day2/input.txt")) {

            String firstCut = line.split(":")[1];
            i++;

            for (String ammountPlusColor : firstCut.split(";|,")) {
                if (testIfColorRightAmmount(ammountPlusColor)) {
                    temp = true;
                } else {
                    temp = false;
                    break;
                }
            }
            if (temp) {
                sum += i;
            }
        }
        return "Summe aller Spiele: " + sum;
    }

    private boolean testIfColorRightAmmount(String ammountPlusColor) {
        String[] zahlPlusFarbe = ammountPlusColor.split(" ");
        if (zahlPlusFarbe[2].equals("red")) {
            if (Integer.parseInt(zahlPlusFarbe[1]) > 12) {
                return false;
            }
        }
        if (zahlPlusFarbe[2].equals("green")) {
            if (Integer.parseInt(zahlPlusFarbe[1]) > 13) {
                return false;
            }
        }
        if (zahlPlusFarbe[2].equals("blue")) {
            if (Integer.parseInt(zahlPlusFarbe[1]) > 14) {
                return false;
            }
        }
        return true;

    }

    public String game2() {
        int sum = 0;
        for (String line : this.scan("/day2/input.txt")) {

            String [] lineArr = line.split(":")[1].split(";|,");
            sum += highestColorAmmount(lineArr);
        }
        return "Summe der power aller Spiele: " + sum;
    }


    private int highestColorAmmount(String[] line) {
        int red = 0;
        int green = 0;
        int blue = 0;

        for (String ammountPlusColor : line) {
            String[] zahlPlusFarbe = ammountPlusColor.split(" ");
            if (zahlPlusFarbe[2].equals("red")) {
                if (Integer.parseInt(zahlPlusFarbe[1]) > red) {
                    red = Integer.parseInt(zahlPlusFarbe[1]);
                }
            }
            if (zahlPlusFarbe[2].equals("green")) {
                if (Integer.parseInt(zahlPlusFarbe[1]) > green) {
                    green = Integer.parseInt(zahlPlusFarbe[1]);
                }
            }
            if (zahlPlusFarbe[2].equals("blue")) {
                if (Integer.parseInt(zahlPlusFarbe[1]) > blue) {
                    blue = Integer.parseInt(zahlPlusFarbe[1]);
                }
            }
        }

        return red*green*blue;
    }
}
