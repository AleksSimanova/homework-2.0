package src.data;

public enum  ColorData {

    BLACK("Черный"),
    WHITE("Белый"),
    RED ("Рыжий");
    private String name;

    ColorData(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}