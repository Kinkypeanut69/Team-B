package bppsimulator;

import java.util.ArrayList;

public class Bin extends Order{
    private int length;
    private int availableRoom;
    private ArrayList<Packet> packetsInBin;
    
    public Bin(){
        super();
        bins.add(this);
        packetsInBin = new ArrayList<>();
        this.length = 4;
    }
    
    public ArrayList<Packet> getPackets(){
        return this.packets;
    }
    
    public ArrayList<Bin> getBins(){
        return this.bins;
    }
    
    public int getLength(){
        return this.length;
    }
        
    public void addBin(Bin bin){
        bins.add(bin);
    }
    
    public boolean addItem(Packet packet){
        
        if ((this.length - packet.getLength()) >= 0){
            packetsInBin.add(packet);
            this.length -= packet.getLength();
        }
        return (this.length - packet.getLength() >= 0);
    }
    
    public void removeItem(Packet packet){
        packetsInBin.remove(packet);
    }
    
    @Override
    public String toString() {
        return "Lengte: " + length;
    }
}
