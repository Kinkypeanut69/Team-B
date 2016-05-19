package bppsimulator;

import java.util.ArrayList;

public class BestFit extends AbstractBinPacking {

    private ArrayList<Bin> bins; //ArrayList to store bins in

    public BestFit(ArrayList<Packet> in, int binSize) {
        super(in, binSize);
        bins = new ArrayList<>();
        for (Packet in1 : in) {
            bins.add(new Bin(binSize)); // create maximum of needed bins
        }
    }
    
    //returns ArrayList of bins
    @Override
    public ArrayList<Bin> getBins() {
        return this.bins;
    }

    //runs the simulation and returns the amount of bins needed
    @Override
    public int getResult() {
        bestFit(); //executes the actual simulation
        return bins.size();
    }
    
    //runs the simulation
    private void bestFit(){
        int leastRoom; //stores number of least room left
        Bin bestBin = null; //stores the best bin

        //iterate over all packets 
        for (Packet packet : in) {
            leastRoom = 99; //an unusually high value to make sure a packet gets below it
            //iterate over all bins
            for (Bin bin1: bins) {
                //Checks if the item fits
                if (bin1.putCheck(packet)) {
                    //calculates amount of room left after packets gets put in
                    int roomLeft = bin1.roomLeft() - packet.getLength();
                    //is roomleft better than previous?
                    if (roomLeft < leastRoom) {
                        //store new roomleft
                        leastRoom = roomLeft;
                        //store the bin
                        bestBin = bin1;
                    }
                }
            }
            //put the packet in the best bin
            bestBin.put(packet);
        }
        bins = deepCopy(bins); //copies the bin list and removes empty bins 
    }

    @Override
    public String toString() {
        String a = ("Bins:");
        for (Bin bin : bins) {
            a += ("\n" + bin.toString());
        }
        return a;
    }
}
