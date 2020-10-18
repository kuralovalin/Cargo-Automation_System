import java.util.Scanner;
import java.lang.*;
import java.security.InvalidParameterException;
/**
 * Main class to test Kargo System class
 *
 * Ask user to login as: administrator, branch employee, transportation personnel, customer.
 * Administrator can add, remove(branch, branch employee, transportation personnel)
 * Branch employees can add, remove(shipments, customers ), changes current status of the shipment.
 * Transportation personnel makes the update of the shipments.
 * Customer enters the system with the tracking number (to see sender,receiver and status of the shipment) or sends the shipment.
 */

public class Main {

    public static void main(String[] args) {
        try {

            KargoSystem company = new KargoSystem();
            Branch bran1 = new Branch();
            boolean flag11=true;
            boolean flag22 = true;

            company.readFromFile("adminTest.txt");

            System.out.println("Administrators you have for now..");
            System.out.println("Please enter logName and Password one of them (Made it in purpose of security, only for teacher PROVIDED -> LogName alina Password 000)...");
            for (int i = 0; i < company.SizeAdd; i++) {
                System.out.println(company.arrAdmin[i]);
            }

            while(flag11) {

                System.out.println("Welcome to Kargo System company ! \n");
                System.out.println("\t LOGIN AS: \n1)Administrator \n2)Branch Employee \n3)Transportational Personnel \n4)Customer \n5)Exit ");

                Scanner sc = new Scanner(System.in);
                int logChoise = sc.nextInt();sc.nextLine();

                if (logChoise == 1)
                {
                    boolean adLog1 = company.adminLogin(sc);

                    if(adLog1 == true) {
                        while (flag22) {
                            System.out.println(" 1)Add administrator \n 2)Add branch \n 3)Remove branch \n 4)Add Branch Employee \n 5)Remove Branch Employee \n 6)Add Transportation Employee \n " +
                                    "7)Remove Transportation Employee \n 8)Exit \n");

                            int adminChoice = sc.nextInt();sc.nextLine();
                               if (adminChoice == 1)
                                   company.adminSignUP(sc);
                               if (adminChoice == 2)
                                   company.adminAddBranch(sc);
                               if (adminChoice == 3)
                                   company.adminRemoveBranch(sc);
                               if (adminChoice == 4)
                                   bran1.AddBranchEmp(sc);
                               if (adminChoice == 5)
                                   bran1.RemoveBranchEmp(sc);
                               if (adminChoice == 6)
                                   bran1.AddTransEmp(sc);
                               if (adminChoice == 7)
                                   bran1.RemoveTransEmp(sc);
                               if (adminChoice == 8)
                               flag22 = false;
                        }
                        adLog1 = false;
                    }
                }
                flag22=true;

                if (logChoise == 2) {
                    boolean brLog1 = bran1.BranchEmpLogin(sc);
                    if(brLog1 == true) {
                        while (flag22) {
                            System.out.println(" 1)Check(List) for shipments of my branch \n 2)Change current status of shipment \n 3)Add shipment \n 4)Remove shipment \n 5)Exit");
                            int branchEmpChoice = sc.nextInt();sc.nextLine();
                            if (branchEmpChoice == 1)
                                bran1.listShipmentsEmp(sc);
                            if (branchEmpChoice == 2)
                                bran1.changeStatusShip(sc);
                            if (branchEmpChoice == 3)
                                bran1.addShipment(sc);
                            if (branchEmpChoice == 4)
                                bran1.removeShipment(sc);
                            if (branchEmpChoice == 5)
                                flag22 = false;
                        }
                    }
                }
                flag22=true;
                if (logChoise == 3) {
                    boolean trLog1 =  bran1.transPerLogin(sc);
                    if(trLog1 == true){
                        while(flag22) {
                            System.out.println(" 1)Check(List) for shipments related to me \n 2)Deliver \n 3)Exit \n");
                            int transPerChoice = sc.nextInt();sc.nextLine();
                            if (transPerChoice == 1)
                                bran1.listShipmentsTransPer(sc);
                            if (transPerChoice == 2)
                                bran1.deliverByTransEmp(sc);
                            if (transPerChoice == 3)
                                    flag22=false;
                        }
                    }
                }
                flag22=true;
                if (logChoise == 4) {
                    while(flag22) {
                        System.out.println(" 1)Send shipment \n 2)Track my shipment \n 3)Exit \n");
                        int CustomerChoice = sc.nextInt();sc.nextLine();
                        if (CustomerChoice == 1)
                            company.SendShipCustomer(sc);
                        if (CustomerChoice == 2)
                            company.trackShipCustomer(sc);
                        if (CustomerChoice == 3)
                            flag22 = false;
                    }
                }
                flag22=true;
                if(logChoise == 5)
                    flag11=false;
            }

        }
        catch (Throwable throwable) {
            throw new InvalidParameterException(throwable.getMessage());
        }

    }
}
