
/**
 *   Homework #1
 *   File:   Workable.java
 *   @author: Alina Kuralova
 *   Student no - 171044094
 */

/**
 * interface Workable
 */
public interface Workable {
   /**
    * Sets name of the Worker
    */
   public void setName(String NewName);
   /**
    * Sets surname of the Worker
    */
   public void setSurname(String NewSurname);

   /**
    * Sets password of the Worker
    */
   public void setPassword(String NewPassword);

   /**
    * Sets logName of the Worker
    */
   public void setLogName(String NewLogName);

   /**
    * Gets name of the Worker
    */
   public String getName();
   /**
    * Gets surname of the Worker
    */
   public String getSurname();

   /**
    * Gets password of the Worker
    */
   public String getPassword();

   /**
    * Gets logName of the Worker
    */
   public String getLogName();
   /**
    * To String method
    */
   public String toString();

}
