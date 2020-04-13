/*
 *       Filename:  PR19203AU06E04.java
 *
 *    Description:  
 *
 *        Created:  13 d’abr. 2020
 *       Revision:  none
 *
 *        @Author:  xavier - xavier.sastre@cide.es
 *       @Version:  1.0
 *
 * =====================================================================================
 */
package cide.dam.pr20192020.PR19203AU06E04;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PR19203AU06E04 extends JFrame{
    private JPanel container;
    private JPanel conversionPane;

    private Font f;

    private JTextField inputField;
    private JLabel outputLabel;
    private JLabel titleLabel;

    private ConversorTemperatura tc = new ConversorTemperatura();

    // CONSTRUCTOR
    public PR19203AU06E04(){
        super("PR19203AU06E04");

        createElements();

        add(container);
    }
    // create GUI elements and add to container
    private void createElements(){
        container = new JPanel(new BorderLayout(5, 5));
        conversionPane = new JPanel();

        f = new Font("Sans-Serif", Font.PLAIN, 30);

        // title
        titleLabel = new JLabel("Fahrenheit to Celsius temperature conversion", SwingConstants.CENTER);

        // input
        inputField = new JTextField(3);
        inputField.setFont(f);

        // register event handler
        TextFieldHandler handler = new TextFieldHandler();
        inputField.addActionListener(handler);

        outputLabel = new JLabel("??");
        outputLabel.setFont(f);

        conversionPane.add(inputField);
        conversionPane.add(outputLabel);

        container.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 10));
        container.add(titleLabel, BorderLayout.PAGE_START);
        container.add(conversionPane, BorderLayout.CENTER);
    }
    // private inner class for event handling
    private class TextFieldHandler implements ActionListener{
        // process text field events
        public void actionPerformed(ActionEvent event){
            // conversion result
            double baseTemp = 0.0f;
            double conversion = 0.0f;

            // user pressed enter
            if(event.getSource() == inputField){
                // ensure input is double
                try{
                    baseTemp = Double.parseDouble(event.getActionCommand());
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, e);
                }
                conversion = tc.fahrenheitToCelsius(baseTemp);
                outputLabel.setText(String.format("%.2f", conversion));
            }
        }
    }

}