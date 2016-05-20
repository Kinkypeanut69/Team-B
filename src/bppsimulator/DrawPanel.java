package bppsimulator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class DrawPanel extends JPanel {
    

    private Screen parent;
    private int startX;
    private int startY;
    private int startYItem;
    private ArrayList<Color> colors;
    private int index = 0;
    
    public DrawPanel(Screen parent){
        this.parent = parent;
        this.colors = new ArrayList<>();
        colors.add(Color.red);
        colors.add(Color.BLUE);
        colors.add(Color.PINK);
        colors.add(Color.GREEN);
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
        this.startX = 50;
        this.startY = 50;
        this.startYItem = 50;
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
