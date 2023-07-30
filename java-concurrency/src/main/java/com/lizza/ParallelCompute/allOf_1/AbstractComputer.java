package com.lizza.ParallelCompute.allOf_1;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-13
 */
public abstract class AbstractComputer {

    public static Map<String, AbstractComputer> map = Maps.newHashMap();

    public static final ExecutorService COMPUTER_EXECUTOR_SERVICE = new ThreadPoolExecutor(5, 10, 6, TimeUnit.SECONDS,
        new LinkedBlockingQueue<>(10),
        r -> new Thread(r, "computer_executor_service")
    );

    abstract String compute() throws Exception;

    abstract String name();

    public AbstractComputer() {
        map.put(name(), this);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            invoke();
            System.out.println();
            System.out.println("=====================================================================================");
            System.out.println();
        }
        COMPUTER_EXECUTOR_SERVICE.shutdown();
    }

    public static void invoke() {
        map.put("Compute_1", new Compute_1());
        map.put("Compute_2", new Compute_2());
        map.put("Compute_3", new Compute_3());

        List<CompletableFuture<String>> futureList = Lists.newArrayList();
        for (int i = 1; i <= 3; i++) {
            int index = i;
            futureList.add(CompletableFuture.supplyAsync(() -> {
                try {
                    AbstractComputer computer = map.get("Compute_" + index);
                    return computer.compute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }, COMPUTER_EXECUTOR_SERVICE));
        }
        try {
            List<String> list = allOf(futureList).get(1000, TimeUnit.MILLISECONDS);
            System.out.println("result: " + list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> CompletableFuture<List<T>> allOf(List<CompletableFuture<T>> futuresList) {
        CompletableFuture<Void> allFuturesResult =
                CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));
        return allFuturesResult.thenApply(v ->
                futuresList.stream().
                        map(future -> future.join()).
                        collect(Collectors.toList())
        );
    }
}
