package day7;

public class Main {
    public static void main(String[] args) {
        Day7 day7 = new Day7();
        day7.init(true);
        day7.sortHandArray();
        //day7.printHandArray();
        System.out.println(day7.calculateOverAllWinnings()); //this is right
        day7.init(false);
        day7.sortHandArray();
        day7.printHandArray();
        System.out.println(day7.calculateOverAllWinnings()); //this should be right now but it isnt dont know hte mistake;
        // interesting impplement on Jokers compareTO
        
        
    }
}
