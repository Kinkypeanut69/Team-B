package bppsimulator;

public class BPPSimulator {

    
    public static void main(String[] args) {
        
        Packet p1 = new Packet(2, 2, 1);
        Packet p2 = new Packet(2, 2, 2);
        Packet p3 = new Packet(2, 2, 3);
        Packet p4 = new Packet(2, 2, 4);
        Bin b1 = new Bin();
        System.out.println("" + p1 + "\n" + b1);
        
        
        Scherm scherm = new Scherm();
    }
    
}
