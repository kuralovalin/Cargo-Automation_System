import java.security.InvalidParameterException;
import java.util.Scanner;
import java.lang.*;
/**
 * Branch class which keeps all information about branch and its workers.
 */
public class Branch extends KargoSystem{

    /**
     * Array, which keeps all Branch Employees.
     */
     protected BranchEmployee arrBranchEmp[] ;
    /**
     * Array, which keeps all Transportation Employees.
     */
     protected TransportEmployee arrTransEmp[] ;
    /**
     * Array, which keeps all shipments.
     */
    protected Shipments arrShipments[] ;
    /**
     * String, which keeps name of the branch.
     */
    protected String branchName;

    protected int SizeBranchEmp;
    protected int BranchEmpIndex;

    protected int SizeTransEmp;
    protected int TransEmpIndex;

    protected int SizeShip;
    protected int ShipIndex;

    /**
     * Constructor
     */
    public Branch() {
        super();
        arrBranchEmp = new BranchEmployee[200];
        arrTransEmp = new TransportEmployee[200];
        arrShipments = new Shipments[200];

        SizeBranchEmp = 0;
        SizeTransEmp = 0;
        SizeShip = 0;
    }

    /**
     * Gets Index of BranchEmp
     */
    public int getBranchEmpIndex() {
        return BranchEmpIndex;
    }

    /**
     * Sets Index of BranchEmp
     * @param newBranchInd to be assigned
     */
    public void setBranchEmpIndex(int newBranchInd) {
        this.BranchEmpIndex = newBranchInd;
    }
    /**
     * Gets Index of TransEmp
     */
    public int getTransEmpIndex() {
        return TransEmpIndex;
    }

    /**
     * Sets Index of TransEmp
     * @param newTransInd to be assigned
     */
    public void setTransEmpIndex(int newTransInd) {
        this.TransEmpIndex = newTransInd;
    }

    /**
     * Gets Name of a Branch
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * Sets Name of a Branch
     * @param newBranchName to be assigned
     */
    public void setBranchName(String newBranchName) {
        this.branchName = newBranchName;
    }

    public int getShipIndex() {
        return ShipIndex;
    }

    public void setShipIndex(int shipIndex) {
        ShipIndex = shipIndex;
    }
    /**
     * To String method
     */
    public String toString()
    {
        String str="";
        str+="Name of Branch = " + branchName + "\n";
        return  str;
    }

    /**
     * Adds new Branch Employee by administrator
     * @param sc scanner
     */
    public void AddBranchEmp(Scanner sc) {
        BranchEmployee br = new BranchEmployee();

        int flag = -1;
        br.signIn(sc);
        for(int i = 0; i < SizeBranchEmp; i++){

            if(br.getLogName().equals(arrBranchEmp[i].getLogName() )){
                System.out.println("This Branch Employee LogName already exist.. Please try again..");
                flag = 0;
                i = SizeBranchEmp;
            }
        }
        if(flag == -1) {

            System.out.println("To which Branch you want to add this Employee..");
            String BrNameTemp = sc.nextLine();
            br.BranchNameOfEmp = BrNameTemp;
            arrBranchEmp[SizeBranchEmp] = br;
            SizeBranchEmp++;
        }
        System.out.println("BRANCH Employees you have for now..");
        for (int i = 0; i < SizeBranchEmp; i++) {
            System.out.println(arrBranchEmp[i]);
        }
    }

    /**
     * Removes branch Employee by administrator
     * @param sc scanner
     */
    public void RemoveBranchEmp(Scanner sc) {

        if (arrBranchEmp[0] == null ){
            System.out.println("There is no Branch Employees to remove..");
        }
        else{
            System.out.println("Branch Employees you have..");
            for(int i = 0; i < SizeBranchEmp; i++){

                System.out.println(arrBranchEmp[i]);
            }
            System.out.println("Please enter the Name of a Branch  Employee you want to REMOVE.. ");

            String tempBr0 = sc.nextLine();

            for(int i = 0; i < SizeBranchEmp; i++){
                if(tempBr0.equals(arrBranchEmp[i].getName())){
                    setBranchEmpIndex(i);
                }
            }

            BranchEmployee tempBranch[] = new BranchEmployee[200];
            for(int m = 0, j = 0; m < SizeBranchEmp; m++) {
                if (m == BranchEmpIndex) {
                    continue;
                }
                tempBranch[j++] = arrBranchEmp[m];
            }
            SizeBranchEmp--;

            arrBranchEmp = tempBranch;
            System.out.println("Remaining branch Employees .. ");
            for (int i = 0; i < SizeBranchEmp; i++) {
                System.out.println(arrBranchEmp[i]);
            }
        }
    }

