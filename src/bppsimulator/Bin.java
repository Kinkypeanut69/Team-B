package bppsimulator;

import java.util.ArrayList;

public class Bin {

    protected int maxSize; //maximum allowed added value of items
    protected int currentSize; //added value of items in the bin
    protected ArrayList<Packet> items; //items in the bin

    public Bin(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.items = new ArrayList<>();
    }

    //method that puts a packet in a bin
    public boolean put(Packet item) {
        //check if there's enough room
        if (currentSize + item.getLength() <= maxSize) {
            items.add(item);
            currentSize += item.getLength();
            return true;
        } else {
            return false; // item didn't fit
        }
    }
    
    //checks if there's room left
    public boolean putCheck(Packet item){
        if (currentSize + item.getLength() <= maxSize) {
            return true;
        } else {
            return false; // item didn't fit
        }
    }

    //remove item from bin
    public void remove(Packet item) {
        items.remove(item);
        currentSize -= item.getLength();
    }

    //amount of items in bin
    public int numberOfItems() {
        return items.size();
    }
    
    //return ArrayList with items that the bin contains
    public ArrayList<Packet> getItems(){
        return this.items;
    }

    public Bin deepCopy() {
        Bin copy = new Bin(0);
        copy.items = new ArrayList<>(items); //copies all the items in the bin
        copy.currentSize = currentSize; //copies the currentsize attribute
        copy.maxSize = maxSize; //copies the maxsize attribute
        return copy; //returns the newly created bin to the deepCopy method in AbstractBinPacking
    }
    
    //calculates room left in bin
    public int roomLeft(){
        return maxSize - currentSize;
    }


    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < items.size(); i++) {
            res += items.get(i).getLength() + " ";
        }
        res += "    Size: " + currentSize + " (max: " + maxSize + ")";
        return res;
    }
}