package com.appagate.business;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public class UniqueIdentifier {

    private static ThreadLocal<Character> threadLocal = new ThreadLocal<Character>();

    private static final Character[] endians = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private static AtomicLong iterator = new AtomicLong(-1);

    /**
     * getUniqueIdentifier
     * @return
     */
    public String getUniqueIdentifier() {
        int firstLetter = ThreadLocalRandom.current().nextInt(0, (endians.length));
        Character secondLetter = threadLocal.get();
        if (secondLetter == null) {
            synchronized (threadLocal) {
                if (secondLetter == null) {
                    threadLocal.set(endians[(int) (iterator.incrementAndGet() % endians.length)]);
                }
            }
        }
        secondLetter = threadLocal.get();
        return "" + endians[firstLetter] + secondLetter + System.nanoTime();
    }
}