    /**
     * Adds new Transportation Employee by administrator
     * @param sc scanner
     */
    public void AddTransEmp(Scanner sc) {
        TransportEmployee tr = new TransportEmployee();

        int flag = -1;
        tr.signIn(sc);
        for(int i = 0; i < SizeTransEmp; i++){

            if(tr.getLogName().equals(arrTransEmp[i].getLogName() )){
                System.out.println("This Transportation Employee LogName already exist.. Please try again..");
                flag = 0;
                i = SizeTransEmp;
            }
        }
        if(flag == -1) {

            System.out.println("To which Branch you want to add this Employee..");
            String BrNameTemp1 = sc.nextLine();
            tr.BranchNameOfTrans = BrNameTemp1;
            arrTransEmp[SizeTransEmp] = tr;
            SizeTransEmp++;
        }
        System.out.println("Transportation Employees you have for now..");
        for (int i = 0; i < SizeTransEmp; i++) {
            System.out.println(arrTransEmp[i]);
        }
    }

    /**
     * Removes Transportation Employee by administrator
     * @param sc scanner
     */
    public void RemoveTransEmp(Scanner sc) {

        if (arrTransEmp[0] == null ){
            System.out.println("There is no Transportation Employees to remove..");
        }
        else{
            System.out.println("Transportation Employees you have..");
            for(int i = 0; i < SizeTransEmp; i++){

                System.out.println(arrTransEmp[i]);
            }
            System.out.println("Please enter the Name of a Transportation Employee you want to REMOVE.. ");

            String tempBr0 = sc.nextLine();

            for(int i = 0; i < SizeTransEmp; i++){
                if(tempBr0.equals(arrTransEmp[i].getName())){
                    setTransEmpIndex(i);
                }
            }

            TransportEmployee tempTrans[] = new TransportEmployee[200];
            for(int m = 0, j = 0; m < SizeTransEmp; m++) {
                if (m == TransEmpIndex) {
                    continue;
                }
                tempTrans[j++] = arrTransEmp[m];
            }
            SizeTransEmp--;

            arrTransEmp = tempTrans;
            System.out.println("Remaining Transportation Employees .. ");
            for (int i = 0; i < SizeTransEmp; i++) {
                System.out.println(arrTransEmp[i]);
            }
        }
    }




    /**
     * LogIn as an Branch Employee
     * @param in scanner
     * @throws InvalidParameterException if an error
     */
    public boolean BranchEmpLogin(Scanner in) throws InvalidParameterException
    {

        String logName, password;
        int flag1 = -1;

        System.out.println("\nEnter a Login Name : ");
        logName = in.nextLine();

        System.out.println("Enter a Password : ");
        password = in.nextLine();
        for (int i = 0; i < SizeBranchEmp; i++) {
            if (arrBranchEmp[i].getLogName().equals(logName) && arrBranchEmp[i].getPassword().equals(password)) {
                setBranchEmpIndex(i);
                System.out.println("\n**************** WELCOME TO BRANCH EMPLOYEE PAGE *****************");
                flag1 = 0;
                i = SizeBranchEmp;
                return true;
            }
        }

        if (flag1 == -1) {
            throw new InvalidParameterException("Incorrect Information entered ! LOGIN failed..");
        }
        return false;
    }

    /**
     * listShipmentEmp method, lists all shipments which Employee have in his(her) branch.
     */
    public void listShipmentsEmp(Scanner sc)
    {
        if (arrShipments[0] == null ){
            System.out.println("There is no Shipments in this branch..");
        }
        else {
            System.out.println("List of Shipments waited to be received..");
            for (int i = 0; i < SizeShip; i++) {
                System.out.println(arrShipments[i]);
            }
        }
    }

    /**
     * Changes current status of the shipment (made by Branch Employee).
     */
    public void changeStatusShip(Scanner sc)
    {
        if (arrShipments[0] == null ){
            System.out.println("There is no Shipments in this branch.. Its impossible to change status..");
        }
        else {
            System.out.println("List of Shipments :..");
            for (int i = 0; i < SizeShip; i++) {
                System.out.println(arrShipments[i]);
            }

            System.out.println("Which shipments status you want to change?");
            System.out.println("Please enter the ShipID..");
            int choice =  sc.nextInt();sc.nextLine();

            for (int i = 0; i < SizeShip; i++) {
                if(arrShipments[i].getShipID() == (choice)){
                    System.out.println("Please enter the new status as: 1) - delivered or 0) - not delivered..");
                    int ch = sc.nextInt();sc.nextLine();
                    if(ch == 1){
                        arrShipments[SizeShip-1].setFlagIsReceived(1);
                        i = SizeShip;

                    }
                    else{

                        arrShipments[SizeShip-1].setFlagIsReceived(0);
                        i = SizeShip;
                    }
                }
            }
            System.out.println("List of Shipments we have : ");
            for (int i = 0; i < SizeShip; i++) {
                System.out.println(arrShipments[i]);
            }
        }
    }


