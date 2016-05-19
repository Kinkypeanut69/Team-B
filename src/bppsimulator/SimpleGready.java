/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bppsimulator;

import java.util.ArrayList;

/**
 *
 * @author Beheerder
 */
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
    }

    @Override
    public int getResult() {
        return bins.size();
    }

    @Override
    public void printBestBins() {
        System.out.println("Bins:");
        for (Bin bin : bins) {
            System.out.println(bin.toString());
        }
    }

    public ArrayList<Bin> getBins() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
