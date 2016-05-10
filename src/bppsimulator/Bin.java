package bppsimulator;

public class Bin {
    private int length;
    private int width;
    
    public Bin(){
        this.length = 150;
        this.width = 150;
    }
    
    @Override
    public String toString() {
        return "Lengte: " + length + " Breedte: " + width + " Hoogte: ";
    }
}
