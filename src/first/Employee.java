// group 4 IT 103 computer programming 2
// Members: Wilson Co, Leoncio Pineda,
package first;

//import java.util.Date;
import java.util.Scanner;

public class Employee {

    private String name;
    private int employee_id;
    private String dob;
    private String address;
    private String contact_number;
    private String position;
    private int sl_Credits;
    private int vl_Credits;
    private int salary;
    private double witholdingTax;
    private double sssContri;
    private double philhealthContri;
    private double pagibigContri;
    private double netPay;
    
    // default constructor
    public Employee() {
        this.name = "";
        this.employee_id = 0;
        this.dob = "";
        this.address = "";
        this.contact_number = "";
        this.position = "";
      //standard sl and vl credits here in the Philippines, although it's management perogative and distinct per company.
        this.sl_Credits = 5;
        this.vl_Credits = 5;
        this.salary = 0;
        this.witholdingTax = 0;
        this.sssContri = 0;
        this.philhealthContri = 0;
        this.pagibigContri = 0;
        this.netPay = 0;

        
    }
    
    public Employee (String name, int id, String dob, String address, String number,
            String position, int sl_Credits, int vl_Credits, int salary) {
        this.name = name;
        this.employee_id = id;
        this.address = address;
        this.contact_number = number;
        this.position = position;
        this.sl_Credits = sl_Credits;
        this.vl_Credits = vl_Credits;
        this.dob =  dob;
        this.salary = salary;
    }
    

    public void calculateContri() {
    	if (this.salary == 20000) {
    		// for 20,833 below the tax rate is 0%;
    		this.witholdingTax = 0;
    		// if compensation rate is equal or above 20k the contribution is 900php for employees.
    		this.sssContri = 900;
    		/* as per the declared computation table of Philhealth the premium rate for 2024 is 5% which is equally shared by the
    		 employee and employer.*/
    		this.philhealthContri = (this.salary*0.05)/2;
    		/* as per the declared computatoin formula of pag-ibig the rate is 0.02% for the contribution of each employees */
    		this.pagibigContri = this.salary*0.02;
    		
    	}
    	
    	else if (this.salary == 30000) {
    		this.witholdingTax = (30000-20833)*0.20;
    		this.sssContri = 900;
    		this.philhealthContri = (this.salary*0.05)/2;
    		this.pagibigContri = this.salary*0.02;
    	}
    	
    	else if (this.salary == 40000) {
    		this.witholdingTax = (40000-33333)*0.25 + 2500;
    		this.sssContri = 900;
    		this.philhealthContri = (this.salary*0.05)/2;
    		this.pagibigContri = this.salary*0.02;	
    	}
    	
    	else if (this.salary == 50000) {
    		this.witholdingTax = (50000-33333)*0.25 + 2500;
    		this.sssContri = 900;
    		this.philhealthContri = (this.salary*0.05)/2;
    		this.pagibigContri = this.salary*0.02;	
    	}
    	
    	else if (this.salary == 60000) {
    		this.witholdingTax = (60000-33333)*0.25 + 2500;
    		this.sssContri = 900;
    		this.philhealthContri = (this.salary*0.05)/2;
    		this.pagibigContri = this.salary*0.02;	
    	}
    	
    	else if (this.salary == 70000) {
    		this.witholdingTax = (70000-33333)*0.30 + 10833.33;
    		this.sssContri = 900;
    		this.philhealthContri = (this.salary*0.05)/2;
    		this.pagibigContri = this.salary*0.02;	
    	}
    	
    	else if (this.salary == 80000) {
    		this.witholdingTax = (80000-33333)*0.30 + 10833.33;
    		this.sssContri = 900;
    		this.philhealthContri = (this.salary*0.05)/2;
    		this.pagibigContri = this.salary*0.02;	
    	}
    	
    	this.netPay = this.salary - this.witholdingTax - this.sssContri - this.philhealthContri - this.pagibigContri;
    }

    // getters

    public String getName() {
        return name;
    }
    
    public int getId() {
        return employee_id;
    }
    
    public String getDate() {
        return dob;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getContactNumber() {
        return contact_number;
    }
    
    public String getPosition() {
        return position;
    }
    
    public int getSlCredits() {
        return sl_Credits;
    }
    
    public int getVlCredits() {
        return vl_Credits;
    }
    
    public int getSalary() {
    	return salary;
    }
    
    /*this.witholdingTax = 0;
    this.sssContri = 0;
    this.philhealthContri = 0;
    this.pagibigContri = 0;
    */
    public double getSss() {
    	return sssContri;
    }
    
    public double getphilhealthContri() {
    	return philhealthContri;
    }
    
    public double getpagibigContri() {
    	return pagibigContri;
    }
    
    public double getWitholdingTax() {
    	return witholdingTax;
    }

    public double getNetPay() {
    	return netPay;
    } 
    
    //setters
    //public Employee (String name, int id, String dob, String address, String number,
    //        String position, int sl_Credits, int vl_Credits)

    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(int id ) {
        this.employee_id = id;
    }
    
    public void setDate(String dob) {
        this.dob = dob;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setNumber(String number) {
        this.contact_number = number;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public void setSlCredits(int sl) {
        this.sl_Credits = sl;
    }
    
    public void setVlCredits(int vl) {
        this.vl_Credits = vl;
    }
    
    public void setSalary(int salary) {
    	this.salary = salary;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
       // @SuppressWarnings("resource")
        //Scanner user_input = new Scanner(System.in);
        //System.out.println("Enter the employee's name");
        
        //String employee_name = user_input.nextLine();
        //Employee firstEmployee = new Employee();
        //firstEmployee.setName(employee_name);
        //System.out.println(firstEmployee.getName());

    }

}