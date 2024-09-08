import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstWindow extends JFrame {
    private JPanel panel1;
    private JTextField firstnameTxt;
    private JTextField lastnameTxt;
    private JButton OKButton1;
    private JLabel labelHead;
    private JLabel labelParagraph;

    public FirstWindow() {
        super("Driver License");
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(10, 10));
        firstnameTxt = new JTextField();
        lastnameTxt = new JTextField();
        OKButton1 = new JButton("OK");

        panel1.add(labelHead);
        panel1.add(labelParagraph);

        panel1.add(new JLabel("Firstname: "));
        panel1.add(firstnameTxt);
        panel1.add(new JLabel("Lastname: "));
        panel1.add(lastnameTxt);
        panel1.add(OKButton1);

        this.add(panel1);

        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ตั้งค่าให้ปิดหน้าต่างนี้ได้โดยไม่ปิดโปรแกรมหลัก
        this.setLocationRelativeTo(null); // ทำให้หน้าต่างอยู่กลางหน้าจอ

        OKButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Users user1 = new Users();
                    user1.setFirstname(firstnameTxt.getText());
                    user1.setLastname(lastnameTxt.getText());
                    Main.users.add(user1);
                    Main.index = Main.users.size() - 1;  // กำหนด index เพื่อให้ใช้ใน checkName
                    Main.checkName(Main.index);

                    FirstWindow.this.dispose();  // ปิดหน้าต่างหลังจากเพิ่มผู้ใช้สำเร็จ
                    PhysicalWindow physicalWindow = new PhysicalWindow();
                    physicalWindow.setVisible(true);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Please enter Firstname and Lastname");
                }
            }
        });
    }
}
