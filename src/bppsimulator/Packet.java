package bppsimulator;

import java.util.ArrayList;

public class Packet extends Order {

    private int length;
    private int artId;
    

    public Packet(int length, int id) {
<<<<<<< HEAD

=======
>>>>>>> origin/master
        super();
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

=======
>>>>>>> origin/master
        return "Lengte: " + length + artId;
    }
}
