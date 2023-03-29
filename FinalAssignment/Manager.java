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
public class Manager extends Staff{
    ArrayList<Employee> list;
    String managerID;
    
    Manager(){
        list = new ArrayList();
        managerID = "";
    }

    // constructor
    public Manager(String managerID, String name, String phone, String gender, String address, int workDates, Double salary) {
        super(name, phone, gender, address, workDates, salary);
        this.managerID = managerID;
    }
    
    // This method use to compare with other by ID
    public Manager(String managerID){
        this.managerID = managerID;
    }

    // getter/setter
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

    
    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    @Override
    public String toString() {
        return "\n      " +"Manager ID = " + this.managerID + super.toString(); 
    }

    @Override
    public boolean equals(Object obj) {
        return this.managerID.equals(((Manager) obj).getManagerID());
    }

    public void input(String managerID) {
        this.managerID = managerID;
        super.input();
    }
    
    public void addEmployee(Employee emp){
        if(!list.contains(emp)){
            list.add(emp);
            System.out.println("Add sucess employee '" + emp.getName() +"' to manager '" + this.name +"'");
        }else{
            System.out.println("This employee already manage by " + this.name);
        }
    }
    
    public void removeEmployee(Employee emp){
        if(list.contains(emp)){
            list.remove(emp);
            System.out.println("Remove sucess");
        }else{
            System.out.println("Not Found!");
        }
    }
    
    public void showEmployeeList(){
        System.out.println("\nList of Employee managed by " + this.name);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}
