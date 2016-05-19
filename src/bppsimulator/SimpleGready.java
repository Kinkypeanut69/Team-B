package bppsimulator;

import java.util.ArrayList;

public class SimpleGready extends AbstractBinPacking {

    private ArrayList<Bin> bins = new ArrayList<>();

    public SimpleGready(ArrayList<Packet> in, int binSize) {
        super(in, binSize);
    }

    public void runSimulation() {
        bins.add(new Bin(binSize));
        for (Packet packet : in) {
            int currentBin = 0;
            boolean putItem = false;
            while (!putItem) {
                if (currentBin == bins.size()) {
                    Bin newBin = new Bin(binSize);
                    newBin.put(packet);
                    bins.add(newBin);
                    putItem = true;
                } else if (bins.get(currentBin).put(packet)) {
                    putItem = true;
                } else {
                    currentBin++;
                }
            }
        }
        bins = deepCopy(bins);
    }

    @Override
    public int getResult() {
        return bins.size();
    }

    @Override
    public String printBestBins() {
        String a = ("Bins:");
        for (Bin bin : bins) {
            a += ("\n" + bin.toString());
        }
        return a;
    }

    @Override
    public ArrayList<Bin> getBins() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}