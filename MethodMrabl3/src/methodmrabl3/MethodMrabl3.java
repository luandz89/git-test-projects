/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodmrabl3;

import java.util.Scanner;

/**
 *
 * @author Prince
 */
public class MethodMrabl3 {

    public static int getChoice(){
    int choice;
       Scanner mpint = new Scanner(System.in);
       System.out.print("\nPlease Enter your Choice below: "+"\n"
               + "1- wash and Go :Sedan (R30), Bakie (R40), Minibus (R50)"+"\n"
               + "2- Deatail:Sedan (R70), Bakie (R80), Minibus (R100)\n"
               + "3- Executive: Sedan (R90), Bakie (R110), Minibus (R150)\n"
               + "4- to end the program\n"
               + "Your choice :");
       choice=mpint.nextInt();
       return choice;
    
    }
    public static int getAdditionalUserServiceOption() {
    int choice;
       Scanner mpint = new Scanner(System.in);
       System.out.print("\nPlease Enter your Choice below: "+"\n"
               + "1- Body polish :Sedan (R90), Bakie (R110), Minibus (R150)"+"\n"
               + "2- Excessive mud :Sedan (R20), Bakie (R40), Minibus (R60)\n"
              
               + "Your choice :");
       choice=mpint.nextInt();
       return choice;
     }
    public static double determineAmountDue(int serviceCode, char carType){
       Scanner mpint = new Scanner(System.in);
       Scanner mpchr = new Scanner(System.in);
     System.out.print("Please enter Service Code");
      serviceCode=mpint.nextInt();  
      int price=0;
    switch(serviceCode){
        case 1:
            System.out.print("Please enter Car Type");
            carType=mpchr.next().charAt(0);
            if (carType=='s'||carType=='S'){ price = price +30;}
            if (carType=='b'||carType=='B'){ price = price +40;}
            if (carType=='m'||carType=='M'){ price = price +50;}
        case 2:System.out.print("Please enter Car Type");
              carType=mpchr.next().charAt(0);
            if (carType=='s'||carType=='S'){ price = price +70;}
            if (carType=='b'||carType=='B'){ price = price +80;}
            if (carType=='m'||carType=='M'){ price = price +110;}
            
        case 3: System.out.print("Please enter Car Type");

            carType=mpchr.next().charAt(0);
            if (carType=='s'||carType=='S'){ price = price +90;}
            if (carType=='b'||carType=='B'){ price = price +110;}
            if (carType=='m'||carType=='M'){ price = price +150;}
    
    }
    return price;
    }
    public static double updateAmountDue(double amountDue, int serviceCode, char carType){
         Scanner mpint = new Scanner(System.in);
       Scanner mpchr = new Scanner(System.in);
       
    System.out.print("Please enter Service Code");
      serviceCode=mpint.nextInt();  
     
    switch(serviceCode)
    {
        case 1:
                System.out.print("Please enter Car Type");

            carType=mpchr.next().charAt(0);
            if (carType=='s'||carType=='S'){ amountDue = amountDue +90;}
            if (carType=='b'||carType=='B'){ amountDue = amountDue +110;}
            if (carType=='m'||carType=='M'){ amountDue = amountDue +150;}
        case 2:
                System.out.print("Please enter Car Type");
              carType=mpchr.next().charAt(0);
            if (carType=='s'||carType=='S'){ amountDue = amountDue +20;}
            if (carType=='b'||carType=='B'){ amountDue = amountDue +40;}
            if (carType=='m'||carType=='M'){ amountDue = amountDue +60;}
            
    }
    amountDue=amountDue+amountDue;
     return amountDue;
 
    }
    public static double makePayment(double totalAmountDue) {
    Scanner mpint = new Scanner(System.in);

    double payment=mpint.nextDouble();
    if(payment<totalAmountDue){  System.out.print(payment+" is less Than the Amount due "
         + "Please Enter the Full Amount");
    }else{
       double  change= totalAmountDue-payment;
        System.out.print("Your Change Is: .R"+change);

    }
    
    return totalAmountDue;}
    
   public static void main(String[] args) {
       int choice,price=0;
     double totalAmountDue = 0;
      choice=getChoice();
     
    }
    
}
