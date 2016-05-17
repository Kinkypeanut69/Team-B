package bppsimulator;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Screen extends JFrame implements ActionListener {
    
    private ArrayList<Packet> in;
    private JLabel jlNaam, jlBinSize;
    private JTextField jtfNaam, jtfBinSize;
    private JButton jbRun;
    private JComboBox jcbAlgorithm;
    private String[] description = {"Brute Force", "First Fit"};
    private JPanel drawPanel;
    
    public Screen(ArrayList<Packet> in){
        this.in = new ArrayList<>();
        this.in = in;
        setTitle("BPP Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(new FlowLayout());
        
        jlNaam = new JLabel("Algorithm name:");
        add(jlNaam);
        
        jcbAlgorithm = new JComboBox();
        add(jcbAlgorithm);
        
        for (String a: description){
            jcbAlgorithm.addItem(a);
        }
        
        jlBinSize = new JLabel("Bin Size:");
        add(jlBinSize);
        
        jtfBinSize = new JTextField(10);
        add(jtfBinSize);
        
        jbRun = new JButton("Run Algorithm");
        jbRun.addActionListener(this);
        add(jbRun);
        
        
        
        
        
        
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jcbAlgorithm.getSelectedIndex() == 0){
            try {
                BinPackingBruteforce bf = new BinPackingBruteforce(in, Integer.parseInt(jtfBinSize.getText()));
                testBinPacking(bf, "brute force");
                this.drawPanel = new DrawPanel(this, bf);
                add(drawPanel);
            } catch (NumberFormatException ae){
                
            }
        }
    }
    
    private static void testBinPacking(AbstractBinPacking algo, String algoName) {
        long startTime;
        long estimatedTime;

        startTime = System.currentTimeMillis();
        System.out.println("needed bins (" + algoName + "): " + algo.getResult());
        algo.printBestBins();
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("in " + estimatedTime + " ms");

        System.out.println("\n\n");
    }
}
