/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Build;

/**
 *
 * @author Phuoc
 */
public interface I_Function {
    void createCompanyInfo();
    void showCompanyInfo();
    boolean checkCompanyInfo();
    
    void createChairmen();
    void showChairmenList();
    void searchChairmen();
    void removeChairmen();
    void updateChairmen();
    
    void createManager();
    void setManagerRole();
    void showManagerList();
    void searchManager();
    void removeManager();
    void updateManager();
    
    void createEmployee();
    void showEmployeeList();
    void searchEmployee();
    void removeEmployee();
    void updateEmployee();
    
    void addEmployeetoManager();
    void showEmployeeofManager();
    
    void showAllStaff();
    void showAllStaffSalary();
    
    void findHighestEmployeeSalary();
    void findManagerwithMostEmployee();
}
