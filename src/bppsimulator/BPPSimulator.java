package bppsimulator;

import java.util.ArrayList;

public class BPPSimulator {

    
    public static void main(String[] args) {
        
        Packet p1 = new Packet(2, 1);
        Packet p2 = new Packet(2, 2);
        Packet p3 = new Packet(2, 3);
        Packet p4 = new Packet(2, 4);
        Packet p5 = new Packet(2, 5);
        Packet p6 = new Packet(7, 6);
        Packet p7 = new Packet(8, 7);
        Packet p8 = new Packet(1, 7);
        ArrayList<Packet> packets;
        packets = new ArrayList<Packet>();
        packets.add(p1);
        packets.add(p2);
        packets.add(p3);
        packets.add(p4);
        //packets.add(p5);
        packets.add(p6);
        packets.add(p7);
        packets.add(p8);
        ArrayList<Bin> bins;
        bins = new ArrayList<Bin>();
        bins.add(new Bin(8));

        //VolledigeEnumeratie VE = new VolledigeEnumeratie(packets, bin.getBins());
        //VE.VolledigeEnumeratie(0);
        SimpleGready SG = new SimpleGready(packets, bins, 8);
        SG.runSimulation();
    }
    
}
