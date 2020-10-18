import java.util.Scanner;
import java.security.InvalidParameterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.io.IOException;
import java.io.FileWriter;
import java.lang.*;

/**
 * Main class of Kargo System company where workers adds, removes shipments, customers send etc.
 */

public class KargoSystem {
    /**
     * Array, which keeps all administrators.
     */
    protected Admin arrAdmin[] = new Admin[200];
    /**
     * Array, which keeps all branches.
     */
    protected Branch arrBranch[] = new Branch[200];;
    /**
     * Array, which keeps all customers.
     */
    protected Customer arrCustomer[] = new Customer[200];;

    protected int SizeAdd = 0 ;
    protected int SizeBranch = 0 ;
    private int SizeCustomer = 0;

    private int adminIndex;
    private int branchIndex;
    private int customerIndex;

    /**
     * Constructor
     */
    public KargoSystem() {}

    /**
     * Gets Index of Admin
     * @return
     */
    public int getAdminIndex() {
        return adminIndex;
    }

    /**
     * Sets Index of Admin
     * @param newAdminIndex to be assigned
     */
    public void setAdminIndex(int newAdminIndex) {
        this.adminIndex = newAdminIndex;
    }
    /**
     * Gets Index of Branch
     * @return
     */
    public int getBranchIndex() {
        return branchIndex;
    }

    /**
     * Sets Index of Branch
     * @param newBranchIndex to be assigned
     */
    public void setBranchIndex(int newBranchIndex) {
        this.branchIndex = newBranchIndex;
    }

    /**
     * Gets Index of Customer
     */
    public int getCustomerIndex() {
        return customerIndex;
    }

    /**
     * Sets Index of Customer
     * @param newCustomerIndex to be assigned
     */
    public void setCustomerIndex(int newCustomerIndex) {
        this.customerIndex = newCustomerIndex;
    }

    /**
     * LogIn as an administrator
     * @param in scanner
     * @throws InvalidParameterException
     */
    public boolean adminLogin(Scanner in) throws InvalidParameterException
    {
        String logName, password;
        int flag1 = -1;

        System.out.println("\nEnter a Login Name : ");
        logName = in.nextLine();

        System.out.println("Enter a Password : ");
        password = in.nextLine();
        for (int i = 0; i < SizeAdd; i++) {
            if (arrAdmin[i].getLogName().equals(logName) && arrAdmin[i].getPassword().equals(password)) {
                setAdminIndex(i);
                System.out.println("\n**************** WELCOME TO ADMIN PAGE *****************");
                flag1 = 0;
                i = SizeAdd;
                return true;
            }
        }

        if (flag1 == -1) {
            throw new InvalidParameterException("Incorrect Information entered ! LOGIN failed..");
        }
        return false;
    }

    /**
     * Register new administrator to the kargo system
     * @param sc
     * @throws InvalidParameterException
     */
    public void adminSignUP(Scanner sc)
    {
        Admin ad1 = new Admin();
        ad1.signIn(sc);
        int flag2 = 0;

        for (int i = 0; i < SizeAdd; i++) {
            if (arrAdmin[i].getLogName().equals(ad1.getLogName())) {
                System.out.println("Username you choose is not available. Please choose another one.");
                flag2 = 1;
            }
        }

        if (flag2 == 0) {
            arrAdmin[SizeAdd] = ad1;
            SizeAdd++;
        }
        FileWriterCSVAdmin();
        System.out.println("Administrators you have for now..");
        for (int i = 0; i < SizeAdd; i++) {
            System.out.println(arrAdmin[i]);
        }
    }
    /**
     * Adds new branch by administrator
     * @param sc
     */
    public void adminAddBranch(Scanner sc) {

        Branch br1 = new Branch();
        System.out.println("Please enter the name of a New Branch.. ");

        String tempBr = sc.nextLine();
        int flag = -1;

        for(int i =0; i<SizeBranch; i++){
            if(tempBr.equals(arrBranch[i].getBranchName())){
                System.out.println("This Branch Name already exist.. Please try again..");
                flag = 0;
                i = SizeBranch;
            }
        }
        if(flag == -1){
            br1.setBranchName(tempBr);
            arrBranch[SizeBranch] = br1;
            SizeBranch++;
        }
        System.out.println("BRANCHES you have for now..");
        for (int i = 0; i < SizeBranch; i++) {
            System.out.println(arrBranch[i].getBranchName());
        }
    }

