package cide.dam.pr20192020.PR19203AU06E02;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;

public class PR19203AU06E02 extends JFrame{
    private static final String[] names = {
        "Red", "Green", "Blue", "Purple", "Greenish"};

    // CONSTRUCTOR
    public PR19203AU06E02(){
        super("PR19203AU06E02");

        setLayout(new BorderLayout(5, 5));

        JPanel center = new JPanel();
        JPanel bottom = new JPanel();

        add(new JComboBox(names), BorderLayout.NORTH);

        center.add(new JCheckBox("Background"));
        center.add(new JCheckBox("Foreground"));

        add(center, BorderLayout.CENTER);

        bottom.add(new JButton("Ok"));
        bottom.add(new JButton("Cancel"));

        add(bottom, BorderLayout.SOUTH);
    }
}
