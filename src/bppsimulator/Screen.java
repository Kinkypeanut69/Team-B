package bppsimulator;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Screen extends JFrame implements ActionListener {
    
    private ArrayList<Packet> in; //ArrayList with all the packets
    private ArrayList<AbstractBinPacking> algorithms; //ArrayList with algorithms
    private JLabel jlNaam, jlBinSize; //labels
    private JTextField jtfBinSize; //textfields
    private JTextArea jtAinfo; //textareas
    private JButton jbRun; //the run simulation button
    private JComboBox jcbAlgorithm; //combobox with different algorithms as options
    private String[] description = {"Brute Force", "First Fit", "Best fit", "Simple gready"}; //descriptions for combobox
    private AbstractBinPacking bForce, fFit, bFit, sGready; //different variables for the algorithms
    
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
        
        //Descriptions for combobox
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
                
        //Panel for drawing bins and packets
        DrawPanel drawpanel = new DrawPanel(this);
        add(drawpanel);
        
        jtAinfo = new JTextArea();
        add(jtAinfo);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //creates a new algorithm and simulates the test
        try {
            //if pressed brute force
            if (jcbAlgorithm.getSelectedIndex() == 0){
                    addAlgoritm(new BinPackingBruteforce(in, Integer.parseInt(jtfBinSize.getText()))); 
            //if pressed firs fit
            } if (jcbAlgorithm.getSelectedIndex() == 1) {
                    addAlgoritm(new BinPackingFirstFit(in, Integer.parseInt(jtfBinSize.getText())));
            //if pressed best fit
            } if (jcbAlgorithm.getSelectedIndex() == 2){
                    addAlgoritm(new BestFit(in, Integer.parseInt(jtfBinSize.getText())));
            //if pressed simple gready
            } if (jcbAlgorithm.getSelectedIndex() == 3){
                    addAlgoritm(new SimpleGready(in, Integer.parseInt(jtfBinSize.getText())));
            }
        } catch (NumberFormatException ae){
            
        }
        //run simulation
        testBinPacking(this.algorithms.get(0), this.description[jcbAlgorithm.getSelectedIndex()]);
        //paint panel
        repaint();
    }
    
    //remove any existing algorithms and add new one
    public void addAlgoritm(AbstractBinPacking algo){
        if (this.algorithms.size() > 0){
            this.algorithms.remove(0);
        }
        this.algorithms.add(algo);
    }
    
    //returns an ArrayList with algorithm
    public ArrayList<AbstractBinPacking> getAlgorithms(){
        return this.algorithms;
    }
    
    //Tests the algorithm here and gives a timer at the end
    private void testBinPacking(AbstractBinPacking algo, String algoName) {
        long startTime;
        long estimatedTime;

        startTime = System.currentTimeMillis();
        this.jtAinfo.setText("");
        this.jtAinfo.append("needed bins (" + algoName + "): " + algo.getResult());
        this.jtAinfo.append(algo.toString());
        estimatedTime = System.currentTimeMillis() - startTime;
        this.jtAinfo.append("\n" + "in " + estimatedTime + " ms");
        this.jtAinfo.append("\n\n");
    }
}