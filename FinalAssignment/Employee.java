/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Build;

import java.util.ArrayList;

/**
 *
 * @author Phuoc
 */
public class Employee extends Staff{
    String employeeID;
    Manager manager;
    
    Employee(){
    }

    // constructors
    public Employee(String employeeID, String name, String phone, String gender, String address, int workDates, Double salary) {
        super(name, phone, gender, address, workDates, salary);
        this.employeeID = employeeID;
    }

    public Employee(String employeeID, String name, String phone, String gender, String address, int workDates, Double salary, Manager manager) {
        super(name, phone, gender, address, workDates, salary);
        this.employeeID = employeeID;
        this.manager = manager;
    }
    
    // this constructors use to compare
    public Employee(String employeeID){
        this.employeeID = employeeID;
    }
    
    // getter/setter

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWorkDates() {
        return workDates;
    }

    public void setWorkDates(int workDates) {
        this.workDates = workDates;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Manager getManager() {
        return manager;
    }

    public void addManager(Manager manager) {
        this.manager = manager;
    }
    
    public void input(String EmployeeID) {
        this.employeeID = EmployeeID;
        super.input(); 
    }
  
    @Override
    public String toString() {
        return "\n      "+"Employee ID = " + this.employeeID + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return this.employeeID.equals(((Employee) obj).getEmployeeID());
    }
}
