import java.io.FileWriter;

public class Personnel {
    private String nameSurname;
    private String registerNumber;
    private String position;
    private int startYear;
    private Personnel[] employeeList;
    private int firstWeekH;
    private int secondWeekH;
    private int thirdWeekH;
    private int fourthWeekH;
    public int currentYear = 2020;
    public int baseSalary = 2600;
    public int severancePay = 16;
    FileWriter writer = null;

    public Personnel(String nameSurname, String registerNumber, String position, int startYear){
        this.nameSurname = nameSurname;
        this.registerNumber = registerNumber;
        this.position = position;
        this.startYear = startYear;

    }
    public Personnel(){}

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getFirstWeekH() {
        return firstWeekH;
    }

    public void setFirstWeekH(int firstWeekH) {
        this.firstWeekH = firstWeekH;
    }

    public int getSecondWeekH() {
        return secondWeekH;
    }

    public void setSecondWeekH(int secondWeekH) {
        this.secondWeekH = secondWeekH;
    }

    public int getThirdWeekH() {
        return thirdWeekH;
    }

    public void setThirdWeekH(int thirdWeekH) {
        this.thirdWeekH = thirdWeekH;
    }

    public int getFourthWeekH() {
        return fourthWeekH;
    }

    public void setFourthWeekH(int fourthWeekH) {
        this.fourthWeekH = fourthWeekH;
    }


}
