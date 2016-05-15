/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bppsimulator;

import java.util.ArrayList;

/**
 *
 * @author Beheerder
 */
public abstract class Order {
    protected ArrayList<Bin> bins;
    protected ArrayList<Packet> packets;
    
    public Order(){
        bins = new ArrayList<>();
        packets = new ArrayList<>();
    }
}
