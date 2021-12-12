package mks;

import java.util.Collection;
import java.util.concurrent.Callable;

public class SumInteger implements Callable<String> {
    private final Collection<Integer> collection;

    public SumInteger(Collection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public String call(){
        System.out.println("SumInteger 'Start'");
        int result = 0;
        for (Integer value : collection) {
            result = result + value;
        }
        System.out.println("SumInteger 'Finish'");
        return "Sum Integer = " + result;
    }
}
