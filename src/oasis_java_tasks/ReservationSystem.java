package oasis_java_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static oasis_java_tasks.Main.isLegalDate;

public class ReservationSystem implements CancelTicket, TicketStore {

    Scanner sc= new Scanner(System.in);

    String trainNumber;
    int PNRNumber ;
    String trainName;


    public String name, classType, date, initialLocation, destination;

    TicketDetails ticket = new TicketDetails();

    HashMap<Integer,HashMap<String,String>> userDetails = new HashMap<Integer, HashMap<String, String>>();
    HashMap<String, String> pnrHash = new HashMap<String, String>();


    public ReservationSystem() {}

    public void userDetails(String name){
        ticket.setName(name);
        System.out.println("************** User Details *************");
        System.out.println("Name: "+ name);
        if (!pnrHash.isEmpty()){
            showTickets();
        }else{
            System.out.println("NO Ticket Found.");
        }
        System.out.println("************** User Details *************");
    }


    public void insertTicketDetails(){
        System.out.println("Enter you details");
        System.out.print("Name: ");
        name = sc.next();
        System.out.print("ClassType: ");
        classType = sc.next();
        System.out.print("date(yyyy-MM-dd): ");
        date = sc.next();
        System.out.print("Source: ");
        initialLocation = sc.next();
        System.out.print("Destination: ");
        destination = sc.next();
        if(validUserDetails(name,date,classType)){

            PNRNumber = (int)(Math.random()*1000000000);
            trainName = "ExpressTrain"+(int)(Math.random()*10+1);
            trainNumber = (int)(Math.random()*10000) +"";

            HashMap<String, String> tickets = new HashMap<String, String>();

            tickets.put("name",name);
            tickets.put("classType",classType);
            tickets.put("date",date);
            tickets.put("source",initialLocation);
            tickets.put("destination",destination);
            tickets.put("trainName",trainName);
            tickets.put("trainNumber",trainNumber);
            tickets.put("pnr",String.valueOf(PNRNumber));

            pnrHash.put(String.valueOf(PNRNumber),String.valueOf(PNRNumber));
            userDetails.put(PNRNumber,tickets);

            System.out.println("Ticket Booked Successfully.");
            System.out.println("******** Ticket Details *******");
            for( Map.Entry<String,String> entry : tickets.entrySet() ){
                System.out.print( entry.getKey() + " = " + entry.getValue()+", ");
            }
            System.out.println("\n******** Ticket Details *******");
        }
        else{
            System.out.println("Invalid details.");
//            insertTicketDetails();
        }
//        ticketDetails(PNRNumber);


    }

    @Override
    public void showTickets() {
        for( Map.Entry<Integer, HashMap<String, String>> entry : userDetails.entrySet() ){
            System.out.println("PNR Number: ");
            System.out.println( entry.getKey() + " = " + entry.getValue() );
        }
//        System.out.println(pnrHash);
    }

    @Override
    public void cancelTicket(String pnrNumber) {
        if(pnrHash.containsKey(pnrNumber)){
            pnrHash.remove(pnrNumber);
            int pnrNum = Integer.parseInt(pnrNumber);
            userDetails.remove(pnrNum);
            if(userDetails.containsKey(pnrNum)){
                System.out.println("Ticket not deleted");
            }else{
                System.out.println("Ticket cancel successful.\n");
            }
        }
        else{
            System.out.println("Enter valid PNR Number");
        }

    }

    private boolean validUserDetails(String name, String date, String classType) {
        if(name.length()>3 && isLegalDate(date) && classType.length()>2){
            return true;
        }
        return false;
    }
}
