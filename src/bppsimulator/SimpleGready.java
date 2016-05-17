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
public class SimpleGready extends Algoritme {

    private int amountOfBins;
    private int maxBinSize;

    public SimpleGready(ArrayList<Packet> packets, ArrayList<Bin> bins, int maxBinSize) {
        this.packets = packets;
        this.bins = bins;
        this.maxBinSize = maxBinSize;
    }

    @Override
    public void runSimulation() {
        
        for (Packet packet : packets) {
            int currentBin = 0;
            boolean putItem = false;
            while (!putItem) {
                if (currentBin == bins.size()) {
                    Bin newBin = new Bin(maxBinSize);
                    newBin.put(packet.getLength());
                    bins.add(newBin);
                    putItem = true;
                } else if (bins.get(currentBin).put(packet.getLength())) {
                    putItem = true;
                } else {
                    currentBin++;
                }
            }
            System.out.println(bins.size());
        }
    }

    @Override
    int returnBins() {
        return 0;
    }
}
