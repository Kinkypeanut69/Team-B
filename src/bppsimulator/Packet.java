package bppsimulator;

public class Packet {

    private int length;
    private int width;
    private int height;

    public Packet(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Lengte: " + length + " Breedte: " + width + " Hoogte: " + height;
    }
}
