package bppsimulator;

import java.util.ArrayList;

public abstract class Algoritme {
    
    protected ArrayList<Bin> bins;
    protected ArrayList<Packet> packets;
    
    abstract void runSimulation();
    abstract int returnBins();
    
}
