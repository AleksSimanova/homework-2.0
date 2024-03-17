package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.validation.Validator;

import src.animal.Animal;
import src.animal.exceptons.AnimalNotSupported;
import src.data.AnimalData;
import src.data.ColorData;
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
//---------------------------------name
                    
                    String nameSrt =null;
                    while (true) {
                        System.out.println("Введите имя животного");
                        nameSrt = sc.next().trim();
                        if (validators.isStringChars(nameSrt)) {
                            break;   
                        }
                        System.out.println("Введите именя животного состояшее из букв");
                        
                    }
                    animal.setName(nameSrt);
//---------------------------------- age
                    int ageIntStr;
                    while (true){
                        System.out.println("Введите возраст животного");
                        String ageStr = sc.next().trim();
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
//----------------------weight
                    int weightStrInt;
                    while (true){
                        System.out.println("Введите вес животного");
                        String weightStr = sc.next().trim();
                        if (validators.isAgeNimbers(weightStr)){
                            try{
                                weightStrInt= Integer.parseInt(weightStr);{
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
                    animal.setWeight(weightStrInt);
//--------------------collor
                    System.out.println("Введите цвет животного");
                    String collorStr;
                    while (true) {
                        System.out.printf("Выбирете цвет животного из %s \n",enamConvecters.getNamesEnam(ColorData.class,"/"));
                        collorStr=sc.next().toUpperCase().trim();
                        if(validators.checkValuesInEnam(ColorData.class,collorStr)){
                            break;
                        }
                        System.out.printf("%s не представлен на данной ферме,выберите цвет из представленных в списке \n",collorStr);
                    }
                    animal.setColor(ColorData.valueOf(collorStr));

//----------------------------
                    animals.add(animal);
                }
                break;
                case LIST:
                {
                    for (Animal animal : animals) {
                        System.out.println(animal.toString());
                    }
                    
                    break;
                }

                case EXIT:
                System.exit(0);
                }
            }
        }
    
    
    }
