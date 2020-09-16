import java.util.ArrayList;
import java.lang.String;
import java.util.Iterator;
/**
 * Class LabMaster handles all the operation related to lab.
 *
 * @author (Palak)
 * @version (24/03/2018)
 */
public class LabMaster
{
    // instance variables 
    private ArrayList<Lab> lstLab;
    
    /**
     * Constructor for objects of class LabMaster
     */
    public LabMaster()
    {
       lstLab = new ArrayList<Lab>();
       
    }

    /**
     * getLabList() - Gets list of Lab
     *
     * @return lstLab
     */
    public ArrayList<Lab> getLabList()
    {
        return this.lstLab;
    }

     /**
     * setLabList() - Sets Lab List
     *
     * @param lstLab
     */
    public void setLabList(ArrayList<Lab> lstLab)
    {
        this.lstLab = lstLab;
    }

    /**
     * addLab() - Adds new lab
     *
     * @param  objLab
     * @return  true or false
     */
    public boolean addLab(Lab objLab)
    {
        int labNumber = objLab.getLabNumber();
        boolean isExist = false;
   
            if(lstLab.size() > 0)
            {
                isExist = SearchLab(objLab);
              
                if(isExist)
                {
                    return false;
                }
                else
                {
                    labNumber = labNumber + 1;
                    objLab.setLabNumber(labNumber);
                    lstLab.add(objLab);
                    return true;
                }
            }
            else
            {
                 labNumber = labNumber + 1;
                 objLab.setLabNumber(labNumber);
                 lstLab.add(objLab);
                 return true;
            }
    }

    /**
     * SearchLab() - Finds Lab
     *
     * @param  objLab
     * @return  true or false
     */
    public boolean SearchLab(Lab objLab)
    {
        boolean isExists = false;
        for(Lab lab : lstLab)
        {
            int roomNo = lab.getRoomNumber();
            int roomNo1 = objLab.getRoomNumber();
            String time = lab.getTime();
            String time1 = objLab.getTime();
            String sub = lab.getSubject();
            String sub1 = objLab.getSubject();
                
            if((roomNo == roomNo1) && time.equals(time1) && sub.equals(sub1))
            {
                isExists = true;
            }

        }
       return isExists;
    }
    
    /**
     * removeLab() - Deletes Lab
     *
     * @param  objLab
     * @return  true or false
     */
    public boolean removeLab(Lab objLab)
    {
        boolean isRemoved = false;
        boolean isExist = false;
        if(lstLab.size() > 0)
        {
            isExist  = SearchLabToRemove(objLab);
            if(isExist)
            {   
                Iterator<Lab> itLab = lstLab.iterator();
                while(itLab.hasNext())
                {
                    Lab lab  = itLab.next();
                    int labNumber = lab.getRoomNumber();
                    int subCode = lab.getSubjectCode(); 
                    int studentRegistered = 0;
                    if(objLab.getStudentList() != null)
                    {
                        studentRegistered = objLab.getStudentList().size();
                    }

                    if((labNumber == objLab.getRoomNumber()) && (subCode == objLab.getSubjectCode()) && (studentRegistered == 0))
                    {
                        itLab.remove();
                        isRemoved = true;
                    }
                }
            }
        }
        return isRemoved;
    }

    /**
     * checkRecords() - Checks record size
     *
     * @return  true or false
     */
    public boolean checkRecords()
    {
       int size = lstLab.size();
       if (size > 0)
        {
           return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * SearchLabToRemove() - Finds a lab
     *
     * @param  objLab
     * @return  true or false
     */
    public boolean SearchLabToRemove(Lab objLab)
    {
        boolean isExists = false;
        for(Lab lab : lstLab)
        {
            int roomNo = lab.getRoomNumber();
            int roomNo1 = objLab.getRoomNumber();
            int subCode = lab.getSubjectCode();
            int subCode1 = objLab.getSubjectCode();
                
            if((roomNo == roomNo1) && (subCode == subCode1))
            {
                isExists = true;
            }

        }
       return isExists;
    }

    /**
     * getAvailableLabs() - Gets available Labs
     *
     * @return  objLabs
     */
    public ArrayList<Lab> getAvailableLabs()
    {
        ArrayList<Lab> objLabs = new ArrayList<Lab>();   
        if(lstLab.size() >0)
        {
            for(Lab lab : lstLab)
            {
              int size =  lab.getStudentList().size();
              int capacity = lab.getCapacity();
              if(capacity - size > 0)
              {
                objLabs.add(lab);
              }
            }
        }
        return objLabs;
    }

    /**
     * getBookedLabs() - Gets booked Lab
     *
     * @return  lstLab
     */
    public ArrayList<Lab> getBookedLabs()
    {
        ArrayList<Lab> lstLab = new ArrayList<Lab>(); 
        if(lstLab.size() >0)
        {
            for(Lab lab : lstLab)
            {
              int size =  lab.getStudentList().size();
              if(size != 0)
              {
                lstLab.add(lab);
              }
            }
        }
        return lstLab;
    }


}
