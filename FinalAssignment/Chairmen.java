/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Build;

/**
 *
 * @author Phuoc
 */
public class Chairmen extends Staff{
    String chairmenID;
    Float shareTotal;
    
    Chairmen(){
    }

    // constructors
    public Chairmen(String chairmenID,String name, String phone, String gender, String address, int workDates, Double salary,Float shareTotal) {
        super(name, phone, gender, address, workDates, salary);
        this.chairmenID = chairmenID;
        this.shareTotal = shareTotal;
    }

    public Chairmen(String chairmenID, Float shareTotal) {
        this.chairmenID = chairmenID;
        this.shareTotal = shareTotal;
    }

    // this Constructors use for compare with other Chairmen
    public Chairmen(String chairmenID) {
        this.chairmenID = chairmenID;
    }

    // getter/setter
    public String getChairmenID() {
        return chairmenID;
    }

    public void setChairmenID(String chairmenID) {
        this.chairmenID = chairmenID;
    }

    public Float getShareTotal() {
        return shareTotal;
    }

    public void setShareTotal(Float shareTotal) {
        this.shareTotal = shareTotal;
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

    @Override
    public String toString() {
        return "\n      " +"Chairmen ID = " + this.chairmenID + super.toString() + "; Total share = " + this.shareTotal*100 + "%"; 
    }

    
    // compare with other chairmen by ID and return true if ID equals
    @Override
    public boolean equals(Object obj) {
        return this.chairmenID.equals(((Chairmen) obj).getChairmenID());
    }
    
    
    // get chairmen infomation
    public void input(String chairmenID, Float shareTotal){
        this.chairmenID = chairmenID;
        super.input(); 
        this.shareTotal = shareTotal;
    }
}
