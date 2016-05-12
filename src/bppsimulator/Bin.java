package bppsimulator;

import java.util.ArrayList;

public class Bin {
    private int length;
    private ArrayList<Bin> bins;
    private ArrayList<Packet> packets;
    private int availableroom;
    
    public Bin(){
        bins = new ArrayList<>();
        this.length = 4;
        this.availableroom = 4;
    }
    
    public int getLength(){
        return this.length;
    }
    
    public void addBin(Bin bin){
        bins.add(bin);
    }
    
    public ArrayList<Bin> getBins(){
        return this.bins;
    }
    
    public void addItem(Packet packet){
        packets.add(packet);
    }
    
    public int getAvailabelroom(){
        return this.availableroom;
    }
    
    public void setAvailableroom(int room){
        this.availableroom = room;
    }
    
    @Override
    public String toString() {
        return "Bin Lengte: " + length;
    }
}
