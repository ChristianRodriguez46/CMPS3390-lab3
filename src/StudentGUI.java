import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI {
    private JPanel panel;
    private JList studentList;
    private JLabel labelFirstName;
    private JTextField inputFirstName;
    private JTextField inputLastName;
    private JTextField inputStudentID;
    private JLabel labelLastName;
    private JLabel labelStudentID;
    private JButton addStudentButton;
    private JButton removeStudentButton;

    public StudentGUI() {
        // Let the JList hold items we can add/remove
        studentList.setModel(new DefaultListModel());

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String first = inputFirstName.getText().trim();
                String last  = inputLastName.getText().trim();
                String id    = inputStudentID.getText().trim();

                // If any box is blank, do nothing
                if (first.isEmpty() || last.isEmpty() || id.isEmpty()) return;

                // Make one string and add it to the list
                String entry = first + " " + last + " " + id;
                ((DefaultListModel) studentList.getModel()).addElement(entry);

                // Clear all three text fields
                inputFirstName.setText("");
                inputLastName.setText("");
                inputStudentID.setText("");
            }
        });
        removeStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = studentList.getSelectedIndex(); // which row is selected?
                if (i == -1) return;                    // nothing selected → stop
                ((DefaultListModel) studentList.getModel()).removeElementAt(i); // remove it
            }
        });
    }

    // Start the app
    public static void main(String[] args) {
        JFrame f = new JFrame();  // creates a window.
        f.setContentPane(new StudentGUI().panel);  // show your panel on launch
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // end process on close
        f.pack();                                   // size window to fit contents
        f.setVisible(true);                         // make it visible
    }
}
