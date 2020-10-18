import java.util.Scanner;
import java.lang.*;

/**
 * TransportEmployee class which extends AbstractWorkers
 */
public class TransportEmployee extends AbstractWorkers {

    protected String BranchNameOfTrans;
    protected int shipmentOfTrans;
    /**
     * Constructor
     */
    public TransportEmployee(){
        super();
    }

    /**
     * Constructor
     * @param name to be assigned
     * @param surname to be assigned
     * @param logName to be assigned
     * @param password to be assigned
     */
    public TransportEmployee(String name, String surname, String logName, String password)
    {
        super( name,  surname,  logName,  password);
    }

    /**
     * Register the Transportation Employee to Kargo System by asking
     * personal information
     * @param in ggggg
     */
    protected void signIn(Scanner in)
    {
        System.out.println("Enter a Name: ");
        setName(in.nextLine());

        System.out.println("Enter a Surname: ");
        setSurname(in.nextLine());

        System.out.println("Enter a Logname: ");
        setLogName(in.nextLine());

        System.out.println("Enter a password: ");
        setPassword(in.nextLine());
    }

    /**
     * compares the parameter  with this class
     *
     * @param Person
     * @return if equals returns true,else returns false
     */
    @Override
    public boolean equals(AbstractWorkers Person){
        if(Person == this ) return true;
        if(Person == null ) return false;

        /**
         * exeption handling using try-catch method
         * */
        try{
            TransportEmployee temp = (TransportEmployee)Person;
            return (getName().equals(temp.getName()) && getSurname().equals(temp.getSurname()));
        }
        catch(ClassCastException E){
            System.out.println("Wrong input for (equals) method!, input is" + "not a Transportation Employee");
            return false;
        }
    }



}
