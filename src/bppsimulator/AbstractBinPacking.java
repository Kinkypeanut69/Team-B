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
    
    public abstract List<Bin> getBins();

    public List<Bin> deepCopy(List<Bin> bins) {
        ArrayList<Bin> copy = new ArrayList<>();
        for (int i = 0; i < bins.size(); i++) {
            copy.add(bins.get(i).deepCopy());
        }
        return copy;
    }
}
