package day7;

public class Hand implements Comparable<Hand>{
    String hand;
    int type;

    public Hand(String hand, int type) {
        this.hand = hand;
        
    }

    @Override
    public int compareTo(Hand o) {
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
    private String sort(String hand) {
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

    private int[] bubbleSort(int[] arr) {
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
