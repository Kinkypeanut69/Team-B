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
public class SimpelGretig extends AbstractBinPacking {

    private int amountOfBins;
    
    public SimpelGretig(ArrayList<Packet> packets){
        Bin bin1 = new Bin();
        //bins.add(bin1);
        this.bins = bin1.getBins();
        this.packets = packets;
    }
    
    @Override
    public void runSimulation(){
        for (Bin bin : bins) {
            for (Packet packet : packets) {
                if(packet.getLength() <= bin.getAvailabelroom()){
                    bin.addItem(packet);
                    bin.setAvailableroom(bin.getAvailabelroom()-packet.getLength());
                    System.out.println(bin.getAvailabelroom());
                }else{
                    
                }
            }
        }
    }
    
    @Override
    int returnBins() {
        return 0;
    }
}
