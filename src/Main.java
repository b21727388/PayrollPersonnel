public class Main {

    public static void main(String[] args){
        readFile readFile = new readFile();
        FacultyMember FM = new FacultyMember();
        ResearchAssistant RA = new ResearchAssistant();
        Officer O = new Officer();
        Security S = new Security();
        Worker W = new Worker();
        Chief C = new Chief();
        PartTime PT = new PartTime();
        int length = readFile.getLength(args[0]);// GETTING LENGTH OF THE PERSONNEL LIST

        Personnel[] calisanList = new Personnel[length];//CREATING A LIST WITH LENGTH OF PERSONNELS

        readFile.readFile(args[0],args[1],calisanList); //READING PERSONNEL AND MONITORING FILES AND SAVING DATAS FROM THE FILE.


        /// THESE CODE BLOCK IS CALLING SALARY CALCULATOR FUNCTION WITH AN ORDER/////
        for (int i = 0 ; i < length ; i++){
            if(calisanList[i].getRegisterNumber().charAt(0) == 'F'){
                FM.SalaryCalculator(calisanList[i]);

            }else if(calisanList[i].getRegisterNumber().charAt(0) == 'R'){
                RA.SalaryCalculator(calisanList[i]);

            }else if(calisanList[i].getRegisterNumber().charAt(0) == 'O'){
                O.SalaryCalculator(calisanList[i]);

            }else if(calisanList[i].getRegisterNumber().charAt(0) == 'P'){
                PT.SalaryCalculator(calisanList[i]);

            }else if(calisanList[i].getRegisterNumber().charAt(0) == 'W'){
                W.SalaryCalculator(calisanList[i]);

            }else if(calisanList[i].getRegisterNumber().charAt(0) == 'S'){
                S.SalaryCalculator(calisanList[i]);

            }else if(calisanList[i].getRegisterNumber().charAt(0) == 'C'){
                C.SalaryCalculator(calisanList[i]);
            }
        }
        ////////////////////////////
    }
}