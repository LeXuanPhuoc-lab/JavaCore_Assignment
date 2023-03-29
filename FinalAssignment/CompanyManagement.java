/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Build;

/**
 *
 * @author Phuoc
 */
public class CompanyManagement implements I_Function{
    Company company;
    ChairmenList chList;
    EmployeeList empList;
    ManagerList mnList;

    public CompanyManagement() {
        company = new Company();
        chList = new ChairmenList();
        empList = new EmployeeList();
        mnList = new ManagerList();
    }

    @Override
    public void createCompanyInfo() {
        company.input();
    }

    @Override
    public void showCompanyInfo(){
        System.out.println(company);
    }
    
    @Override
    public boolean checkCompanyInfo(){
        return company.companyName == null;
    }
    
    @Override
    public void createChairmen() {
        // if currentShareTotal > 0 --> share > 0%
        Float currentShareTotal = company.getTotalShare();
        
        // Chairmen in company may not have share
        // Enter 0 if chairmen dont have company share
        Float getshareTotal = Utils.getShareTotal("Enter share total");
        
        // check company share total, if > 0 we can set share for chairmen
        Float count = currentShareTotal - getshareTotal;
        
        if(count >=0){
            // substract curr share total and set back to Company share
            currentShareTotal -= getshareTotal;
            company.setTotalShare(currentShareTotal);
            // create a chair men with/without share total
            // if getShareTotal = 0 --> this chairmen dont have share
             chList.createChairmen(getshareTotal);
        }else{
            System.out.println("Create fail, This chairmen cant have share in a company");
        }
    }

    @Override
    public void showChairmenList() {
        chList.showChairmenList();
    }

    @Override
    public void searchChairmen() {
        var ch = chList.searchChairmen();
        if(ch!=null){
            System.out.println(ch);
        }else{
            System.out.println("Not Found!");
        }
    }

    @Override
    public void removeChairmen() {
        chList.removeChairmen();
    }

    @Override
    public void updateChairmen() {
        chList.updateChairmen();
    }

    @Override
    public void createManager() {
        mnList.createManager();
    }

    @Override
    public void setManagerRole(){
        var emp= empList.searchEmployee();
        boolean check = mnList.setRole(emp);
        if(check){
            empList.list.remove(emp);
            System.out.println("Set Role Sucess");
        }else{
            System.out.println("Set Role Fail");
        }
    }
    
    @Override
    public void showManagerList() {
        mnList.showManagerList();
    }

    @Override
    public void searchManager() {
        var mn = mnList.searchManager();
        if(mn!=null){
            System.out.println(mn);
        }else{
            System.out.println("Not Found!");
        }
    }

    @Override
    public void removeManager() {
        Manager mn = mnList.removeManager();
        
        if(mn!=null){
            // remove all Manager hold by employee
            for (Employee employee : empList.list) {
                if(employee.getManager().equals(mn)){
                    employee.manager = null;
                }
            }
        }else{
            System.out.println("Not Found!");
        }
    }

    @Override
    public void updateManager() {
        mnList.updateManager();
    }

    @Override
    public void createEmployee() {
        empList.createEmployee();
    }

    @Override
    public void showEmployeeList() {
        empList.showEmployeeList();
    }

    @Override
    public void searchEmployee() {
       var emp = empList.searchEmployee();
        if(emp!=null){
            System.out.println(emp);
        }else{
            System.out.println("Not Found!");
        }
    }

    @Override
    public void removeEmployee() {
        var emp = empList.removeEmployee();
        if(emp==null){
            System.out.println("Not Found!");
        }
    }

    @Override
    public void updateEmployee() {
        empList.updateEmployee();
    }
    
    // add a Employee for a Manager
    @Override
    public void addEmployeetoManager() {
        Employee emp = empList.searchEmployee();
        Manager mn = mnList.searchManager();
        if(emp!=null && mn!=null){
            // add manager for employee
            emp.addManager(mn);
            // add employee for manager
            mnList.addEmployeetoManager(emp, mn);
        }else{
            System.out.println("Not found!, please check ID again");
        }
    }

    // Display all employees of Manger
    @Override
    public void showEmployeeofManager() {
        Manager mn = mnList.searchManager();
        if(mn!=null){
            mn.showEmployeeList();
        }
    }

    // Display all Staff in a company
    @Override
    public void showAllStaff() {
        chList.showChairmenList();
        mnList.showManagerList();
        empList.showEmployeeList();
    }

    @Override
    public void showAllStaffSalary() {
        System.out.println("Total Chairmens Salary = " + chList.getChairmenListSalary());
        System.out.println("Total Managers Salary = " + mnList.getManagerListSalary());
        System.out.println("Total Employees Salary = " + empList.getEmployeeListSalary());
        double totalSalary = chList.getChairmenListSalary() + mnList.getManagerListSalary()+empList.getEmployeeListSalary();
        System.out.println("Total Company Salary = " + totalSalary);
    }

    @Override
    public void findHighestEmployeeSalary() {
        Employee result = empList.list.get(0);
        for (Employee emp : empList.list) {
            if(result.getSalary() < emp.getSalary()){
                result = emp; 
            }
        }
        System.out.println("Employee with Highest Salary");
        System.out.println(result);
    }

    @Override
    public void findManagerwithMostEmployee() {
        Manager result = mnList.list.get(0);
        int max = result.list.size();
        for (Manager mn : mnList.list) {
            if(max < mn.list.size()){
                result = mn;
            }
        }
    }
    
    
}
