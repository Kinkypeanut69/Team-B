package bppsimulator;

import java.util.ArrayList;

public class BestFit extends AbstractBinPacking {

    private ArrayList<Bin> bins;

    public BestFit(ArrayList<Packet> in, int binSize) {
        super(in, binSize);
        bins = new ArrayList<>();
        for (Packet in1 : in) {
            bins.add(new Bin(binSize)); // create maximum of needed bins
        }
    }

    public void runSimulation() {
        int leastRoom;
        Packet bestPacket = null;
        Bin bestBin = null;

        for (Packet packet : in) {
            leastRoom = 99;
            for (Bin bin1: bins) {
                if (bin1.putCheck(packet)) {
                    int roomLeft = bin1.roomLeft() - packet.getLength();
                    if (roomLeft < leastRoom) {
                        leastRoom = roomLeft;
                        bestPacket = packet;
                        bestBin = bin1;
                    }
                }
            }
            bestBin.put(bestPacket);
        }
        bins = deepCopy(bins);
    }

    @Override
    public int getResult() {
        return bins.size();
    }

    @Override
    public String printBestBins() {
        String a = ("Bins:");
        for (Bin bin : bins) {
            a += ("\n" + bin.toString());
        }
        return a;
    }

    public ArrayList<Bin> getBins() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
