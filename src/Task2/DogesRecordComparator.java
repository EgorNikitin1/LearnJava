package Task2;

import java.util.Comparator;

public record DogesRecordComparator() implements Comparator<DogRecord> {
    @Override
    public int compare(DogRecord dog1, DogRecord dog2) {
        int nameCompare = dog1.name().compareToIgnoreCase(dog2.name());
        if (nameCompare != 0) {
            return nameCompare;
        } else {
            return Integer.valueOf(dog1.age()).compareTo(Integer.valueOf(dog2.age()));
        }
    }
}
