package Task4.Generics;


public class GenericDemo {
    public static void main(String[] args) {

        Apple apple = new Apple(100);
        Persimmon persimmon = new Persimmon(300);

        Box<Fruit> appleBox1 = new Box<>(apple, 5);
        Box<Fruit> appleBox2 = new Box<>(apple, 5);
        Box<Fruit> persimmonBox1 = new Box<>(persimmon, 3);
        Box<Fruit> persimmonBox2 = new Box<>(persimmon, 3);

        System.out.println("The first box: " + appleBox1.getTotalWeight() + "g");
        System.out.println("The second box: " + appleBox2.getTotalWeight() + "g");
        System.out.println(compareBoxes(appleBox1, appleBox2));
        System.out.println();
        System.out.println("The first box: " + persimmonBox1.getTotalWeight() + "g");
        System.out.println("The second box: " + persimmonBox2.getTotalWeight() + "g");
        System.out.println(compareBoxes(persimmonBox1, persimmonBox2));
        System.out.println();

        Object[] temp1 = moveFruits(appleBox1, appleBox2, 3);
        appleBox1 = (Box<Fruit>) temp1[0];
        appleBox2 = (Box<Fruit>) temp1[1];

        Object[] temp2 = moveFruits(persimmonBox2, persimmonBox1, 1);
        persimmonBox1 = (Box<Fruit>) temp2[1];
        persimmonBox2 = (Box<Fruit>) temp2[0];

        System.out.println("The first box: " + appleBox1.getTotalWeight() + "g");
        System.out.println("The second box: " + appleBox2.getTotalWeight() + "g");
        System.out.println(compareBoxes(appleBox1, appleBox2));
        System.out.println();
        System.out.println("The first box: " + persimmonBox1.getTotalWeight() + "g");
        System.out.println("The second box: " + persimmonBox2.getTotalWeight() + "g");
        System.out.println(compareBoxes(persimmonBox1, persimmonBox2));

    }

    public static String compareBoxes(Box<Fruit> box1, Box<Fruit> box2) {
        if (box1.getTotalWeight().compareTo(box2.getTotalWeight()) > 0) {
            return "The first box is heavier";
        } else if (box1.getTotalWeight().compareTo(box2.getTotalWeight()) == 0) {
            return "Both boxes have the same mass";
        } else {
            return "The second box is heavier";
        }
    }

    public static Object[] moveFruits(Box<Fruit> box1, Box<Fruit> box2, int quantity) {
        Box<Fruit> tempBox1 = new Box<>(box1.getFruit(), box1.getNumber() - quantity);
        Box<Fruit> tempBox2 = new Box<>(box2.getFruit(), box2.getNumber() + quantity);
        return new Object[]{tempBox1, tempBox2};
    }
}
