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
public class BestFit extends Algoritme {

    private int amountOfBins;

    public BestFit(ArrayList<Packet> packets, ArrayList<Bin> bins) {
        this.packets = packets;
        this.bins = bins;
    }

    @Override
    public void runSimulation() {
        int leastRoom;
        for (Packet packet : packets) {
            boolean putItem = false;
            int currentBin = 0;
            while (!putItem) {
                if (currentBin == bins.size()) {
                    Bin newBin = new Bin(8);
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
