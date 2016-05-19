package bppsimulator;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawPanel extends JPanel {
    

    private Screen parent;
    private int startX, startY, startYItem, index = 0;
    private ArrayList<Color> colors;
    
    public DrawPanel(Screen parent){
        this.parent = parent; //stores the screen parent in an attribute
        this.colors = new ArrayList<>(); //add a variety of colors to switch between
        colors.add(Color.red);
        colors.add(Color.BLUE);
        colors.add(Color.PINK);
        colors.add(Color.GREEN);
        //x and y coordinates for drawing the panel
        this.startX = 50; 
        this.startY = 50;
        this.startYItem = 50;
        
        setPreferredSize(new Dimension(1800, 500));
        setBackground(Color.WHITE);
        setVisible(true);
    }
    
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        startX = 50; 
        startY = 50;
        startYItem = 50;
        
        //draws bins and packets on the drawingpanel
        for (AbstractBinPacking a: parent.getAlgorithms()){
            for (Bin b: a.getBins()){
                g.setColor(Color.BLACK);
                g.drawRect(startX, startY, 50, b.maxSize * 10);
                startYItem = startY;
                for (Packet c: b.getItems()){
                    if (index == 3){
                        index = 0;
                    }
                    g.setColor(colors.get(index));
                    index++;
                    g.fillRect(startX, startYItem, 50, c.getLength() * 10);
                    startYItem += c.getLength() * 10;
                }
                startX += 100;
            }
        }  
    }
}
