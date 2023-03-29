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
public class Company {
    String companyName;
    String taxCode;
    Double monthIncome;
    Float totalShare;
    
    Company(){
    }
    
    // construtors
    public Company(String companyName, String taxCode, Double monthIncome) {
        this.companyName = companyName;
        this.taxCode = taxCode;
        this.monthIncome = monthIncome;
        this.totalShare = new Float(String.format("%f",1.0));
    }

    // getter/ setter
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Double getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(Double monthIncome) {
        this.monthIncome = monthIncome;
    }

    public Float getTotalShare() {
        return totalShare;
    }

    public void setTotalShare(Float totalShare) {
        this.totalShare = totalShare;
    }

    // print Company info
    @Override
    public String toString() {
        return "\n      " + "Company name = " + this.companyName 
                + "; Tax code = " + this.taxCode
                + "; Month income = " + String.format("%,.2f",this.monthIncome);
    }

    // get infomation for Company 
    public void input(){
        this.companyName = Utils.getString("Enter company name", "^[a-zA-Z ]+$");
        this.taxCode = Utils.getString("Enter tax code", "^[a-zA-Z_0-9 ]+$");
        this.monthIncome = Utils.getSalary("Enter month income");
        this.totalShare = new Float(String.format("%f",1.0));
    }
}
