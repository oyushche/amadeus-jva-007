package com.amadeus.shared;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

abstract public class AbstractStorage<K> {
    protected HashMap<K, Integer> items = new HashMap();

    public HashMap<K, Integer> getItems() {
        return items;
    }

    public int getItemsCount() {
        int total = 0;

        for(Map.Entry<K, Integer> entry: items.entrySet()) {
            total += entry.getValue();
        }

        return total;
    }

    public int getItemsCount(K item) {
        int total = 0;

        for(Map.Entry<K, Integer> entry: items.entrySet()) {
            if(entry.getKey() == item) {
                total += entry.getValue();
            }
        }

        return total;
    }

    public boolean addItems(K key, int count) {
        try {
            items.put(key, items.getOrDefault(key, 0) + count);
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public boolean removeItems(K key, int count) {
        try {
            Integer currentCount = items.get(key);
            Integer futureCount = currentCount - count;

            if (futureCount > 0) {
                items.put(key, futureCount);
            } else if (futureCount == 0) {
                items.remove(key);
            } else {
                throw new InvalidParameterException("Not enough items");
            }
        } catch (InvalidParameterException e) {
            throw e;
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public boolean removeAllItems(K key) {
        try {
            items.remove(key);
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public boolean removeAllItems() {
        try {
            items.clear();
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public static <K, V> Map<K, V> filterByValue(Map<K, V> map, Predicate<V> predicate) {
        return map.entrySet()
            .stream()
            .filter(x -> predicate.test(x.getValue()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
        ;
    }

    public static Predicate<Integer> itemsLessThan(int count) {
        return p -> p < count;
    }
}
