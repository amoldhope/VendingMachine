package main.java.com.practice.oops;

public class Main {
    public static void main(String[] args) {
        VendingMachineImplementation v=new VendingMachineImplementation();
        System.out.println(v.selectItemAndGetPrice(Item.PEPSI));
    }
}
