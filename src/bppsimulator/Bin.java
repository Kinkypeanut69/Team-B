package bppsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 * A Bin holding integers.
 * <br/>
 * The number of items it can hold is not limited, but the added value of the
 * items it holds may not be higher than the given maximal size.
 */
public class Bin {

    protected int maxSize; //maximum allowed added value of items
    protected int currentSize; //added value of items in the bin
    protected ArrayList<Packet> items; //items in the bin

    public Bin(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.items = new ArrayList<>();
    }

    public boolean put(Packet item) {
        if (currentSize + item.getLength() <= maxSize) {
            items.add(item);
            currentSize += item.getLength();
            return true;
        } else {
            return false; // item didn't fit
        }
    }
    
    public boolean putCheck(Packet item){
        if (currentSize + item.getLength() <= maxSize) {
            return true;
        } else {
            return false; // item didn't fit
        }
    }

    public void remove(Packet item) {
        items.remove(item);
        currentSize -= item.getLength();
    }

    public int numberOfItems() {
        return items.size();
    }
    
    public ArrayList<Packet> getItems(){
        return this.items;
    }

    public Bin deepCopy() {
        Bin copy = new Bin(0);
        copy.items = new ArrayList<>(items); // Integers are not copied by reference
        copy.currentSize = currentSize;
        copy.maxSize = maxSize;
        return copy;
    }
    
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