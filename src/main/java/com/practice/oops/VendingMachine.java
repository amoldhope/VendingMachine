package main.java.com.practice.oops;

import java.util.List;

public interface VendingMachine {
    public Long selectItemAndGetPrice(Item item);
    public void insertCoin(Coin coin);
    public List<Coin> refund();
    public Bucket<Item,List<Coin>> collectItemAndChange();
    public  void reset();
}
