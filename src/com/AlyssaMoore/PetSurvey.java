package com.AlyssaMoore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PetSurvey extends JFrame{
    private JCheckBox catCheckBox;
    private JCheckBox dogCheckBox;
    private JCheckBox fishCheckBox;
    private JButton quitButton;
    private JLabel selectPets;
    private JLabel surveyResults;
    private JPanel rootPanel;

    private boolean fish, cat, dog;

    PetSurvey() {
        setContentPane(rootPanel);
        pack();
        setSize(350, 200);
        setTitle("Pet Survey");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cat = catCheckBox.isSelected();
                updateResults();
            }
        });
        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dog = dogCheckBox.isSelected();
                updateResults();
            }
        });
        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fish = fishCheckBox.isSelected();
                updateResults();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(PetSurvey.this, "Are you sure you want to exit?", "Quit?", JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
        private void updateResults() {
            String hasDog = dog ? "a dog" : "no dogs";
            String hasCat = cat ? "a cat" : "no cats";
            String hasFish = fish ? "a fish" : "no fish";
            String results = "You have " + hasCat + ", " + hasDog + ", and " + hasFish;
            surveyResults.setText(results);

        }
}