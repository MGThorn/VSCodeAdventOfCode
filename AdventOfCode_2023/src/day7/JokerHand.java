package day7;

import java.util.Arrays;

public class JokerHand extends Hand {

    
    public JokerHand(String hand, int bet) {
        super(hand, bet);
    }

    public int compareTo(Hand o) {
        evalHandType(cardsAsValuesWithJokersAs1);
        o.evalHandType(o.cardsAsValuesWithJokersAs1);
        if (this.type != o.type) {
            return Integer.compare(this.type, o.type); //if the Type is Different the better Type wins    
        }else{
            return Arrays.compare(handArrwithJokersReplaced, o.handArrwithJokersReplaced); //if the Type is Same the first Higher Card wins
        }
        
    }
    
}
