import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVFile extends JFrame implements ActionListener {
    private Container c;
    private JLabel title;
    private JLabel username;
    private JTextField tusername;
    private JLabel password;
    private JPasswordField tpassword;
    private JButton sub;
    private JLabel res;
    private EmployeeReadGUI employeeReadGUI;

    public CSVFile() {
        setTitle("Login Form");
        setBounds(300, 90, 600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Login Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        username = new JLabel("Username");
        username.setFont(new Font("Arial", Font.PLAIN, 20));
        username.setSize(100, 20);
        username.setLocation(100, 150);
        c.add(username);

        tusername = new JTextField();
        tusername.setFont(new Font("Arial", Font.PLAIN, 15));
        tusername.setSize(190, 20);
        tusername.setLocation(200, 150);
        c.add(tusername);

        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(100, 20);
        password.setLocation(100, 220);
        c.add(password);

        tpassword = new JPasswordField();
        tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tpassword.setSize(190, 20);
        tpassword.setLocation(200, 220);
        c.add(tpassword);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 300);
        sub.addActionListener(this);
        c.add(sub);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 350);
        c.add(res);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String usernameInput = tusername.getText();
        String passwordInput = String.valueOf(tpassword.getPassword());

        try {
            CSVReader reader = new CSVReader(new FileReader("Employee_Records.csv"));
            String[] nextLine;
            boolean isAuthenticated = false;

            while ((nextLine = reader.readNext()) != null) {
                // Check if nextLine has at least 16 elements before accessing indices 14 and 15
                if (nextLine.length >= 16 && nextLine[14].equals(usernameInput) && nextLine[15].equals(passwordInput)) {
                    isAuthenticated = true;
                    res.setText("Login Successful");
                    employeeReadGUI = new EmployeeReadGUI(nextLine);
                    break;
                }
            }
            if (!isAuthenticated) {
                res.setText("Login Failed");
            }
        } catch (IOException | CsvValidationException ex) {
            res.setText("Error occurred while reading the file.");
        }
    }

    public static void main(String[] args) {
        new CSVFile();
    }
}