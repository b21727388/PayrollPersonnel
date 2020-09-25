import java.io.FileWriter;
import java.io.IOException;

public class PartTime extends Employee{
    int salary = 0;
    int partTimeHourly = 18;

    public void SalaryCalculator(Personnel partTime){
        int[] weekList = new int[4];// CREATING A NEW LIST FOR WEEKLY WORKING HOURS TO USE IN FOR LOOP.
        weekList[0] = partTime.getFirstWeekH();
        weekList[1] = partTime.getSecondWeekH();
        weekList[2] = partTime.getThirdWeekH();
        weekList[3] = partTime.getFourthWeekH();

        String fileName = partTime.getRegisterNumber() + ".txt";//OUTPUT FILE NAME
        String[] name = partTime.getNameSurname().split(" ");//SPLITTING NAME AND SURNAME

        salary = (severancePay * (currentYear - partTime.getStartYear()));//MONTHLY CONSTANT SALARY

        /////// THIS FOR LOOP IS CALCULATING SALARY WEEK BY WEEK/////////////////
        for(int i = 0; i < 4 ; i++){
            if( weekList[i] >= 10){
                if(weekList[i] >= 20) {
                    salary += ( 20 * partTimeHourly);
                }else{
                    salary += (weekList[i] * partTimeHourly);
                }
            }
        }
        ////

        //// THIS CODE BLOCK IS CREATING OUTPUT FILE WITH A GIVING ORDER/////////////////
        try {
            writer = new FileWriter(fileName);
            writer.write("Name : "+ name[0] +"\nSurname : " + name[1] + "\nRegistration Number : "+partTime.getRegisterNumber()+"\nPosition : "+ partTime.getPosition()+"\nYear of Start : "+partTime.getStartYear()+"\nTotal Salary : " + salary+".00 TL");
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
