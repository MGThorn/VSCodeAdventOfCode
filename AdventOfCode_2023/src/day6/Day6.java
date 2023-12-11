package day6;


import day4.Day4;

public class Day6 extends Day4 {

    public void init(){
        String [] times = this.removeEmptyFields(this.scan("/day6/input.txt").get(0).split(":")[1].split(" "));
        String [] distances = this.removeEmptyFields(this.scan("/day6/input.txt").get(1).split(":")[1].split(" "));

        int allCounter = 1;

        for (int i = 0; i < times.length; i++) {
            allCounter *= ammountOfFurtherDistances(times[i],distances[i]) > 0 ? ammountOfFurtherDistances(times[i],distances[i]) : 1;
        }
        System.out.println("allcounter : " +allCounter);
    }

    private int ammountOfFurtherDistances(String time, String stringDistance) {
        int [] ad = calculateAllDistances(time);
        int counter = 0;
        int distances = Integer.parseInt(stringDistance);

        for (int i : ad) {
            counter += i > distances ? 1 : 0 ;
        }
        return counter;
    }

    public int [] calculateAllDistances(String stringTime) {
        int time = Integer.parseInt(stringTime);
        int [] ret = new int[time+1];

        for (int i = 0; i <= time; i++) {
            ret[i] = (time-i)*i;
        }
        return ret;
    }


}
