package dynamic_beat_11;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimer extends Thread{
    private Timer timer;
    private long startTime;

    public MyTimer(){
        startTime = System.currentTimeMillis();
        timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                long elapsedTime = System.currentTimeMillis() - startTime;
                System.out.println("Elapsed Time:"+elapsedTime/1000+"seconds");
            }
        }, 0,1000);
    }

    public void close(){
        interrupt();
    }
}