    /**
     * Removes branch by administrator
     * @param sc
     */
    public void adminRemoveBranch(Scanner sc) {

        System.out.println("BRANCHES you have for now..");
        for (int i = 0; i < SizeBranch; i++) {
            System.out.println(arrBranch[i].getBranchName());
        }

        if (arrBranch[0] == null ){
            System.out.println("There is no Branch to remove..");
        }
        else{
            System.out.println("Please enter the name of a Branch you want to REMOVE.. ");

            String tempBr2 = sc.nextLine();

            for(int i = 0; i < SizeBranch; i++){
                if(tempBr2.equals(arrBranch[i].getBranchName())){
                    setBranchIndex(i);
                }
            }

            Branch tempBranch[] = new Branch[200];
            for(int m = 0, j = 0; m < SizeBranch; m++) {
                if (m == branchIndex) {
                    continue;
                }
                tempBranch[j++] = arrBranch[m];
            }
            SizeBranch--;

            arrBranch = tempBranch;
            System.out.println("Remaining branches .. ");
            for (int i = 0; i < SizeBranch; i++) {
                System.out.println(arrBranch[i].getBranchName());
            }
        }
    }


    /**
     * Read From File method, reads Administrators from file when program starts.
     * @param fileRead name of the File to be read.
     */
    public void readFromFile(String fileRead){
        try {
            File file = new File(fileRead);
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                Admin ad2 = new Admin();
                ad2.setName(myReader.nextLine());;
                ad2.setSurname(myReader.nextLine());;
                ad2.setLogName(myReader.nextLine());;
                ad2.setPassword(myReader.nextLine());;
                arrAdmin[SizeAdd] = ad2;
                SizeAdd++;
            }
            myReader.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("File was not opened..");
        }
    }
    /**
     *
     * Write all administrators to csv file
     * Write their personal information, logName and Passwords.
     */
    public void FileWriterCSVAdmin()
    {
        String NEW_LINE_SEPARATOR = "\n";
        String COMMA_DELIMITER = ",";

        String header="Name, Surname, Login Name, Password";

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("AdminsRecord.csv");
            fileWriter.append(header.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (int i = 0; i < SizeAdd; i++) {
                fileWriter.append(arrAdmin[i].getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(arrAdmin[i].getSurname());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(arrAdmin[i].getLogName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(arrAdmin[i].getPassword());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
            System.out.println("FileWriter CSV Error occured !!!");
            e.printStackTrace();
        }
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    /**
     * Sends shipment by Customer
     * @param sc scanner
     */
    public void SendShipCustomer(Scanner sc) {

        Customer cus1 = new Customer();
        cus1.signIn(sc);

        Random rn = new Random();

        int num = rn.nextInt(1000);

        System.out.println("Please SAVE your TRACKING NUMBER!!!  \n In order to check your shipment status later..");

        System.out.println("Your Tracking number is -> " + num);

        arrCustomer[SizeCustomer] = cus1;

        arrCustomer[SizeCustomer].setTrackingNum(num);

        SizeCustomer++;

    }

    /**
     * Tracks shipment by Customer, using Tracking Number
     * @param sc scanner
     */
    public void trackShipCustomer(Scanner sc) {

        System.out.println("Please ENTER your Tracking Number you saved before. \n In order to check your shipment status.");

        int TrackNum = sc.nextInt();sc.nextLine();

        for(int i =0; i<SizeCustomer; i++) {
            System.out.println(arrCustomer[i].getTrackingNum());
            if(arrCustomer[i].getTrackingNum() == (TrackNum)) {
                arrCustomer[i].setStatus(1);
            }
        }
        for(int i =0; i<SizeCustomer; i++) {

            System.out.println(arrCustomer[i]);
        }
    }


}
























