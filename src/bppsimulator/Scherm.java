package bppsimulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Scherm extends JFrame implements ActionListener {
    
    private JLabel jl1, jl2;
    private JButton jB1, jB2;
    private JTextField jtf1, jtf2;

    public Scherm(){
        setTitle("Bin Packing Problem simulator");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
