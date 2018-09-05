package areaandperimeter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AreaAndPerimeter extends JFrame {

    // TODO: Add instance variables for text fields
    
    JLabel lengthLabel = new JLabel("Length:");
    JLabel widthLabel = new JLabel("Width:");
    JLabel areaLabel = new JLabel("Area:");
    JLabel perimeterLabel = new JLabel("Perimeter:");
    private JTextField lengthField;
    private JTextField widthField;
    private JTextField areaField;
    private JTextField perimeterField;
    private JButton computeButton;
    private JButton resetButton;
    
    public AreaAndPerimeter() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
    }

    private void initComponents() {
        setTitle("Area and Perimeter Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        
        lengthField = new JTextField("");
        widthField = new JTextField("");
        areaField = new JTextField("");
        perimeterField = new JTextField("");
    
        areaField.setEditable(false);
        perimeterField.setEditable(false);
        
        Dimension dim = new Dimension(150, 20);
        
        lengthField.setPreferredSize(dim);
        lengthField.setMinimumSize(dim);
        widthField.setPreferredSize(dim);
        widthField.setMinimumSize(dim);
        areaField.setPreferredSize(dim);
        areaField.setMinimumSize(dim);
        perimeterField.setPreferredSize(dim);
        perimeterField.setMinimumSize(dim);
        
        computeButton = new JButton("Compute");
        resetButton = new JButton("Reset");
        // components go here
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(lengthLabel, getConstraints(0,0));
        panel.add(widthLabel, getConstraints(0,1));
        panel.add(areaLabel, getConstraints(0,2));
        panel.add(perimeterLabel, getConstraints(0,3));

        panel.add(lengthField, getConstraints(1,0));
        panel.add(widthField, getConstraints(1,1));
        panel.add(areaField, getConstraints(1,2));
        panel.add(perimeterField, getConstraints(1,3));
        
        add(panel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(computeButton);
        buttonPanel.add(resetButton);
        
        computeButton.addActionListener(e -> computeButtonClicked());
        resetButton.addActionListener(e -> resetButtonClicked());
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        setSize(new Dimension(300, 200));
        setVisible(true);
    }

    // Helper method to return GridBagConstraints objects
    private GridBagConstraints getConstraints(int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        return c;
    }

    private void computeButtonClicked() {
        int length = 0;
        int width = 0;
        int perimeter = 0;
        int area = 0;
        SwingValidator validator = new SwingValidator();
        
        if(validator.isPresent(lengthField, "Length Field") && 
                validator.isPresent(widthField, "Width Field") && 
                validator.isInteger(lengthField, "Length Field") &&
                validator.isInteger(widthField, "Width Field"))
        {
            length = Integer.parseInt(lengthField.getText());
            width = Integer.parseInt(widthField.getText());
         
            perimeter = (length * 2) + (width * 2);
            area = length * width;
         
            perimeterField.setText(Integer.toString(perimeter));
            areaField.setText(Integer.toString(area));
        }
        else
        {
            lengthField.setText("");
            widthField.setText("");
            areaField.setText("");
            perimeterField.setText("");
        }
        
    }

    private void resetButtonClicked() {
        lengthField.setText("");
        widthField.setText("");
        areaField.setText("");
        perimeterField.setText("");
        
    }
    
    
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new AreaAndPerimeter();
        });        
    }
}

