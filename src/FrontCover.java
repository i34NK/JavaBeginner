import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontCover extends JFrame {
    private JPanel panel0;
    private JButton nextButton;
    private JLabel head;

    public FrontCover() {
        super("Driver License");

        // Initialize components
        panel0 = new JPanel();
        panel0.setLayout(new BorderLayout());

        // Create and style the header
        panel0.add(head);

        // Create and style the next button
        panel0.add(nextButton);
        nextButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        nextButton.setPreferredSize(new Dimension(100, 40));
        nextButton.setBackground(Color.LIGHT_GRAY);
        nextButton.setFocusPainted(false);

        panel0.add(head, BorderLayout.NORTH);
        panel0.add(nextButton, BorderLayout.SOUTH);

        panel0.setBackground(Color.WHITE);

        this.add(panel0);

        // Set window properties
        this.setSize(500, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstWindow firstWindow = new FirstWindow();
                firstWindow.setVisible(true);
                FrontCover.this.dispose();
            }
        });
    }


}
