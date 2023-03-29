/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Build;

/**
 *
 * @author Phuoc
 */
public class Staff {
    String name;
    String phone;
    String gender;
    String address;
    int workDates;
    Double salary;
    
    Staff(){
    }

    // constructors
    public Staff(String name, String phone, String gender, String address, int workDates, Double salary) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.workDates = workDates;
        this.salary = salary;
    }

    // gettter/ setter
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

    public int getWorkDates() {
        return this.workDates;
    }

    public void setWorkDates(int workDates) {
        this.workDates = workDates;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double Salary) {
        this.salary = Salary;
    }

    //  print info
    @Override
    public String toString() {
        return "; Name = " + this.name
                + "; Gender = " + this.gender 
                + "; Phone = " + this.phone 
                + "; Address = " + this.address 
                + "; Work dates = " + this.workDates 
                + "; Salary = " + String.format("%,.2f",this.salary);
    }
    
    //  get a basic infomation
    public void input(){
        this.name = Utils.getString("Enter name", "^[a-zA-Z ]+$").toUpperCase();
        this.gender = Utils.getString("Enter gender(m/f)", "[mMfF]").toUpperCase();
        this.phone = Utils.getPhone("Enter phone");
        this.address = Utils.getString("Enter address", "(.)+").toUpperCase();
        this.workDates = Utils.getInt("Enter work day", 1, 31);
        this.salary = Utils.getSalary("Enter salary");
    }
}
