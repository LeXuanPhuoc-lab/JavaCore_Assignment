/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Using;

import Build.*;


/**
 *
 * @author Phuoc
 */
public class Main {
    public static void main(String[] args) {
        CompanyManagement cm = new CompanyManagement();
        String[] mainMenu = {"COMPANY","CHAIRMEN",
            "MANAGER","EMPLOYEE",
            "OTHER FUNCTION","QUIT"};
        int choice = 0;
        do{
            choice = Utils.getChoice(mainMenu);
            
            switch(choice){
                case 1:
                    if(cm.checkCompanyInfo()){
                        String[] companyMenu = {"Add Company Info","Quit"};
                        int choice1 = 0;
                        do{
                            choice1 = Utils.getChoice(companyMenu);
                            switch(choice1){
                                case 1:
                                    cm.createCompanyInfo();
                                    break;
                            }
                        }while(choice1<companyMenu.length);
                    }else{
                        System.out.println("Company Info Already Exist!");
                        break;
                    }
                    break;
                    
                case 2:
                    String[] chairmenMenu = {"Add Chairmen","Search Chairmen",
                        "Remove Chairmen","Update Chairmen",
                        "Print Chairmen List","Quit"};
                    
                    int choice2 = 0;
                    do{
                        choice2 = Utils.getChoice(chairmenMenu);
                        
                        switch(choice2){
                            case 1:
                                cm.createChairmen();
                                break;
                            case 2:
                                cm.searchChairmen();
                                break;
                            case 3:
                                cm.removeChairmen();
                                break;
                            case 4:
                                cm.updateChairmen();
                                break;
                            case 5:
                                cm.showChairmenList();
                                break;
                        }
                    }while(choice2<chairmenMenu.length);
                    break;
                    
                case 3:
                    String[] managerMenu = {"Add Manager","Set Manager Role","Search Manager",
                        "Remove Manager","Update Manager",
                        "Print Manager List","Print Employees of Manager","Quit"};
                    
                    int choice3 = 0;
                    do{
                        choice3 = Utils.getChoice(managerMenu);
                        
                        switch(choice3){
                            case 1:
                                cm.createManager();
                                break;
                            case 2:
                                cm.setManagerRole();
                                break;
                            case 3:
                                cm.searchManager();
                                break;
                            case 4:
                                cm.removeManager();
                                break;
                            case 5:
                                cm.updateManager();
                                break;
                            case 6:
                                cm.showManagerList();
                                break;
                            case 7:
                                cm.showEmployeeofManager();
                                break;
                        }
                    }while(choice3<managerMenu.length);
                    break;
                    
                case 4:
                    String[] employeeMenu = {"Add Employee","Search Employee",
                        "Remove Employee","Update Employee",
                        "Print Employee List","Quit"};
                    
                    int choice4 = 0;
                    do{
                        choice4 = Utils.getChoice(employeeMenu);
                        
                        switch(choice4){
                            case 1:
                                cm.createEmployee();
                                break;
                            case 2:
                                cm.searchEmployee();
                                break;
                            case 3:
                                cm.removeEmployee();
                                break;
                            case 4:
                                cm.updateEmployee();
                                break;
                            case 5:
                                cm.showEmployeeList();
                                break;
                        }
                    }while(choice4<employeeMenu.length);
                    break;
                    
                case 5:
                    String[] othersMenu = {"Add Employee to Manager","Print all Staff in Company", 
                        "Total Company Salary", "Find Employee with Highest Salary","Find Manager with most Employee","Quit"};
                    int choice5 = 0;
                    
                    do{
                        choice5 = Utils.getChoice(othersMenu);
                        
                        switch(choice5){
                            case 1:
                                cm.addEmployeetoManager();
                                break;
                            case 2:
                                cm.showAllStaff();
                                break;
                            case 3:
                                cm.showAllStaffSalary();
                                break;
                            case 4:
                                cm.findHighestEmployeeSalary();
                                break;
                            case 5:
                                cm.findManagerwithMostEmployee();
                                break;
                        }
                    }while(choice5<othersMenu.length);
                    break;
            }
        }while(choice < mainMenu.length);
    }
}
