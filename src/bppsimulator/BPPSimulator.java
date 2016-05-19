package bppsimulator;

import java.util.ArrayList;

public class BPPSimulator {

    public static void main(String[] args) {
        //Creates an ArrayList of Packet objects to use for the simulations
        ArrayList<Packet> in = new ArrayList<>();
        in.add(new Packet(10));
        in.add(new Packet(3));
        in.add(new Packet(2)); 
        in.add(new Packet(3));
        in.add(new Packet(10)); 
        in.add(new Packet(1)); 
        in.add(new Packet(6)); 
        in.add(new Packet(7));
        
        //Makes the screen to run simulations in
        Screen screen = new Screen(in);
    }
}
