package bppsimulator;

import java.util.ArrayList;
import java.util.List;

public class Bin {

    protected int maxSize; //maximum allowed added value of items
    protected int currentSize; //added value of items in the bin
    protected List<Packet> items; //items in the bin

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

    public void remove(Packet item) {
        items.remove(item);
        currentSize -= item.getLength();
    }

    public int numberOfItems() {
        return items.size();
    }

    public Bin deepCopy() {
        Bin copy = new Bin(0);
        copy.items = new ArrayList<>(items); // Integers are not copied by reference
        copy.currentSize = currentSize;
        copy.maxSize = maxSize;
        return copy;
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