package bppsimulator;

public class Packet {

    private int length;
    private int width;
    private int artId;

    public Packet(int length, int width, int id) {
        this.length = length;
        this.width = width;
        this.artId = id;
    }
    
    public int getLength(){
        return this.length;
    }
    
    public int getWidth(){
        return this.width;
    }

    @Override
    public String toString() {
        return "Lengte: " + length + " Breedte: " + width + " Hoogte: " + artId;
    }
}
