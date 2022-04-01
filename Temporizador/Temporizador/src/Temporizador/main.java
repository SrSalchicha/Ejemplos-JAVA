package Temporizador;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.*;

public class main {
	//Scheduled
    private static final ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
	//Main del programa
    public static void main(String[] args) {
    //Dentro del main se crea el objeto runnable todo lo que este dentro es lo que se ejecutara mientras el temporizador este activado
    Runnable runnable = new Runnable() {
    	//time: es el tiempo del temporizador para la cuenta regresiva
        int time = 20;
        @Override
        //Dentro de esta funcion se ejecuta la cuenta regresiva y todo lo que se tenga que ejecutar mientras el temporizador este activado
        public void run() {
        	//Comenzamos la cuenta regresiva
            time--;
            System.out.println("contando" + time);
            //cuando la cuenta sea menor a 0 vamos a deter el timer
            if (time < 0){
                System.out.println("time stop");
                service.shutdown();
            }
        }
    };
    //indicamos que la cuenta sera en segundos
    service.scheduleAtFixedRate(runnable, 0,1, TimeUnit.SECONDS);
    }
}
