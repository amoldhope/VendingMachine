package main.java.com.practice.oops;

import java.util.Collections;
import java.util.List;

public class VendingMachineImplementation implements VendingMachine {
    private Inventory<Item> itemInventory = new Inventory<>();
    private Inventory<Coin> cashInventory = new Inventory<>();
    private Long currentBalance;
    private Item currentitem;

    public VendingMachineImplementation() {
        initialize();
    }

    private void initialize() {
        for (Coin c : Coin.values()) {
            cashInventory.put(c, 10);
        }

        for (Item i : Item.values()) {
            itemInventory.put(i, 5);
        }

    }


    @Override
    public Long selectItemAndGetPrice(Item item) {
        currentitem = item;
        if (itemInventory.hasItem(item)) {
            return item.getPrice();

        }
        return null;
    }

    @Override
    public void insertCoin(Coin coin) {
        currentBalance = currentBalance + coin.getDenomination();
        cashInventory.add(coin);

    }

    @Override
    public List<Coin> refund() {
        List<Coin> refund=getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance=0L;
        currentitem=null;
        return refund;
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        List<Coin> change = collectChange();
        
        itemInventory.deduct(currentitem);

        return new Bucket<Item,List<Coin>>(currentitem,change);
    }

    private List<Coin> collectChange() {
        long chaneAmount = currentBalance - currentitem.getPrice();
        List<Coin> change = getChange(chaneAmount);
        updateCashInventory(change);
        return change;
    }

    private void updateCashInventory(List<Coin> change) {

        for (Coin coin : change) {
            cashInventory.deduct(coin);
        }

    }

    private List<Coin> getChange(long chaneAmount) {
        List<Coin> changes = Collections.EMPTY_LIST;
        long amount = chaneAmount;
        if (chaneAmount > 0) {

            while (amount > 0) {

                if (amount >= Coin.QUARTER.getDenomination() && cashInventory.hasItem(Coin.QUARTER)) {

                    amount = amount - Coin.QUARTER.getDenomination();
                    changes.add(Coin.QUARTER);
                    continue;

                } else if (amount >= Coin.DIME.getDenomination() && cashInventory.hasItem(Coin.DIME)) {

                    amount = amount - Coin.DIME.getDenomination();
                    changes.add(Coin.DIME);
                    continue;

                } else if (amount >= Coin.NICKLE.getDenomination() && cashInventory.hasItem(Coin.NICKLE)) {

                    amount = amount - Coin.NICKLE.getDenomination();
                    changes.add(Coin.NICKLE);
                    continue;

                } else {

                    amount = amount - Coin.PENNY.getDenomination();
                    changes.add(Coin.PENNY);
                    continue;

                }

            }

        }

return changes;
    }

    @Override
    public void reset() {
cashInventory.reset();
itemInventory.reset();
currentitem=null;
currentBalance=0L;


    }
}
