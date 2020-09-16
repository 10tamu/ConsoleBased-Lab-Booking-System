
/**
 * Student Class having its getters and Setters methods.
 *
 * @author (Palak)
 * @version (24/03/2018)
 */
public class Student
{
    // instance variables
    private int id;
    private String name;

    /**
     * Constructors for objects of class Student
     */
        
    public Student(int id){
        this.id = id;
    }
    
    /**
     * Constructors for objects of class Student with name parameter
     */
    public Student(String name)
    {
        this.name = name;
    }

    /**
     * Constructors for objects of class Student with name and id parameter
     */
    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * toString() - returns string
     *
     * @return  String
     */
    public String toString()
    {
        return "\n" + this.id + "  " + this.name;
    }
    
    /**
     * setID() - Sets ID for Student
     *
     * @param  ID
     */
    public void setID(int id)
    {
        // put your code 
        this.id = id;
    }
    
    /**
     * getID() - Gets ID for Student
     *
     * @return  ID
     */

    public int getID()
    {
        return this.id;
    }
    
     /**
     * setName() - Sets Name for Student
     *
     * @param  name
     */
    public void setName(String name)
    {
        // put your code 
        this.name = name;
    }
    
    /**
     * getName() - Gets Name for Student
     *
     * @return  name
     */
    public String getName()
    {
        return this.name;
    }
}
