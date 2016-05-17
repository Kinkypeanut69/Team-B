package bppsimulator;

public class Packet {
    private int length;
    private int id;
    
    public Packet(int length) {
        super();
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
