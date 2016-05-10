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
    private int amountOfBins;
    
    public VolledigeEnumeratie(ArrayList<Packet> packets){
        Bin bin1 = new Bin();
        this.bins = bin1.getBins();
        this.packets = packets;
    }
    
    @Override
    public void runSimulation(){
        for (Bin a: bins){
            for (Packet b: packets){
                if (b.getLength() <= a.getLength() && b.getWidth() <= a.getWidth()){
                    a.addItem(b);
                }
            }
        }
    }

    @Override
    int returnBins() {
        return 0;
    }
}
