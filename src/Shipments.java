import java.util.Scanner;
import java.lang.*;

/**
 * Shipments class, keeps all shipments in Kargo System
 */
public class Shipments  {

    private String sender;
    private String receiver;
    private int ShipID;
    protected int flagIsReceived;

    /**
     * Constructor
     */
    public Shipments(){}
    /**
     * Getters and Setters
     */
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getShipID() {
        return ShipID;
    }

    public void setShipID(int shipID) {
        ShipID = shipID;
    }

    public int getFlagIsReceived() {
        return flagIsReceived;
    }

    public void setFlagIsReceived(int flagIsReceived) {
        this.flagIsReceived = flagIsReceived;
    }

    /**
     * Register new Shipment to Kargo System
     * @param sc scanner
     */
    protected void add(Scanner sc)
    {
        System.out.println("Enter a sender: ");
        setSender(sc.nextLine());

        System.out.println("Enter a receiver: ");
        setReceiver(sc.nextLine());

        System.out.println("Enter a shipID: ");
        setShipID(sc.nextInt());

        System.out.println("Enter a status 1) - Delivered or 0) - Not delivered : ");
        setFlagIsReceived(sc.nextInt());
    }

    /**
     * compares the parameter  with this class
     * @return if equals returns true,else returns false
     */
    public boolean equals(Shipments other){
        if(other == this ) return true;
        if(other == null ) return false;

        try{
            Shipments temp = (Shipments) other;
            return (getShipID() == (temp.getShipID()) );
        }
        catch(ClassCastException E){
            System.out.println("Wrong input for (equals) method!, input is" + "not an shipment");
            return false;
        }
    }

    /**
     * To String method
     */
    public String toString()
    {
        String str="";
        str+="Sender = " + sender + ", Receiver = " + receiver + ", ShipID = " + ShipID + ", Status = " + flagIsReceived + "\n";
        return  str;
    }


}
