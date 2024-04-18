package Task4.Generics;


public class GenericDemo {
    public static void main(String[] args) {

        Apple apple = new Apple(100);
        Persimmon persimmon = new Persimmon(300);

        Box<Apple> appleBox = new Box<>(apple, 5);
        Box<Persimmon> persimmonBox = new Box<>(persimmon, 3);

        System.out.println("The first box: " + appleBox.getTotalWeight() + "g");
        System.out.println("The second box: " + persimmonBox.getTotalWeight() + "g");
        System.out.println(compareBoxes(appleBox, persimmonBox));
        System.out.println();

        appleBox.addFruit(2);
        persimmonBox.takeFruit(1);

        System.out.println("The first box: " + appleBox.getTotalWeight() + "g");
        System.out.println("The second box: " + persimmonBox.getTotalWeight() + "g");
        System.out.println(compareBoxes(appleBox, persimmonBox));

    }

    public static String compareBoxes(Box box1, Box box2) {
        if (box1.getTotalWeight().compareTo(box2.getTotalWeight()) > 0) {
            return "The first box is heavier";
        } else if (box1.getTotalWeight().compareTo(box2.getTotalWeight()) == 0) {
            return "Both boxes have the same mass";
        } else {
            return "The second box is heavier";
        }
    }
}
