package day7;

import java.util.Arrays;

public class Hand implements Comparable<Hand> {
    String hand;
    final char[] handArr;
    final int[] cardsAsValues;
    final int bet;
    int type;

    public Hand(String hand, int bet) {
        this.hand = hand;
        this.handArr = hand.toCharArray();
        this.cardsAsValues = handToCardValues();
        this.bet = bet;
    }

    @Override
    public int compareTo(Hand o) {
        evalHandType(cardsAsValues);
        o.evalHandType(o.cardsAsValues);
        if (this.type != o.type) {
            return Integer.compare(this.type, o.type); // if the Type is Different the better Type wins
        } else {
            return Arrays.compare(cardsAsValues, o.cardsAsValues); // if the Type is Same the first Higher Card wins
        }

    }

    @Override
    public String toString() {
        return "Hand [hand=" + hand + ", bet=" + bet + ", cardsAsValues=" + Arrays.toString(cardsAsValues) + ", type="
                + type + "]";
    }

    public void evalHandType(int[] arr) {
        int[] temp = new int[5];
        int i = 0;

        for (int c : arr) {
            for (int c2 : arr) {
                if (c == c2) {
                    temp[i]++;
                }
            }
            i++;
        }
        int max = Arrays.stream(temp).max().getAsInt();
        int towCounter = (int) Arrays.stream(temp).filter(a -> a == 2).count(); // counts how many twos there are in the
                                                                                // whole Array
        type = max + max * 10;
        type += towCounter == 4 ? 2 : 0; // for Two Pair -> 24
        type += max == 3 && towCounter == 2 ? 2 : 0; // for FullHouse -> 35
    }

    private int[] handToCardValues() {
        int[] ret = new String(handArr)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
        ;

        for (int i = 0; i < handArr.length; i++) {
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

}
