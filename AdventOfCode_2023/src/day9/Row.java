package day9;

public class Row {
    private int pointer;
    private Row parentRow;
    private int [] numbers;
    private boolean isRoot;

    Row(int ... numbers){
        this.numbers = numbers;
        this.parentRow = this;
        this.isRoot = true;
    }
    Row(Row parentRow){
        this.parentRow = parentRow;
        this.isRoot = false;
        numbers = new int[parentRow.getNumbers().length-1];

        for (int i : parentRow.getNumbers()) {
            int a = parentRow.getNext() - i;
        }


    }
    public int [] getNumbers(){
        pointer = 0;
        return numbers;
    }
    public int getNext(){
        return pointer<numbers.length-1 ? numbers[pointer++] : numbers[pointer];
    }
    public Row getParentRow(){
        return parentRow;
    }
    public boolean isRoot() {
        return isRoot;
    }
    

    
}
