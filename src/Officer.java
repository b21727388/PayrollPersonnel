import java.io.FileWriter;
import java.io.IOException;

public class Officer extends Personnel {
    int salary = 0;
    int ssBenefits = 1690;
    int addCourseFee = 20;

    public void SalaryCalculator(Personnel officer){
        int[] weekList = new int[4];// CREATING A NEW LIST FOR WEEKLY WORKING HOURS TO USE IN FOR LOOP.
        weekList[0] = officer.getFirstWeekH();
        weekList[1] = officer.getSecondWeekH();
        weekList[2] = officer.getThirdWeekH();
        weekList[3] = officer.getFourthWeekH();

        String fileName = officer.getRegisterNumber() + ".txt";//OUTPUT FILE NAME
        String[] name = officer.getNameSurname().split(" ");//SPLITTING NAME AND SURNAME

        salary = super.baseSalary + ssBenefits + (super.severancePay * (super.currentYear - officer.getStartYear()));//MONTHLY CONSTANT SALARY

        /////// THIS FOR LOOP IS CALCULATING SALARY WEEK BY WEEK/////////////////
        for(int i = 0; i < 4; i++){
            if(weekList[i] >= 40){
                if(weekList[i] >= 50){
                    salary += (addCourseFee * 10);
                }else{
                    salary +=  (addCourseFee * (weekList[i] - 40));
                }
            }
        }
        ////

        //// THIS CODE BLOCK IS CREATING OUTPUT FILE WITH A GIVING ORDER/////////////////
        try {
            writer = new FileWriter(fileName);
            writer.write("Name : "+ name[0] +"\nSurname : " + name[1] + "\nRegistration Number : "+officer.getRegisterNumber()+"\nPosition : "+ officer.getPosition()+"\nYear of Start : "+officer.getStartYear()+"\nTotal Salary : " + salary+".00 TL");
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
