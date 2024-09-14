import DBConnect.SaveTheory;
import Test.TheoryTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheoryWindow extends JFrame {
    private JPanel panel3;
    private JLabel labelHead;
    private JLabel labelSign;
    private JTextField signTxt;
    private JLabel labelLine;
    private JTextField lineTxt;
    private JLabel labelGiveaway;
    private JTextField giveawayTxt;
    private JButton OKButton3;
    private JLabel labelScore;
    private String physicalResult;
    private String firstname;
    private String lastname;

    public TheoryWindow(String firstname, String lastname) {
        super("การทดสอบภาคทฤษฎี");
        this.physicalResult = physicalResult;
        this.firstname = firstname;
        this.lastname = lastname;

        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(10, 2));

        panel3.add(labelHead);
        panel3.add(labelSign);
        signTxt = new JTextField();
        panel3.add(labelLine);
        lineTxt = new JTextField();
        panel3.add(labelGiveaway);
        giveawayTxt = new JTextField();
        panel3.add(OKButton3);

        panel3.add(labelHead);
        panel3.add(new JLabel(""));

        panel3.add(labelSign);
        panel3.add(signTxt);

        panel3.add(labelLine);
        panel3.add(lineTxt);

        panel3.add(labelGiveaway);
        panel3.add(giveawayTxt);

        panel3.add(OKButton3);
        panel3.add(new JLabel("")); // Placeholder for spacing

        this.add(panel3);

        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        OKButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int signScore = Integer.parseInt(signTxt.getText());
                    int lineScore = Integer.parseInt(lineTxt.getText());
                    int giveawayScore = Integer.parseInt(giveawayTxt.getText());

                    // ตรวจสอบว่าคะแนนไม่เกิน 50
                    if (signScore > 50 || lineScore > 50 || giveawayScore > 50) {
                        JOptionPane.showMessageDialog(null, "The score should not exceed 50.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;  // หยุดการทำงานหากมีคะแนนเกิน
                    }

                    TheoryTest theoryTest = new TheoryTest();
                    theoryTest.setTrafficSignTest(signScore);
                    theoryTest.setTrafficLinesTest(lineScore);
                    theoryTest.setGiveWayTest(giveawayScore);

                    // คำนวณคะแนนรวมภาคทฤษฎี
                    int theoryTotalScore = signScore + lineScore + giveawayScore;

                    // ตรวจสอบว่าผ่านหรือไม่
                    String theoryResult = (theoryTotalScore >= 120) ? "Pass" : "Failed";

                    // บันทึกข้อมูลภาคทฤษฎี
                    SaveTheory.saveTheory(signScore, lineScore, giveawayScore);

                    TheoryWindow.this.dispose();

                    // เปิดหน้าต่าง TotalScoreWindow และส่งค่าที่จำเป็น
                    TotalScoreWindow totalScoreWindow = new TotalScoreWindow(physicalResult, theoryTotalScore, theoryResult, firstname, lastname);
                    totalScoreWindow.setVisible(true);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "กรุณากรอกคะแนนที่ถูกต้อง", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}