import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class readFile {
    private Personnel[] calisanList;

    public void readFile(String pathPersonnel, String pathMonitoring, Personnel[] aList){


        int itemCounter = 1;
        try{
            calisanList = new Personnel[getLength(pathPersonnel)];
            for(String line: Files.readAllLines(Paths.get(pathPersonnel))){
                String[] words = line.split("\t"); //SPLITTING INPUT TXT TO THE WORDS AND CREATING A LIST.
                aList[itemCounter-1] = new Personnel(words[0],words[1],words[2],Integer.valueOf(words[3])); //CREATING LIST
                itemCounter++;
            }
            itemCounter = 1;
            for(String line: Files.readAllLines(Paths.get(pathMonitoring))){
                String[] words = line.split("\t"); //SPLITTING INPUT TXT TO THE WORDS AND CREATING A LIST.
                aList[itemCounter-1].setFirstWeekH(Integer.valueOf(words[1])); //THESE 4 ROW IS GETTING WEEKLY WORKING HOUR FROM TEXT AND MATCHING WITH PERSONELS.
                aList[itemCounter-1].setSecondWeekH(Integer.valueOf(words[2]));
                aList[itemCounter-1].setThirdWeekH(Integer.valueOf(words[3]));
                aList[itemCounter-1].setFourthWeekH(Integer.valueOf(words[4]));
                itemCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }





    }



    //// THESE FUNCTION IS GETTING FILE LENGTH
    public int getLength (String path){
        int length = 0;
        try {
            length = Files.readAllLines(Paths.get(path)).size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return length;
    }
}
