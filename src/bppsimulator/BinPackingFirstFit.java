package bppsimulator;

import java.util.ArrayList;
import java.util.List;

public class BinPackingFirstFit extends AbstractBinPacking {

    private ArrayList<Bin> bins = new ArrayList<>();

    public BinPackingFirstFit(ArrayList<Packet> in, int binSize) {
        super(in, binSize);
    }
    
 
    public ArrayList<Bin> getBins() {
        return this.bins;
    }

    @Override
    public int getResult() {
        
        bins.add(new Bin(binSize)); // add first bin
        for (Packet currentItem1 : in) {
            int currentItem = currentItem1.getLength();
            // iterate over bins and try to put the item into the first one it fits into
            boolean putItem = false; // did we put the item in a bin?
            int currentBin = 0;
            while (!putItem) {
                if (currentBin == bins.size()) {
                    // item did not fit in last bin. put it in a new bin
                    Bin newBin = new Bin(binSize);
                    newBin.put(currentItem1);
                    bins.add(newBin);
                    putItem = true;
                } else if (bins.get(currentBin).put(currentItem1)) {
                    // item fit in bin
                    putItem = true;
                } else {
                    // try next bin
                    currentBin++;
                }
            }
        }
        return bins.size();
    }

    @Override
    public void printBestBins() {
        System.out.println("Bins:");
        if (bins.size() == in.size()) {
            System.out.println("each item is in its own bin");
        } else {
            for (Bin bin : bins) {
                System.out.println(bin.toString());
            }
        }
    }


}
