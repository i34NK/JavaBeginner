import javax.swing.*;
import java.awt.*;

public class TotalScoreWindow extends JFrame {
    private JPanel panel4;
    private JTextField bodyTotalTxt;
    private JTextField theoryTxt;
    private JTextField practiceTxt;
    private JTextField result; // ประกาศตัวแปร result
    private JLabel labelHead;
    private JLabel labelBody;
    private JLabel labelTheory;

    // เพิ่ม physicalResult เป็นพารามิเตอร์
    public TotalScoreWindow(String physicalResult, int theoryScore, String theoryResult) {
        super("ผลการประเมินการทดสอบ");

        // Initialize panel
        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(10, 2));

        // Initialize text fields with results
        bodyTotalTxt = new JTextField(physicalResult);  // แสดงผลว่าผ่านหรือไม่ผ่านการทดสอบร่างกาย
        theoryTxt = new JTextField(String.valueOf(theoryScore));
        practiceTxt = new JTextField(theoryResult);
        result = new JTextField(); // เพิ่มตัวแปร result

        // Set text fields to non-editable
        bodyTotalTxt.setEditable(false);
        theoryTxt.setEditable(false);
        practiceTxt.setEditable(false);
        result.setEditable(false); // ทำให้ result ไม่แก้ไขได้

        // Adding components to panel
        panel4.add(labelBody);
        panel4.add(bodyTotalTxt);

        panel4.add(labelTheory);
        panel4.add(theoryTxt);


        // Add panel to frame
        this.add(panel4);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // ตัวอย่างการเรียกใช้ TotalScoreWindow
        TotalScoreWindow window = new TotalScoreWindow("Pass", 130, "Pass");
        window.setVisible(true);
    }
}
