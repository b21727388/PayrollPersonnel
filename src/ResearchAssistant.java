import java.io.FileWriter;
import java.io.IOException;

public class ResearchAssistant extends Academician {
    int salary = 0;
    int ssBenefits = 2730;
    public void SalaryCalculator(Personnel raMem){

        int[] weekList = new int[4];// CREATING A NEW LIST FOR WEEKLY WORKING HOURS TO USE IN FOR LOOP.
        weekList[0] = raMem.getFirstWeekH();
        weekList[1] = raMem.getSecondWeekH();
        weekList[2] = raMem.getThirdWeekH();
        weekList[3] = raMem.getFourthWeekH();

        String fileName = raMem.getRegisterNumber() + ".txt";//OUTPUT FILE NAME
        String[] name = raMem.getNameSurname().split(" ");//SPLITTING NAME AND SURNAME

        salary = super.baseSalary + ssBenefits + (super.severancePay * (super.currentYear - raMem.getStartYear()));//MONTHLY CONSTANT SALARY

        //// THIS CODE BLOCK IS CREATING OUTPUT FILE WITH A GIVING ORDER/////////////////
        try {
            writer = new FileWriter(fileName);
            writer.write("Name : "+ name[0] +"\nSurname : " + name[1] + "\nRegistration Number : "+raMem.getRegisterNumber()+"\nPosition : "+ raMem.getPosition()+"\nYear of Start : "+raMem.getStartYear()+"\nTotal Salary : " + salary+".00 TL");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //////////////

    }
}
