package mks;

import java.util.concurrent.Callable;

public class LoadingTask implements Callable<String> {
    @Override
    public String call() {
        long time = System.nanoTime();
        System.out.println("Вывод чисел для загрузки процессора");
        for(int index =0; index<10000000;index++){
            time = getSleep(time);
            System.out.print("\r"+Math.random()*1000);

        }
        return "\nFinish";
    }

    private long getSleep(long time) {
        if (System.nanoTime() - time > 1000000000) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = System.nanoTime();
        }
        return time;
    }
}
