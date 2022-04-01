package Temporizador;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.*;

public class main {
    private static final ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
    Runnable runnable = new Runnable() {
        int time = 20;
        @Override
        public void run() {
            time--;
            System.out.println("contando" + time);
            if (time < 0){
                System.out.println("time stop");
                service.shutdown();
            }
        }
    };
    service.scheduleAtFixedRate(runnable, 0,1, TimeUnit.SECONDS);
    }
}
