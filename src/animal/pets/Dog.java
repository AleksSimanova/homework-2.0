package src.animal.pets;

import src.animal.Animal;

public class Dog extends Animal {
    @Override
    public String say(){
        return "Гав-Гав" ;
    }
    @Override
    public String toString(){
        return String.format("Привет cобака, меня зовут %s, мне %d %s, я вещу %d кг, мой цвет %s, я говорю %s", 
        name,age,getPadej(),weight,color.getName(),say());
    }
}
