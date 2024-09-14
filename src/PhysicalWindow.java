import DBConnect.SavePhysicalTest;
import Test.PhysicalTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhysicalWindow extends JFrame {
    private JPanel panel2;
    private JLabel labelHead2;
    private JLabel labelColorBlind;
    private JButton OKbutton2;
    private JRadioButton colorPass;
    private JRadioButton colorFail;
    private JRadioButton farPass;
    private JRadioButton astmPass;
    private JRadioButton brPass;
    private JRadioButton farFail;
    private JRadioButton astmFail;
    private JRadioButton brFail;
    private JLabel labelfar;
    private JLabel labelastm;
    private JLabel labelrs;
    private String firstname;
    private String lastname;

    public PhysicalWindow(String firstname,String lastname) {
        super("Physical Test");

        this.firstname = firstname;
        this.lastname = lastname;

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(10, 2));


        panel2.add(labelHead2);

        panel2.add(labelColorBlind);
        panel2.add(labelfar);
        panel2.add(labelastm);
        panel2.add(labelrs);


        ButtonGroup colorBlindGroup = new ButtonGroup();
        colorBlindGroup.add(colorPass);
        colorBlindGroup.add(colorFail);

        ButtonGroup farGroup = new ButtonGroup();
        farGroup.add(farPass);
        farGroup.add(farFail);

        ButtonGroup astmGroup = new ButtonGroup();
        astmGroup.add(astmPass);
        astmGroup.add(astmFail);

        ButtonGroup brGroup = new ButtonGroup();
        brGroup.add(brPass);
        brGroup.add(brFail);

        panel2.add(labelHead2);
        panel2.add(new JLabel(""));

        panel2.add(labelColorBlind);
        panel2.add(colorPass);
        panel2.add(new JLabel(""));
        panel2.add(colorFail);

        panel2.add(labelfar);
        panel2.add(farPass);
        panel2.add(new JLabel(""));
        panel2.add(farFail);

        panel2.add(labelastm);
        panel2.add(astmPass);
        panel2.add(new JLabel(""));
        panel2.add(astmFail);

        panel2.add(labelrs);
        panel2.add(brPass);
        panel2.add(new JLabel(""));
        panel2.add(brFail);

        panel2.add(OKbutton2);

        panel2.add(new JLabel(""));

        this.add(panel2);

        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        OKbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Processing the test results

                boolean colorblindess = colorPass.isSelected();
                boolean farsight = farPass.isSelected();
                boolean astigmatism = astmPass.isSelected();
                boolean bodyresponse = brPass.isSelected();

                SavePhysicalTest.savePhysical(colorblindess,farsight,astigmatism,bodyresponse);


                TheoryWindow theoryWindow = new TheoryWindow(firstname,lastname);
                theoryWindow.setVisible(true);

                PhysicalWindow.this.dispose();
            }
        });

    }

}