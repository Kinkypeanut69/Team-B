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

    private int maxBinSize;
    private ArrayList<Bin> bins = new ArrayList<>();

        super(in, binSize);
    }

    public void runSimulation() {
        for (Packet packet : in) {
            int currentBin = 0;
            boolean putItem = false;
            while (!putItem) {
                if (currentBin == bins.size()) {
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
    }

    @Override
    public void printBestBins() {
    }
}
