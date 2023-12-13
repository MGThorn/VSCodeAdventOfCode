package day7;

import java.util.HashMap;
import java.util.Map;
import day6.Day6;

public class Day7 extends Day6 {
    Map<Integer, Integer> betMap = new HashMap<>();
    Map<Integer, String> cardMap = new HashMap<>();

    Map<String, Integer> replaceNum = new HashMap<>();
    Map<Integer, String> replaceSign = new HashMap<>();

    int[] sortedKeysFromWorstToBest;

    int[] fiveOfAKind;
    int indexF;
    int[] fourOfAKind;
    int indexFo;
    int[] fullHouse;
    int indexFH;
    int[] threeOfAKind;
    int indexT;
    int[] towPair;
    int indexTP;
    int[] onePair;
    int indexOP;
    int[] highCard;
    int indexhighCard;

    public Day7() {
        replaceNum.put("A", 14);
        replaceNum.put("K", 13);
        replaceNum.put("Q", 12);
        replaceNum.put("J", 11);
        replaceNum.put("T", 10);

        replaceSign.put(14, "A");
        replaceSign.put(13, "K");
        replaceSign.put(12, "Q");
        replaceSign.put(11, "J");
        replaceSign.put(10, "T");

        indexF = 0;
        indexFH = 0;
        indexFo = 0;
        indexOP = 0;
        indexT = 0;
        indexTP = 0;
        indexhighCard = 0;
    }

    public void init() {
        int i = 0;
        for (String line : this.scan("/day7/input.txt")) {
            betMap.put(i++, Integer.parseInt(line.split(" ")[1]));
        }
        for (String line : this.scan("/day7/input.txt")) {
            cardMap.put(i++, line.split(" ")[0]);
        }

        sortedKeysFromWorstToBest = new int[cardMap.values().size()];
        highCard = new int[cardMap.values().size()];
        onePair = new int[cardMap.values().size()];
        towPair = new int[cardMap.values().size()];
        threeOfAKind = new int[cardMap.values().size()];
        fullHouse = new int[cardMap.values().size()];
        fourOfAKind = new int[cardMap.values().size()];
        fiveOfAKind = new int[cardMap.values().size()];

        i = 0;
        for (String hand : cardMap.values()) {
            hand = sort(hand);
            try {
                valueHand(hand, i++);
            } catch (Exception e) {
                e.printStackTrace();
            }
           
        }
        for (int f : fiveOfAKind) {
            System.out.println(cardMap.get(f));
        }

              

    }

    public void valueHand(String hand, int key) throws Exception {
        switch (calcKinds(hand)) {
            case 0:
                highCard[indexhighCard++] = key;
                break;
            case 2:
                onePair[indexOP++] = key;
                break;
            case 33:
                towPair[indexTP++] = key;
                break;
            case 44:
                threeOfAKind[indexT++] = key;
                break;
            case 66:
                fullHouse[indexFH++] = key;
                break;
            case 99:
                fourOfAKind[indexFo++] = key;
                break;
            case 132:
                fiveOfAKind[indexFH++] = key;
                break;
            default:
                throw new Exception("sth went wrong");
        }
    }

    public int calcKinds(String hand) {
        int temp = 0;
        int simSimbol = 0;
        int dupeCount = 0;
        int dupeDupe = 0;

        for (char c : hand.toCharArray()) {
            for (char c2 : hand.toCharArray()) {
                temp += c == c2 ? 1 : 0; 
            }
            if (dupeCount > 2) {
                dupeDupe = simSimbol;
            }else if (--temp > 1) {
                simSimbol = temp;
                dupeCount++;
            }
        }
        /*
         * This Method returns 0 if highCard
         * This Method returns 2 if onePair
         * * This Method returns 33 if twoPair
         * This Method returns 44 if threeOFAKinde
         * * This Method returns 66 if fullHous
         * This Method returns 99 if fourOFAKinde
         * This Method returns 132 if fiveOFAkinde
         */

        return simSimbol+dupeDupe*10;
    }

    public String sort(String hand) {
        int[] intHand = convertToArr(hand);
        intHand = bubbleSort(intHand);
        hand = convertBackToString(intHand);
        return hand;
    }

    private String convertBackToString(int[] intHand) {
        String hand = "";

        for (int i = 0; i < intHand.length; i++) {
            hand += intHand[i] < 10 ? intHand[i] : "";
            for (int value : replaceNum.values()) {
                hand += intHand[i] == value ? replaceSign.get(value) + "" : "";
            }
        }
        return hand;
    }

    public int[] convertToArr(String hand) {
        String[] strgArr = removeEmptyFields(hand.split(""));

        for (int i = 0; i < strgArr.length; i++) {
            for (String key : replaceNum.keySet()) {
                strgArr[i] = strgArr[i].equals(key) ? replaceNum.get(key) + "" : strgArr[i];
            }
        }

        return convertStringArrayToIntArray(strgArr);

    }

    public static int[] convertStringArrayToIntArray(String[] stringArray) {
        int length = stringArray.length;
        int[] intArray = new int[length];

        for (int i = 0; i < length; i++) {
            try {
                intArray[i] = Integer.parseInt(stringArray[i]);
            } catch (NumberFormatException e) {
                System.err.println("Error parsing string to int at index " + i + ": " + e.getMessage());
                intArray[i] = 0;
            }
        }

        return intArray;
    }

    public int[] bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
        return arr;
    }

}
