package oasis_java_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static oasis_java_tasks.Main.isLegalDate;

public class ReservationSystem implements CancelTicket, TicketStore {

    Scanner sc= new Scanner(System.in);

    public String name, classType, date, initialLocation, destination;

    TicketDetails ticket = new TicketDetails();

    HashMap<Integer,HashMap<String,String>> userDetails = new HashMap<Integer, HashMap<String, String>>();
    HashMap<String, String> pnrHash = new HashMap<String, String>();
    HashMap<String, String> tickets = new HashMap<String, String>();

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
        System.out.print("Name: ");name = sc.nextLine();
        System.out.print("ClassType: "); classType = sc.nextLine();
        System.out.print("date(yyyy-MM-dd): "); date = sc.nextLine();
        System.out.print("Source: "); initialLocation = sc.nextLine();
        System.out.print("Destination: "); destination = sc.nextLine();
        if(validUserDetails(name,date,classType)){
            ticket.setName(name);
            ticket.setClassType(classType);
            ticket.setDate(date);
            ticket.setInitialLocation(initialLocation);
            ticket.setDestination(destination);
        }
        else{
            System.out.println("Invalid details.");
//            insertTicketDetails();
        }
        ticketDetails();

    }

    public void ticketDetails(){
        System.out.println("Ticket Booked Successfully.");
        System.out.println("******** Ticket Details *******");
        System.out.println("PNR number: "+ticket.getPNRNumber());
        System.out.println("Name: "+ticket.getName());
        System.out.println("Train Name: "+ticket.getTrainName());
        System.out.println("Train Number: "+ticket.getTrainNumber());
        System.out.println("Class Type: "+ticket.getClassType());
        System.out.println("Date: "+ticket.getDate());
        System.out.println("From "+ticket.getInitialLocation() +" To "+ ticket.getDestination());
        System.out.println("******* Ticket Details ******");

        pnrHash.put(ticket.getPNRNumber() ,ticket.getPNRNumber());

        int pnrNumberInt = Integer.parseInt(ticket.getPNRNumber());
        tickets.put("name",ticket.getName());
        tickets.put("trainName",ticket.getTrainName());
        tickets.put("trainNum",ticket.getTrainNumber());
        tickets.put("classType",ticket.getClassType());
        tickets.put("date",ticket.getDate());
        tickets.put("location",ticket.getInitialLocation());
        tickets.put("destination",ticket.getDestination());

        userDetails.put(pnrNumberInt,tickets);


    }

    @Override
    public void showTickets() {
        for( Map.Entry<Integer, HashMap<String, String>> entry : userDetails.entrySet() ){
            System.out.println("PNR Number: ");
            System.out.println( entry.getKey() + " = " + entry.getValue() );
        }
    }

    @Override
    public void cancelTicket(String pnrNumber) {
        if(pnrHash.containsKey(pnrNumber)){
            pnrHash.remove(pnrNumber);
            userDetails.remove(pnrNumber);
            if(userDetails.containsKey(pnrNumber)){
                System.out.println("Ticket not deleted");
            }else{
                System.out.println("Ticket cancel successful.");
            }
        }
        else{
            System.out.println("Enter valid PNR Number");
        }

    }

    private boolean validUserDetails(String name, String date, String classType) {
        if(name.length()>5 && isLegalDate(date) && classType.length()>2){
            return true;
        }
        return false;
    }
}
