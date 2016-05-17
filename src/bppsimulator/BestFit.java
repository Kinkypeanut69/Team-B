/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bppsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beheerder
 */
public class BestFit extends AbstractBinPacking {
    
    private int amountOfBins;
    private ArrayList<Bin> bins = new ArrayList<>();

    public BestFit(ArrayList<Packet> in, int binSize){
        super(in, binSize);
        this.bins = new ArrayList<>();
    }

    public void runSimulation() {
        Bin bin = new Bin(binSize);
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
            System.out.println(bins.size());
        }
    }

    @Override
    public int getResult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printBestBins() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Bin> getBins() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

