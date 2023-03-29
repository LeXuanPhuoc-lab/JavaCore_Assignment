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
public class ChairmenList {
    ArrayList<Chairmen> list;
    Chairmen cmenTmp;
    int index;
    
    public ChairmenList(){
        list = new ArrayList();
    }
    
    public void showChairmenList(){
        System.out.println("-------------------------------------- ChaimenList --------------------------------------------\n");
        for (Chairmen chairmen : list) {
            System.out.println(chairmen);
        }
    }
    
    public String createChairmenID(){
        String result = "";
        int countEle = list.size();
        if(countEle ==0){
            result =  "C0001";
        }else{
            int index = list.size()-1;
            String getString = list.get(index).getChairmenID();
            Pattern p = Pattern.compile("[^w][^0]");
            Matcher m = p.matcher(getString);
            
            String tmp = "";
            int num = 0;
            while(m.find()){
                tmp = m.group();
                num = Integer.parseInt(tmp);
            }
            result = String.format("C%04d", num+1);
        }
        return result;
    }
    
    public void createChairmen( Float totalShare){
        cmenTmp = new Chairmen(createChairmenID(),totalShare);
        cmenTmp.input();
        index = list.indexOf(cmenTmp);
        if(index!=-1){
            System.out.println("Chairmen already exist!");
        }else{
            list.add(cmenTmp);
            System.out.println("Add sucess");
            
            // cant continue to create chairmen cause of totalShare must be check from Company share
        }
    }
    
    public Chairmen searchChairmen(){
        String chairmenID = Utils.getString("Enter chairmen ID to search[Cxxxx]", "[Cc][0-9]{4}").toUpperCase();
        for (Chairmen ch : list) {
            if(ch.getChairmenID().equals(chairmenID)){
                return ch;
            }
        }
        return null;
    }
    
    public void updateChairmen(){
        String chairmenID = Utils.getString("Enter chairmen ID to update[Cxxxx]", "[Cc][0-9]{4}").toUpperCase();
        cmenTmp = new Chairmen(chairmenID);
        index = list.indexOf(cmenTmp);
        if(index==-1){
            System.out.println("Not found!");
        }else{
            list.get(index).input();
            System.out.println("Update sucess");
        }
    }
    
    public Chairmen removeChairmen(){
        Chairmen result = null;
        String chairmenID = Utils.getString("Enter chairmen ID to remove[Cxxxx]", "[Cc][0-9]{4}").toUpperCase();
        cmenTmp = new Chairmen(chairmenID);
        index = list.indexOf(cmenTmp);
        if(index==-1){
            System.out.println("Not found!");
        }else{
            result = list.get(index);
            list.remove(index);
            System.out.println("Remove sucess");
        }
        return result;
    }
    
    public double getChairmenListSalary(){
        double result = 0;
        for (Chairmen chairmen : list) {
            result += chairmen.getSalary();
        }
        return result;
    }
}
