package main.java.com.practice.oops;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {
    Map<T, Integer> inventory = new HashMap<>();

    public boolean hasItem(T item) {
        return getQuanity(item) > 0;

    }

    private int getQuanity(T item) {
        Integer quantity=inventory.get(item);
        return quantity;
    }


    public void put(T c, int i) {
        inventory.put(c, i);
    }

    public void add(T coin) {
    int count=inventory.get(coin);
    inventory.put(coin,count+1);

    }

    public void deduct(T currentitem) {
        int count=inventory.get(currentitem);
        inventory.put(currentitem,count-1);
    }

    public void reset() {
    inventory.clear();
    }
}
