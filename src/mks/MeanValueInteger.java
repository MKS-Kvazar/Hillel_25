package mks;

import java.util.Collection;
import java.util.concurrent.Callable;

public class MeanValueInteger implements Callable<String> {
    private final Collection<Integer> collection;

    public MeanValueInteger(Collection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public String call() {
        System.out.println("MeanValueInteger 'Start'");
        int result = 0;
        for (Integer value : collection) {
            result = result + value;
        }
        result = result / collection.size();
        System.out.println("MeanValueInteger 'Finish'");
        return "Mean value Integer = " + result;
    }
}
