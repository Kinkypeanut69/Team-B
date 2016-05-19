package bppsimulator;

import java.util.ArrayList;

public class SimpleGready extends AbstractBinPacking {

    private ArrayList<Bin> bins = new ArrayList<>(); //arraylist with bins

    public SimpleGready(ArrayList<Packet> in, int binSize) {
        super(in, binSize); //calls superclass 
    }

    //returns ArrayList with the bins
    @Override
    public ArrayList<Bin> getBins() {
        return this.bins;
    }

    //runs the simulation and return the number of bins
    @Override
    public int getResult() {
        simpleGready();
        return this.bins.size();
    }

    //actual simulation
    private void simpleGready() {
        bins.add(new Bin(binSize)); // add first bin
        for (Packet packet : in) { 
            // iterate over bins and try to put the item into the first one it fits into
            int currentBin = 0;
            boolean putItem = false; // did we put the item in a bin?
            while (!putItem) {
                if (currentBin == bins.size()) { 
                    // item did not fit in last bin. put it in a new bin
                    Bin newBin = new Bin(binSize); //creates a new bin
                    newBin.put(packet); //puts the item in a new bin
                    bins.add(newBin); //adds the bin to the ArrayList attribute of the class
                    putItem = true; // item put in bin, condition true
                } else if (bins.get(currentBin).put(packet)) {
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
        for (Bin bin : bins) {
            a += ("\n" + bin.toString());
        }
        return a;
    }
}
