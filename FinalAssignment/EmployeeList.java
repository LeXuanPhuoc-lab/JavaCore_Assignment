/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Build;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Phuoc
 */
public class EmployeeList {
    ArrayList<Employee> list;
    Employee empTest;
    int index;
    
    public EmployeeList(){
        list = new ArrayList();
    }
    
    // show All Employee
    public void showEmployeeList(){
        System.out.println("-------------------------------------- EmployeeList --------------------------------------------\n");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
    
    // create increasing Employee ID
    public String createEmployeeID(){
        String result = "";
        int countEle = list.size();
        if(countEle==0){
            result =  "E0001";
        }else{
            // get last employee ID to create new ID by oldID + 1
            int index = list.size()-1;
            String getString = list.get(index).getEmployeeID();
            
            // compile "[^w^0]" to be pattern and use Matcher instance to
            // find Element match pattern
            Pattern p = Pattern.compile("[^w][^0]");
            Matcher m = p.matcher(getString);
            
            // group all element found
            String tmp = "";
            int num = 0;
            while(m.find()){
                System.out.println(tmp);
                tmp = m.group();
                num = Integer.parseInt(tmp);
            }
            // format a num to a String "Exxxx" with x is 3 number 0 and the other are num + 1
            result = String.format("E%04d", num+1);
        }
        return result;
    }
    
    public void createEmployee(){
        empTest = new Employee();
        empTest.input(createEmployeeID());
        index = list.indexOf(empTest);
        if(index!=-1){
            System.out.println("Employee already exist");
        }else{
            list.add(empTest);
            System.out.println("Add sucess");
            
            String getYesNo = Utils.getYesNo("Continue to create Employee (Yes/No)?");
            if(getYesNo.equalsIgnoreCase("Yes")){
                createEmployee();
            }
        } 
    }
    
    public Employee searchEmployee(){
        String employeeID = Utils.getString("Enter employee ID to search[Exxxx]", "[Ee][0-9]{4}").toUpperCase();
        for (Employee employee : list) {
            if(employee.getEmployeeID().equals(employeeID)){
                return employee;
            }
        }
        return null;
    }
    
    public Employee removeEmployee(){
        Employee result = null;
        String employeeID = Utils.getString("Enter employee ID to remove[Exxxx]", "[Ee][0-9]{4}").toUpperCase();
        for (Employee employee : list) {
            if(employee.getEmployeeID().equals(employeeID)){
                result = employee;
                list.remove(employee);
            }
        }
        return result;
    }
    
    public void updateEmployee(){
        String employeeID = Utils.getString("Enter employee ID to update[Exxxx]", "[Ee][0-9]{4}").toUpperCase();
        for (Employee employee : list) {
            if(employee.getEmployeeID().equals(employeeID)){
                employee.input();
            }
        }
    }
    
    public double getEmployeeListSalary(){
        double result = 0;
        for (Employee employee : list) {
            result += employee.getSalary();
        }
        return result;
    }
}
    
