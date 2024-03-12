package src.factory;

import src.animal.Animal;
import src.animal.birds.Duck;
import src.animal.exceptons.AnimalNotSupported;
import src.animal.pets.Cat;
import src.animal.pets.Dog;
import src.data.AnimalData;

public class AnimalFactory {

    public Animal create (AnimalData animaData) throws AnimalNotSupported{ 
        switch (animaData) {
            case DOG:{
                return new Dog();
            }  
                
            case CAT:{
                return new Cat();
            }
            case DUCK:{
                return new Duck();
            }
        }
            throw new AnimalNotSupported(animaData);
            
        }

    }
