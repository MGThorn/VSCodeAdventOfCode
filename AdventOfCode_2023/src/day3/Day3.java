package day3;

import day.Day;

public class Day3 extends Day {
    char[] [] field;
    int [] directions;

    Day3(){
        directions = new int[8];
    }

    public void initField() {
        int i =0;
        field = new char[this.scan("/day3/test_input.txt").size()][this.scan("/day3/test_input.txt").get(0).length()];
        
        for (String line : this.scan("/day3/test_input.txt")) {
            char [] temp = line.toCharArray();
            field[i++] = temp;
        }

    }

    public void run(){
        int sum = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (Character.isDigit(field[i][j])&&isValid(i,j)) {
                    sum += getNumber();
                }
            }
        }
        System.out.println(sum);
    }

    private int getNumber() {
        return 0;
    }

    public boolean isValid(int i, int j) {
        if (!Character.isDigit(field[i-1][j+1])) {
            return true;
        }else if (!Character.isDigit(field[i][j+1])) {
            
        }else if (!Character.isDigit(field[i+1][j+1])) {
            
        }else if (!Character.isDigit(field[i][j-1])) {
            
        }else if (!Character.isDigit(field[i][j-1])) {
            
        }else if (!Character.isDigit(field[i][j])) {
            
        }else if (!Character.isDigit(field[i][j])) {
            
        }
        return true;

    }
}
