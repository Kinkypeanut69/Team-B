package bppsimulator;

import java.util.ArrayList;

public class BinPackingBruteforce extends AbstractBinPacking {

    private ArrayList<Bin> bins; //ArrayList to store all temporary bins in
    private ArrayList<Bin> currentBestBins; //ArrayList to store the current best solution bins in
    private int currentBestSolution;
     
    public BinPackingBruteforce(ArrayList<Packet> in, int binSize) {
        super(in, binSize);
        this.currentBestBins = new ArrayList<>();
        this.bins = new ArrayList<>();
        
        for (Packet in1 : in) {
            bins.add(new Bin(binSize)); // create maximum of needed bins
        }
        currentBestSolution = in.size(); // worst case solution: every item one bin
    }
    
    @Override
    public ArrayList<Bin> getBins() {
        return this.currentBestBins; //returns the ArrayList with best bins
    }

    @Override
    public int getResult() { 
        bruteforce(in, 0); // call actual bruteforce method, with input, starting with position 0
        return currentBestSolution; 
    }
    
    private void bruteforce(ArrayList<Packet> in, int currentPosition) {
        if (currentPosition >= in.size()) { // reached last item, done with this iteration
            int filledBins = getFilledBinsCount();
            if (filledBins < currentBestSolution) { // is this solution better than the current best?
                currentBestSolution = filledBins; // then save it
                currentBestBins = deepCopy(bins); //copies the solution to the attribute ArrayList currentBestBins
            }
            return;
        }
        // iterate over bins
        Packet currentItem = in.get(currentPosition);
        for (Bin bin : bins) {
            if (bin.put(currentItem)) { //checks if there's room for an item
                bruteforce(in, currentPosition + 1); //recurive approach for next item
                bin.remove(currentItem); 
            } // else: item did not fit in bin, ignore
        }
    }
    
    //returns the amount of filled bins
    private int getFilledBinsCount() {
        int filledBins = 0;
        for (Bin bin : bins) {
            if (bin.numberOfItems() != 0) {
                filledBins++;
            }
        }
        return filledBins;
    }

    //prints an overview of all bins
    @Override
    public String toString() {
        String a = ("Bins:");
        if (currentBestSolution == in.size()) {
            a += ("each item is in its own bin");
        } else {
            for (Bin currentBin : currentBestBins) {
                a += ("\n" + currentBin.toString());  
            }
        }
        return a;
    }
}
