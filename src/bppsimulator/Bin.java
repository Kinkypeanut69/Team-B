package bppsimulator;

import java.util.ArrayList;

public class Bin extends Order{
    private int length;
    private int availableRoom;
    private ArrayList<Packet> packetsInBin;
    private ArrayList<Bin> bins;
    private ArrayList<Packet> packets;
    private int availableroom;
    
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
    
     //   this.availableroom = 4;
    //}
    
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
    
    public int getAvailabelroom(){
        return this.availableroom;
    }
    
    public void setAvailableroom(int room){
        this.availableroom = room;
    }
    
    @Override
    public String toString() {
        return "Lengte: " + length;
    }
}
