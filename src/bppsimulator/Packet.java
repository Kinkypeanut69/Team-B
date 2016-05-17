package bppsimulator;

public class Packet {
    private int length;
    private int id;
    
    public Packet(int length) {
        this.length = length;
    }
    
    public int getLength(){
        return this.length;
    }
    
    @Override
    public String toString() {
        return "Lengte: " + length;
    }
}
