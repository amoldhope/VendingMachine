package main.java.com.practice.oops;

public enum Coin {
    PENNY(1), NICKLE(5), DIME(10), QUARTER(25);


    Coin(int denomination) {
        this.denomination=denomination;
    }

    private final int denomination;

    public long getDenomination() {
        return denomination;
    }
}
