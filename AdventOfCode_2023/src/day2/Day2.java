package day2;

import day.Day;

public class Day2 extends Day{
    
    public String game(){
        int i = 1;
        int sum = 0;
        for (String line : this.scan("/day2/input.txt")) {          

            String firstCut = line.split(":")[1];
            i++;

            for (String ammountPlusColor : firstCut.split(";|,")) {
                if (testIfColorRightAmmount(ammountPlusColor)) {
                    break;
                }else{
                    sum+=i;
                }
            }      
        }
        return "Summe aller Spiele: "+ sum;
    }

    private boolean testIfColorRightAmmount(String ammountPlusColor) {
            String [] zahlPlusFarbe = ammountPlusColor.split(" ");                
            if (zahlPlusFarbe[2].equals("red")) {
                if(Integer.parseInt(zahlPlusFarbe[1]) > 12){ 
                    return false;
                }
            }
            if (zahlPlusFarbe[2].equals("green")) {
                if(Integer.parseInt(zahlPlusFarbe[1]) > 13){ 
                    return false;
                }
            }
            if (zahlPlusFarbe[2].equals("blue")) {
                if(Integer.parseInt(zahlPlusFarbe[1]) > 14){ 
                    return false;
                }
            }
            return true;
        
    }
}
