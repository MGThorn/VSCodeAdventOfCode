package day7;

import java.util.Arrays;

public class JokerHand extends Hand {

    final int[] handArrwithJokersReplaced;
    final int[] cardsAsValuesWithJokersAs1;

    public JokerHand(String hand, int bet){
        super(hand, bet);
        this.cardsAsValuesWithJokersAs1 = revalueCardsWithJequals1();
        this.handArrwithJokersReplaced = replaceJokers();
    }

    @Override
    public int compareTo(Hand o) {
        if (o instanceof JokerHand) {
        JokerHand otherJokerHand = (JokerHand) o;

        evalHandType(handArrwithJokersReplaced);
        o.evalHandType(otherJokerHand.handArrwithJokersReplaced);
        if (this.type != o.type) {
            return Integer.compare(this.type, o.type); // if the Type is Different the better Type wins
        } else {
            return Arrays.compare(cardsAsValuesWithJokersAs1, otherJokerHand.cardsAsValuesWithJokersAs1); // if the Type is Same the first Higher Card wins
        }
        }else{
            return super.compareTo(o);
        }

    }

    private int[] replaceJokers() {
        int häufigstesZeichen = Arrays.stream(cardsAsValuesWithJokersAs1).max().getAsInt();
        int[] ret = cardsAsValuesWithJokersAs1.clone();

        if (häufigstesZeichen != 1) {
            for (int i = 0; i < ret.length; i++) {
                ret[i] = ret[i] == 1 ? häufigstesZeichen : ret[i];
            }
        } else {
            System.out.println(hand);
            System.out.println("TODO");
        }
        return ret;

    }

    private int[] revalueCardsWithJequals1() {
        int[] temp = cardsAsValues.clone();
        for (int i = 0; i < temp.length; i++) {
            temp[i] = temp[i] == 11 ? 1 : temp[i];
        }
        return temp;

    }

    @Override
    public String toString() {
        return "JokerHand [hand=" + hand + ", bet=" + bet + ", handArrwithJokersReplaced = "
                + Arrays.toString(handArrwithJokersReplaced)
                + ", cardsAsValuesWithJokersAs1=" + Arrays.toString(cardsAsValuesWithJokersAs1) + ", type=" + type
                + "]";
    }

}
