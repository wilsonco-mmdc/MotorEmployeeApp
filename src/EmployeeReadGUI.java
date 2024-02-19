import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class EmployeeReadGUI extends JFrame {
    private JTable table;
    public EmployeeReadGUI() throws CsvValidationException, IOException {
    	String csvFile = "Employee_Records.csv";
    	CSVReader reader = new CSVReader(new FileReader(csvFile));
        setTitle("MOTOR PH EMPLOYEE RECORDS");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Table creation
        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Employee Name");
        model.addColumn("Id");
        model.addColumn("Date of Birth");
        model.addColumn("Address");
        model.addColumn("Mobile Number");
        model.addColumn("Position");
        model.addColumn("SL Credits");
        model.addColumn("VL Credits");
        model.addColumn("Gross Salary");
        model.addColumn("Witholding tax");
        model.addColumn("SSS");
        model.addColumn("PhilHealth");
        model.addColumn("Pag-ibig");
        model.addColumn("Net Salary");
        
        //SSS calculation 
        
        String[] line;
        //skip the first line
        reader.readNext();
        while ((line = reader.readNext()) != null) {
        	model.addRow(line);
        }
        //closing csvreader
        reader.close();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
					new EmployeeReadGUI();
				} catch (CsvValidationException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
}