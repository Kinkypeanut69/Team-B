package bppsimulator;

import java.util.ArrayList;

public class BPPSimulator {

    public static void main(String[] args) {
<<<<<<< HEAD
        ArrayList<Packet> in = new ArrayList<>();
        in.add(new Packet(10));
        in.add(new Packet(3));
        in.add(new Packet(2)); 
        in.add(new Packet(3));
        in.add(new Packet(10)); 
        in.add(new Packet(1)); 
        in.add(new Packet(6)); 
        in.add(new Packet(7));

        BinPackingBruteforce bf = new BinPackingBruteforce(in, 12);
        testBinPacking(bf, "brute force");

        BinPackingFirstFit ffd = new BinPackingFirstFit(in, 12);
        testBinPacking(ffd, "first fit decreasing");
=======
        
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
>>>>>>> origin/master
    }

    private static void testBinPacking(AbstractBinPacking algo, String algoName) {
        long startTime;
        long estimatedTime;

        startTime = System.currentTimeMillis();
        System.out.println("needed bins (" + algoName + "): " + algo.getResult());
        algo.printBestBins();
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("in " + estimatedTime + " ms");

        System.out.println("\n\n");
    }

}
