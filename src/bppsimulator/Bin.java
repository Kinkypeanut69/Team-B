package bppsimulator;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
/**
 * A Bin holding integers.
 * <br/>
 * The number of items it can hold is not limited, but the added value of the
 * items it holds may not be higher than the given maximal size.
 */
public class Bin {

    /**
     * maximal allowed added value of items.
     */
    protected int maxSize;
    /**
     * current added value of items.
     */
    protected int currentSize;
    /**
     * list of items in bin.
     */
    protected List<Integer> items;

    /**
     * construct new bin with given maximal size.
     *
     * @param maxSize
     */
    public Bin(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.items = new ArrayList<Integer>();
=======
public class Bin extends Order{
    private int length;
    private int availableRoom;
    private ArrayList<Packet> packetsInBin;
    private ArrayList<Bin> bins;
    private ArrayList<Packet> packets;
    private int availableroom;
    
    public Bin(){
        super();
        bins.add(this);
        packetsInBin = new ArrayList<>();
        this.length = 4;

    }
    
    public ArrayList<Packet> getPackets(){
        return this.packets;
    }
    
    public ArrayList<Bin> getBins(){
        return this.bins;
    } 
    
     //   this.availableroom = 4;
    //}
    
    public int getLength(){
        return this.length;
    }
    
    public void addBin(Bin bin){
        bins.add(bin);
>>>>>>> origin/master
    }

    /**
     * adds given item to this bin, and increases the currentSize of the bin by
     * value of item. If item does not fit, it will not be put in the bin and
     * false will be returned.
     *
     * @param item item to put in bin
     * @return true if item fit in bin, false otherwise
     */
    public boolean put(Integer item) {
        if (currentSize + item <= maxSize) {
            items.add(item);
            currentSize += item;
            return true;
        } else {
            return false; // item didn't fit
        }
    }
<<<<<<< HEAD

    /**
     * removes given item from bin and reduces the currentSize of the bin by
     * value of item.
     *
     * @param item item to remove from bin
     */
    public void remove(Integer item) {
        items.remove(item);
        currentSize -= item;
    }

    /**
     * returns the number of items in this bin (NOT the added value of the
     * items).
     *
     * @return number of items in this bin
     */
    public int numberOfItems() {
        return items.size();
    }

    /**
     * creates a deep copy of this bin.
     *
     * @return deep copy of this bin
     */
    public Bin deepCopy() {
        Bin copy = new Bin(0);
        copy.items = new ArrayList<Integer>(items); // Integers are not copied by reference
        copy.currentSize = currentSize;
        copy.maxSize = maxSize;
        return copy;
=======
    
    public void removeItem(Packet packet){
        packetsInBin.remove(packet);
}
    
    public int getAvailabelroom(){
        return this.availableroom;
    }
    
    public void setAvailableroom(int room){
        this.availableroom = room;
>>>>>>> origin/master
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        String res = "";
        for (int i = 0; i < items.size(); i++) {
            res += items.get(i) + " ";
        }
        res += "    Size: " + currentSize + " (max: " + maxSize + ")";
        return res;
=======
        return "Lengte: " + length;
>>>>>>> origin/master
    }
}
