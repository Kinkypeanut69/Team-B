package bppsimulator;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawPanel extends JPanel {
    

    private ArrayList<Bin> bins;
    private int startX;
    private int startY;
    private int counter = 0;
    
    public DrawPanel(ArrayList<Bin> algo){
        this.startX = 50;
        this.startY = 100;
        this.bins = algo;
        setPreferredSize(new Dimension(800, 200));
        setBackground(Color.WHITE);
        setVisible(true);
    }
    
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        
        for (Bin a: bins){
            System.out.println(bins.size());
            System.out.println("next bin");
        }
        
    }
}
