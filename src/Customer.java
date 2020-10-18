import java.util.Scanner;

public class Customer {

    protected String senderName;
    protected String receiverName;
    protected String fromBranch;
    protected String toBranch;
    protected int trackingNum;
    protected int status = 0;

    /**
     * Default Constructor
     */
    public Customer() {}

    public int getTrackingNum() {
        return trackingNum;
    }

    public void setTrackingNum(int trackingNum) {
        this.trackingNum = trackingNum;
    }

    public String getToBranch() {
        return toBranch;
    }

    public void setToBranch(String toBranch) {
        this.toBranch = toBranch;
    }

    public String getFromBranch() {
        return fromBranch;
    }

    public void setFromBranch(String fromBranch) {
        this.fromBranch = fromBranch;
    }

    public String getSenderName() {
        return senderName;
    }
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }


    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    /**
     * Register the Customer to Kargo System by asking
     * personal information, for sending shipment
     */
    protected void signIn(Scanner in)
    {
        System.out.println("Enter a sender Name (Your Name): ");
        setSenderName(in.nextLine());

        System.out.println("Enter a receiver Name : ");
        setReceiverName(in.nextLine());

        System.out.println("Enter FROM which Branch you send: ");
        setFromBranch(in.nextLine());

        System.out.println("Enter TO which Branch you send: ");
        setToBranch(in.nextLine());
    }

    /**
     * To String method
     */
    public String toString()
    {
        String str="";
        str+="Sender = " + senderName + ", Receiver = " + receiverName + ", From = " + fromBranch + ", To = " + toBranch + ", Status =" + status + "\n";
        return  str;
    }


}