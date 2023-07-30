package com.lizza.ParallelCompute;

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

    abstract String compute();

    abstract String name();

    public AbstractComputer() {
        map.put(name(), this);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
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
                AbstractComputer computer = map.get("Compute_" + index);
                computer.compute();
                return null;
            }, COMPUTER_EXECUTOR_SERVICE));
        }
        try {
            CompletableFuture
                    .allOf(futureList.toArray(new CompletableFuture[0]))
                    .thenApply(v -> futureList.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList())
                    ).get();
            Thread.sleep(300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
