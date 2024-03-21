package Task2;

import java.util.Comparator;

public class DogesComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog dog1, Dog dog2) {
        int nameCompare = dog1.getName().compareToIgnoreCase(dog2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }
        else {
            return Integer.valueOf(dog1.getAge()).compareTo(Integer.valueOf(dog2.getAge()));
        }
    }
}
