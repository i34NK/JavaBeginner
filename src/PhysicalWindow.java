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

    public PhysicalWindow() {
        super("Physical Test");

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(10, 2));

        // Initializing labels and radio buttons

        panel2.add(labelHead2);

        panel2.add(labelColorBlind);
        panel2.add(labelfar);
        panel2.add(labelastm);
        panel2.add(labelrs);


        // Grouping the radio buttons
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

        // Adding components to panel
        panel2.add(labelHead2);
        panel2.add(new JLabel("")); // Placeholder for spacing

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

        // Adding OK button
        OKbutton2 = new JButton("OK");
        panel2.add(OKbutton2);
        panel2.add(new JLabel("")); // Placeholder for spacing

        // Adding the panel to the frame
        this.add(panel2);

        // Set window properties
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Adding action listener to the OK button
        OKbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Processing the test results
                PhysicalTest physicalTest = new PhysicalTest();
                physicalTest.setColorBlindessTest(colorPass.isSelected());
                physicalTest.setFarsightednessTest(farPass.isSelected());
                physicalTest.setAstigmatismTest(astmPass.isSelected());
                physicalTest.setBodyResponseTest(brPass.isSelected());

                // Check if the user passed the physical test
                boolean passed = physicalTest.estimatePhysicalTest();
                String physicalResult = passed ? "Pass" : "Failed";

                // เปิดหน้าต่าง TheoryWindow พร้อมส่งผลการทดสอบภาคปฏิบัติไปด้วย
                TheoryWindow theoryWindow = new TheoryWindow(physicalResult);
                theoryWindow.setVisible(true);

                // ปิดหน้าต่าง PhysicalWindow
                PhysicalWindow.this.dispose();
            }
        });

    }

    public static void main(String[] args) {
        new PhysicalWindow().setVisible(true);
    }
}
