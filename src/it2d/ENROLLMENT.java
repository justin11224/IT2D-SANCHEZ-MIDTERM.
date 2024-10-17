package it2d;

import java.util.Scanner;

public class ENROLLMENT {
    

     public static void main(String[] args) {
       String response;
        do{ 
        Scanner sc=new Scanner(System.in);
        System.out.println("ADD ENROLLMENT");
        System.out.println("VIEW ENROLLMENT");
        System.out.println("UPDATE ENROLLMENT");
        System.out.println("DELETE ENROLLMENT");
        System.out.println("EXIT ENROLLMENT");
        
        System.out.print("Enter section: ");
        int action = sc.nextInt();
        ENROLLMENT ADDENROLLS=new ENROLLMENT();
        switch(action){
            
            case 1:
             
                
                ADDENROLLS.addENROLL();
                
            break;
            
            case 2:
                ADDENROLLS.viewENROLL();
                
            break;    
            
            case 3:
                ADDENROLLS.viewENROLL();
                ADDENROLLS.updateEmployee();
                ADDENROLLS.viewENROLL();
            break; 
            
            case 4:
                ADDENROLLS.viewENROLL();
                ADDENROLLS.deleteEmployee();
                ADDENROLLS.viewENROLL();
            break; 
                
        }
           System.out.print("do you want to continue? (yes or no)");
           response = sc.next();
  
       }while (response.equalsIgnoreCase("yes"));
        System.out.println("Thank you,see you!");
       }
    

    public void addENROLL() {
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Enrollment Date: ");
        String enrolld = sc.next();
        System.out.print("Status: ");
        String status = sc.next();
        System.out.print("Semester: ");
        String sem = sc.next();
        String sql = "INSERT INTO tbl_enrollment (e_enrolld, e_status, e_sem) VALUES (?, ?, ?)";
        config conf = new config();
        conf.addRecord(sql, enrolld, status, sem);
    }

    public void viewENROLL() {
        config conf = new config();
        String query = "SELECT * FROM tbl_enrollment";
        String[] headers = {"Employee_ID", "ENROLLMENT_DATE", "ENROLLMENT_STATUS","ENROLLMENT_SEMESTER"};
        String[] columns = {"e_id","e_enrolld", "e_status", "e_sem"};

        conf.viewRecords(query, headers, columns);
    }

    public void updateEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to update: ");
        int id = sc.nextInt();

        System.out.print("New Enrollment Date: ");
        String Nenrolld = sc.next();
        System.out.print("New Status: ");
        String Nstatus = sc.next();
        System.out.print("New Semester: ");
        String Nsem = sc.next();
        

        String qry = "UPDATE tbl_enrollment SET e_enrolld = ?, e_status = ?, e_sem = ? WHERE e_id = ?";
        config conf = new config();
        conf.updateRecord(qry, Nenrolld, Nstatus, Nsem, id); 
    }

    public void deleteEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_enrollment WHERE e_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}
