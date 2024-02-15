import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class EmployeeRead extends JFrame {
    private JTable table;

    public EmployeeRead() throws CsvValidationException, IOException {
    	String csvFile = "Employee_Records.csv";
    	CSVReader reader = new CSVReader(new FileReader(csvFile));
        setTitle("PH MOTOR EMPLOYEE RECORDS");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Employee Name");
        model.addColumn("Id");
        model.addColumn("DOB");
        model.addColumn("Address");
        model.addColumn("Contact Number");
        model.addColumn("Position");
        model.addColumn("SL Credits");
        model.addColumn("VL Credits");
        model.addColumn("Salary");

        String[] line;
        reader.readNext();
        while ((line = reader.readNext()) != null) {
        	model.addRow(line);
        }
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
					new EmployeeRead();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CsvValidationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
}