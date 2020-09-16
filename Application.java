import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;
/**
 * Class Application is for user interface that handles user input anf output.
 *
 * @author (Palak)
 * @version (24/03/2018)
 */
public class Application
{
    /**
     * main() - handles input and output
     *
     * @param  args
     */
    public static void main(String[] args)
    {
        LabMaster objLabMaster = new LabMaster();
        Lab objLab = new Lab();
        Scanner sc = new Scanner(System.in);
        boolean isContinue = true;
           
        do
        {
            userChoice();
            int option = sc.nextInt();
        
        if(option == 1)    // Adds new Lab
        {
            System.out.println("\nEnter room number:");
            int roomNumber = sc.nextInt();
            System.out.println("Enter tutor name:");
            String tutorName = sc.next();
            System.out.println("Enter lab time:");
            String labTime = sc.next();
            System.out.println("Enter lab capacity:");
            int capacity = sc.nextInt();
            System.out.println("Enter lab Subject:");
            String subject = sc.next();
            System.out.println("Enter subject code:");
            int subjectCode = sc.nextInt();       
            Lab lab = new Lab(roomNumber, tutorName, labTime, capacity, subject, subjectCode);
            addLab(lab, objLabMaster);
        }
        else if(option == 2)  //Removes a Lab
        {
            boolean isAnyRecod = objLabMaster.checkRecords();
            if(isAnyRecod)
            {
                System.out.println("Enter subject code:");
                int subjectCode = sc.nextInt();     
                System.out.println("Enter lab number:");
                int labNumber = sc.nextInt();
                System.out.println("Enter lab time:");
                String labTime = sc.next();
                Lab lab = new Lab(labNumber, subjectCode, labTime);
                removeLab(lab, objLabMaster);    
            }
            else
            {
                System.out.println("There are no records.");
            }
            
        }
        else if(option == 3)  // Shows all available Labs
        {
            showAllLab(objLabMaster);
        }
        else if(option == 4)  // Adds a student to Lab
        {
            int labNumber = objLabMaster.getAvailableLabs().size();
            if(labNumber > 0)
            {
                System.out.println("Enter Student Name:");
                String name = sc.next();     
                System.out.println("\nEnter Student ID:");
                int studentNumber = sc.nextInt();
                Student objStudent = new Student(studentNumber, name);
                addNewStudent(objLab, objStudent);
            }
            else
            {
                System.out.println("No labs available, please enter lab first.");
            }
        }
        else if(option == 5)  // Deletes Student from a Lab
        {
            int studentCount = objLab.getStudentList().size();
            if(studentCount > 0)
            {
                System.out.println("Enter Student Name:");
                String name = sc.next();     
                System.out.println("\nEnter Student ID:");
                int studentNumber = sc.nextInt();
                Student objStudent = new Student(studentNumber, name);
                removeStudent(objLab, objStudent);    
            }
            else    
            {
                System.out.println("No students, please enter student first.");
            }    
            
        }
        else if(option == 6)  //  changes Student Lab 
        {
            int labNumber = objLabMaster.getAvailableLabs().size();
            if(labNumber > 0)
            {
                System.out.println("Enter Student Name:");
                String name = sc.next();     
                System.out.println("\nEnter Student ID:");
                int studentNumber = sc.nextInt();
                Student objStudent = new Student(studentNumber, name);

                System.out.println("Enter current subject code:");
                int currentSubjectCode = sc.nextInt();     
                System.out.println("Enter current lab time:");
                String currentLabTime = sc.next();
                System.out.println("\nEnter current lab number:");
                int currentLabNumber = sc.nextInt();

                System.out.println("Enter new subject code:");
                int newSubjectCode = sc.nextInt();     
                System.out.println("Enter new lab time:");
                String newLabTime = sc.next();
                System.out.println("\nEnter new lab number:");
                int newLabNumber = sc.nextInt();


                Lab currentLab = new Lab(currentLabNumber, currentSubjectCode, currentLabTime);
                Lab newLab = new Lab(newLabNumber, newSubjectCode, newLabTime);

                changeLab(objStudent, currentLab, newLab, objLabMaster, objLab);
            }
            else
            {
                System.out.println("No labs available, please enter lab first.");
            }

        }
        else if(option == 7)   // Shows all Labs booked by student
        { 
            showAllBookedLab(objLabMaster);
        }
        else if(option == 8)  // Exits the system
        {
            System.exit(0);
        }
        else
        {
            System.out.println("Invalid entry, please try again.");
        }
        
        System.out.println("Do you want to continue? y/n");  // Asks user for continuation
        String answer = sc.next();
        if(answer.equals("n"))
        {
            isContinue = false;
        }
        
        }
        while(isContinue);
    }

