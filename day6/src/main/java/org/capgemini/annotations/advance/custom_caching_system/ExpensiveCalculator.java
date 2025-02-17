package org.capgemini.annotations.advance.custom_caching_system;

import java.util.HashMap;
import java.util.Map;

// Class with computationally expensive method
public class ExpensiveCalculator {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int number) {
        if (cache.containsKey(number)) {
            System.out.println("Returning cached result for: " + number);
            return cache.get(number);
        }
        System.out.println("Computing result for: " + number);
        int result = number * number;
        cache.put(number, result);
        return result;
    }
}