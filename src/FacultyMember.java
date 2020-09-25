import java.io.FileWriter;
import java.io.IOException;

public class FacultyMember extends Academician {
    int salary = 0;
    int ssBenefits = 3510;
    int addCourseFee = 20;

    public void SalaryCalculator (Personnel facMem){

        int[] weekList = new int[4]; // CREATING A NEW LIST FOR WEEKLY WORKING HOURS TO USE IN FOR LOOP.
        weekList[0] = facMem.getFirstWeekH();
        weekList[1] = facMem.getSecondWeekH();
        weekList[2] = facMem.getThirdWeekH();
        weekList[3] = facMem.getFourthWeekH();

        String fileName = facMem.getRegisterNumber() + ".txt"; //OUTPUT FILE NAME
        String[] name = facMem.getNameSurname().split(" "); //SPLITTING NAME AND SURNAME

        salary = super.baseSalary + ssBenefits + (super.severancePay *(super.currentYear - facMem.getStartYear())); //MONTHLY CONSTANT SALARY

        /////// THIS FOR LOOP IS CALCULATING SALARY WEEK BY WEEK/////////////////
        for(int i = 0; i < 4; i++){
            if(weekList[i] >= 40){
                if(weekList[i] >= 48){
                    salary +=  (addCourseFee * 8);
                }else{
                    salary += (addCourseFee * (weekList[i] - 40));
                }
            }
        }
        ////

        //// THIS CODE BLOCK IS CREATING OUTPUT FILE WITH A GIVING ORDER/////////////////
        try {
            super.writer = new FileWriter(fileName);
            super.writer.write("Name : "+ name[0] +"\nSurname : " + name[1] + "\nRegistration Number : "+facMem.getRegisterNumber()+"\nPosition : "+ facMem.getPosition()+"\nYear of Start : "+facMem.getStartYear()+"\nTotal Salary : " + salary+".00 TL");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (super.writer != null) {
                try {
                    super.writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //////////////

    }
}
