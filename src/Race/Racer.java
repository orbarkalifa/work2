package Race;

import static java.lang.Thread.currentThread;

public class Racer implements Runnable {

    private static int globalID = 1;
    private final int id;
    private int speed;
    private Track track;

    public Racer(int speed, Track track){
        id = globalID++;
        if(speed < 1 || speed > 10){
            speed = 5;
            System.out.println("incorrect speed input, 5 set as default.");
        }
        this.speed = speed;
        this.track = track;
    }

    public void go(){

        currentThread().setPriority(speed);
        for (int i=0; i<10; i++){
            System.out.println("Runner " + id + " ran " + (i+1) + " meters");
        }
        String place = Integer.toString(++track.finishedRacers);
        switch (track.finishedRacers){
            case 1:
                 place += "st";
                 break;
            case 2:
                 place += "nd";
                break;
            case 3:
                 place += "rd";
                break;
            default:
                 place += "th";
                break;
        }
        System.out.println("Runner " + id + " finished " + place);
    }
    @Override
    public void run() {
        go();
    }
}
