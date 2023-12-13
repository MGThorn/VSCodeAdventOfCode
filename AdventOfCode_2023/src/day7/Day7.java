package day7;


import java.util.ArrayList;
import java.util.Arrays;

import day6.Day6;

public class Day7 extends Day6 {
    Hand[] hands;

    public Day7() {
        
    }

    public void init(boolean withoutJoker) {
        ArrayList<String> scan = this.scan("/day7/input.txt");
        hands = new Hand[scan.size()];
        int index = 0;

        for (String line : scan) {
            hands[index++] = withoutJoker ? new Hand(line.split(" ")[0],Integer.parseInt(line.split(" ")[1])) : new JokerHand(line.split(" ")[0],Integer.parseInt(line.split(" ")[1]));
        }
    }
    

    public void sortHandArray(){
        Arrays.sort(hands);
    }

    public int calculateOverAllWinnings(){
        sortHandArray();
        int factor = 1;
        int cumulatedWinnings = 0;

        for (Hand hand : hands) {
            //System.out.println(hand.bet+" * "+factor+" + ");
            cumulatedWinnings += hand.bet*factor++;
        }
        return cumulatedWinnings;
    }


    

    public void printHandArray() {
        for (Hand hand : hands) {
            System.out.println(hand);
        }
    }

}
