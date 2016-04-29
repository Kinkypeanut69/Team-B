package bppsimulator;

public class Bin {
    private int length;
    private int width;
    private int height;
    
    public Bin(int length, int width, int height){
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public String toString() {
        return "Lengte: " + length + " Breedte: " + width + " Hoogte: " + height;
    }
}
