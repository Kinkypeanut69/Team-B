package bppsimulator;

import java.util.ArrayList;

public class Packet extends Order {

    private int length;
    private int artId;
    

    public Packet(int length, int id) {
<<<<<<< HEAD
        super();
=======
>>>>>>> origin/master
        this.length = length;
        this.artId = id;
    }
    
    public ArrayList<Packet> getPackets(){
        return this.packets;
    }
    
    public void addPackets(){
        this.packets.add(this);
    }
    
    public int getLength(){
        return this.length;
    }
    
    @Override
    public String toString() {
<<<<<<< HEAD
        return "Lengte: " + length + artId;
=======
        return "Packet Lengte: " + length + " Artikelnummer: " + artId;
>>>>>>> origin/master
    }
}
