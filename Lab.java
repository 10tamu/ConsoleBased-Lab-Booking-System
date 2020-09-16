import java.util.ArrayList;
import java.lang.String;
import java.util.Iterator;
/**
 * Class Lab handles Student Management.
 *
 * @author (Palak)
 * @version (24/03/2018)
 */
public class Lab
{
    // instance variables 
    private int roomNumber;
    private String tutorName;
    private String time;
    private int capacity;
    private String subject;
    private int subjectCode;
    private int labNumber;
    private ArrayList<Student> lstStudent;

    /**
     * Constructor for objects of class Lab
     */
    public Lab()
    {
        this.lstStudent = new ArrayList<Student>();
    }

    /**
     * Constructor for objects of class Lab with roomNumber, tutorName, time, capacity, subject, subjectCode parameters
     */
    public Lab(int roomNumber, String tutorName, String time, int capacity, String subject, int subjectCode)
    {
        // initialise instance variables
        this.roomNumber = roomNumber;
        this.tutorName = tutorName;
        this.time = time;
        this.capacity = capacity;
        this.subject = subject;
        this.subjectCode = subjectCode;
        this.lstStudent = new ArrayList<Student>();   
        labNumber = 0;
     
    }

    /**
     * Constructor for objects of class Lab with roomNumber, time, subjectCode parameters
     */
    public Lab(int roomNumber, int subjectCode, String time)
    {
        this.roomNumber = roomNumber;
        this.subjectCode = subjectCode;
        this.time = time;
    }

    /**
     * getRoomNumber() - Gets RoomNumber for Lab
     *
     * @return roomNumberD
     */
    public int getRoomNumber()
    {
        return this.roomNumber;
    }
    
     /**
     * setRoomNumber() - Sets roomNumber for Lab
     *
     * @param roomNumber
     */
    public void setRoomNumber(int roomNumber)
    {
         this.roomNumber = roomNumber;
    }
    
    /**
     * getTutorName() - Gets tutorName for Lab
     *
     * @return tutorName
     */
    public String getTutorName()
    {
        return this.tutorName;
    }
    
     /**
     * setTutorName() - Sets tutorName for Lab
     *
     * @param  tutorName
     */
    public void setTutorName(String tutorName)
    {
         this.tutorName = tutorName;
    }
    
    /**
     * getTime() - Gets time for Lab
     *
     * @return time
     */
    public String getTime()
    {
        return this.time;
    }
    
     /**
     * setTime() - Sets time for Lab
     *
     * @param  setTime
     */
    public void setTime(String time)
    {
         this.time= time;
    }
    
     /**
     * setCapacity() - Sets capacity for Lab
     *
     * @param  capacity
     */
    public void setCapacity(int capacity)
    {
         this.capacity= capacity;
    }
    
    /**
     * getCapacity() - Gets capacity for Lab
     *
     * @return  capacity
     */
    public int getCapacity()
    {
        return this.capacity;
    }
    
    /**
     * getSubject() - Gets subject for Lab
     *
     * @return  subject
     */
    public String getSubject()
    {
        return this.subject;
    }
    
     /**
     * setSubject() - Sets subject for Lab
     *
     * @param  subject
     */
    public void setSubject(String subject)
    {
         this.subject = subject;
    }
    
     /**
     * setSubjectCode() - Sets subjectCode for Lab
     *
     * @param  subjectCode
     */
    public void setSubjectCode(int subjectCode)
    {
         this.subjectCode = subjectCode;
    }
    
    /**
     * getSubjectCode() - Gets subjectCode for Lab
     *
     * @return  subjectCode
     */
    public int getSubjectCode()
    {
        return this.subjectCode;
    }
    
    /**
     * getLabNumber() - Gets labNumber for Lab
     *
     * @return  labNumber
     */
    public int getLabNumber()
    {
        return this.labNumber;
    }

     /**
     * setLabNumber() - Sets labNumber for Lab
     *
     * @param  labNumber
     */
    public void setLabNumber(int labNumber)
    {
        this.labNumber = labNumber;
    } 

    /**
     * getStudentList() - Gets lstStudent for Lab
     *
     * @return  lstStudent
     */
    public ArrayList<Student> getStudentList()
    {
        return this.lstStudent;
    }

     /**
     * setStudentList() - Sets lstStudent for Lab
     *
     * @param  lstStudent
     */
    public void setStudentList(ArrayList<Student> lstStudent)
    {
        this.lstStudent = lstStudent;
    }

     /**
     * toString() - a string with Lab Data
     *
     * @param  Lab Data
     */
    public String toString()
    {
        return  subjectCode + "               " +   this.labNumber+  "        "    + this.roomNumber + "         "  + time + "     " +   tutorName + "        "  +  capacity + "           "  + subject;
    }
    
    /**
     * addStudent() - Adds new student
     *
     * @param  student
     * @return  true or false
     */
    public boolean addStudent(Student student)
    {
        
        boolean isAdded = false;
        setStudentList(lstStudent);
        if(lstStudent.size() != 0)
        {
      
           boolean isExist =  searchStudent(student); 

           if(!isExist)
           {
                lstStudent.add(student);    
                isAdded = true;    
           }
        }
        else
        {
            lstStudent.add(student);    
            isAdded = true;
        }
        
       return isAdded;
    }
    
    /**
     * removeStudent() - Deletes student from a lab
     *
     * @param  student
     * @return  true or false
     */
    public boolean removeStudent(Student student)
    {
        boolean isRemoved = false;
        if(lstStudent.size() > 0)
        {
           boolean isExist =  searchStudent(student);
           if(isExist)
           {
                lstStudent.remove(student);        
                isRemoved = true;    
           }
        }
        else
        {
            isRemoved = false;
        }
        return isRemoved;
    }

    /**
     * getRegistredStudentCount() - Gets registered students for lab
     *
     * @return  student count
     */
    public int getRegistredStudentCount()
    {
        return lstStudent.size();
    }
    
    /**
     * searchStudent() - finds student from list
     *
     * @param  student
     * @return  true or false
     */
    public boolean searchStudent(Student student)
    {
       boolean isContainsName = false;
       boolean isContainsID = false;
       boolean isAlreadyExist = false;
       if(getStudentList().size()>0)
       {
            for(Student objStudent : lstStudent)
            {
                isContainsName = (objStudent.getName()).equals(student.getName());
                isContainsID = objStudent.getID() == student.getID();
            }
            
          if(isContainsName && isContainsID)
          {
            isAlreadyExist = true;
          }
       } 
       return isAlreadyExist;
    }

     /**
     * changeLab() - Change lab for student
     *
     * @param  objStudent, currentLab, newLab, objLabMaster
     * @return  true or false
     */
    public boolean changeLab(Student objStudent, Lab currentLab, Lab newLab, LabMaster objLabMaster)
    {
        ArrayList<Lab> lstLab = new ArrayList<Lab>();
        lstLab = objLabMaster.getLabList();
        boolean isChanged = false;
        for(Lab lab : lstLab)
        {
            String time = lab.getTime();
            int labNumber = lab.getLabNumber();
            int subCode = lab.getSubjectCode(); 
            if((labNumber == currentLab.getRoomNumber()) && (subCode == currentLab.getSubjectCode()) && (time.equals(currentLab.getTime())))
            {
                lab.setRoomNumber(newLab.getRoomNumber());
                lab.setSubjectCode(newLab.getSubjectCode());
                lab.setTime(newLab.getTime());
                
                isChanged = true;
            }
        }
               
        return isChanged;
    }
}
