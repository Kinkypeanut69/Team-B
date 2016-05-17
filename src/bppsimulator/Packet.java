package bppsimulator;

public class Packet {
    private int length;
    
    public Packet(int length){
        this.length = length;
    }
    
    public int getLength(){
        return this.length;
    }  
}