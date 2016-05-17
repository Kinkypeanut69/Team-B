package bppsimulator;

public class Packet {
    private int length;
    
<<<<<<< HEAD
    public Packet(int length){
=======

    public Packet(int length, int id) {
        super();
>>>>>>> origin/master
        this.length = length;
    }
    
    public int getLength(){
<<<<<<< HEAD
        return this.length;
    }  
}
=======
        return length;
    }
    
    @Override
    public String toString() {
        return "Lengte: " + length + " " + artId;
    }
}
>>>>>>> origin/master
