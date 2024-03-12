package src.animal.exceptons;

import src.data.AnimalData;

public class AnimalNotSupported  extends Exception {
    public AnimalNotSupported (AnimalData animaData){
        super (String.format(":Животное %s,на этой ферме не представлено", animaData.name()));
    }

}