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
    private String physicalResult;  // รับค่าผลจาก PhysicalWindow

    // ปรับ constructor เพื่อรับผลลัพธ์จาก PhysicalWindow
    public TheoryWindow(String physicalResult) {
        super("การทดสอบภาคทฤษฎี");
        this.physicalResult = physicalResult;

        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(10, 2));


        signTxt = new JTextField();
        lineTxt = new JTextField();
        giveawayTxt = new JTextField();
        OKButton3 = new JButton("OK");

        panel3.add(labelHead);
        panel3.add(new JLabel("")); // Placeholder for spacing

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
                    // รับค่าคะแนนจาก TextField
                    int signScore = Integer.parseInt(signTxt.getText());
                    int lineScore = Integer.parseInt(lineTxt.getText());
                    int giveawayScore = Integer.parseInt(giveawayTxt.getText());

                    // สร้างออบเจกต์ TheoryTest และตั้งค่าคะแนน
                    TheoryTest theoryTest = new TheoryTest();
                    theoryTest.setTrafficSignTest(signScore);
                    theoryTest.setTrafficLinesTest(lineScore);
                    theoryTest.setGiveWayTest(giveawayScore);

                    // คำนวณผลลัพธ์ภาคทฤษฎี
                    int theoryTotalScore = signScore + lineScore + giveawayScore;  // คะแนนรวมภาคทฤษฎี

                    // ตรวจสอบเงื่อนไขการผ่านการทดสอบภาคทฤษฎี
                    String theoryResult = (theoryTotalScore >= 120) ? "Pass" : "Failed";

                    // ปิดหน้าต่าง TheoryWindow
                    TheoryWindow.this.dispose();

                    // ส่งค่าคะแนนไปยัง TotalScoreWindow รวมถึงผลลัพธ์จาก PhysicalWindow
                    TotalScoreWindow totalScoreWindow = new TotalScoreWindow(physicalResult, theoryTotalScore, theoryResult);
                    totalScoreWindow.setVisible(true);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "กรุณากรอกคะแนนที่ถูกต้อง", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
