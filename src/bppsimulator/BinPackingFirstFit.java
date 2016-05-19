package bppsimulator;

import java.util.ArrayList;

public class BinPackingFirstFit extends AbstractBinPacking {

    private ArrayList<Bin> bins; //ArrayList for all the bins

    public BinPackingFirstFit(ArrayList<Packet> in, int binSize) {
        super(in, binSize); //calls the superclass AbstractBinPacking
        bins = new ArrayList<>();
    }
    
    @Override
    public ArrayList<Bin> getBins() {
        return this.bins; //return ArrayList with all bins
    }

    @Override
    public int getResult() {  
        firstFit(); //calls the algorithm function
        return bins.size(); //return amount of bins
    }
    
    private void firstFit(){
        bins.add(new Bin(binSize)); // add first bin
        for (Packet currentItem : in) {
            // iterate over bins and try to put the item into the first one it fits into
            boolean putItem = false; // did we put the item in a bin?
            int currentBin = 0;
            while (!putItem) {
                if (currentBin == bins.size()) {
                    // item did not fit in last bin. put it in a new bin
                    Bin newBin = new Bin(binSize); //creates a new bin
                    newBin.put(currentItem); //puts the item in a new bin
                    bins.add(newBin); //adds the bin to the ArrayList attribute of the class
                    putItem = true; // item put in bin, condition true
                } else if (bins.get(currentBin).put(currentItem)) {
                    // item fit in bin
                    putItem = true;
                } else {
                    // try next bin
                    currentBin++;
                }
            }
        }
        bins = deepCopy(bins); //copies the bin list and removes empty bins
    }

    @Override
    public String toString() {
        String a = ("Bins:");
        if (bins.size() == in.size()) {
            a += ("each item is in its own bin");
        } else {
            for (Bin bin : bins) {
                a += ("\n" + bin.toString());
            }
        }
        return a;
    }


}
