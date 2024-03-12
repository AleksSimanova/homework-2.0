package src.animal.birds;

import src.animal.Animal;

public class Duck extends Animal implements IFlying {
    @Override
    public void say(){
        System.out.println("Кря-кря");
    }
    @Override
    public  void fly(){
        System.out.println("Я умнею летать");
    }
    
}
