package day3;

import day.Day;

public class Day3 extends Day {
    char[] [] field;
    int [] directions;
    int stackNumber;

    Day3(){
        directions = new int[8];
        stackNumber = 0;
    }

    public void initField() {
        int i =0;
        field = new char[this.scan("/day3/input.txt").size()][this.scan("/day3/input.txt").get(0).length()];
        
        for (String line : this.scan("/day3/input.txt")) {
            char [] temp = line.toCharArray();
            field[i++] = temp;
        }

    }
    public void initTestField() {
        int i =0;
        field = new char[this.scan("/day3/test_input.txt").size()][this.scan("/day3/test_input.txt").get(0).length()];
        
        for (String line : this.scan("/day3/test_input.txt")) {
            char [] temp = line.toCharArray();
            field[i++] = temp;
        }

    }

    public void run(){
        int sum = 0;
        stackNumber = 0;
        boolean validNumber = false;
       

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (Character.isDigit(field[i][j])) {
                    stackNumber = stackNumber*10 + Character.getNumericValue(field[i][j]);
                    validNumber = validNumber ? true : isValid(i, j); 
                }else{
                    if (validNumber) {
                        sum += stackNumber;
                    }
                    validNumber = false;
                    stackNumber = 0;
                }
            }
        }
        System.out.println(sum);
    }

    

    public boolean isValid(int i, int j) {
        boolean ret=false;
        if (i-1>=0&&j+1<field.length&&!(field[i-1][j+1]=='.'|Character.isDigit(field[i-1][j+1]))) {
            ret = true;
        }else if (j+1<field.length&&!(field[i][j+1]=='.'|Character.isDigit(field[i][j+1]))) {
            ret = true;
        }else if (j+1<field.length&&i+1<field.length&&!(field[i+1][j+1]=='.'|Character.isDigit(field[i+1][j+1]))) {
            ret = true;
        }else if (i+1<field.length&&!(field[i+1][j]=='.'|Character.isDigit(field[i+1][j]))) {
            ret = true;
        }else if (i-1>=0&&!(field[i-1][j]=='.'|Character.isDigit(field[i-1][j]))) {
            ret = true;
        }else if (j-1>=0&&i-1>=0&&!(field[i-1][j-1]=='.'|Character.isDigit(field[i-1][j-1]))) {
            ret = true;
        }else if (j-1>=0&&!(field[i][j-1]=='.'|Character.isDigit(field[i][j-1]))) {
            ret = true;
        }else if (j-1>=0&&i+1<field.length&&!(field[i+1][j-1]=='.'|Character.isDigit(field[i+1][j-1]))) {
            ret = true;
        }
        return ret ;

    }
}
