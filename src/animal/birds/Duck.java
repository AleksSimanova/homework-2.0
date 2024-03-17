package src.animal.birds;

import src.animal.Animal;

public class Duck extends Animal implements IFlying {
    @Override
    public String say(){
        return "Кря-кря";
    }
    @Override
    public  String fly(){
        return "Я умнею летать";
    }
    
    @Override
    public String toString(){
        return String.format("Привет утка, меня зовут %s, мне %d %s, я вещу %d кг, мой цвет %s, я говорю %s, я еще я %s", 
        name,age,getPadej(),weight,color.getName(),say(),fly());
    }
}
