package bppsimulator;

public class Packet {

    private int length;
    private int artId;

    public Packet(int length, int id) {
        this.length = length;
        this.artId = id;
    }
    
    public int getLength(){
        return this.length;
    }
    
    @Override
    public String toString() {
        return "Packet Lengte: " + length + " Artikelnummer: " + artId;
    }
}
