
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Phuoc
 */
public class Main {
    public static int getInt(){
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
    
    public static String getString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    public static int getChoice(String[] str){
        for (int i = 0; i < str.length; i++) {
            System.out.println((i+1) + "-" + str[i]);
        }
        System.out.println("Choose 1-" + str.length+":");
        while(true){
            Scanner sc = new Scanner(System.in);
            int num = Integer.parseInt(sc.nextLine());
            if(num>0) return num;
        }
    }
    
    public static void KaraokePayment(){
        /**
         *  TINH TIEN KARAOKE
         */
        System.out.print("Input hours:  ");
        int h  = getInt(); 
        
        int money = 30000;
        double totalBill = 0;
        
        if(h>3){
            // if hour > 3 --> total = first 3 hour + 70% of 30.000/hour
            totalBill = 3*money + (h-3)*((money)*0.7);
        }else{
            // if hour = 3 --> total = first 3 hour
            totalBill = 3*money;
        }
        System.out.println("Total payment = " + totalBill);  
    }
    
    public static void Question1_2(){
        /**
         *  VE QUOC KY, DOI CO SO
         */
        
        /*System.out.println("  |* * * * * * * * * * =========================|\n" +
                                    "  | * * * * * * * * *  =========================|\n" +
                                    "  |* * * * * * * * * * =========================|\n" +
                                    "  | * * * * * * * * *  =========================|\n" +
                                    "  |* * * * * * * * * * =========================|\n" +
                                    "  | * * * * * * * * *  =========================|\n" +
                                    "  |* * * * * * * * * * =========================|\n" +
                                    "  |=============================================|\n" +
                                    "  |=============================================|\n" +
                                    "  |=============================================|\n" +
                                    "  |=============================================|\n" +
                                    "  |=============================================|\n" +
                                    "  |=============================================|");  */
        
        // convert num from radix 10 to 2 and opposite

        // covert num from radix 10 to 2
        System.out.print("Input number to covert from radix 10 to 2: ");
        int num = getInt();
        
        int sum = 0; 
        while(num>0){
            // (num%2) to get remainder and sum new remainder to prev (sum*10)
            sum = sum*10 + num%2;
            // num/2 until num = 0 --> out loop
            num = num / 2;
        }
        
        int result = 0; 
        // this loop will reverse previous result
        // return a radix converted number
        while(sum>0){
            // (num%10) to get remainder and sum new remainder to prev (sum*10)
            result =  result*10 + sum%10;
            // num/10 until num = 0 --> out loop
            sum = sum / 10;
        }
        System.out.println(result);

        // convert num from radix 2 to 10
        System.out.print("Input number to covert from radix 2 to 10: ");
        int num1 = getInt();
        int result1 = 0; int i = 0;
        while(num1>0){
            // (num%10) to get remainder and multiplication with 2^i ( i increase from 0 to num length )
            result1 += (num1%10)*Math.pow(2, i);
            // num/10 until num = 0 --> out loop
            num1 = num1/10;
            // increase i 
            i++;
        }
        System.out.println(result1); 
    }
    
    public static void Question3(){
        /**
         * CHECK JAVA VERSION
         */
        System.out.println("Java Version: 19.0.2\n" +
            "Java Runtime Version: 19.0.2+7-44\n" +
            "Java Home: C:\\Program Files\\Java\\jdk-19\n" +
            "Java Vendor: Oracle Corporation\n" +
            "Java Vendor URL: https://java.oracle.com/\n" +
            "Java Class Path: C:\\Users\\USER\\Documents\\NetBeansProjects\\JavaBackEndCourse\\target\\classes");

    }
    
    public static void Question4(){
        /**
         * TONG CAC SO TU NHIEN TU INPUT
         */
        System.out.print("Input num: ");
        int num = getInt();
        int result = 0;
        while(num>0){
            result += num%10;
            num = num/10;
        }
        System.out.println("Sum = " + result);
    }
    
    public static void Question5(){
        int[] arr =  new int[4];
        String[] str = {"Input x1","Input y1","Input x2", "Input y2"};
        System.out.println("Caculate length A(x1,y1) and B(x2,y2)");
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]+": ");
            arr[i] = getInt();
        }
        // caculate (x2-x1)^2
        double calc1 =  Math.pow((arr[2]-arr[0]), 2);
        // caculate (y2-y1)^2
        double calc2 =  Math.pow(arr[3]-arr[1], 2);
        // get sqrt of (calc1 + calc2)
        double result = Math.sqrt(calc2+calc1);
        System.out.println("|AB| = "+result);
    }
    
    public static void Question6(){
        System.out.print("Input string to reverse: ");
        String getString = getString();
        // split String to String array
        String[] str = getString.split("");
       
        System.out.print("String after reverse [" );
        for (int i = str.length-1; i >=0; i--) {
            System.out.print(str[i]);
        }
        System.out.print("]");
    }
    
    public static void Question7(){
        int num = getInt();
        int i = 2;
        System.out.print("Divisor of " + num +": ");
        for (; i <num; ++i) {
            if(num%i==0){
                System.out.print(i+" ");
            }
        }
    }
    
    public static void Question8(){
        System.out.print("Input a string want to uppercase first");
        String getString = getString();
        String newString = "";
        String[] str = getString.split(" ");
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].substring(0,1).toUpperCase() + str[i].substring(1);
        }
        for (int i = 0; i < str.length; i++) {
            newString += str[i]+" ";
        }
        System.out.println(newString);
    }
    
    public static void Question9(){
        System.out.println("Check duplicate");
        System.out.print("Input num1: ");
        int num1 = getInt();
        System.out.print("Input num2: ");
        int num2 = getInt();
        
        int[] arr = new int[4]; 
        
        int i = 0;
        while(num1>0){
            arr[i] = num1%10;
            arr[i+2] = num2%10;
            num1 = num1/10;
            num2 = num2/10;
            i++;
        }

        // sort an array
        for (int j = 0; j < arr.length-1; ++j) {
            for (int k = j+1; k < arr.length ; ++k) {
                if(arr[j]>arr[k]){
                    int tmp = arr[j];
                    arr[j] = arr[k];
                    arr[k] = tmp;
                }
            }
        }
        
        // check = true if has a duplicate value
        boolean check = false;
        for (int j = 0; j < arr.length-1; j++) {
            if(arr[j]==arr[j+1]){
                check = true;
            }
        }
        if(check==false) System.out.println("False");
        else System.out.println("True");
    }
    
    public static void Question10(){
        System.out.print("Input n to sum 1 to n: ");
        int n = getInt();
        int sum = 0;
        for (int i = 1; i <=n; i++) {
            sum+= i;
        }
        System.out.println("Total = " + sum);
    }
    
    public static double getPow(int x, int y){
        return Math.pow(x, y);
    }
    
    public static void Question11(){
        System.out.print("Input n: ");
        int n = getInt();
        
        for (int i = 0; i < n/2; i++) {
            // i is increasing overtime
            
            // if 2^i equal n then [MAX]num = i
            if(getPow(2, i) == (double)n){
                System.out.println("2^"+ i +" is equal with Floor[log2n]");
                System.out.println("==> [MAX]num < log2n = "+ (i));
                return;
                
                // x = floor[log2n]
                // check that 2^x < n and with any case that 2^x < log2n < 2^(x+1)
                // ==> x is the largest num that smaller than log2n
            }else if( ((double)n) > getPow(2, i) && ((double)n) < getPow(2, i+1)){
                System.out.println("2^"+ i +" is nearly equal with Floor[log2n]");
                System.out.println("==> [MAX]num < log2n = "+(i));
                return;
            }
        }
    }
    
    public static void Question12(){
        System.out.print("Input a num[1-9]: ");
        int n = getInt();
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.print("\n");
        }
    }
    
    public static void Question13() {
        
        String[] s = {"Input array length","Quit"};
        String[] str = {"Find average value",
            "Find max, min value",
            "Find negative max, min value",
            "Find postive max, min value",
            "Find odd, even value",
            "Add value by index",
            "Remove value by index",
            "Quit"
        };
        int choice = 0;
        do{
            // request to get a length and array element
           choice = getChoice(s);
           
           switch(choice){
               case 1:
                   System.out.print("Input n: ");
                   // get array length
                    int n = getInt();

                    // create an array 
                    int[] arr = new int[n];

                    // get array elements
                    for (int i = 0; i < n; i++) {
                        System.out.print("arr["+i+"] = ");
                        arr[i] = getInt();
                    }
        
                   int ch = 0;
                   do{
                       // Show options for users
                        ch = getChoice(str);

                        switch(ch){
                            case 1:
                                    // average value
                                
                                     double result = 0;
                                     int sum = 0; 
                                     for (int i = 0; i < arr.length; i++) {
                                         sum+= arr[i];
                                     }
                                     result = ((double) sum / n);
                                     System.out.println("Average value = " + result); 
                                break;
                            case 2:
                                    // find max, min value
                                
                                    int max = arr[0];
                                    int min = arr[0];

                                    for (int i = 0; i < arr.length; i++) {
                                        if(max < arr[i]){
                                            max = arr[i];
                                        }

                                        if(min > arr[i]){
                                            min = arr[i];
                                        }
                                    }
                                    System.out.println("[MAX] = " + max + "; [MIN] = " + min);
                                break;
                            case 3:
                                    // Find max, min negative number
                                
                                    // if (negative nums > 2) ? true : false;
                                    int nMax = arr[0];
                                    int nMin = arr[0];
                                    for (int i = 0; i < arr.length; i++) {
                                        if(arr[i]<0){
                                            if(nMax < arr[i]){
                                                nMax = arr[i];
                                            }
                                            if(nMin > arr[i]){
                                                nMin = arr[i];
                                            }
                                        }
                                    }

                                    if(nMax<0 && nMin<0){
                                        System.out.println("[MAX] negative num = " + nMax);
                                        System.out.println("[MIN] negative num = " + nMin);
                                    }else{
                                        System.out.println("Array not exist 2 negative number");
                                    }
                                break;
                            case 4:
                                    // find max,min positive number
                                
                                    // if(postive nums > 2) ? true : false;
                                    int pMax = arr[0];
                                    int pMin = arr[0];
                                    for (int i = 0; i < arr.length; i++) {
                                        if(arr[i]>0){
                                            if(pMax < arr[i]){
                                                pMax = arr[i];
                                            }
                                            if(pMin > arr[i]){
                                                pMin = arr[i];
                                            }
                                        }
                                    }

                                    if(pMax>0 && pMin>0){
                                        System.out.println("[MAX] positive num = " + pMax);
                                        System.out.println("[MIN] positive num = " + pMin);
                                    }else{
                                        System.out.println("Array not exist 2 postive number");
                                    }
                                break;
                            case 5:
                                    // print out odd, even nums
                                
                                    int oddNum = -1;
                                    int evenNum = -1;
                                    System.out.print("[EVEN] number = ");
                                    for (int i = 0; i < arr.length; i++) {
                                        if(arr[i]%2==0){
                                            System.out.print(arr[i]+" ");
                                        }
                                    }
                                    System.out.print("\n");
                                    System.out.print("[ODD] number = ");
                                    for (int i = 0; i < arr.length; i++) {
                                        if(arr[i]%2!=0){
                                            System.out.print(arr[i]+" ");
                                        }
                                    }
                                    System.out.print("\n");
                                break;
                            case 6:
                                // add value by index
                                
                                System.out.print("Input index: ");
                                int pos = getInt();
                                System.out.print("Input new value: ");
                                int newNum = getInt();

                                // create a temp arr to increase size 1
                                int[] arr1 = new int[arr.length+1];
                                
                                // assign arr1 elements by arr elements
                                for (int i = 0; i < arr.length; i++) {
                                    arr1[i] = arr[i];
                                }
                                
                                // move elements from 'pos' index to index+1
                                for (int i = arr1.length-1; i >pos; i--) {
                                    arr1[i] = arr1[i-1];
                                }
                                // add new element to 'pos' index
                                arr1[pos] = newNum;
                                
                                // assign new array
                                arr = arr1;
                                
                                // display array after add
                                System.out.print("Array after add new number = [ ");
                                for (int i = 0; i < arr.length; i++) {
                                    System.out.print(arr[i]+" ");
                                }
                                System.out.print("]\n");
                                break;
                            case 7:
                                // remove value by index
                                
                                System.out.print("Input index to remove element: ");
                                pos = getInt();
                                
                                if(pos < arr.length){
                                    // create a temp arr to decrease size 1
                                    arr1 = new int[arr.length-1];

                                    for (int i = pos; i < arr.length-1; i++) {
                                        arr[pos] = arr[i+1];
                                    }

                                    for (int i = 0; i < arr1.length; i++) {
                                        arr1[i] = arr[i];
                                    }

                                    arr = arr1;

                                    System.out.print("Array after remove = [ ");
                                    for (int i = 0; i < arr.length; i++) {
                                        System.out.print(arr[i]+" ");
                                    }
                                    System.out.print("]\n");
                                }else{
                                    System.out.println("Remove fail, array length = " + arr.length);
                                }
                                break;
                        }
                    }while(ch < str.length);
                   break;
           }
        }while(choice<2);
    }

    public static void Question14(){
        System.out.print("Input n: ");
        // get array length
         int n = getInt();

         // create an array 
         int[] arr = new int[n];

         // get array elements
         for (int i = 0; i < n; i++) {
             System.out.print("arr["+i+"] = ");
             arr[i] = getInt();
         }
         
         // sort an array
         for (int i = 0; i < arr.length-1; i++) {
             for (int j = i+1; j < arr.length; j++) {
                 if(arr[i] > arr[j]){
                     int tmp = arr[i];
                     arr[i] = arr[j];
                     arr[j] = tmp;
                 }
             }
        }
         
         // count duplicate element
         int count = 0;
         // remove duplicate element
         for (int i = 0; i < arr.length-1; i++) {
             if(arr[i]==arr[i+1]){
                 for (int j = i; j < arr.length-1; j++) {
                     arr[j] = arr[j+1];
                 }
                 ++count;
             }
         }
         
         // set arr by new an array with arr.length - count
         int[] arr1 = new int[arr.length-count];
         for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }
         
         arr = arr1;
         for (int i = 0; i < arr.length; i++) {;
             System.out.println(arr[i]);
        }
         
    }
    
    public static void Question15(){
        String[] op = {"Input a String","Quit"};
        String[] op1 = {"String length","Find char by index","Check subString","Quit"};
        
        int choice = 0;
        do{
            choice = getChoice(op);
            switch(choice){
                case 1:
                    System.out.print("Input a string:");
                    String str = getString();
                    
                    int ch = 0;
                    do{
                        ch = getChoice(op1);
                        
                        switch(ch){
                            case 1:
                                System.out.println("String length = " + str.length());
                                break;
                            case 2:
                                System.out.print("Input index: ");
                                int index = getInt();
                                if(index < str.length()){
                                    System.out.println("Char at " + index + " =" +str.charAt(index));
                                }else{
                                    System.out.println("Error, String length = " + str.length());
                                }
                                break;
                            case 3:
                                System.out.print("Input sub string: ");
                                String subString = getString();
                                // compile a subString to a pattern 
                                // use Matcher instance to check match by matches() method
                                // or check that subsquence of String match pattern or not by find() method
                                // e.g: "abcdxyz" pattern = "abc" --> check that subsequence "abc"
                                // of String "abcdxyz" match pattern "abc" by find() method --> return true
                                Pattern p = Pattern.compile(subString);
                                Matcher m = p.matcher(str);
                               // m.matches() --> return true if 2 String are equal
                                if(m.find()){
                                    System.out.println("'" + subString +"' is a sub string of " + str);
                                }
                                break;
                        }
                    }while(ch < op1.length);
                    break;
            }
        }while(choice < op.length);
    }
    
    public static void Question16(){
        System.out.print("Input year to check is leap or not: ");
        int year = getInt();
        
        if((year%400==0) || (year%4==0) && (year%100!=0)){
            System.out.println("Year is leap");
        }else{
            System.out.println("Year is not leap");
        }
    }
    
    public static void Question17(){
        int secretNum = (int)(Math.random()*1000);
        
        int count = 0; 
        int tmp = secretNum;
        int firstNum = 0;
        while(tmp > 0){
            count++;
            firstNum = tmp;
            tmp = tmp/10;
        }
        
        boolean check = false;
        System.out.println(firstNum);
        System.out.println(secretNum);
        do{
            System.out.print("Guess a number: ");
            int userInput = getInt();
            if(userInput < 0 || userInput > 1000){
                System.out.println("Please guess number in range[1,1000]");
            }else{
                if(userInput == secretNum){
                    System.out.println("Congratulation, secrect number is " + secretNum);
                    check = true;
                }else if(userInput < secretNum){
                    System.out.println("Try to guess bigger number, secret number has length = " + count + ", begin with number = " + firstNum);
                }else{
                    System.out.println("Try to guess smaller number, secret number has length = " + count + ", begin with number = " + firstNum);
                }
            }
        }while(!check);
    }
    
    public static void Question18(){
        System.out.print("Input send money: ");
        int totalMoney = getInt();
        
        System.out.print("Input money want to by car: ");
        int wishMoney = getInt();
        
        System.out.print("Input interest rate(%): ");
        double rate = ((double)getInt()/100);
        
        double result = totalMoney;
        int count = 1;
        for (int i = 1; i < 100; i++) {
            if(result < wishMoney){
                result += result*rate;
                count++;
            }else{
                break;
            }
        }
        System.out.println("It's take " + count + " year to buy a car");
    }
    
    public static int getIntbyCondition(String msg,int min, int max) throws Exception{
        System.out.print(msg);
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        if(num>=min && num<=max) return num;
        else throw new Exception();
    }
    
    public static void Question19(){
        String[] op = {"Equation of degree 1", "Equation of degree 2","Quit"};
        
        int choice = 0;
        do{
            choice = getChoice(op);
            
            switch(choice){
                case 1:
                    System.out.println("[FORTMAT] ax+b=0");
                    System.out.print("Input a: ");
                    int a = getInt();
                    System.out.print("Input b: ");
                    int b = getInt();
                    double calc = ((double)(-b)/a);
                    
                    int max = Math.max(a,b);
                    System.out.println(max);
                    int maxDivisor = 1;
                    for (int i = 1; i <=Math.abs(max); i++) {
                        if(a%i==0 && b%i==0){
                            maxDivisor = i;
                        }
                    }
                    int numberator = (-b)/maxDivisor;
                    int denominator = a/maxDivisor;
                    System.out.println("Fraction number result = " + numberator+ "/" + denominator);
                    System.out.println("Real number result = " + String.format("%.4f", calc));

                    break;
                case 2:
                    System.out.println("[FORTMAT] ax^2 + bx + c = 0");
                    System.out.print("Input a: ");
                    a = getInt();
                    System.out.print("Input b: ");
                    b = getInt();
                    System.out.print("Input c: ");
                    int c = getInt();
                    
                    // solve Equation
                    double delta = Math.pow(b, 2) - 4*a*c;
                    if(delta>0){
                        double result1 = ((-b) - Math.sqrt(delta))/(2*a)*1.0;
                        double result2 = ((-b) + Math.sqrt(delta))/(2*a)*1.0;
                        System.out.println("x1 = "+result1);
                        System.out.println("x2 = "+result2);
                    }else if(delta == 0){
                        double result = -b/(2*a)*1.0;
                        System.out.println("x1 = x2 = "+result);
                    }else{
                        System.out.println("No solution");
                    }
                    break;
            }
        }while(choice<op.length);
    }
    
    public static int[] getEvenArray(int[] arr,int n){
        ArrayList<Integer> list = new ArrayList();
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2==0){
                list.add(arr[i]);
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    public static int[] getOddArray(int[] arr,int n){
        ArrayList<Integer> list = new ArrayList();
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2!=0){
                list.add(arr[i]);
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    public static void Question20(){
        System.out.println("Input length: ");
        int n = getInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = getInt();
        }
        
        int[] evenArr = getEvenArray(arr, n);
        System.out.print("[EVEN] array = [ ");
        for (int i = 0; i < evenArr.length; i++) {
            System.out.print(evenArr[i] + " ");
        }
        System.out.print("]");
        
        System.out.print("\n");
        
        int[] oddArr = getOddArray(arr, n);
        System.out.print("[ODD] array = [ ");
        for (int i = 0; i < oddArr.length; i++) {
            System.out.print(oddArr[i] + " ");
        }
        System.out.print("]");
 
    }
    
    public static void Question21(){
        
        int x1=0, x2=0;
        int v1=0, v2=0;
        
        try{
            x1 = getIntbyCondition("Input x1: ",0, 10000);
            v1 = getIntbyCondition("Input v1: ",0, 10000);
            x2 = getIntbyCondition("Input x2: ",0, 10000);
            v2 = getIntbyCondition("Input v2: ",0, 10000);
        } catch (Exception ex) {
            System.out.println("x1,x2 domain [0,10000)");
            System.out.println("v1,v2 domain [0,10000]");
        }
        
        int sum1 = x1, sum2 = x2;
        while(sum1 != sum2){
            if(sum1>10000){
                break;
            }else{
                sum1 += v1; 
                sum2 += v2;
            }
        }
        System.out.println("2 Kangaroo meet at " + sum1);

    }
    
    public static void Question22(){
        ArrayList<String> list = new ArrayList();
        String input = getString();
        String get = new String();
        
        for (int i = 0; i < input.length()-1; i++) {
            if(input.charAt(i) != input.charAt(i+1)){
                get+= input.charAt(i);
                System.out.println(input.charAt(i));
            }else{
                list.add(get+input.charAt(i));
                get = new String();
            }
        }
        System.out.println("---");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    
    public static void main(String[] args) {
        
         //KaraokePayment();
         //Question1_2();
         //Question3();
         //Question4();
        //Question5();
        //Question6();
        //Question7();
        //Question8();
        //Question9();
        //Question10();
        //Question11();
        //Question12();
        //Question13();
        //Question14();
        //Question15();
        //Question16();
        //Question17();
        //Question18();
        //Question19();
        //Question20();
        //Question21();
        Question22();
    }
}
