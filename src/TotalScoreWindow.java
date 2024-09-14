import javax.swing.*;
import java.awt.*;

public class TotalScoreWindow extends JFrame {
    private JPanel panel4;
    private JTextField nameTxt;
    private JTextField surnameTxt;
    private JTextField practiceTxt;
    private JLabel labelHead;
    private JLabel firstnamelabel;
    private JLabel lastnamelabel;
    private JLabel resultscore;
    private String firstname;
    private String lastname;

    public TotalScoreWindow(String physicalResult, int theoryScore, String theoryResult, String firstname, String lastname) {
        super("ผลการประเมินการทดสอบ");
        this.firstname = firstname;
        this.lastname = lastname;

        // Initialize panel
        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(10, 2));
        panel4.add(labelHead);

        // Create JLabel and JTextField for displaying the name and surname
        panel4.add(firstnamelabel);
        nameTxt = new JTextField(firstname);
        panel4.add(nameTxt);
        nameTxt.setEditable(false);  // Set text field to non-editable

        panel4.add(lastnamelabel);
        surnameTxt = new JTextField(lastname);
        panel4.add(surnameTxt);
        surnameTxt.setEditable(false);  // Set text field to non-editable

        // Add name and surname to panel


        // Create and add result label and text field
        panel4.add(resultscore);
        practiceTxt = new JTextField(theoryResult);
        practiceTxt.setEditable(false);

        panel4.add(resultscore);
        panel4.add(practiceTxt);

        // Add panel to the frame
        this.add(panel4);
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }


}
