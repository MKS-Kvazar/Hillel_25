package mks;

import java.util.Collection;
import java.util.concurrent.Callable;

public class MaxInteger implements Callable<String> {
    private final Collection<Integer> collection;

    public MaxInteger(Collection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public String call() {
        System.out.println("MaxInteger 'Start'");
        Integer result = collection.iterator().next();
        for (Integer value : collection) {
            if (result < value) {
                result = value;
            }
        }
        System.out.println("MaxInteger 'Finish'");
        return "Max Integer = " + result;
    }
}
