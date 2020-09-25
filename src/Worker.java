import java.io.FileWriter;
import java.io.IOException;

public class Worker extends FullTime {
    int salary = 0;
    int weeklyWorker = 525;
    int severancePay = 16;
    int addCourseFee = 11;
    public void SalaryCalculator (Personnel worker){
        int[] weekList = new int[4];// CREATING A NEW LIST FOR WEEKLY WORKING HOURS TO USE IN FOR LOOP.
        weekList[0] = worker.getFirstWeekH();
        weekList[1] = worker.getSecondWeekH();
        weekList[2] = worker.getThirdWeekH();
        weekList[3] = worker.getFourthWeekH();

        String fileName = worker.getRegisterNumber() + ".txt";//OUTPUT FILE NAME
        String[] name = worker.getNameSurname().split(" ");//SPLITTING NAME AND SURNAME

        salary = (4 * weeklyWorker) + (severancePay * (currentYear - worker.getStartYear()));//MONTHLY CONSTANT SALARY

        /////// THIS FOR LOOP IS CALCULATING SALARY WEEK BY WEEK/////////////////
        for(int i = 0; i < 4; i++){
            if(weekList[i] >= 40){
                if(weekList[i] >= 50) {
                    salary +=  (addCourseFee * 10);
                }else{
                    salary += (addCourseFee * (weekList[i] - 40));
                }
            }
        }
        ////

        //// THIS CODE BLOCK IS CREATING OUTPUT FILE WITH A GIVING ORDER/////////////////
        try {
            writer = new FileWriter(fileName);
            writer.write("Name : "+ name[0] +"\nSurname : " + name[1] + "\nRegistration Number : "+worker.getRegisterNumber()+"\nPosition : "+ worker.getPosition()+"\nYear of Start : "+worker.getStartYear()+"\nTotal Salary : " + salary+".00 TL");
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
