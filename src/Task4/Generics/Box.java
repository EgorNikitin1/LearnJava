package Task4.Generics;

public class Box<T> {
    private Fruit fruit;
    private Integer number;

    public Box(Fruit fruit, Integer number) {
        this.fruit = fruit;
        this.number = number;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
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

    public void addFruit(Integer quantity) {
        this.number += quantity;
    }

    public void takeFruit(Integer quantity) {
        this.number -= quantity;
    }
}
