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
public class VolledigeEnumeratie extends Algoritme {
    private int currentBestSolution;
    
    public VolledigeEnumeratie(ArrayList<Packet> packets, ArrayList<Bin> bins){
        this.packets = packets;
        this.bins = bins;
    }
    
    @Override
    public void runSimulation(){
        for (Bin a: bins){
            for (Packet b: packets){
                if (b.getLength() <= a.getLength()){
                    a.addItem(b);
                }
            }
        }
    }
    
    public void VolledigeEnumeratie(int curr) {
        if (curr>= packets.size()){
            int filledBins = bins.size();
            
            if (filledBins < currentBestSolution){
                currentBestSolution = filledBins;
            }
            System.out.println(currentBestSolution);
            return;
            
        }
                
        for (Bin a: bins){
            new Bin();
            for (Packet b: packets){
                if (a.addItem(b)){
                    VolledigeEnumeratie(curr + 1);
                    a.removeItem(b);
                }else {
                    new Bin();
                }
            }
        }
    }

    @Override
    int returnBins() {
        return 0;
    }
}
