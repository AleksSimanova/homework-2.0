package src.animal;
import src.data.ColorData;
public  abstract class Animal {
    private String name;
    private int age;
    private float weight;
    private ColorData color;
//---------------------------------------
    public void setName(String name){
        this.name=name;
    }
    
    public void setColor(ColorData color){
        this.color=color;
    }
    public void setAge(int age){
        this.age=age;
    }
    
    public void setWeight(float weight){
        this.weight=weight;
    }
//-------------------------------------
    public String getName(){
        return name;
    }
    
    public ColorData getColorData(){
        return color;
    }

    public int getAge(){
        return age;
    }

    public float getWeight(){
        return weight;
    }
//-----------------------------------
    public void  say(){
        System.out.println("Я говорю");
    }

    public void  go (){
        System.out.println( "Я иду");} 

    public  void  drink(){
            System.out.println( "Я пью");
    }
    
    public void eat(){
        System.out.println("я ем");
    }
//----------------------------------
    public String toString(){
        return String.format("Привет меня зовут %s, мне $d $s, я вещу $d кг, мой цвет $s", 
                            name,age,weight,color.getName());
    }

    private String getPadej(){
        int remains=age % 10;
        switch(remains){
                case 1:
                return "год";
                
                case 2:case 3: case 4:
                return"года";
                case 5: case 0:
                return"лет";
                default : return "лет";

        }
        
    }
}