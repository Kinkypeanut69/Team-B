package bppsimulator;

import java.util.ArrayList;

public class Bin {
    private int length;
    private int width;
    private ArrayList<Bin> bins;
    
    public Bin(){
        bins = new ArrayList<>();
        this.length = 4;
        this.width = 4;
    }
    
    public void setLength(int length){
        this.length -= length;
    }
    
    public int getLength(){
        return this.length;
    }
    
    public void setWidth(int width){
        this.width -= width;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public void addBin(Bin bin){
        bins.add(bin);
    }
    
    public ArrayList<Bin> getBins(){
        return this.bins;
    }
    
    public void addItem(Packet packet){
        
    }
    
    @Override
    public String toString() {
        return "Lengte: " + length + " Breedte: " + width + " Hoogte: ";
    }
}
