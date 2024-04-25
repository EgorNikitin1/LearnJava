package Task4.Generics;

public class Box<T extends Fruit> {
    private T fruit;
    private Integer number;

    public Box(T fruit, Integer number) {
        this.fruit = fruit;
        this.number = number;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(T fruit) {
        this.fruit = fruit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getTotalWeight() {
        return fruit.getWeight() * number;
    }
}
