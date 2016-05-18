package bppsimulator;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Screen extends JFrame implements ActionListener {
    
    private ArrayList<Packet> in;
    private ArrayList<AbstractBinPacking> algorithms;
    private JLabel jlNaam, jlBinSize;
    private JTextField jtfBinSize;
    private JButton jbRun;
    private JComboBox jcbAlgorithm;
    private String[] description = {"Brute Force", "First Fit"};
    private AbstractBinPacking bForce, fFit, bFit, sGready;
    
    public Screen(ArrayList<Packet> in){
        this.in = in;
        algorithms = new ArrayList<>();
        setTitle("BPP Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
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
                
        DrawPanel drawpanel = new DrawPanel(this);
        add(drawpanel);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jcbAlgorithm.getSelectedIndex() == 0){
            try {
                this.bForce = new BinPackingBruteforce(in, Integer.parseInt(jtfBinSize.getText()));
                testBinPacking(bForce, "brute force"); 
                addAlgorithm(bForce);   
            } catch (NumberFormatException ae){
                
            }
        } else {
            try {
                this.fFit = new BinPackingFirstFit(in, Integer.parseInt(jtfBinSize.getText()));
                testBinPacking(fFit, "First fit");
                addAlgorithm(fFit);
            } catch (NumberFormatException a){
                
            }
        }
        repaint();
    }
    
    private void addAlgorithm(AbstractBinPacking algo){
        if (this.algorithms.size() > 0){
            this.algorithms.remove(0);
        }
        this.algorithms.add(algo);
    }
    
    public ArrayList<AbstractBinPacking> getAlgorithms(){
        return this.algorithms;
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
