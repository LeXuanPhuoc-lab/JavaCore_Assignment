/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Build;

import java.util.Scanner;

/**
 *
 * @author Phuoc
 */
public class Utils {
    public static int getInt(String msg){
        while(true){
            try{
                System.out.print(msg + ": ");
                Scanner sc = new Scanner(System.in);
                int num = Integer.parseInt(sc.nextLine());
                if(num>0) return num;
                else System.out.println("Error, wrong format!");
            }catch(NumberFormatException e){
                System.out.println(e);
            }
        }
    }
    
    public static int getInt(String msg, int min, int max){
        while(true){
            try{
                System.out.print(msg + ": ");
                Scanner sc = new Scanner(System.in);
                int num = Integer.parseInt(sc.nextLine());
                if(num>=min && num<=max) return num;
                else System.out.println("Error, wrong format!");
            }catch(NumberFormatException e){
                System.out.println("Error, please input number!");
            }
        }
    }
    
    public static String getString(String msg, String pattern){
        String result = "";
        boolean check = false;
        do{
            System.out.print(msg + ": ");
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine();
            if(!tmp.isEmpty() && tmp.matches(pattern)){
                result = tmp;
                check = true;
            } 
            else System.out.println("Error, wrong format!");
        }while(!check);
        return result;
    }
    
    public static double getSalary(String msg){
        while(true){
            try{
                System.out.print(msg + ": ");
                Scanner sc = new Scanner(System.in);
                double result = Double.parseDouble(sc.nextLine());
                if(result > 0) return result;
                else System.out.println("Error, wrong format!");
            }catch(NumberFormatException e){
                System.out.println("Error, please input number!");
            }
        }
    }
    
    public static String getPhone(String msg){
        String pattern = "[0-9]{10,12}";
        String result = "";
        boolean check = false;
        do{
            System.out.print(msg + ": ");
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine();
            if(!tmp.isEmpty() && tmp.matches(pattern)){
                result = tmp;
                check = true;
            }else{
                System.out.println("Error, wrong format!");
            }
        }while(!check);
        return result;
    }
    
    public static float getShareTotal(String msg){
        while(true){
            try{
                System.out.print(msg + ": ");
                Scanner sc = new Scanner(System.in);
                double tmp = Double.parseDouble(sc.nextLine());
                if(tmp < 100) return ((float)tmp/100);
                else{
                    System.out.println("Error, Share must greater than 0");
                }
            }catch(NumberFormatException e){
                System.out.println("Error, please input number!");
            }
        }
    }
    
    public static String getYesNo(String msg){
        while(true){
            System.out.print(msg + ": ");
            Scanner sc = new Scanner(System.in);
            String result = sc.nextLine();
            if(result.equalsIgnoreCase("Yes") || result.equalsIgnoreCase("No")){
                return result;
            }else{
                System.out.println("Error, please input (Yes/No)");
            }
        }
    }
    
    public static int getChoice(String[] str){
        for (int i = 0; i < str.length; i++) {
            System.out.println((i+1)+"-"+str[i]);
        }
        System.out.println("Choose 1-" +str.length+":");
        while(true){
            try{
                Scanner sc = new Scanner(System.in);
                return Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Error, please input number!");
            }
        }
    }
}
