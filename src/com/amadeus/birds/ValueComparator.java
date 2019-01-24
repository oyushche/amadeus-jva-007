package com.amadeus.birds;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator<K, V> implements Comparator<K> {
    private Map<K, V> map;

    public ValueComparator(Map<K, V> map) {
        this.map = map;
    }

    public int compare(K a, K b) {
        return ((Comparable<V>)this.map.get(a)).compareTo(map.get(b)) < 0 ? -1 : 1;
    }
}
