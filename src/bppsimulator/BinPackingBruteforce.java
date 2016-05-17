package bppsimulator;

import java.util.ArrayList;
import java.util.List;

public class BinPackingBruteforce extends AbstractBinPacking {

    private ArrayList<Bin> bins = new ArrayList<Bin>();
    private int currentBestSolution;
    private ArrayList<Bin> currentBestBins;
    
    @Override
    public ArrayList<Bin> getBins() {
        return this.currentBestBins;
    }

    public BinPackingBruteforce(ArrayList<Packet> in, int binSize) {
        super(in, binSize);
        this.currentBestBins = new ArrayList<Bin>();
        
        for (Packet in1 : in) {
            bins.add(new Bin(binSize)); // create maximum of needed bins
        }
        currentBestSolution = in.size(); // worst case solution: every item one bin
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
                currentBestBins = deepCopy(bins);
            }
            return;
        }
        // iterate over bins
        Packet currentItem = in.get(currentPosition);
        for (Bin bin : bins) {
            if (bin.put(currentItem)) {
                bruteforce(in, currentPosition + 1);
                bin.remove(currentItem);
            } // else: item did not fit in bin, ignore
        }
    }

    private int getFilledBinsCount() {
        int filledBins = 0;
        for (Bin bin : bins) {
            if (bin.numberOfItems() != 0) {
                filledBins++;
            }
        }
        return filledBins;
    }

    @Override
    public void printBestBins() {
        System.out.println("Bins:");
        if (currentBestSolution == in.size()) {
            System.out.println("each item is in its own bin");
        } else {
            for (Bin currentBin : currentBestBins) {
                if (currentBin.numberOfItems() != 0) { // don't print empty bins
                    System.out.println(currentBin.toString());
                }
            }
        }
    }


}
