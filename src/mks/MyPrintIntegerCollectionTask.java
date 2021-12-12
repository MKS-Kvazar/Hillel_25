package mks;

import java.util.Collection;

public class MyPrintIntegerCollectionTask implements Runnable {
    private final Collection<Integer> collection;

    public MyPrintIntegerCollectionTask(Collection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public void run() {
        System.out.println("+++++ MyPrintIntegerCollectionTask::run");
        for (Integer value : collection) {
            System.out.println(value);
        }
        System.out.println("----- MyPrintIntegerCollectionTask::run");
    }
}
