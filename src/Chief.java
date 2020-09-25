import java.io.FileWriter;
import java.io.IOException;

public class Chief extends FullTime {
    int salary = 0;
    int weeklyChief = 625;
    int extraChief = 15;

    public void SalaryCalculator(Personnel chief){
        int[] weekList = new int[4];// CREATING A NEW LIST FOR WEEKLY WORKING HOURS TO USE IN FOR LOOP.
        weekList[0] = chief.getFirstWeekH();
        weekList[1] = chief.getSecondWeekH();
        weekList[2] = chief.getThirdWeekH();
        weekList[3] = chief.getFourthWeekH();

        String fileName = chief.getRegisterNumber() + ".txt";//OUTPUT FILE NAME
        String[] name = chief.getNameSurname().split(" ");//SPLITTING NAME AND SURNAME

        salary =  (4 * weeklyChief) + (super.severancePay * (super.currentYear - chief.getStartYear()));//MONTHLY CONSTANT SALARY

        /////// THIS FOR LOOP IS CALCULATING SALARY WEEK BY WEEK/////////////////
        for(int i = 0; i < 4 ; i++){
            if(weekList[i] >= 40){
                if(weekList[i] >= 48){
                    salary += (extraChief * 8);
                }else{
                    salary += (extraChief * (weekList[i] - 40));
                }
            }
        }
        ////

        //// THIS CODE BLOCK IS CREATING OUTPUT FILE WITH A GIVING ORDER/////////////////
        try {
            writer = new FileWriter(fileName);
            writer.write("Name : "+ name[0] +"\nSurname : " + name[1] + "\nRegistration Number : "+chief.getRegisterNumber()+"\nPosition : "+ chief.getPosition()+"\nYear of Start : "+chief.getStartYear()+"\nTotal Salary : " + salary+".00 TL");
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
