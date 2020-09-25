import java.io.FileWriter;
import java.io.IOException;

public class Security extends Personnel {
    int salary = 0;
    int weeklyTransportNFood = 90;
    int hourlySecurity = 10;

    public void SalaryCalculator (Personnel security){
        int[] weekList = new int[4];// CREATING A NEW LIST FOR WEEKLY WORKING HOURS TO USE IN FOR LOOP.
        weekList[0] = security.getFirstWeekH();
        weekList[1] = security.getSecondWeekH();
        weekList[2] = security.getThirdWeekH();
        weekList[3] = security.getFourthWeekH();

        String fileName = security.getRegisterNumber() + ".txt";//OUTPUT FILE NAME
        String[] name = security.getNameSurname().split(" ");//SPLITTING NAME AND SURNAME

        salary = (super.severancePay *(super.currentYear - security.getStartYear()));//MONTHLY CONSTANT SALARY

        /////// THIS FOR LOOP IS CALCULATING SALARY WEEK BY WEEK/////////////////
        for (int i = 0; i < 4 ; i++){
            if(weekList[i] < 30){
            }else if (weekList[i] >= 54){
                salary += weeklyTransportNFood + (54 * hourlySecurity);
            }else{
                salary += weeklyTransportNFood + (weekList[i] * hourlySecurity);
            }
        }
        ////

        //// THIS CODE BLOCK IS CREATING OUTPUT FILE WITH A GIVING ORDER/////////////////
        try {
            writer = new FileWriter(fileName);
            writer.write("Name : "+ name[0] +"\nSurname : " + name[1] + "\nRegistration Number : "+security.getRegisterNumber()+"\nPosition : "+ security.getPosition()+"\nYear of Start : "+security.getStartYear()+"\nTotal Salary : " + salary+".00 TL");
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
