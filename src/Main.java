package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.animal.Animal;
import src.animal.exceptons.AnimalNotSupported;
import src.data.TeamsData;

public class Main{
    public static void main (String args[]) throws AnimalNotSupported{
        Scanner sc = new Scanner(System.in);
        
        TeamsData []teamData= TeamsData.values();
        String [] commandConsole = new String[TeamsData.values().length];

        for (int i=0;i<teamData.length;i++){
            commandConsole[i]=teamData[i].name().toLowerCase();
        }

        List<Animal>animals=new ArrayList<>();

        while (true) {
            System.out.println(String.format("Введите одну команду из %s", String.join("/", commandConsole)));

            String commandStr=  sc.next().toUpperCase().trim();

            boolean isCommandCorrect=false;
            for(TeamsData teamsData:teamData){
                if(teamsData.name().equals(commandStr)){
                
                isCommandCorrect=true;
                }
                break;
            }  
            if(!isCommandCorrect){
                System.out.println(String.format("Комманда %ы некорректна,введение корректную команду", commandStr));
                continue;
            };
        
            TeamsData teamsData=TeamsData.valueOf(commandStr);
            switch(teamsData){
                case ADD:
                break;
                case LIST:
                    animals.forEach((Animal animal)->System.out.println(animal.toString()));
                break;
                case EXIT:
                System.exit(0);

            }
        }
    
    
    }
}