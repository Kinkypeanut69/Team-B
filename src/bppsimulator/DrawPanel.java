/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bppsimulator;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Beheerder
 */
public class DrawPanel extends JPanel {
    
    private JFrame frame;
    private AbstractBinPacking algo;
    private ArrayList<Bin> bins;
    private ArrayList<Packet> items;
    
    public DrawPanel(JFrame frame, AbstractBinPacking algo){
        this.algo = algo;
        this.frame = frame;
        this.bins = algo.getBins();
        setPreferredSize(new Dimension(800, 200));
        
        setVisible(true);
       
    }
    
    @Override
    public void paintComponent (Graphics g){
        g.drawString("Brute Force", 50, 100);
        
    }
}
