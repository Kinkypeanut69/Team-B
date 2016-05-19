package bppsimulator;

import java.util.ArrayList;

public abstract class AbstractBinPacking {

    protected ArrayList<Packet> in; //ArrayList of the packets in the order
    protected int binSize; //the max binsize

    public AbstractBinPacking(ArrayList<Packet> in, int binSize) {
        this.in = in;
        this.binSize = binSize;
    }

    //Abstract methods for all algorithm subclasses
    public abstract int getResult();
    public abstract ArrayList<Bin> getBins();

    //Method to create a new array of bins
    public ArrayList<Bin> deepCopy(ArrayList<Bin> bins) {
        ArrayList<Bin> copy = new ArrayList<>(); //creates a new ArrayList to store all Bin objects in
        
        for (int i = 0; i < bins.size(); i++) {
            if(bins.get(i).numberOfItems() != 0){ //Checks if the Bin isn't empty
                //copies all the data from the give ArrayList in the parameters
                copy.add(bins.get(i).deepCopy());
            } 
        }
       
        //removes all Bin object that have no items in it
        for (Bin bin: copy){
            if (bin.numberOfItems() == 0){
                copy.remove(bin);
            }
        }
        
        //returns the Bin ArrayList
        return copy;
    }
}
