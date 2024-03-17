package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.validation.Validator;

import src.animal.Animal;
import src.animal.exceptons.AnimalNotSupported;
import src.data.AnimalData;
import src.data.TeamsData;
import src.factory.AnimalFactory;
import src.utilit.EnamConvecters;
import src.utilit.Validators;

public class Main{
    public static void main (String args[]) throws AnimalNotSupported{
        Scanner sc = new Scanner(System.in);
        Validators validators = new Validators();
        EnamConvecters enamConvecters =new EnamConvecters();
        List<Animal>animals=new ArrayList<>();
        while (true) {
            System.out.println(String.format("Введите одну команду из %s",enamConvecters.getNamesEnam(TeamsData.class, "/")));
            String commandStr=  sc.next().toUpperCase().trim();

            if(!validators.checkValuesInEnam(TeamsData.class, commandStr)){
                System.out.println(String.format("Комманда %s некорректна,введение корректную команду", commandStr));
                continue;
            };
            //else()
        
            TeamsData teamsData=TeamsData.valueOf(commandStr);
            switch(teamsData){
                case ADD:
                {

                    String typeAnimalsStr ="";
                    while (true) {
                        System.out.println(String.format("Введите  тип животного  из %s",enamConvecters.getNamesEnam(AnimalData.class, "/")));
                        typeAnimalsStr = sc.next().toUpperCase().trim();

                        if(validators.checkValuesInEnam(AnimalData.class, typeAnimalsStr)){
                            break;
                        }
                        System.out.println(String.format("Данного вида  %s животного нет на этой ферме,выберите другой вид из ", typeAnimalsStr));
                        }
                    Animal animal = new AnimalFactory().create(AnimalData.valueOf( typeAnimalsStr));
//---------------------------------имя
                    
                    String nameSrt =null;
                    while (true) {
                        System.out.println("Введите имя животного");
                        nameSrt = sc.next();
                        if (validators.isStringChars(nameSrt)) {
                            break;   
                        }
                        System.out.println("Введите именя животного состояшее из букв");
                        
                    }
                    animal.setName(nameSrt);
//---------------------------------- возраст
                    int ageIntStr;
                    while (true){
                        System.out.println("Введите возраст животного");
                        String ageStr = sc.next();
                        if (validators.isAgeNimbers(ageStr)){
                            try{
                                ageIntStr= Integer.parseInt(ageStr);{
                                    if(ageIntStr>=0){
                                        break;
                                    }else {
                                        System.out.println("Введите положительное число");
                                    }
                                }
                                
                            }
                            catch(Exception ex){
                                System.out.println("ошибка  ввода числа ");
                            }
                            
                        }System.out.println("Введите  число");
                    }
                    animal.setAge(ageIntStr);
//----------------------вес
                    float weightFloatStr;
                    while (true){
                        System.out.println("Введите вес животного");
                        String weightStr = sc.next();
                        if (validators.isAgeNimbers(weightStr)){
                            try{
                                weightFloatStr= Float.parseFloat(weightStr);{
                                    if(ageIntStr>=0){
                                        break;
                                    }else {
                                        System.out.println("Введите положительное число");
                                    }
                                }
                                
                            }
                            catch(Exception ex){
                                System.out.println("ошибка  ввода числа ");
                            }
                            
                        }System.out.println("Введите  число");
                    }
                    animal.setWeight(weightFloatStr);
                }

                case LIST:
                {
                    animals.forEach((Animal animal)-> System.out.println(animal.toString()));
                    break;
                }

                case EXIT:
                System.exit(0);
                }
            }
        }
    
    
    }
