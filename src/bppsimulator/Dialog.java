package bppsimulator;

import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Dialog extends JDialog implements ActionListener{

    public Dialog(JFrame frame, ArrayList<Bin> algo){
        super(frame, true);
        setTitle("Schets");
        setSize(new Dimension(1000, 300));
       
        add(new DrawPanel(algo));
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
