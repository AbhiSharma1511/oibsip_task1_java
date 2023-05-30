package oasis_java_tasks;

public class TicketDetails {

    private String name ;
//    private final String trainNumber = (int)(Math.random()*10000) +"";
//    private final String PNRNumber = (int)(Math.random()*1000000000) +"";
//    private final String trainName = "ExpressTrain"+(int)(Math.random()*10+1);

    private String classType, date, initialLocation, destination;

    public TicketDetails(String name, String classType, String date, String initialLocation, String destination) {
        this.name = name;
        this.classType = classType;
        this.date = date;
        this.initialLocation = initialLocation;
        this.destination = destination;
    }

    public TicketDetails(String name) {
        this.name = name;
    }

    public TicketDetails() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInitialLocation() {
        return initialLocation;
    }

    public void setInitialLocation(String initialLocation) {
        this.initialLocation = initialLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

//    public String getTrainNumber() {
//        return trainNumber;
//    }
//
//    public String getPNRNumber() {
//        return PNRNumber;
//    }
//
//    public String getTrainName() {
//        return trainName;
//    }

}
