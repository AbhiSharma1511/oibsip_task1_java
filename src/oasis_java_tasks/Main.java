package oasis_java_tasks;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main  {

    static ReservationSystem system = new ReservationSystem();

    public static void main(String[] args) {
        // write your code here
        String username = "Abhinav";
        String password = "12345";

        System.out.println("******* Welcome to Online Reservation System ********");
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter username: ");
        String userName = sc.nextLine();
        System.out.print("Enter password: ");
        String passWord = sc.nextLine();

        if(userName.equals(username) && passWord.equals(password)){
            System.out.println("Login Successful");
            while(true) {
                userMenu(username);
            }
        }
        else{
            System.out.println("Enter valid username/password");
            System.exit(0);
        }

    }

    static boolean isLegalDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        return sdf.parse(s, new ParsePosition(0)) != null;
    }

    static void userMenu(String username){
        Scanner sc= new Scanner(System.in);
        System.out.println("\n1. See Your Details \n2. Book Ticket \n3. Cancel Ticket \n4. Exit() ");
        int num = sc.nextInt();

        if(num==1){
            system.userDetails(username);
        }
        else if(num==2){
            system.insertTicketDetails();
        }
        else if(num==3){
            Scanner sc1 = new Scanner(System.in);
            System.out.println("For cancel the ticket enter PNR NUmber: ");
            String pnr = sc1.nextLine();
            system.cancelTicket(pnr);
        }
        else if(num==4){
            System.exit(0);
        }else{
            System.out.println("Invalid Entry.");
        }

    }


}