    /**
     * Adds new Shipment of a branch by Branch Employee
     * @param sc scanner
     */
    public void addShipment(Scanner sc) {
        Shipments sh = new Shipments();

        int flag = -1;
        sh.add(sc);

        arrShipments[SizeShip] = sh;
        SizeShip++;

        System.out.println("Shipments you have for now..");
        for (int i = 0; i < SizeShip; i++) {
            System.out.println(arrShipments[i]);
        }
    }

    /**
     * Removes Shipment by Branch Employee
     * @param sc scanner
     */
    public void removeShipment(Scanner sc) {

        if (arrShipments[0] == null ){
            System.out.println("There is no Shipments to remove..");
        }
        else{
            System.out.println("Shipments you have..");
            for(int i = 0; i < SizeShip; i++){

                System.out.println(arrShipments[i]);
            }
            System.out.println("Please enter the shipID of a Shipment you want to REMOVE.. ");

            int tempID = sc.nextInt();sc.nextLine();

            for(int i = 0; i < SizeShip; i++){
                if(tempID == arrShipments[i].getShipID()){
                    setShipIndex(i);
                }
            }

            Shipments tempShip[] = new Shipments[200];
            for(int m = 0, j = 0; m < SizeShip; m++) {
                if (m == ShipIndex) {
                    continue;
                }
                tempShip[j++] = arrShipments[m];
            }
            SizeShip--;

            arrShipments = tempShip;
            System.out.println("Remaining Shipments .. ");
            for (int i = 0; i < SizeShip; i++) {
                System.out.println(arrShipments[i]);
            }
        }
    }

    /**
     * LogIn as a Transportation Employee
     * @param in scanner
     * @throws InvalidParameterException if an error
     */
    public boolean transPerLogin(Scanner in) throws InvalidParameterException
    {

        String logName, password;
        int flag1 = -1;

        System.out.println("\nEnter a Login Name : ");
        logName = in.nextLine();

        System.out.println("Enter a Password : ");
        password = in.nextLine();
        for (int i = 0; i < SizeTransEmp; i++) {
            if (arrTransEmp[i].getLogName().equals(logName) && arrTransEmp[i].getPassword().equals(password)) {
                setTransEmpIndex(i);
                System.out.println("\n**************** WELCOME TO TRANSPORTATION EMPLOYEE PAGE *****************");
                flag1 = 0;
                i = SizeTransEmp;
                return true;
            }
        }

        if (flag1 == -1) {
            throw new InvalidParameterException("Incorrect Information entered ! LOGIN failed..");
        }
        return false;
    }

    /**
     * listShipmentsTransPer method, lists all shipments which Transportation Employee has to deliver.
     */
    public void listShipmentsTransPer(Scanner sc)
    {
        if (arrShipments[0] == null ){
            System.out.println("There is no Shipments in your list..");
        }
        else {
            System.out.println("List of Shipments waited to be received..");
            for (int i = 0; i < SizeShip; i++) {
                System.out.println(arrShipments[i]);
            }
        }
    }


    /**
     * Changes current status of the shipment by TRANSPORTATION EMPLOYEE, when receiving maded.
     */
    public void deliverByTransEmp(Scanner sc)
    {
        if (arrShipments[0] == null ){
            System.out.println("There is no Shipments in this branch.. Its impossible to deliver something..");
        }
        else {
            System.out.println("List of Shipments : ");
            for (int i = 0; i < SizeShip; i++) {
                System.out.println(arrShipments[i]);
            }

            System.out.println("Which shipment you want to deliver?");
            System.out.println("Please enter the ShipID..");
            int choice =  sc.nextInt();sc.nextLine();

            for (int i = 0; i < SizeShip; i++) {
                if(arrShipments[i].getShipID() == (choice)){
                    System.out.println("Thanks for delivering...");
                    System.out.println("Please change the previous status as: 1) - delivered, before was 0) - not delivered..");
                    int ch = sc.nextInt();sc.nextLine();
                    if(ch == 1){
                        arrShipments[SizeShip-1].setFlagIsReceived(1);
                        i = SizeShip;

                    }
                    else{
                        System.out.println("Your inpur was wrong, system changes status for you.Thank you:)...");
                        arrShipments[SizeShip-1].setFlagIsReceived(1);
                        i = SizeShip;
                    }
                }
            }
            System.out.println("List of Shipments we have : ");
            for (int i = 0; i < SizeShip; i++) {
                System.out.println(arrShipments[i]);
            }
        }
    }




}
