package mks;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        new Main().Task_1();
        new Main().Task_2();
        new Main().Task_3();
    }

    void Task_1() {
        System.out.println("Start Task 1");
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        MyPrintIntegerCollectionTask task = new MyPrintIntegerCollectionTask(integerList);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> result = executorService.submit(task);
        System.out.println("Awaiting 'MyPrintIntegerCollectionTask'...");
        try {
            result.get();
            System.out.println("Task 'MyPrintIntegerCollectionTask' is completed");
            executorService.shutdown();
        } catch (Exception e) {
            System.out.println("Task 'MyPrintIntegerCollectionTask' has failed");
            e.printStackTrace();
        }
        System.out.println("Finish Task 1");
    }

    void Task_2() {
        System.out.println("Start Task 2");
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        MaxInteger maxIntegerTask = new MaxInteger(integerList);
        MinInteger minIntegerTask = new MinInteger(integerList);
        MeanValueInteger meanValueIntegerTask = new MeanValueInteger(integerList);
        SumInteger sumIntegerTask = new SumInteger(integerList);
        List<Callable<String>> callableList = Arrays.asList(maxIntegerTask, minIntegerTask, meanValueIntegerTask, sumIntegerTask);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            List<Future<String>> futureList = executorService.invokeAll(callableList);
            for (Future<String> future : futureList) {
                System.out.println(future.get());
            }
            System.out.println("Task 'MyPrintIntegerCollectionTask' is completed");
            executorService.shutdown();
        } catch (Exception e) {
            System.out.println("Task 'MyPrintIntegerCollectionTask' has failed");
            e.printStackTrace();
        }
        System.out.println("Finish Task 2");
    }

    void Task_3() {
        System.out.println("Start Task 3");
        Callable<String> task = new LoadingTask();
        Future<String> result = new FutureTask<>(task);
        Thread thread = new Thread((Runnable) result);
        thread.start();
        try {
            while (!result.isDone()) {
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}