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
public class ManagerList {
    ArrayList<Manager> list;
    Manager mnTmp;
    int index;
    
    public ManagerList(){
        list = new ArrayList();
    }
    
    public void showManagerList(){
        System.out.println("-------------------------------------- ManagerList--------------------------------------------\n");
        for (Manager manager : list) {
            System.out.println(manager);
        }
    }
    public String createManagerID(){
        String result = "";
        int countEle = list.size();
        if(countEle==0){
            result = "M0001";
        }else{
            int index = list.size()-1;
            String getString = list.get(index).getManagerID();
            
            Pattern p = Pattern.compile("[^w][^0]");
            Matcher m = p.matcher(getString);
            
            String tmp = "";
            int num = 0;
            while(m.find()){
                tmp = m.group();
                num = Integer.parseInt(tmp);
            }
            result = String.format("M%04d", num+1);
        }
        return result;
    }
    
    public void createManager(){
        mnTmp = new Manager();
        mnTmp.input(createManagerID());
        index = list.indexOf(mnTmp);
        if(index!=-1){
            System.out.println("Manager already exist");
        }else{
            list.add(mnTmp);
            System.out.println("Add success");
            
            String getYesNo = Utils.getYesNo("Continue to create Manager (Yes/No)?");
            if(getYesNo.equalsIgnoreCase("Yes")){
                createManager();
            }
        }
    }
    
    public Manager searchManager(){
        String managerID = Utils.getString("Enter manager ID to search[Mxxxx]", "[Mm][0-9]{4}").toUpperCase();
        for (Manager manager : list) {
            if(manager.getManagerID().equals(managerID)){
                return manager;
            }
        }
        return null;
    }
    
    public void updateManager(){
        String managerID = Utils.getString("Enter manager ID to update[Mxxxx]", "[Mm][0-9]{4}").toUpperCase();
        for (Manager manager : list) {
            if(manager.getManagerID().equals(managerID)){
                manager.input();
            }
        }
    }
    
    public Manager removeManager(){
        Manager result = null;
        String managerID = Utils.getString("Enter manager ID to remove[Mxxxx]", "[Mm][0-9]{4}").toUpperCase();
        for (Manager manager : list) {
            if(manager.getManagerID().equals(managerID)){
                list.remove(manager);
                result = manager;
            }
        }
        return result;
    }
    
    public void addEmployeetoManager(Employee emp, Manager mn){
        mn.addEmployee(emp);
    }
    
    public double getManagerListSalary(){
        double result = 0;
        for (Manager manager : list) {
            result+= manager.getSalary();
        }
        return result;
    }
    
    public boolean setRole(Employee emp){
            if(emp!=null){
                Manager mnTmp = emp.manager;

                String managerID = createManagerID();
                String name = emp.name;
                String phone = emp.phone;
                String gender = emp.gender;
                String address = emp.address;
                int workDates = emp.workDates;
                double salary = emp.salary;

                if(mnTmp==null){
                    list.add(new Manager(managerID, name, phone, gender, address, workDates, salary));
                    return true;
                }else{
                    System.out.println("This Employee is managed by " + mnTmp.managerID);
                    String getYesNo = Utils.getYesNo("Do you want to remove manager '" + mnTmp.name +"' of new Manager " + emp.employeeID);
                    if(getYesNo.equalsIgnoreCase("No")){
                       list.add(new Manager(managerID, name, phone, gender, address, workDates, salary));
                       return true;
                    }
                }
            }else{
                System.out.println("Not Found!");
            }
            return false;
    }
}