    /**
     * addLab() - Adds new Lab
     *
     * @param  objLab, objLabMaster
     */
    public static void addLab(Lab objLab, LabMaster objLabMaster)
    {
        boolean isCompleted = false;
        isCompleted = objLabMaster.addLab(objLab);
                
        if(isCompleted)
        {
             System.out.println("\nRecored saved\n");
        }
        else
        {
            System.out.println("\nRecored not saved\n");
        }
    }
    
    /**
     * removeLab() - Deletes a Lab
     *
     * @param  objLab, objLabMaster
     */
    public static void removeLab(Lab objLab, LabMaster objLabMaster)
    {
      boolean isAnyRecord =  objLabMaster.checkRecords();
      boolean isRemoved = false;
      if(isAnyRecord)
      {
            isRemoved = objLabMaster.removeLab(objLab);
            if(isRemoved)
            {
                System.out.println("Record removed successfully.");
            }
            else
            {
                System.out.println("Record not removed.");   
            }
      }
      else 
      {
            System.out.println("No records found.");
      }
    }
    
    /**
     * showAllLab() - Displays all Labs
     *
     * @param  objLabMaster
     */

    public static void showAllLab(LabMaster objLabMaster)
    {
        ArrayList<Lab> lstLab = new ArrayList<Lab>();
        lstLab = objLabMaster.getAvailableLabs();
        if(lstLab.size() > 0)
        {
            System.out.println("Subject Code   Lab#      Room      Time    Tutor     Capacity    Subject  ");
            System.out.println("--------------------------------------------------------------------------");
            for (Lab objLab : lstLab )
            {
                System.out.println(objLab);
            }
        }
        else
        {
            System.out.println("No labs found. ");
        }
    }
    
    /**
     * addNewStudent() - Adds new student to lab
     *
     * @param  objLab, objStudent
     */
    public static void addNewStudent(Lab objLab, Student objStudent)
    {
        boolean isRegistered = false;
        isRegistered = objLab.addStudent(objStudent);
        if(isRegistered)
        {
            System.out.println("Student registered successfully.");
        }
        else
        {
            System.out.println("Student already exists.");   
        }
    }
    
    /**
     * removeStudent() - Deletes a student from lab
     *
     * @param  objLab, objStudent
     */
    public static void removeStudent(Lab objLab , Student objStudent)
    {
        boolean isRemoved = false;
        isRemoved = objLab.removeStudent(objStudent);
        if(isRemoved)
        {
            System.out.println("Student removed successfully."); 
        }
        else
        {
            System.out.println("No student found.");   
        }
    }
    
    /**
     * changeLab() - Changes student Lab
     *
     * @param  objStudent, currentLab, newLab, objLabMaster, objLab
     */
    public static void changeLab( Student objStudent, Lab currentLab, Lab newLab, LabMaster objLabMaster, Lab objLab)
    {
        boolean isStudentExist = false;
        boolean isCurrentLabExist = false;
        boolean isNewLabExist = false;
        boolean isChanged = false;
        isStudentExist = objLab.searchStudent(objStudent);
        isCurrentLabExist = objLabMaster.SearchLab(currentLab);
        isNewLabExist = objLabMaster.SearchLab(newLab);
        if(!isStudentExist)
        {
            System.out.println("No student found.");
        }
        if(!isCurrentLabExist)
        {
            System.out.println("No current lab found.");   
        }
        if(!isNewLabExist)
        {
            System.out.println("No new lab found.");
        }
        if(isStudentExist && isCurrentLabExist && isNewLabExist)
        {
          isChanged = objLab.changeLab(objStudent, currentLab, newLab, objLabMaster);
          if(isChanged)
          {
              System.out.println("Lab changed successfully.");
          }
        }
    }
    
    /**
     * showAllBookedLab() - Displays all booked Lab
     *
     * @param  objLabMaster
     */
    public static void showAllBookedLab(LabMaster objLabMaster)
    {
        ArrayList<Lab> lstLab = new ArrayList<Lab>();
        lstLab = objLabMaster.getBookedLabs();
        if(lstLab.size() > 0)
        {
            for (Lab objLab : lstLab )
            {
                System.out.println(objLab);
            }
        }
        else
        {
            System.out.println("No labs found ");
        }
    }
    
    /**
     * userChoice() - Displays all user choices.
     *
     */
    public static void userChoice()
    {
        System.out.println("\nStudent Lab Management System");
        System.out.println("----------------------------------------");
        System.out.println("Choose your option from below list:");
        System.out.println("----------------------------------------");
        System.out.println("1. Add a lab");
        System.out.println("2. Remove a lab");
        System.out.println("3. Show all labs");
        System.out.println("4. Register a student for a lab");
        System.out.println("5. Remove a student from lab");
        System.out.println("6. Change student lab");
        System.out.println("7. List all already booked lab");
        System.out.println("8. Exit \n");
    }
}
