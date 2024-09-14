import DBConnect.SaveUser;

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
    private JLabel labelName;
    private JLabel labelLast;

    public FirstWindow() {
        super("Driver License");
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(10, 10));
        firstnameTxt = new JTextField();
        lastnameTxt = new JTextField();
        OKButton1 = new JButton("OK");

        panel1.add(labelHead);
        panel1.add(labelParagraph);

        panel1.add(labelName);
        panel1.add(firstnameTxt);
        panel1.add(labelLast);
        panel1.add(lastnameTxt);
        panel1.add(OKButton1);

        this.add(panel1);

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ตั้งค่าให้ปิดหน้าต่างนี้ได้โดยไม่ปิดโปรแกรมหลัก
        this.setLocationRelativeTo(null); // ทำให้หน้าต่างอยู่กลางหน้าจอ

        OKButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    // ดึงค่าจาก textfield
                    String firstname = firstnameTxt.getText();
                    String lastname = lastnameTxt.getText();

                    //ตรวจสอบว่าผู้ใช้ทำการกรอกชื่อและนามสกุลหรือไม่
                    if(firstname.isEmpty() || lastname.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter Firstname and Lastname");
                    }

                    SaveUser.saveUser(firstname,lastname);

                    FirstWindow.this.dispose();

                    PhysicalWindow physicalWindow = new PhysicalWindow(firstname,lastname);
                    physicalWindow.setVisible(true);




                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        });
    }

    private void saveToDatabase(String firstname,String lastname){


    }
}
