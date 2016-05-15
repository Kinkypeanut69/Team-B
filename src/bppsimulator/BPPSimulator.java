package bppsimulator;

import java.util.ArrayList;

public class BPPSimulator {

    
    public static void main(String[] args) {
        
        Packet p1 = new Packet(2, 1);
        Packet p2 = new Packet(2, 2);
        Packet p3 = new Packet(2, 3);
        Packet p4 = new Packet(2, 4);
        ArrayList<Packet> packets;
        packets = new ArrayList<Packet>();
        packets.add(p1);
        packets.add(p2);
        packets.add(p3);
        packets.add(p4);
        Bin bin = new Bin();

        VolledigeEnumeratie VE = new VolledigeEnumeratie(packets, bin.getBins());
        VE.VolledigeEnumeratie(0);
    }
    
}
