package src.animal.pets;

import src.animal.Animal;

public class Cat extends Animal {
    @Override
    public  String say(){
        return"Мяу";
    }
    @Override
    public String toString(){
        return String.format("Привет кошка, меня зовут %s, мне %d %s, я вещу %d кг, мой цвет %s, я говорю %s", 
        name,age,getPadej(),weight,color.getName(),say());
    }
}
