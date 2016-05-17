package bppsimulator;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinPacking {

    protected ArrayList<Packet> in;
    protected int binSize;

    public AbstractBinPacking(ArrayList<Packet> in, int binSize) {
        this.in = in;
        this.binSize = binSize;
    }

    public abstract int getResult();

    public abstract void printBestBins();
    
    public abstract ArrayList<Bin> getBins();

    public ArrayList<Bin> deepCopy(List<Bin> bins) {
        ArrayList<Bin> copy = new ArrayList<>();
        for (int i = 0; i < bins.size(); i++) {
            if (bins.get(i).numberOfItems() != 0){
                copy.add(bins.get(i).deepCopy());
            }
        }
        return copy;
    }
}
