package cide.dam.pr20192020.PR19203AU06E01;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

public class PR19203AU06E01 extends JFrame{
    private static final String[] names = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+"};

    // CONSTRUCTOR
    public PR19203AU06E01(){
        super("PR19203AU06E01");

        JPanel container = new JPanel();
        JPanel topGrid = new JPanel(new GridLayout(1, 1));
        JPanel bottomGrid = new JPanel(new GridLayout(4, 4, 3, 3));

        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        topGrid.add(new JTextField(10));

        // add buttons
        for(int i=0; i<names.length; i++){
            bottomGrid.add(new JButton(names[i]));
        }

        container.add(topGrid);
        container.add(bottomGrid);

        add(container);
    }
}
