package java.com.amadeus.shared;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

abstract public class AbstractStorage<K> {
    // https://www.callicoder.com/java-hashmap/
    protected Map<K, Integer> items = new HashMap<>();

    public Map<K, Integer> getItems() {
        return items;
    }

    public int getItemsCount() {
        int total = 0;

        for(Map.Entry<K, Integer> entry: items.entrySet()) {
            total += entry.getValue();
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
}
