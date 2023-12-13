package day7;

public class Main {
    public static void main(String[] args) {
        Day7 day7 = new Day7();
        day7.init(false);
        day7.sortHandArray();
        //day7.printHandArray();
        System.out.println(day7.calculateOverAllWinnings());
        
        
        
    }
}
