package day7;


import java.util.Arrays;

public class Hand implements Comparable<Hand> {
    String hand;
    final char[] handArr;
    final int[] cardsAsValues;
    final char[] handArrwithJokersReplaced;
    final int[] cardsAsValuesWithJokersAs1;
    final int bet;
    int type;

    public Hand(String hand, int bet) {
        this.hand = hand;
        this.handArr = hand.toCharArray();
        this.cardsAsValues = handToCardValues();
        this.handArrwithJokersReplaced = replaceJokers(); 
        this.cardsAsValuesWithJokersAs1 = revalueCardsWithJequals1();
        this.bet = bet;    
    }

    private char[] replaceJokers() {
        int häufigstesZeichen = Arrays.stream(cardsAsValuesWithJokersAs1).max().getAsInt();
        

        if (häufigstesZeichen!=1) {
            
        }
        return null;
        
    }

    

    
    public int compareTo(Hand o) {
        evalHandType();
        o.evalHandType();
        if (this.type != o.type) {
            return Integer.compare(this.type, o.type); //if the Type is Different the better Type wins    
        }else{
            return Arrays.compare(cardsAsValues, o.cardsAsValues); //if the Type is Same the first Higher Card wins
        }
        
    }

    

    @Override
    public String toString() {
        return "Hand [hand=" + hand + ", bet=" + bet + ", cardsAsValues=" + Arrays.toString(cardsAsValues) + ", type="
                + type + "]";
    }

    public void evalHandType() {
        int[] temp = new int[5];
        int i = 0;
        
        for (char c : handArr) {
            for (char c2 : handArr) {
                if (c == c2) {
                    temp[i]++;
                }
            }
            i++;
        }
        int max = Arrays.stream(temp).max().getAsInt();
        int towCounter = (int) Arrays.stream(temp).filter(a -> a == 2).count(); //counts how many twos there are in the whole Array
        type = max+max*10; 
        type += towCounter==4 ? 2 : 0; //for Two Pair -> 24 
        type += max == 3 && towCounter==2 ? 2 : 0; //for FullHouse -> 35
    }

    private int [] handToCardValues(){
        int[] ret = new String(handArr)
        .chars()
        .map(Character::getNumericValue)
        .toArray();;
        
        for (int i=0; i < handArr.length ;i++) {
            switch (handArr[i]) {
                case 'A':
                    ret[i] = 14;
                    break;
                case 'K':
                    ret[i] = 13;
                    break;
                case 'Q':
                    ret[i] = 12;
                    break;
                case 'J':
                    ret[i] = 11;
                    break;
                case 'T':
                    ret[i] = 10;
                    break;
                default:
                    break;
            }
        }
        return ret;
    }

    private int[] revalueCardsWithJequals1() {
        int [] temp = cardsAsValues;
        for (int i : temp) {
            i = i == 11 ? 1 : i;
        }
        return temp;
    }
    
        
   


    
}
