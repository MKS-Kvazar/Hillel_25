package mks;

import java.util.Collection;
import java.util.concurrent.Callable;

public class MinInteger implements Callable<String> {
    private final Collection<Integer> collection;

    public MinInteger(Collection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public String call(){
        System.out.println("MinInteger 'Start'");
        Integer result = collection.iterator().next();
        for (Integer value : collection) {
            if (result > value) {
                result = value;
            }
        }
        System.out.println("MinInteger 'Finish'");
        return "Min Integer = " + result;
    }
}
